package encryption;

public class CaesarCipher {
    char[] lowercase, uppercase;

    CaesarCipher(){
        lowercase = new char[26];
        uppercase = new char[26];
        int i=0;

        for(char ch = 'a', CH = 'A'; ch<='z'; ch++, CH++){
            lowercase[i] = ch;
            uppercase[i++] = CH;
        }
    }

    public boolean isUpperCase(char ch){
        if(ch>='A' && ch<='Z')
            return true;
        return false;
    }

    public int indexOf(char ch){
        if(ch>='A' && ch<='Z')
            return ch - 'A';
        else
            return ch - 'a';
    }

    public String encrypt(String input, int key){
        String encrypted = "";

        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);

            if(Character.isLetter(ch)){
                int index = indexOf(ch);
                index = (index + key) % 26;

                if(isUpperCase(ch))
                    encrypted += uppercase[index];
                else
                    encrypted += lowercase[index];
            }

            else
                encrypted += ch;
        }

        return encrypted;
    }

    public String halfOfString(String message, int start){
        String newMsg = "";

        for(int i = start; i<message.length(); i+=2)
            newMsg += message.charAt(i);

        return newMsg;
    }

    public String merge(String odd, String even){
        String message = "";

        for(int i=0; i<odd.length(); i++){
            message += odd.charAt(i);
            message += even.charAt(i);
        }

        return message;
    }

    public String encryptTwoKeys(String input, int key1, int key2){
        String encrypted;

        String odd = halfOfString(input,0);
        String even = halfOfString(input, 1);

        odd = encrypt(odd, key1);
        even = encrypt(even, key2);

        encrypted = merge(odd, even);

        return encrypted;
    }

    public void testCaesar(){
        String ans;
        ans = encrypt("First Legion", 17);
        System.out.println(ans);

        ans = encryptTwoKeys("First Legion", 23, 17);
        System.out.println(ans);
    }

    public static void main(String args[]){
        CaesarCipher obj = new CaesarCipher();
        obj.testCaesar();
    }
}
