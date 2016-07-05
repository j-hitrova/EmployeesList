import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileWriter {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "id,firstName,lastName,yearOfBirth,phone,department,manager";
    public static void writeCsvFile(ArrayList<Employee> employeeList, String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Employee employee : employeeList) {
                fileWriter.append(employee.getFirstname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(employee.getLastname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(employee.getYearOfBirth()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(employee.getPhone());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(employee.getDepartment());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(employee.getManager());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}