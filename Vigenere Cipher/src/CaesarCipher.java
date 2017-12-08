public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int key;

    public CaesarCipher(int k){
        key = k;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        alphabet += alphabet.toLowerCase();
        shiftedAlphabet += shiftedAlphabet.toLowerCase();
    }

    public char encryptLetter(char ch){
        int index = alphabet.indexOf(ch);
        if(index == -1)
            return ch;
        return shiftedAlphabet.charAt(index);
    }

    public char decryptLetter(char ch){
        int index = shiftedAlphabet.indexOf(ch);
        if(index == -1)
            return ch;
        return alphabet.charAt(index);
    }

    public String encrypt(String message){
        String encrypted = "";
        for(int i=0; i<message.length(); i++)
            encrypted += encryptLetter(message.charAt(i));
        return encrypted;
    }

    public String decrypt(String message){
        String decrypted = "";
        for(int i=0; i<message.length(); i++)
            decrypted += decryptLetter(message.charAt(i));
        return decrypted;
    }
}
