/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tony Tang
 */

package ex46;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

class WordFrequency {

    public static ArrayList<String> readFile() throws FileNotFoundException {

        File inputFile = new File("src/main/java/ex46/exercise46_input.txt");
        ArrayList<String> Words = new ArrayList<>();

        try (Scanner scan = new Scanner(inputFile)) {

            while (scan.hasNext()) {
                String filePath = scan.next();
                Words.add(filePath);

            }
        }

        return Words;
    }

    static int count (ArrayList<String> allWords, String word)
    {

        int count = 0;
        for (String allWord : allWords) {
            if (word.equals(allWord))
                count++;

        }

        return count;
    }

    public static void arrange (int[] count, String[] word, int wordAmount){

        String tempString;
        int tempNumber;

        for (int n = 0; n < wordAmount; n++) {

            for(int i = 0; i < wordAmount; i++) {

                if(count[i] < count[i + 1]) {

                    tempNumber = count[i];
                    tempString = word[i];

                    count[i] = count[i+1];
                    word[i] = word[i+1];

                    count[i+1] = tempNumber;
                    word[i+1] = tempString;

                }
            }
        }

        String[] display = new String[wordAmount];

        for (int n = 0; n < wordAmount; n++) {

            display[n] = "";

            for (int i = 0; i < count[n]; i++) {

                display[n] += " *";

            }
        }

        for(int i = 0; i < wordAmount; i++) {

            System.out.println(word[i] + ":" + display[i]);

        }

    }

    public static void find (ArrayList<String> allWords) {

        int[] count = new int[allWords.size()];
        String[] word = new String[allWords.size()];

        boolean There = false;
        int tempNumb = 0;

        for(int i = 0; i < allWords.size(); i++) {

            String temp = allWords.get(i);

            for (String x : word) {

                if (Objects.equals(temp, x)) {
                    There = true;
                    break;

                }
            }

            if (!There) {
                word[tempNumb] = temp;
                count[tempNumb] = count(allWords, word[tempNumb]);
                tempNumb++;
            }

            There = false;
        }

        arrange(count, word, tempNumb);

    }

    public static void main (String[] args) throws IOException {

        ArrayList<String> allWords = readFile();
        find(allWords);

    }
}


