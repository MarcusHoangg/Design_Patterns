package buildercomputer;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
    }

    @Override
    public void buildRAM() {
        computer.setRam(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4070");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}