package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

// WRITE YOUR CODE HERE
public class Main{

    public static void main(String[] args){
        
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