package buildercomputer;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Build gaming computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getComputer();

        System.out.println("=== Gaming Computer ===");
        System.out.println(gamingComputer);

        System.out.println();

        // Build office computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder);
        Computer officeComputer = officeBuilder.getComputer();

        System.out.println("=== Office Computer ===");
        System.out.println(officeComputer);
    }
}