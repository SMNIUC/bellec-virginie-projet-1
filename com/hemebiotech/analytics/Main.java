package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

  /**
 * Reads the file "symptoms.txt", creates a List from that file, counts the number of occurences
 * for each symptoms, saves the pairs symptom/occurences in a Map, alphabetically order this Map,
 * and finally writes these symptom/occurences pairs onto a valid output format.
 *
 */
 
  public static void main(String[] args) {
    
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile();
    AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
    List<String> listSymptoms;
    Map<String, Integer> mapSymptoms;

    listSymptoms = reader.getSymptoms();

    mapSymptoms = counter.countSymptoms(listSymptoms);

    mapSymptoms = counter.sortSymptoms(mapSymptoms);

    writer.writeSymptoms(mapSymptoms);
  }
}