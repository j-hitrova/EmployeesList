package com.test.empList;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee employee = new Employee();
        ArrayList<Employee> employeeList;

        String filename = "out/empList.sav";
        File file = new File(filename);
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            employeeList = (ArrayList<Employee>) objectInputStream.readObject();
            fileInputStream.close();
        } else {
            employeeList = new ArrayList<>();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        employee.firstname = "Vasya";
        employee.lastname = "Petrov";
        employee.department = "IT";
        employee.manager = "Fedor Potemkin";
        employee.phone = "+71234567890";

        employeeList.add(employee);

        objectOutputStream.writeObject(employeeList);
        fileOutputStream.close();


        for (Employee employeeOut : employeeList
                ) {
            System.out.println(employeeOut.firstname + " " + employeeOut.lastname);
        }
    }
}
