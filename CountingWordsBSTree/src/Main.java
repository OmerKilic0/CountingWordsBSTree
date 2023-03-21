import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<BSTree> trees = new ArrayList<>();
        for(int i=0; i<26; i++){
            trees.add(new BSTree());
        }

        File f = new File("input.txt");
        Scanner scanFile = new Scanner(f);
        String str;

        while(scanFile.hasNext()){
            str = scanFile.next().toLowerCase();
            String word = "";
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if ((ch <= 122 && ch >= 97)){
                    word = word + ch;
                }
                else{
                    word = word + " ";
                }
            }
            if((word.charAt(0)>=97 && word.charAt(0)<=122)) {
                int firstChar = word.charAt(0);
                if(!trees.get(firstChar-97).isMember(word)){
                    trees.get(firstChar-97).insert(word);
                }
                else{
                    BTNode<String> newNode = trees.get(firstChar-97).search(word);
                    newNode.incrementFreq();
                }
            }
        }
        File file = new File("out.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter buffW = new BufferedWriter(fileWriter);
        String a = "";
        for(int i=0; i<26; i++){
            buffW.write(trees.get(i).InOrder());
        }
        buffW.close();
    }
}