package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Anything that will get symptom data from a source, count them, order them alphabetically, 
 * and output them.
 *
 * @param reader an instance of ISymptomReader.
 * @param writer an instance of ISymptomWriter.
 */

public class AnalyticsCounter {

  private ISymptomReader reader;
  private ISymptomWriter writer;

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
    this.reader = reader;
    this.writer = writer;
  } 

  /**
   * Generates a List of symptoms from a source, using the ISymptomReader instance.
   *
   * @return a List of symptoms present in the source.
   */
  public List<String> getSymptoms() {
    List<String> listSymptoms;
    listSymptoms = reader.getSymptoms();
    return listSymptoms;
  }

  /**
   * Counts symptom occurences from a symptoms List.
   * 
   * @param symptoms a List of symptoms.
   * @return a Map with each individual symptom paired with its number of occurences.
   */
  public Map<String, Integer> countSymptoms(List<String> symptoms) { 

    Map<String, Integer> symptomCount = new HashMap<>();

    for (String symptom : symptoms) {
      if (symptomCount.get(symptom) == null) {
        symptomCount.put(symptom,1);
      } else {
        int symptomCounter = symptomCount.get(symptom);
        symptomCounter++;
        symptomCount.put(symptom, symptomCounter);
      }
    }
    return symptomCount;
  }

  /**
   * Sorts symptoms Map alphabetically.
   * 
   * @param symptoms a Map with each individual symptom paired with its number of occurences.
   * @return an alphabetically ordered Map of all symptoms and their occurences.
   */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    Map<String, Integer> treeMap = new TreeMap<String, Integer>(symptoms);
    return treeMap;
  }

  /**
   * Writes the results onto a valid output format, using the ISymptomWriter instance.
   *
   * @param symptoms an alphanetically ordered Map of all symptoms and their occurences.
   */
  public void writeSymptoms(Map<String, Integer> symptoms) { 
    writer.writeSymptoms(symptoms);
  }
}