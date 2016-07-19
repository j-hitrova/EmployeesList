import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, TransformerException {
        Scanner in = new Scanner(System.in);
        Employee employee;
        ArrayList<Employee> employeeList = new ArrayList<>();
        String filename = "target/empList.csv";
        int recordNo, yearOfBirth;
        String mode, searchString;

        File file = new File(filename);
        if (file.exists()) {
            employeeList = CsvFileReader.readCsvFile(filename);
        } else {
            file.createNewFile();
        }
        do {
            System.out.println("\nSelect operation (add/delete/list/search/save as/load from/quit): ");
            switch (mode = in.nextLine()) {
                case "add":
                    employee = new Employee();

                    System.out.print("First Name: ");
                    employee.firstname = in.nextLine();

                    System.out.print("Last Name: ");
                    employee.lastname = in.nextLine();

                    do {
                        System.out.print("Year of birth: ");
                        yearOfBirth = Integer.parseInt(in.nextLine());
                    } while (!employee.setYearOfBirth(yearOfBirth));

                    System.out.print("Department: ");
                    employee.department = in.nextLine();

                    System.out.print("Manager: ");
                    employee.manager = in.nextLine();

                    do {
                        System.out.print("Phone number (+1 234 567 89 10): ");
                    } while (! employee.setPhone(in.nextLine()));

                    employeeList.add(employee);
                    break;

                case "delete":
                    System.out.print("Enter record number to delete: ");
                    recordNo = Integer.parseInt(in.nextLine());
                    employeeList.remove(recordNo);
                    break;

                case "list":
                    for (int i = 0; i < employeeList.size(); i++){
                        Employee emp = employeeList.get(i);
                        System.out.println(i + ". " + emp.toString());
                    }
                    break;

                case "save as":
                    System.out.println("Enter filename: ");
                    filename = in.nextLine();
                    CsvFileWriter.writeCsvFile(employeeList, filename);
                    break;

                case "load from":
                    System.out.println("Enter filename: ");
                    filename = in.nextLine();
                    employeeList = CsvFileReader.readCsvFile(filename);
                    break;

                case "quit":
                    System.out.println("Good bye!");
                    break;

                case "search":
                    System.out.println("Enter name, lastname or phone number:");
                    searchString = in.nextLine();

                    for (int i = 0; i < employeeList.size(); i++) {
                        Employee emp = employeeList.get(i);
                        if (emp.firstname.toUpperCase().matches(".*" + searchString.toUpperCase() + ".*")
                                || emp.lastname.toUpperCase().matches(".*" + searchString.toUpperCase() + ".*")
                                || emp.phone.matches(".*" + searchString + ".*")) {
                            System.out.println(i + ". " + emp.toString());
                        }
                    }
                    break;

                default:
                    System.out.println("Incorrect mode selected");
            }
        } while (!Objects.equals(mode, "quit"));

        CsvFileWriter.writeCsvFile(employeeList, filename);
    }
}