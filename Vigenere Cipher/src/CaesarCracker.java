
public class CaesarCracker {
    private char common;

    public CaesarCracker(){
        common = 'e';
    }

    public CaesarCracker(char ch){
        common = ch;
    }

    public int maxIndex(int[] counts){
        int index = 0;
        for(int i=0; i<counts.length; i++)
            if(counts[i] > counts[index])
                index = i;

        return index;
    }

    private int[] countLetter(String str){
        int[] counts = new int[26];
        str = str.toLowerCase();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLetter(ch))
                counts[ch - 'a']++;
        }

        return counts;
    }

    public int getKey(String encrypted){
        int[] freq = countLetter(encrypted);
        int maxDex = maxIndex(freq);
        int dKey = maxDex - (common - 'a');

        if(dKey < 0)
            dKey += 26;
        return dKey;
    }

    public String decrypt(String encrypted){
        int dKey = getKey(encrypted);
        CaesarCipher cc = new CaesarCipher(dKey);
        System.out.println(dKey);
        return cc.decrypt(encrypted);
    }
}
