//student name: Ashley Osborne
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int input;
        String message, newMessage,finalMessage;
        Scanner scan=new Scanner(System.in);
        Scanner scan1=new Scanner(System.in);
    Caesar c1= new Caesar();
    do {
        System.out.println("1 Encrypt a message\n" +
                "2 Decrypt a message\n" +
                "3 Quit");
        input = scan.nextInt();
        if (input == 1){
            System.out.println("Enter a message to encrypt (with no spaces or special characters).");
        message = scan1.nextLine();
        newMessage = message.toLowerCase();
        finalMessage=c1.encrypt(newMessage);
        System.out.println("Encrypted message: "+finalMessage);
    }
        if(input==2){
                System.out.println("Enter a message to decrypt (with no spaces or special characters).");
                message=scan1.nextLine();
                newMessage=message.toLowerCase();
                finalMessage=c1.decrypt(newMessage);
                System.out.println("Decrypted message: "+finalMessage);
        }
    }while(input!=3);
    }
}
class Caesar {
    ArrayList<Character> alphabet = new ArrayList<Character>();
    public Caesar() {
        for(char letter='a';letter<='z';letter++) {
            alphabet.add(letter);
        }
    }
    int position_of_char(char pos){
            int index=alphabet.indexOf(pos);
        return index;
    }
    char letter_at_pos(int index){
        char char_at_index=alphabet.get(index);
        return char_at_index;
    }
    char encrypt_char(char unencrypted_char){
        char encrypted_char, step3;
        int step1,step2;
        step1=position_of_char(unencrypted_char);
        step2=step1+3;
        if(step2>=26){
            step2-=26;
        }
        step3=letter_at_pos(step2);
        encrypted_char=step3;
        return encrypted_char;
    }
    char decrypt_char(char aChar){
        int stepA=position_of_char(aChar);
        int stepB=stepA-3;
        if(stepB<0){
            stepB+=26;
        }
        char decrypted_char=letter_at_pos(stepB);
        return decrypted_char;
    }
    String encrypt(String newString){
        String ciphertext="";
        for(int i=0;i<newString.length();i++){
            char oldChar=newString.charAt(i);
            char newChar=encrypt_char(oldChar);
            ciphertext=ciphertext+newChar;
        }
        return ciphertext;
    }
    String decrypt(String newString){
        String ciphertext="";
        for(int i=0;i<newString.length();i++){
            char oldChar=newString.charAt(i);
            char newChar=decrypt_char(oldChar);
            ciphertext=ciphertext+newChar;
        }
        return ciphertext;
    }
}
