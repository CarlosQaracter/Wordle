package org.main;

import Data.DataManager;

import java.io.IOException;


public class Main {

    final static String fileDRC = "src/main/java/Data/data.txt";

    public static void main(String[] args) {
        String playWord;
        try {
            DataManager dm = new DataManager(fileDRC);
            System.out.println("Returned" + dm.getWord());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
