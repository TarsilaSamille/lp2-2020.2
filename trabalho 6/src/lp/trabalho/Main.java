package lp.trabalho;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private static int R = 256; // alfabeto ASCII
    private static Node node;
    public static void main(String[] args) throws FileNotFoundException {
       // String file = args[0];
        try (BufferedReader in
                     = new BufferedReader(new FileReader(
                             new File("/home/tarsila/Imagens/trabalho 6/src/lp/trabalho/oi.txt")))) {
            int readed = in.read();
            StringBuilder str = new StringBuilder();
            while (readed != -1) {
                str.append((char) readed);
                readed = in.read();
            }
            String textoCompactado = compress(str.toString());
            StringBuilder sb = new StringBuilder();
            Arrays.stream( textoCompactado.split("(?<=\\G.{8})") )
                    .forEach(s -> sb.append((char) Integer.parseInt(s, 2)) );
            salvar("/home/tarsila/Imagens/trabalho 6/src/lp/trabalho/caracteresCodificados.txt", sb.toString());
            System.out.println("\nTexto codificado final: " + textoCompactado);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader in
                     = new BufferedReader(new FileReader(new File(
                "/home/tarsila/Imagens/trabalho 6/src/lp/trabalho/caracteresCodificados.txt")))) {
            int readed = in.read();
            StringBuilder str = new StringBuilder();
            while (readed != -1) {
                str.append((char) readed);
                readed = in.read();
            }
            String textoDescompactado = expand(toBinary( str.toString()));
            salvar("/home/tarsila/Imagens/trabalho 6/src/lp/trabalho/caracteresDesCodificados.txt", textoDescompactado);

            System.out.println("\na final:" + textoDescompactado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String compress(String text) throws IOException {
        char[] input = text.toCharArray();
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;
        Node root = buildTrie(freq);
        String[] st = new String[R];
        buildCode(st, root, "");
        writeTrie(root);
        node = root;
        Node.geraCodificacao(node);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++)
                if (code.charAt(j) == '1')
                    str.append('1');
                else str.append('0');
        }
        return str.toString();
    }

    private static String[] buildCode(Node root) {
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (x.isLeaf()) {
            st[x.value] = s;
            return;
        }
        buildCode(st, x.left, s + '0');
        buildCode(st, x.right, s + '1');
    }

    private static void writeTrie(Node x) {
        StringBuilder str = new StringBuilder();
        if (x.isLeaf()) {
            str.append('1');
            str.append(x.value);
            return;
        }
        str.append('0');
        writeTrie(x.left);
        writeTrie(x.right);
    }
    public static String toBinary(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(String.format("%8s",Integer.toBinaryString(c)));
        }
        return sb.toString().replace(' ', '0');
    }

    public static String expand(String text) {
        return  readTrie(text);
    }
    public static String readTrie(String s) {
        String a = "";
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
                a +=  s.charAt(i);
                while(Node.get(node, a) == null){
                    i++; a +=  s.charAt(i);
                }
                finalString.append(Node.get(node, a));
                a="";
        }
       return finalString.toString();
    }

    private static Node buildTrie(int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (char c = 0; c < R; c++)
            if (freq[c] > 0)
                pq.add(new Node(c, freq[c], null, null));
        while (pq.size() > 1) {
            Node x = pq.remove();
            Node y = pq.remove();
            Node parent = new Node('\0', x.freq + y.freq, x, y);
            pq.add(parent);
        }
        return pq.remove();
    }

    public static void salvar(String path, String text) throws IOException {
        File file = new File(path);
        try (Writer out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            out.write(text);
        }
    }
}
