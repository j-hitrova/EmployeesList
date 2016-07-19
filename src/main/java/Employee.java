
import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;

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

    public boolean setYearOfBirth(String strYearOfBirth) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearOfBirth;

        if (! strYearOfBirth.isEmpty() && Pattern.matches("\\d{4}", strYearOfBirth)){
            yearOfBirth = Integer.parseInt(strYearOfBirth);
        } else {
            System.err.println("Four digits are expected! Try again");
            return false;
        }

        if (yearOfBirth > (currentYear - 100) && yearOfBirth < (currentYear - 16)) {
            this.yearOfBirth = yearOfBirth;
            return true;
        } else {
            System.err.println("Age should not be more than 100 year or less than 16. Try again");
            return false;
        }
    }

    public boolean setPhone (String phone) {
        if (phone.matches("^\\+\\d{1,2}\\s+\\d{3}\\s+\\d{3}\\s+\\d{2}\\s+\\d{2}$"))
        {
            this.phone = phone;
            return true;
        } else {
            System.err.println("Try again!");
            return false;
        }
    }

    public String toString(){
        return this.getFirstname() + " " + this.getLastname() + " " + this.getYearOfBirth() + " "
                + this.getPhone() + " " + this.getDepartment() + " " + this.getManager();
    }
}
