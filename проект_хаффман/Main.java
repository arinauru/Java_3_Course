import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.util.*;

import static java.lang.Math.min;

class Node {
    Byte symbol;
    int frequency;
    Node left, right;

    Node(Byte symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    Node(int frequency) {
        this(null, frequency);
    }
}

public class Main {

    private static int SizeOfHeaderLength = 2;
    private static int SizeOfEncodedTextLength = 8;


    private static Map<Byte, Integer> counter(byte[] text) {
        Map<Byte, Integer> res = new HashMap<>();
        for (byte c : text) {
            res.put(c, res.getOrDefault(c, 0) + 1);
        }
        return res;
    }

    private static Node huffmanTree(byte[] bytes) {
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        for (var entry : counter(bytes).entrySet()) {
            heap.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (heap.size() > 1) {
            Node left = heap.poll();
            Node right = heap.poll();
            Node mergedNode = new Node(left.frequency + right.frequency);
            mergedNode.left = left;
            mergedNode.right = right;
            heap.add(mergedNode);
        }
        return heap.poll();
    }

    private static Map<Byte, String> huffmanCodes(Node tree) {
        Map<Byte, String> huffCodes = new HashMap<>();
        if (tree.symbol != null) {
            huffCodes.put(tree.symbol, "0");
            return huffCodes;
        }
        Stack<Pair<Node, String>> stack = new Stack<>();
        stack.push(new Pair<>(tree, ""));
        while (!stack.isEmpty()) {
            Pair<Node, String> pair = stack.pop();
            Node currentNode = pair.node;
            String currentCode = pair.code;

            if (currentNode.symbol != null) {
                huffCodes.put(currentNode.symbol, currentCode);
            } else {
                stack.push(new Pair<>(currentNode.right, currentCode + "1"));
                stack.push(new Pair<>(currentNode.left, currentCode + "0"));
            }
        }
        return huffCodes;
    }

    private static String fromBytes(byte[] bytes) {
        StringBuilder res = new StringBuilder();
        for (byte i : bytes) {
            String s = Integer.toString(Byte.toUnsignedInt(i), 2);
            while (s.length() < 8) {
                s = '0' + s;
            }
            res.append(s);
        }
        return res.toString();
    }

    private static byte[] toBytes(String code) {
        byte[] res = new byte[(code.length() + 7) / 8];
        for (int i = 0; i < code.length(); i += 8) {
            for (int j = i; j < min(i + 8, code.length()); j++) {
                res[i / 8] += (code.charAt(j) == '0' ? 0 : 1) << (7 - (j - i));
            }
        }
        return res;
    }

    private static byte[] encodeTree(Map<Byte, String> codes) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (var entry : codes.entrySet()) {
            Byte symbol = entry.getKey();
            String code = entry.getValue();
            int length = code.length();
            int lengthBytes = (length + 7) / 8;
            byte[] codeBytes = toBytes(code);
            if (codeBytes.length != lengthBytes) {
                System.out.println(codeBytes.length - lengthBytes);
            }

            baos.write(symbol);
            baos.write(length);
            baos.write(codeBytes);
        }
        byte[] treeBytes = baos.toByteArray();
        ByteArrayOutputStream finalBaos = new ByteArrayOutputStream();
        finalBaos.write(ByteBuffer.allocate(SizeOfHeaderLength).putShort((short) treeBytes.length).array());
        finalBaos.write(treeBytes);
        return finalBaos.toByteArray();
    }

    private static Node decodeTree(byte[] treeBytes) {
        int length = ByteBuffer.wrap(Arrays.copyOfRange(treeBytes, 0, SizeOfHeaderLength)).getShort();
        Map<String, Byte> codes = new HashMap<>();
        int i = SizeOfHeaderLength;
        while (i < SizeOfHeaderLength + length) {
            byte symbol = treeBytes[i];
            int codeLength = treeBytes[i + 1];
            int codeBytesLength = (codeLength + 7) / 8;
            byte[] codeBytes = Arrays.copyOfRange(treeBytes, i + 2, i + 2 + codeBytesLength);
            String code = fromBytes(codeBytes);
            code = code.substring(0, codeLength);
            codes.put(code, symbol);
            i += 2 + codeBytesLength;
        }
        codes.forEach((code, symbol) -> System.out.println((char) symbol.byteValue() + ": " + code));
        return regenerateTree(codes);
    }

