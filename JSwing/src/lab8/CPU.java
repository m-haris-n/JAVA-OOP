package lab8;

public class CPU {
    class Processor{
        final int cache = 3;
        int cores;

        final double clock = 5.5;
        String company = "INTEL";

        String getClockSpeed(){
            return clock+" GHz";
        }

        String getCache(){
            return cache+" MBs L2 Cache";
        }
    }

    protected class RAM{
        final double clock = 5.5;
        int size;
        final int flipFlops = 2000;
        String company = "GIGABYTE";

        String getFlipFlops(){
            return flipFlops+" Flip FLops";
        }
    }
}

class Run {
    public static void main(String[] args) {

        CPU cpu = new CPU();

        CPU.Processor processor = cpu.new Processor();

        CPU.RAM ram = cpu.new RAM();
        System.out.println("Processor Cache = " + processor.getCache());
        System.out.println("CPU Clock speed = " + processor.getClockSpeed());
        System.out.println("Ram Flip Flop = " + ram.getFlipFlops());

    }
}