package org;

import java.util.ArrayList;

public class Department implements OrgUnit {
    private final String name;
    private final ArrayList<OrgUnit> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void add(OrgUnit unit) {
        children.add(unit);
    }

    public void remove(OrgUnit unit) {
        children.remove(unit);
    }

    @Override
    public double getTotalSalary() {
        double sum = 0;
        for (OrgUnit u : children) {
            sum += u.getTotalSalary();
        }
        return sum;
    }

    @Override
    public String toXml(int indent) {
        String xml = spaces(indent) + "<department name=\"" + name + "\">\n";

        for (OrgUnit u : children) {
            xml += u.toXml(indent + 2);
        }

        xml += spaces(indent) + "</department>\n";
        return xml;
    }

    private String spaces(int n) {
        String s = "";
        for (int i = 0; i < n; i++) s += " ";
        return s;
    }
}
