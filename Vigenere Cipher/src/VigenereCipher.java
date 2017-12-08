import java.util.Arrays;

public class VigenereCipher {
    private CaesarCipher[] cipher;

    public VigenereCipher(int[] key){
        cipher = new CaesarCipher[key.length];
        for(int i=0; i<key.length; i++)
            cipher[i] = new CaesarCipher(key[i]);
    }

    public String encrypt(String message){
        int i=0;
        String encrypted = "";
        for(char ch : message.toCharArray())
            encrypted += cipher[i++ % cipher.length].encryptLetter(ch);
        return encrypted;
    }

    public String decrypt(String message){
        int i=0;
        String decrypted = "";
        for(char ch : message.toCharArray())
            decrypted += cipher[i++ % cipher.length].decryptLetter(ch);
        return decrypted;
    }

    public String toString(){
        return Arrays.toString(cipher);
    }
}