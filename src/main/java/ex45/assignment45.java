/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tony Tang
 */

package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class WordFinder {

    public static void main (String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        System.out.print("\nEnter the output file : ");

        String out = scan.next();

        ReadFile read = new ReadFile();

        read.read();

        ArrayList<String> list = read.getData();

        WriteFile write = new WriteFile(out, list);

        write.write();

    }

}

class ReadFile{

    private final ArrayList<String> list;
    private final Scanner scan;

    public ReadFile() throws FileNotFoundException {

        list = new ArrayList<>();

        File file = new File("src/main/java/ex45/exercise45_input.txt");
        scan = new Scanner(file);

    }

    public void read() {

        try
        {

            while (scan.hasNext())
            {

                String fileData = scan.nextLine();

                list.add(fileData);

            }
        }
        finally
        {
            scan.close();
        }

    }

    public ArrayList<String> getData() {

        return list;

    }

}

class WriteFile{

    private final FileWriter writer;
    private final ArrayList<String> list;

    public WriteFile (String name, ArrayList<String> list) throws IOException {

        writer = new FileWriter("src/main/java/ex45/" + name + ".txt");
        this.list = list;
    }

    public void write() throws IOException {

        for (String temp : list) {

            String replace = "utilize";

            int index = 0;

            while (true) {

                index = temp.indexOf(replace, index);
                if (index != -1) {

                    index += replace.length();

                } else {

                    break;

                }
            }

            temp = temp.replaceAll("utilize", "use");

            writer.write(temp + "\n");

        }

        writer.close();

    }

}