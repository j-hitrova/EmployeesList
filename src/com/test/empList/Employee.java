package com.test.empList;

import java.io.Serializable;
import java.util.Calendar;

public class Employee implements Serializable {
    String firstname, lastname, phone, department, manager;
    Integer yearOfBirth;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public boolean setYearOfBirth(Integer yearOfBirth) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (yearOfBirth > 1900 && yearOfBirth < currentYear) {
            this.yearOfBirth = yearOfBirth;
            return true;
        } else {
            return false;
        }
    }
}
