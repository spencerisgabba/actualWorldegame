import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        //Reads txt file adds to list and picks random word


        Scanner s = new Scanner(System.in);
        File file = new File("./src/sgb-words.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> words = new ArrayList<String>();

        /* List of previously guessed words */

        List<String> guessedWords = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            words.add(line);
        }

        // Array for storing guess location of words

        int[] arr = {0,0,0,0,0};
        Random rand = new Random();
        String targetWord = words.get((int)rand.nextInt(words.size()));


        // Main loop
        boolean guess = false;
        while(!guess){
            //Input validation, if not in list, won't go through

            System.out.println("Please enter a 5 letter word.");
            String userGuess = s.nextLine();
            if(!words.contains(userGuess)){
                System.out.println("Word not recognized in our list!");
                continue;
            }
            if(userGuess.equals(targetWord)){
                System.out.println("Congrats, you got the word!");
                guess = true;
                continue;
            }
            //adds correct index to array.
            for (int i = 0; i < userGuess.length(); i++) {
                char c = userGuess.charAt(i);
                if (targetWord.indexOf(c) != -1 && targetWord.charAt(i) == c) {
                    arr[i]++;
                }
            }

            //lists out previously guessed words

            guessedWords.add(userGuess);
            System.out.print("Previous word(s): ");
            for(String word : guessedWords){
                System.out.print(word + " ");
            }
            System.out.println();
            for(int j = 0; j<arr.length; j++){
                if(arr[j] >= 1){
                    System.out.print("["+targetWord.charAt(j)+"]");
                }
                else{
                    System.out.print("[ ]");
                }
            }
            System.out.println();

        }



    }
}