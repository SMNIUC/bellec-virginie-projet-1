package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;     
import java.util.ArrayList;
import java.util.List;

/**
 * Reads symptom data from a file and outputs them in a List.
 *
 * @param filepath a full or partial path to file with symptom strings in it, one per line.
 * @return a List of strings with all the symptoms from the file.
 */
 
public class ReadSymptomDataFromFile implements ISymptomReader {

  private String filepath;

  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<String>();
    
    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        
        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        
        reader.close();
        
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    return result;
  }

}