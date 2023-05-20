package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Writes each unique symptom and its number of occurences onto a file.
 *
 * @param filepath a full or partial path to file in which symptoms will be written, one per line.
 * @param symptoms an alphabetically ordered Map that pairs each unique symptom with 
 *      its number of occurences.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

  private final String filePath = "result.out";

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {

    try {

      BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false));

      for (Map.Entry<String, Integer> entry: symptoms.entrySet()) {

        writer.write(entry.getKey() + " : " + entry.getValue());
        writer.newLine();
        
      }

      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}