    private static Node regenerateTree(Map<String, Byte> codes) {
        Node root = new Node(null, 0);
        for (var entry : codes.entrySet()) {
            String code = entry.getKey();
            byte symbol = entry.getValue();
            Node current = root;
            for (char c : code.toCharArray()) {
                if (c == '0') {
                    if (current.left == null) {
                        current.left = new Node(null, 0);
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = new Node(null, 0);
                    }
                    current = current.right;
                }
            }
            current.symbol = symbol;
        }
        return root;
    }

    private static byte[] encode(byte[] bytes, Map<Byte, String> codes) throws IOException {
        byte[] encodedTree = encodeTree(codes);

        StringBuilder encodedBuilder = new StringBuilder();
        for (byte c : bytes) {
            encodedBuilder.append(codes.get(c));
        }
        String encoded = encodedBuilder.toString();
        long length = encoded.length();
        ByteBuffer lengthBuffer = ByteBuffer.allocate(SizeOfEncodedTextLength).putLong(length);
        while (encoded.length() % 8 != 0) {
            encoded += "0";
        }

        ByteArrayOutputStream binaryEncoded = new ByteArrayOutputStream();
        for (int i = 0; i < encoded.length(); i += 8) {
            binaryEncoded.write(Integer.parseInt(encoded.substring(i, i + 8), 2));
        }
        ByteArrayOutputStream finalEncoded = new ByteArrayOutputStream();
        finalEncoded.write(encodedTree);
        finalEncoded.write(lengthBuffer.array());
        finalEncoded.write(binaryEncoded.toByteArray());
        return finalEncoded.toByteArray();
    }

    private static byte[] decode(byte[] encodedText) throws IOException {
        Node huffTree = decodeTree(encodedText);
        int offset = ByteBuffer.wrap(Arrays.copyOfRange(encodedText, 0, SizeOfHeaderLength)).getShort() + SizeOfHeaderLength;
        encodedText = Arrays.copyOfRange(encodedText, offset, encodedText.length);
        long length = ByteBuffer.wrap(Arrays.copyOfRange(encodedText, 0, SizeOfEncodedTextLength)).getLong();
        StringBuilder encodedBuilder = new StringBuilder();
        for (int i = SizeOfEncodedTextLength; i < encodedText.length; i++) {
            encodedBuilder.append(String.format("%8s", Integer.toBinaryString(encodedText[i] & 0xFF)).replace(' ', '0'));
        }
        encodedBuilder.setLength((int) length);

        ArrayList<Byte> decodedText = new ArrayList<>();
        Node current = huffTree;
        for (char c : encodedBuilder.toString().toCharArray()) {
            current = c == '0' ? current.left : current.right;
            if (current.symbol != null) {
                decodedText.add(current.symbol);
                current = huffTree;
            }
        }
        byte[] res = new byte[decodedText.size()];
        for (int i = 0; i < decodedText.size(); i++) {
            res[i] = decodedText.get(i);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.err.println("Usage: java HuffmanCoding <encode|decode> <input file> <output file>");
            return;
        }

        String mode = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        switch (mode) {
            case "encode" -> {
                byte[] bytes = Files.readAllBytes(Paths.get(inputFile));
                Node huffTree = huffmanTree(bytes);
                Map<Byte, String> huffCodes = huffmanCodes(huffTree);
                byte[] encodedText = encode(bytes, huffCodes);
                Files.write(Paths.get(outputFile), encodedText);
                System.out.println("Encoded successfully. The codes are:");
                huffCodes.forEach((symbol, code) -> System.out.println((char) symbol.byteValue() + ": " + code));
            }
            case "decode" -> {
                byte[] text = Files.readAllBytes(Paths.get(inputFile));
                byte[] decodedText = decode(text);
                Files.write(Paths.get(outputFile), decodedText);
            }
            default -> System.err.println("Invalid mode. Use 'encode' or 'decode'.");
        }
    }
}

class Pair<T, U> {
    T node;
    U code;

    Pair(T node, U code) {
        this.node = node;
        this.code = code;
    }
}
