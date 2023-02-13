public class Decryption {

    public String Decrypt(String cipherText, String key) {
        String plainText = "";

        // 1.given are key and plaintext in string cast
        // 2. for the length of plaintext
        // 3. take same index entiries from both strs
        // 4. cast them int
        // 5. xor them
        // 6. string cast xor-ed value
        // 7. append xor-ed value in plaintext

        // 2.
        for (int cipherTextIndex = 0; cipherTextIndex < cipherText.length(); cipherTextIndex++) {
            // 3. , 4.
            int cipherTextCurrNum = cipherText.charAt(cipherTextIndex);
            int keyCurrNum = key.charAt(cipherTextIndex);

            // 5.
            int xor_edValue = cipherTextCurrNum ^ keyCurrNum;

            // 6.
            String str_xor_edValue = Integer.toString(xor_edValue);
            // 7.
            plainText = plainText + str_xor_edValue;
        }
        return plainText;
    }
}
