/**
 * 构建者模式
 */
public class BuilderPatterns {

    public static void main(String[] args) {

        Computer computer = new ComputerDirector(new LenovoComputerBuild()).buildComputer();
        System.out.println(computer.toString());
    }

}

interface ComputerBuild {
    ComputerBuild setCpu(String cpu);

    ComputerBuild setGpu(String gpu);

    ComputerBuild setRAM(String ram);

    ComputerBuild setDisk(String disk);

    ComputerBuild setMotherboard(String motherboard);

    ComputerBuild setDisplay(String display);

    Computer build();
}


class Computer {
    private String cpu;
    private String gpu;
    private String ram;
    private String disk;
    private String power;
    private String motherboard;
    private String display;


    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram='" + ram + '\'' +
                ", disk='" + disk + '\'' +
                ", power='" + power + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}


class LenovoComputerBuild implements ComputerBuild {

    private Computer computer = new Computer();


    @Override
    public ComputerBuild setCpu(String cpu) {
        computer.setCpu(cpu + "base on Lenovo");
        return this;
    }

    @Override
    public ComputerBuild setGpu(String gpu) {
        computer.setGpu(gpu+"base on Lenovo");
        return this;
    }

    @Override
    public ComputerBuild setRAM(String ram) {
        computer.setRam(ram+"base on Lenovo");
        return this;
    }

    @Override
    public ComputerBuild setDisk(String disk) {
        computer.setDisk(disk+"base on Lenovo");
        return this;
    }

    @Override
    public ComputerBuild setMotherboard(String motherboard) {
        computer.setMotherboard(motherboard+"base on Lenovo");
        return this;
    }

    @Override
    public ComputerBuild setDisplay(String display) {
        computer.setDisplay(display+"base on Lenovo");
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }
}

class ComputerDirector {
    private ComputerBuild build;

    public ComputerDirector(ComputerBuild build) {
        this.build = build;
    }

    public Computer buildComputer() {
        return build.setCpu("cpu")
                .setDisk("disk")
                .setDisplay("display")
                .setGpu("gpu")
                .setMotherboard("motherboard")
                .setRAM("RAM")
                .build();


    }
}