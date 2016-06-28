package com.test.empList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

        Scanner in = new Scanner(System.in);

        System.out.print("First Name: ");
        employee.firstname = in.nextLine();

        System.out.print("Last Name: ");
        employee.lastname = in.nextLine();

        System.out.print("Year of birth: ");
        employee.yearOfBirth = Integer.parseInt(in.nextLine());

        System.out.print("Department: ");
        employee.department = in.nextLine();

        System.out.print("Manager: ");
        employee.manager = in.nextLine();

        System.out.print("Phone number: ");
        employee.phone = in.nextLine();


/*
        employee.firstname = "Vasya";
        employee.lastname = "Petrov";
        employee.department = "IT";
        employee.manager = "Fedor Potemkin";
        employee.phone = "+71234567890";
*/
        employeeList.add(employee);

        objectOutputStream.writeObject(employeeList);
        fileOutputStream.close();

        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("EmpNo " + i + ". " + employeeList.get(i).firstname + " " + employeeList.get(i).lastname +
                    " born in " + employeeList.get(i).yearOfBirth + " year, works in " +
                    employeeList.get(i).department + " under " + employeeList.get(i).manager +
                    " management and has phone number " + employeeList.get(i).phone);
        }
    }
}
