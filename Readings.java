package AirQualityController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat.Type;

public class Readings {

    private String[] getReadings(int lineNumber) {
        String[] readings = {};
        String csvFilePath = "readings.csv";
        String csvSeparator = ",";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            int currentLine = 1;
            while ((line = reader.readLine()) != null && currentLine < lineNumber) {
                currentLine++;
            }
            if (currentLine == lineNumber) {
                readings = line.split(csvSeparator);
            }
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readings;
    }

    public void updateReadings(int lineNumber, int columnNumber, Double add) {
        String csvFilePath = "readings.csv";
        String csvSeparator = ",";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            int currentline = 1;
            String prevLine = "";
            StringBuilder fileContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (currentline == lineNumber) {
                    String[] fields = line.split(csvSeparator);
                    String[] prevFields = prevLine.split(csvSeparator);
                    fields[columnNumber - 1] = Double.toString(Double.parseDouble(prevFields[columnNumber-1]) + add); // update the value in the specified column
                    line = String.join(csvSeparator, fields); // join the fields back into a CSV line
                }
                fileContent.append(line);
                fileContent.append("\n");
                currentline++;
                prevLine = line;
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("readings.csv"));
            writer.write(fileContent.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void updateCSV() {
        
    // }

    public String getAQIString(int lineNumber) {
        String[] readings = getReadings(lineNumber);
        while (lineNumber > 1 && readings[0].compareTo("-") == 0){
            lineNumber = lineNumber-1;
            readings = getReadings(lineNumber);
        }
        return readings[0];
    }
    public String getTempString(int lineNumber) {
        String[] readings = getReadings(lineNumber);
        while (lineNumber > 1 && readings[1].compareTo("-") == 0){
            lineNumber = lineNumber-1;
            readings = getReadings(lineNumber);
        }
        return readings[1];
    }
    public String gethumidString(int lineNumber) {
        String[] readings = getReadings(lineNumber);
        while (lineNumber > 1 && readings[2].compareTo("-") == 0){
            lineNumber = lineNumber-1;
            readings = getReadings(lineNumber);
        }
        return readings[2];
    }
    public String getCOString(int lineNumber) {
        String[] readings = getReadings(lineNumber);
        while (lineNumber > 1 && readings[3].compareTo("-") == 0){
            lineNumber = lineNumber-1;
            readings = getReadings(lineNumber);
        }
        return readings[3];
    }
}
