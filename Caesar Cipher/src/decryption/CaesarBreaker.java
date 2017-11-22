package decryption;

import encryption.*;

public class CaesarBreaker {
    public int maxIndex(int[] counts){
        int max = -1, index = -1;
        for(int i=0; i<counts.length; i++){
            if(counts[i] > max){
                max = counts[i];
                index = i;
            }
        }

        return index;
    }

    public int[] countLetter(String str){
        int[] counts = new int[26];
        str = str.toLowerCase();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLetter(ch)){
                counts[ch - 'a']++;
            }
        }

        return counts;
    }

    public int getKey(String encrypted){
        int[] freq = countLetter(encrypted);
        int maxDex = maxIndex(freq);
        int dKey = maxDex - 4;

        if(dKey < 0)
            dKey += 26;
        return dKey;
    }

    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int dKey = getKey(encrypted);
        System.out.println(dKey);
        return cc.encrypt(encrypted, 26-dKey);
    }

    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();

        String odd = cc.halfOfString(encrypted, 0);
        String even = cc.halfOfString(encrypted, 1);

        int key1 = getKey(odd);
        int key2 = getKey(even);

        System.out.println(key1 + " " + key2);

        return cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }

    private void testDecrypt(){
        String ans;
        ans = decrypt("Aljk r kvjk jkizex nzky cfkj fw vvvvvvvvvvvvvvvvvj");
        System.out.println(ans);

        ans = decrypt("Grpq x qbpq pqofkd tfqe ilqp lc bbbbbbbbbbbbbbbbbp");
        System.out.println(ans);

        ans = decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
        System.out.println(ans);
    }

    public static void main(String args[]){
        CaesarBreaker obj = new CaesarBreaker();
        obj.testDecrypt();
    }
}
