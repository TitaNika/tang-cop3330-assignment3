/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tony Tang
 */

package ex43;

import java.io.*;
import java.util.Scanner;

class WebSiteGenerator {

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);

        String author, siteName;

        char javascript, css;

        System.out.print("Site name: ");
        siteName = scan.nextLine();

        System.out.print("Author: ");
        author = scan.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        javascript = scan.next().charAt(0);

        System.out.print("Do you want a folder for CSS? ");
        css = scan.next().charAt(0);

        Web(author, siteName, javascript, css);

        scan.close();
    }


    public static void Web (String author, String siteName, char javascript, char css) {

        String path = System.getProperty("user.dir");
        path += "\\src\\main\\java\\ex43\\" + siteName;

        File website = new File(path);
        boolean websiteCreated = website.mkdir();

        if (websiteCreated)
        {

            System.out.println("Created " + path);

            try
            {
                FileWriter Writer = new FileWriter(path + "\\index.html");

                Writer.write("<!DOC TYPE html>\n<html lang=\"en\">\n<head>\n");

                Writer.write("\t<meta author=\"" + author + "\">\n");

                Writer.write("\t<title>" + siteName + "</title>\n");

                Writer.write("</head>\n<body>\n\n</body>\n</html>");

                Writer.close();

                System.out.println("Created " + path + "\\index.html");

                if (javascript == 'y' || javascript == 'Y')
                {
                    File javascriptFolder = new File(path + "\\js");
                    boolean javascriptCreated = javascriptFolder.mkdir();

                    if(javascriptCreated)
                    {
                        System.out.println("Created " + javascriptFolder +"\\");
                    }
                    else
                    {
                        System.out.println("Javascript folder not created!!");
                    }
                }
                if (css == 'y' || css == 'Y')
                {
                    File cssFolder = new File(path + "\\css");
                    boolean cssCreated = cssFolder.mkdir();

                    if(cssCreated)
                    {
                        System.out.println("Created " + cssFolder + "\\");
                    }
                    else
                    {
                        System.out.println("CSS folder not created!!");
                    }
                }
            }
            catch(IOException x)
            {
                System.out.println("index.html not created!!");
            }
        }
        else
        {
            System.out.println("Website folder not created!!");
        }
    }
}

