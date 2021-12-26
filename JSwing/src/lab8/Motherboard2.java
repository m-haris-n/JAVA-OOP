package lab8;

class Motherboard2 {
    static class USB{
        int usb2 = 2;
        int usb3 = 1;
        int getTotalPorts(){
            return usb2 + usb3;
        }
    }

}
class Run4 {
    public static void main(String[] args) {
        Motherboard2.USB usb = new Motherboard2.USB();
        System.out.println("Total Ports = " + usb.getTotalPorts());
    }
}
