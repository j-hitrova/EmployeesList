import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileReader {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";

    public static ArrayList<Employee> readCsvFile(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        try {

            //Create a new list of employees to be filled by CSV file data
            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //Read the CSV file header to skip it
            fileReader.readLine();

            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Employee employee = new Employee();
                    employee.setFirstname(tokens[0]);
                    employee.setLastname(tokens[1]);
                    employee.setYearOfBirth(Integer.parseInt(tokens[2]));
                    employee.setPhone(tokens[3]);
                    employee.setDepartment(tokens[4]);
                    employee.setManager(tokens[5]);
                    employeeList.add(employee);
                }
            }

            //Print the new employees list
            for (int i = 0; i < employeeList.size(); i++) {
                Employee emp = employeeList.get(i);
                System.out.println(i + ". " + emp.toString());
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return employeeList;
    }
}