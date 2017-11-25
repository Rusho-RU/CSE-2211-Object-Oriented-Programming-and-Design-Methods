package gladlibs;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

public class WordsInFiles {
    private HashMap<String, ArrayList<String> > words;

    WordsInFiles(){
        words = new HashMap<>();
    }

    private void addWordsFromFile(File file){
        FileResource fileResource = new FileResource(file.toString());
        String fileName = file.getName();

        for(String word : fileResource.words()){
            if(!words.containsKey(word)){
                words.put(word, new ArrayList<>());
                words.get(word).add(fileName);
            }

            else if(!words.get(word).contains(fileName))
                words.get(word).add(fileName);
        }
    }

    public void buildWordFileMap(){
        words.clear();
        DirectoryResource directoryResource = new DirectoryResource();

        for(File file : directoryResource.selectedFiles())
            addWordsFromFile(file);
    }

    public int maxNumber(){
        int max = -1;
        for(String key : words.keySet())
            max =  Math.max(max, words.get(key).size());
        return max;
    }

    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String>fileList = new ArrayList<>();
        for(String key : words.keySet())
            if(words.get(key).size() == number)
                fileList.add(key);
        return fileList;
    }

    public void printFilesIn(String word){
        for(String fileName : words.get(word))
            System.out.println(fileName);
    }

    private void tester() {
        buildWordFileMap();
        System.out.println(words.size());
        int max = maxNumber();
        ArrayList<String> fileList = wordsInNumFiles(max);

        System.out.println("Maximum " + max + " Files contain same word.\nThe words are:" + fileList);

        for (String key : words.keySet()) {
            System.out.println(key);
            System.out.println(words.get(key));
        }
    }

    public static void main(String args[]){
        WordsInFiles obj = new WordsInFiles();
        obj.tester();
    }
}
