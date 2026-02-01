import org.Department;
import org.Employee;

public class Main {

    public static void main(String[] args) {
        Department company = new Department("TechNova");
        Department engineering = new Department("Engineering");
        Department backend = new Department("Backend");
        Department frontend = new Department("Frontend");
        Department hr = new Department("HR");

        Employee alice = new Employee("Alice", 3500);
        Employee bob = new Employee("Bob", 3200);
        Employee carol = new Employee("Carol", 3000);
        Employee dave = new Employee("Dave", 2500);

        backend.add(alice);
        backend.add(bob);
        frontend.add(carol);
        engineering.add(backend);
        engineering.add(frontend);
        hr.add(dave);
        company.add(engineering);
        company.add(hr);
        System.out.println(company.getTotalSalary());
        hr.remove(dave);
        System.out.println(company.getTotalSalary());
        System.out.println(company.toXml(0));
    }
}
