package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalyticsCounter {

    // 1 - Declared private class attributes
    private ISymptomReader reader;
    private ISymptomWriter writer;

    // 1 - Constructor
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
        this.reader = reader;
        this.writer = writer;
    } 

    // 2 - Methode qui récupère la liste des entrées dans le fichier 
    // en utilisant l’instance de ISymptomReader déjà créée
    public List<String> getSymptoms(){
        List<String> listSymptoms;
        //ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt"); //Don't forget to specify the file...
        listSymptoms = reader.getSymptoms();
        return listSymptoms;
    }

    // 3 - Methode qui compte les occurrences de chaque symptôme existant
    public Map<String, Integer> countSymptoms(List<String> symptoms) { 

        Map<String, Integer> symptomCount = new HashMap<>();

            for (String symptom : symptoms){
                if (symptomCount.get(symptom) == null){
                    symptomCount.put(symptom,1);
                }else{
                    int symptomCounter = symptomCount.get(symptom);
                    symptomCounter ++;
                    symptomCount.put(symptom, symptomCounter);
                }
            }
        return symptomCount;
    }

    // 4 - Methode  qui trie la liste de symptômes et d’occurrences 
    // par ordre alphabétique
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(symptoms);
        return treeMap;
    }

    // 5 - Methode qui écrit le résultat dans le fichier de sortie 
    // en utilisant l’instance de ISymptomWriter déjà créée
    public void writeSymptoms(Map<String, Integer> symptoms) { 
        //WriteSymptomDataToFile writer = new WriteSymptomDataToFile();
        writer.writeSymptoms(symptoms);
    }
}



//---------------------------- VERSION 3 ------------------------------------------
/**
	public static void main(String args[]) throws Exception{
        
        //ReadSymptomDataFromFile implementation
        List<String> symptomsList = new ArrayList<>();

		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
        String line = reader.readLine();

        while (line != null) {
            symptomsList.add(line);
            line = reader.readLine();
        }

        reader.close();

        Map<String, Integer> symptomCount = countSymptoms(symptomsList);

        BufferedWriter writer = new BufferedWriter(new FileWriter("result.out", false));
                
        //For each entry in the Map, I write it on a new line into our file
        for(Map.Entry<String, Integer> entry: symptomCount.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue());
            writer.newLine();
        }

        writer.close();

        // //writeSymptomsDataToFile implementation
        // Map<String, Integer> symptomCount = countSymptoms(symptomsList);
		// for(Map.Entry<String, Integer> entry: symptomCount.entrySet()) {
        //     System.out.println("Symptom: "+ entry.getKey()+" appears: "+ entry.getValue());
        // }
	}

//Count the symptoms implementation
public static Map<String, Integer> countSymptoms (List<String> symptomsList){

    Map<String, Integer> symptomCount = new HashMap<>();

    for (String symptom : symptomsList){
        if (symptomCount.get(symptom) == null){
            symptomCount.put(symptom,1);
        }else{
            int symptomCounter = symptomCount.get(symptom);
            symptomCounter ++;
            symptomCount.put(symptom, symptomCounter);
        }
    }
    return symptomCount;
*/

//-------------------------------- VERSION 2 --------------------------------
/**
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception{

		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		
        String line = reader.readLine();

        while (line != null) {
            if (line.equals("headache")) {
                headacheCount++;
            }
            else if (line.equals("rash")) {
                rashCount++;
            }
            else if (line.contains("pupils")) {
                pupilCount++;
            }

            line = reader.readLine();
        }

        reader.close();

        System.out.println("Total number of headaches: " + headacheCount);
        System.out.println("Total number of rashes: " + rashCount);
        System.out.println("Total number of dilated pupils: " + pupilCount);
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
*/

// -------------------------- VERSION 1 ----------------------------------------

	/**
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
*/