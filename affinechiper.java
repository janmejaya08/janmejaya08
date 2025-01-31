/*
 *Name:-janmejaya Panda
 * Program is to take the plain text from the user encript it to ciphertext and decript with key pair
 * to plaintext again. 
 * here,
 * the first key is taken as multiplicativekey
 * the second key is taken as additivekey
 */
import java.util.*;
public class affinechiper {
    static final int ALPHABET_SIZE = 26;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine();
        System.out.print("Enter multiplicative key: ");
        int multiplicativeKey = sc.nextInt();
        System.out.print("Enter additive key: ");
        int additiveKey = sc.nextInt();
       
        String ciphertext = encrypt(plaintext, multiplicativeKey, additiveKey);
        System.out.println("Ciphertext: " + ciphertext);
       
        String decryptedMessage = decrypt(ciphertext, multiplicativeKey, additiveKey);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
   
    public static String encrypt(String plaintext, int multiplicativeKey, int additiveKey) {
        char[] plaintextArr = plaintext.toCharArray();
        for (int i = 0; i < plaintextArr.length; i++) {
            if (Character.isLetter(plaintextArr[i])) {
                int newChar = (multiplicativeKey * (Character.toLowerCase(plaintextArr[i]) - 'a') + additiveKey) % ALPHABET_SIZE;
                plaintextArr[i] = (char) (newChar + 'a');
            }
        }
        return new String(plaintextArr);
    }
   
    public static String decrypt(String ciphertext, int multiplicativeKey, int additiveKey) {
        char[] ciphertextArr = ciphertext.toCharArray();
        int inverseKey = -1;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if ((multiplicativeKey * i) % ALPHABET_SIZE == 1) {
                inverseKey = i;
                break;
            }
        }
        for (int i = 0; i < ciphertextArr.length; i++) {
            if (Character.isLetter(ciphertextArr[i])) {
                int newChar = (inverseKey * ((Character.toLowerCase(ciphertextArr[i]) - 'a') - additiveKey + ALPHABET_SIZE)) % ALPHABET_SIZE;
                ciphertextArr[i] = (char) (newChar + 'a');
            }
        }
        return new String(ciphertextArr);
    }
}


