import java.util.ArrayList;
import java.util.List;
interface Employee {
    void showEmployeeDetails();
}
class Developer implements Employee {
    private String name;
    private int id;

    public Developer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Developer [ID: " + id + ", Name: " + name + "]");
    }
}

class Manager implements Employee {
    private String name;
    private int id;

    public Manager(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Manager [ID: " + id + ", Name: " + name + "]");
    }
}
class CompanyDirectory implements Employee {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void showEmployeeDetails() {
        for (Employee emp : employees) {
            emp.showEmployeeDetails();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer("VISHNU", 461);
        Developer dev2 = new Developer("KESAV", 455);
        Manager man1 = new Manager("SHONE", 456);

        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(dev1);
        directory.addEmployee(dev2);
        directory.addEmployee(man1);

        directory.showEmployeeDetails();
    }
}
