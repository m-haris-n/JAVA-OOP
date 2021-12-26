package lab8;

class Car {
    String carName;
    String carType;

    public Car(String name, String type) {
        this.carName = name;
        this.carType = type;
    }

    private String getCarName() {
        return this.carName;
    }

    class Engine {
        String engineType;
        void setEngine() {

            if(Car.this.carType.equals("4WD")){

                if(Car.this.getCarName().equals("Crysler")) {
                    this.engineType = "Smaller";
                } else {
                    this.engineType = "Bigger";
                }

            }else{
                this.engineType = "Bigger";
            }
        }
        String getEngineType(){
            return this.engineType;
        }
    }
}

class  Run2{
    public static void main(String[] args) {

        Car car1 = new Car("Mazda", "8WD");

        Car.Engine engine = car1.new Engine();
        engine.setEngine();
        System.out.println("Engine Type for 8WD= " + engine.getEngineType());

        Car car2 = new Car("Crysler", "4WD");
        Car.Engine c2engine = car2.new Engine();
        c2engine.setEngine();
        System.out.println("Engine Type for 4WD = " + c2engine.getEngineType());
    }
}