package com.test.empList;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "empList.sav";
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        Employee employee = new Employee();
        ArrayList<Employee> employeeList;

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        employeeList = (ArrayList<Employee>) objectInputStream.readObject();
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        employee.firstname = "Alexander";
        employee.lastname = "Paul";
        employeeList.add(employee);

        objectOutputStream.writeObject(employeeList);
        fileOutputStream.close();


        for (Employee employeeOut : employeeList
                ) {
            System.out.println(employeeOut.firstname + " " + employeeOut.lastname);
        }
    }
}
