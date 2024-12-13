import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

class Node {
    String symbol;
    int frequency;
    Node left, right;

    Node(String symbol, int frequency) {
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

    private static Map<String, Integer> counter(String text) {
        Map<String, Integer> res = new HashMap<>();
        for (char c : text.toCharArray()) {
            res.put(String.valueOf(c), res.getOrDefault(String.valueOf(c), 0) + 1);
        }
        return res;
    }

    private static Node huffmanTree(String text) {
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        for (var entry : counter(text).entrySet()) {
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

    private static Map<String, String> huffmanCodes(Node tree) {
        Map<String, String> huffCodes = new HashMap<>();
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

    private static byte[] encodeTree(Map<String, String> codes) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (var entry : codes.entrySet()) {
            String symbol = entry.getKey();
            String code = entry.getValue();
            int length = code.length();

            baos.write(symbol.getBytes(StandardCharsets.US_ASCII));
            baos.write(length);
            baos.write(new BigInteger(code, 2).toByteArray());
        }
        byte[] treeBytes = baos.toByteArray();
        ByteArrayOutputStream finalBaos = new ByteArrayOutputStream();
        finalBaos.write(ByteBuffer.allocate(4).putInt(treeBytes.length).array());
        finalBaos.write(treeBytes);
        return finalBaos.toByteArray();
    }

    private static Node decodeTree(byte[] treeBytes) throws IOException {
        int length = ByteBuffer.wrap(Arrays.copyOfRange(treeBytes, 0, 4)).getInt();
        Map<String, String> codes = new HashMap<>();
        int i = 4;
        while (i < 4 + length) {
            String symbol = new String(Arrays.copyOfRange(treeBytes, i, i + 1), "ASCII");
            int codeLength = treeBytes[i + 1];
            int codeBytesLength = (codeLength + 7) / 8;
            byte[] codeBytes = Arrays.copyOfRange(treeBytes, i + 2, i + 2 + codeBytesLength);
            String code = new BigInteger(codeBytes).toString(2);
            while (code.length() < codeLength) {
                code = "0" + code;
            }
            codes.put(code, symbol);
            i += 2 + codeBytesLength;
        }
        return regenerateTree(codes);
    }

    private static Node regenerateTree(Map<String, String> codes) {
        Node root = new Node(null, 0);
        for (var entry : codes.entrySet()) {
            String code = entry.getKey();
            String symbol = entry.getValue();
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

    private static byte[] encode(String text, Map<String, String> codes) throws IOException {
        byte[] encodedTree = encodeTree(codes);

        StringBuilder encodedBuilder = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedBuilder.append(codes.get(String.valueOf(c)));
        }
        String encoded = encodedBuilder.toString();
        int length = encoded.length();
        ByteBuffer lengthBuffer = ByteBuffer.allocate(4).putInt(length);
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

    private static String decode(byte[] encodedText) throws IOException {
        Node huffTree = decodeTree(encodedText);
        int offset = ByteBuffer.wrap(Arrays.copyOfRange(encodedText, 0, 4)).getInt() + 4;
        encodedText = Arrays.copyOfRange(encodedText, offset, encodedText.length);
        int length = ByteBuffer.wrap(Arrays.copyOfRange(encodedText, 0, 4)).getInt();
        StringBuilder encodedBuilder = new StringBuilder();
        for (int i = 4; i < encodedText.length; i++) {
            encodedBuilder.append(String.format("%8s", Integer.toBinaryString(encodedText[i] & 0xFF)).replace(' ', '0'));
        }
        encodedBuilder.setLength(length);

        StringBuilder decodedText = new StringBuilder();
        Node current = huffTree;
        for (char c : encodedBuilder.toString().toCharArray()) {
            current = c == '0' ? current.left : current.right;
            if (current.symbol != null) {
                decodedText.append(current.symbol);
                current = huffTree;
            }
        }
        return decodedText.toString();
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
                String text = new String(Files.readAllBytes(Paths.get(inputFile)));
                Node huffTree = huffmanTree(text);
                Map<String, String> huffCodes = huffmanCodes(huffTree);
                byte[] encodedText = encode(text, huffCodes);
                Files.write(Paths.get(outputFile), encodedText);
                System.out.println("Encoded successfully. The codes are:");
                huffCodes.forEach((symbol, code) -> System.out.println(symbol + ": " + code));
            }
            case "decode" -> {
                byte[] text = Files.readAllBytes(Paths.get(inputFile));
                String decodedText = decode(text);
                Files.write(Paths.get(outputFile), decodedText.getBytes());
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
