package org;

public class Employee implements OrgUnit {
    private final String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public String toXml(int indent) {
        return spaces(indent) + "<employee name=\"" + name + "\" salary=\"" + salary + "\" />\n";
    }

    private String spaces(int n) {
        String s = "";
        for (int i = 0; i < n; i++) s += " ";
        return s;
    }
}
