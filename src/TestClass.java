import java.io.*;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws IOException {
        File keysText = new File("src/Abb.txt");
        File text = new File("C:/Users/Keyvan/Desktop/merged-csv-files.csv");
        File data = new File("src/TimeData.txt");
        File outFile = new File("C:/Users/Keyvan/Desktop/FinalAnswer.txt");
        BufferedWriter dataOut = new BufferedWriter(new FileWriter(data));
        long startTime = System.nanoTime();
        long endTime;
        int cnt = 0;

        Trie key1 = new Trie();
        Scanner keyIn = new Scanner(keysText);
        while (keyIn.hasNextLine()) {
            String st = keyIn.nextLine();
            Scanner inp = new Scanner(st);
            String ab = inp.next();
            ab = ab.substring(0, ab.length() - 1);
            ab = ab.toUpperCase();
            String word = "";
            while (inp.hasNext()) {
                word += inp.next() + " ";
            }
            key1.insert(ab, word.trim());
        }
        Scanner in = new Scanner(text);
        BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
        in.useDelimiter(",");
        while (in.hasNext()) {
            if(cnt >= 100000 && cnt % 100000 == 0) {
                endTime = System.nanoTime();
                dataOut.write("Trie: " + cnt + " " + (endTime - startTime) + "\n");
            }
            String st = in.next();

            String rep = key1.search(st);
            if (rep != null) {
                out.write(rep + " ");
            } else {
                out.write(st + " ");
            }
            cnt ++;
        }
        in.close();
        out.close();
        dataOut.write("(endTime - startTime)" + "\n");

        startTime = System.nanoTime();
        cnt = 0;
        BinarySearchTree key2 = new BinarySearchTree();
        Scanner keyIn2 = new Scanner(keysText);
        while (keyIn2.hasNextLine()) {
            String st = keyIn2.nextLine();
            Scanner inp = new Scanner(st);
            String ab = inp.next();
            ab = ab.substring(0, ab.length() - 1);
            ab = ab.toUpperCase();
            String word = "";
            while (inp.hasNext()) {
                word += inp.next() + " ";
            }
            key2.insert(ab, word.trim());
        }

        Scanner input = new Scanner(text);
        BufferedWriter output = new BufferedWriter(new FileWriter(outFile));
        input.useDelimiter(",");
        while (input.hasNext()) {
            if(cnt >= 100000 && cnt % 100000 == 0) {
                endTime = System.nanoTime();
                dataOut.write("Hash: " + cnt + " " + (endTime - startTime) + "\n");
            }
            String st = input.next();

            String rep = key2.search(st);
            if (rep != null) {
                output.write(rep + " ");
            } else {
                output.write(st + " ");
            }
            cnt ++;
        }
        input.close();
        output.close();
        dataOut.close();
    }
}
