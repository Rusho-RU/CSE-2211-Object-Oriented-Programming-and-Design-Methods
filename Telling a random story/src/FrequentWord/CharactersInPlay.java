package FrequentWord;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String>character;
    private ArrayList<Integer>counts;

    public CharactersInPlay(){
        character = new ArrayList<>();
        counts = new ArrayList<>();
    }

    public void update(String person){
        int index = character.indexOf(person);

        if(index != -1){
            int value = counts.get(index);
            counts.set(index, value + 1);
        }

        else{
            character.add(person);
            counts.add(1);
        }
    }

    public void findAllCharacters(){
        FileResource file = new FileResource();

        for(String line : file.lines()){
            int indexOfPeriod = line.indexOf('.');

            if(indexOfPeriod > -1){
                int indexOfBlank = 0;
                while(indexOfBlank < indexOfPeriod){
                    if(line.charAt(indexOfBlank) == ' ')
                        indexOfBlank++;
                    else
                        break;
                }

                String person = line.substring(indexOfBlank, indexOfPeriod);
                update(person);
            }
        }
    }

    public void characterWithNumParts(int num1, int num2){
        for(int i=0; i<character.size(); i++){
            if(counts.get(i) >= num1 && counts.get(i) <= num2)
                System.out.println(character.get(i) + ": " + counts.get(i));
        }
    }

    private void tester(){
        findAllCharacters();
        characterWithNumParts(13, 200);
    }

    public static void main(String args[]){
        CharactersInPlay obj = new CharactersInPlay();
        obj.tester();
    }
}
