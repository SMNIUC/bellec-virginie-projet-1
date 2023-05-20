package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source.
 * The implementation does not need to order the list.
 *
 * @return a List of all symptoms obtained from a data source, duplicates are possible. 
 *      If no data is available, returns an empty List.
 */
 
public interface ISymptomReader {

  List<String> getSymptoms();

}
