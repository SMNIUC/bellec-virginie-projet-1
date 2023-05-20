package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data on a valid data output format.
 *
 * @param symptoms an alphabetically ordered Map that pairs each unique symptom with 
 *      its number of occurences.
 */
 
public interface ISymptomWriter {

  public void writeSymptoms(Map<String, Integer> symptoms);
    
}
