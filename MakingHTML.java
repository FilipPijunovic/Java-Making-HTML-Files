package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Scanner fileIn;
    PrintWriter fileOut;
    String fileNameIn;
    String fileNameOut;
    int dotIndex;
    String line = null;

    System.out.println("Napisite ime fajla: ");
    fileNameIn = scanner.nextLine();
    
    try {
        fileIn = new Scanner(new FileReader(fileNameIn));
        dotIndex = fileNameIn.lastIndexOf(".");
        if (dotIndex == -1) {
            fileNameOut = fileNameIn + ".html";
        }
        else {
            fileNameOut = fileNameIn.substring(0,dotIndex) + ".html";
        }
        fileOut = new PrintWriter(fileNameOut);
        try {
            line = fileIn.nextLine();
        }
        catch (NoSuchElementException e) {
            System.out.println("Greska: "+e.getMessage());
        }
        if (line==null) {
            System.out.println("Prazan fajl");
        }
        else {
            fileOut.println("<html>");
            fileOut.println("<head>");
            fileOut.println("</head>");
            fileOut.println("<body>");
            fileOut.println(line);
            
            while (fileIn.hasNextLine()) {
                fileOut.println("<br>");
                line = fileIn.nextLine();
                
                if(line.isEmpty()) {
                    fileOut.println("<br>");
                }
                else {
                    fileOut.println(line);
                }
            }
            fileOut.println("</body<");
            fileOut.println("</html>");

            System.out.println("Gotovo");
        }
        fileIn.close();
        fileOut.close();
    }
    catch(FileNotFoundException e) {
        System.out.println("Ne postoji");
    }
    
}
}
