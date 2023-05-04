package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    //private String filepath = "symptoms.txt";
    
    /**
     * @param filepath a full or partial path to file in which symptoms will be written, 
     * one per line
	 * 
     */

    // public WriteSymptomDataToFile (String filepath) {
	// 	this.filepath = filepath;
	// } 

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){

        //if (filepath != null){
            try{
                //I create a file at filepath and a writer to write into it
                BufferedWriter writer = new BufferedWriter(new FileWriter("result.out", false));
                
                //For each entry in the Map, I write it on a new line into our file
                for(Map.Entry<String, Integer> entry: symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue()+ "\n");
                    //writer.newLine();
                }

                writer.close(); // Isn't it a pb to put it in the try?

            } catch (IOException e) {
				e.printStackTrace();
            }
        //}
    }
}