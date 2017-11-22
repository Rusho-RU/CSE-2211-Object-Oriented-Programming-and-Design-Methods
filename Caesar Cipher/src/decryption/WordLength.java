package decryption;

import edu.duke.*;
import org.jetbrains.annotations.Contract;

public class WordLength {
    private void countWordLengths(FileResource resource, int[] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            int cnt = 0;

            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);

                if(Character.isLetter(ch) || ch == '-')
                    cnt++;
            }

            counts[cnt]++;
        }
    }

    @Contract(pure = true)
    private int indexOfMax(int[] values){
        int max = 0, index=-1;

        for(int i=0; i<values.length; i++){
            if(values[i] > max){
                max = Math.max(max, values[i]);
                index = i;
            }
        }
        return index;
    }

    private void testWordLength(){
        FileResource file = new FileResource();
        int[] counts = new int[31];

        countWordLengths(file, counts);

        for(int i=0; i<counts.length; i++){
            System.out.println(counts[i] + " words of length " + i);
        }

        int index = indexOfMax(counts);

        System.out.println("Words with length " + index + " has commonly occurred");
    }

    public static void main(String args[]){
        WordLength obj = new WordLength();
        obj.testWordLength();
    }
}
