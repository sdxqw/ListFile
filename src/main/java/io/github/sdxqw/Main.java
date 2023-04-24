package io.github.sdxqw;

import io.github.sdxqw.listfile.FilesReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(System.in);

            System.out.println(""" 
                    Welcome to listFile, a simple java tool!
                                     
                    Please check what option you want to try:
                    (0) exit
                    (1) scan dir file
                    (2) help
                    """);

            String input = scn.nextLine();
            int type = Integer.parseInt(input);

            do {
                switch (type) {
                    case 0 -> {
                        System.out.println("Thanks for using this program");
                        scn.close();
                        System.exit(0);
                    }
                    case 1 -> FilesReader.searchUp(scn);
                    case 2 -> System.out.println("""
                            Help Center
                                                        
                            (0) exit - close the program
                            (1) scan dir file - search up on the selected dir
                            (2) help - pop up helps about commands
                            """);
                    default -> {
                        System.out.println("\n");
                        System.out.println("this option it's not valid.");
                    }
                }

                System.out.println("""
                        ---------------------------------
                        """);

                System.out.println(""" 
                        Welcome to listFile, a simple java tool!
                                     
                        Please check what option you want to try:
                        (0) exit
                        (1) scan dir file
                        (2) help
                        """);

                input = scn.nextLine();
                type = Integer.parseInt(input);
            } while (type != 0);
        } catch (NumberFormatException e) {
            System.out.printf("""
                    !!!  SKILL ISSUES  !!!
                    %s
                    """, e.getLocalizedMessage());
        }
    }
}