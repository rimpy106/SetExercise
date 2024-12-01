package main;

import java.io.*;
import java.util.HashSet;
import java.util.Set;


public class SetExerciseApplication {
    // instatiate new hashset
    public static void main(String[] args) throws IOException {
        // extract the data from the CSV
        Set<String> winningHand = new HashSet<>();
        {
            try {
                winningHand = extractDataFromCSV("PokerHands.csv");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        printToConsole(winningHand);

        // remove ACE HIGH and QUEEN HIGH
        winningHand.remove("ACE HIGH");
        winningHand.remove("QUEEN HIGH");
        printToConsole(winningHand);

        // Update PAIR to DEUCES
        if (winningHand.contains("PAIR")) {
            winningHand.remove("PAIR");
            winningHand.add("DEUCES");
        }
        printToConsole(winningHand);

    }

    public static void printToConsole(Set<String> winningHand) {
        System.out.println("-------------");
        for (String elements : winningHand) {
            System.out.println(elements);
        }
    }

    public static Set<String> extractDataFromCSV(String fileName) throws IOException {
        String line;
        String[] lineData;
        Set<String> winningHandCSV = new HashSet<>();
        int i = 0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.readLine();
        while ((line = br.readLine()) != null) {
            lineData = line.split(",");
            winningHandCSV.add(lineData[1]);
            i++;
        }
        return winningHandCSV;
    }

}
