//Eitan Jacob

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File myFile = new File("\\C:\\Users\\eitan\\OneDrive\\Desktop\\FourAuthors\\");
        EitanFrequency ef= new EitanFrequency();
        PrintWriter pw= new PrintWriter("fingerprint.txt");
        for (File f : myFile.listFiles()) {
           Map<Integer,Double> myMap= ef.findWordLengthFrequency(f);
           //Creating a new variable in order to cut out the ".txt" in each file name
            int lengthOfFileName= f.getName().length();
            pw.println("Filename: " + f.getName().substring(0,lengthOfFileName-4)+ " Histogram");
            pw.println("Contexts:");
            pw.println("WordLength Freq");
            for (Integer i:myMap.keySet()) {
                pw.printf("%d = %.3f %n",i,myMap.get(i));
            }
        }
        pw.println("The above histograms show that Shakespeare tends to use words of slightly greater length than Dickens.");
        pw.println("In both of Shakespeare's works, Hamlet and Macbeth, he most often used a word length of four, " +
                   "while Dickens used a word length of three most often in both Tale Of Two Cities and Great Expectations. ");
        pw.close();
    }
}
