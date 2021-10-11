/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tony Tang
 */

package ex42;

import java.io.*;
import java.util.*;

class Employee {

    public void Parse (String filename) {

        try {

            File input = new File(filename);
            Scanner scan = new Scanner(input);

            while (scan.hasNext()) {

                String parse = scan.nextLine();

                String[] temp = parse.split(",");

                System.out.printf("%-10s%-10s%-10s\n", temp[0], temp[1], temp[2]);

            }

        } catch (FileNotFoundException error) {

            System.out.println("Error: File Not Found!!");

        }
    }

    public static void main (String[] args) {

        Employee employee = new Employee();

        System.out.printf("%-10s%-10s%-10s\n", "Last", "First", "Salary");

        System.out.println("---------------------------");

        employee.Parse("src/main/java/ex42/exercise42_input.txt");
    }
}
