package org.main;

import Data.DataManager;
import UI.UIManager;

import java.io.IOException;


public class Main {

    final static String fileDRC = "src/main/java/Data/data.txt";

    public static void main(String[] args) {

        DataManager dm = null;
        try {
            dm = new DataManager(fileDRC);
            System.out.println("DataManager initialized.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        UIManager ui = null;

        if(dm != null) {
            ui = new UIManager(dm);
        } else {
            System.out.println("DataManager not correctly initialized.");
            System.exit(0);
        }

        ui.runInterface();

    }
}
