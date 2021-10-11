/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tony Tang
 */

package ex44;

import org.json.simple.*;
import java.io.*;
import org.json.simple.parser.*;
import java.util.Scanner;

class Json {

    public static void print (String input) {

        JSONParser parse = new JSONParser();

        boolean present = false;

        try {

            Object read = parse.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));

            JSONObject jsonObject = (JSONObject)read;

            JSONArray products = (JSONArray)jsonObject.get("products");

            for (Object product : products) {

                JSONObject json = (JSONObject) product;

                String name = (String) json.get("name");

                if (input.equalsIgnoreCase(name)) {

                    System.out.println("Name: " + name);
                    System.out.println("Price: " + json.get("price"));
                    System.out.println("Quantity: " + json.get("quantity"));

                    present = true;
                }

            }
            if(!present) {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }

        catch(Exception x) {

            x.printStackTrace();

        }

    }

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is the product name? ");

        String input = scan.nextLine();

        print(input);
    }
}