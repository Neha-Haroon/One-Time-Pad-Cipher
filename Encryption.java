
public class Encryption {

    public String Encrypt(String plainText, String key) {
        String cipherText = "";

        // 1.given are key and plaintext in string cast
        // 2. for the length of plaintext
        // 3. take same index entiries from both strs
        // 4. cast them int
        // 5. xor them
        // 6. string cast xor-ed value
        // 7. append xor-ed value in cipherText

        // 2.
        for (int plainTextIndex = 0; plainTextIndex < plainText.length(); plainTextIndex++) {
            // 3. , 4.
            int plainTextCurrNum = plainText.charAt(plainTextIndex);
            int keyCurrNum = key.charAt(plainTextIndex);

            // 5.
            int xor_edValue = plainTextCurrNum ^ keyCurrNum;

            // 6.
            String str_xor_edValue = Integer.toString(xor_edValue);
            // 7.
            cipherText = cipherText + str_xor_edValue;
        }
        return cipherText;
    }

}
