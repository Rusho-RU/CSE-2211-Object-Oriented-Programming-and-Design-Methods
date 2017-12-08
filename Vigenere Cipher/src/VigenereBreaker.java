import edu.duke.URLResource;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlice){
        String sliced = "";
        for(int i = whichSlice; i < message.length(); i += totalSlice)
            sliced += message.charAt(i);

        return sliced;
    }

    public int[] tryKeyLength(String encrypted, int kLength, char mostCommon){
        int[] key = new int[kLength];
        CaesarCracker obj = new CaesarCracker(mostCommon);
        for(int i=0; i<kLength; i++)
            key[i] = obj.getKey(sliceString(encrypted, i, kLength));

        return key;
    }

    public void breakVigenere(){
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/java/athens_keyflute.txt");
        String encrypted = url.asString();
        int[] key = tryKeyLength(encrypted, 5,'e');
        VigenereCipher obj = new VigenereCipher(key);
        System.out.println(obj.decrypt(encrypted));
    }
}
