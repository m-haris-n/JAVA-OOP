package lab8;

class Motherboard {
//    String model;
    static String model="2";
    public Motherboard(String mod) {
        model = mod;
//        Motherboard.model = model;
    }

    static class USB{
        int usb2 = 2;
        int usb3 = 1;
        int getTotalPorts(){

//            if(model.equals("MSI")) {
            if(model.equals("MSI")) {
                return 4;
            }
            else {
                return usb2 + usb3;
            }
        }
    }
}
class Run3 {
    public static void main(String[] args) {
        Motherboard.USB usb = new Motherboard.USB();
        System.out.println("Total Ports = " + usb.getTotalPorts());
    }
}