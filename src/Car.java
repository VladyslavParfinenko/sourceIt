public class Car {

    private final int FUEL = 0;

    private String carName;
    private int maxFuel;
    private int fuel;

    private Engine engine = new Engine(5);

    private Wheel frontRight = new Wheel();
    private Wheel frontLeft = new Wheel();
    private Wheel rearRight = new Wheel();
    private Wheel rearLeft = new Wheel();

    Car(){
        this.carName = "Неопределено";
        this.maxFuel = FUEL;
        this.fuel = maxFuel;
    }
    Car(String name, int fuel){
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("У машины должна быть марка");
        } else
            this.carName = name;
        if(fuel < 0)
            throw new IllegalArgumentException("Ёмкость бака не может быть отрецательной");
        else
            this.maxFuel = fuel;
        this.fuel = maxFuel;
    }
    Car(String name, int fuel, int tank){
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("У машины должна быть марка");
        } else
            this.carName = name;
        if(fuel < 0)
            throw new IllegalArgumentException("Ёмкость бака не может быть отрецательной");
        else
            this.maxFuel = tank;
        this.fuel = maxFuel;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setTank(int tank){
        this.maxFuel = tank;
        this.fuel = this.maxFuel;
    }

    public int getFuel(){
        return this.fuel;
    }

    public void ride() {
        if(this.fuel==0)
            System.out.println("Ехать не возможно, бак пуст");
        else if (!engine.hasSterted()){
            System.out.println("Дигатель не заведён");
        }
        else {
            System.out.println("Едем");
            isRide();
        }
    }

    private void isRide(){
        int balance = this.fuel;
        int border = this.engine.getExpense();
        for(int i = balance; i > 0; i-=border){
            if(balance - this.engine.getExpense() < 0){
                this.engine.stopEngine();
                break;
            } else {
                balance = balance - this.engine.getExpense();
                this.engine.increase();
            }
        }
        this.fuel = balance;
        this.engine.stopEngine();
        System.out.println("Мало бениза, необходимо заправится");
    }

    public void chargeFuel(int fuel) {
        int balance = this.maxFuel - this.fuel;
        int availability = this.maxFuel - balance;
        if(this.maxFuel==0)
            System.out.println("Не инициализирована ёмкость бака");
        else if(this.maxFuel < fuel)
            System.out.println("Бак на " + this.maxFuel + " литров, в него не влезет " + fuel + " литров");
        else if (availability + fuel == this.maxFuel){
            System.out.println("Машина успешно заправлена на " + fuel + " литров");
        }
        else if (this.fuel == this.maxFuel && this.maxFuel - this.fuel!=0){
            System.out.println("Невозмонжно заправить на " + fuel + " литров");
            System.out.println("Бак не пуст. Остаток " + availability + " литров");
            System.out.println("Заправить можно не больше чем на " + balance + " литров");
        }
        else {
            this.fuel = fuel;
            System.out.println("Машина успешно заправлена на " + fuel + " литров");
        }
    }

    public void changeWheel(double radius) {
        if(this.engine.hasSterted()){
            System.out.println("Нельзя менять колёса на ходу");
        } else {
            this.frontRight = new Wheel(radius);
            this.frontLeft = new Wheel(radius);
            this.rearRight = new Wheel(radius);
            this.rearLeft = new Wheel(radius);
            System.out.println("Колёса успешно заменены");
        }
    }

    public void startEngine(){
        if(this.fuel!=0)
            this.engine.startEngine();
        else
            System.out.println("Машину не завести, бак пуст");
    }

    public int getMileage(){
        return this.engine.getMileage();
    }
    public void setExpense(int expense){
        this.engine.setExpense(expense);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (maxFuel != car.maxFuel) return false;
        if (!carName.equals(car.carName)) return false;
        if (!engine.equals(car.engine)) return false;
        if (!frontLeft.equals(car.frontLeft)) return false;
        if (!frontRight.equals(car.frontRight)) return false;
        if (!rearLeft.equals(car.rearLeft)) return false;
        if (!rearRight.equals(car.rearRight)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carName.hashCode();
        result = 31 * result + maxFuel;
        result = 31 * result + engine.hashCode();
        result = 31 * result + frontRight.hashCode();
        result = 31 * result + frontLeft.hashCode();
        result = 31 * result + rearRight.hashCode();
        result = 31 * result + rearLeft.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Car{");
        sb.append("carName='").append(carName).append('\'');
        sb.append(", maxFuel=").append(maxFuel);
        sb.append(", fuel=").append(fuel);
        sb.append(", engine expense=").append(engine.getExpense());
        sb.append(", engine mileage=").append(engine.getMileage());
        sb.append(", frontRight=").append(this.frontRight.getRadius());
        sb.append(", frontLeft=").append(this.frontLeft.getRadius());
        sb.append(", rearRight=").append(this.rearRight.getRadius());
        sb.append(", rearLeft=").append(this.rearLeft.getRadius());
        sb.append('}');
        return sb.toString();
    }
}
class CarRunner {
    public static void main(String[] args) {
        Car mitsuboshi = new Car();
        inicializateCar(mitsuboshi);
        System.out.println(mitsuboshi.getCarName());
        mitsuboshi.ride();
        mitsuboshi.chargeFuel(100);
        mitsuboshi.ride();
        mitsuboshi.startEngine();
        mitsuboshi.changeWheel(21);
        mitsuboshi.ride();
        System.out.println("Пробег автомобиля составляет " + mitsuboshi.getMileage() + " км.");
        System.out.println("Остаток топлива " + mitsuboshi.getFuel() + " литров.");
        mitsuboshi.chargeFuel(119);
        mitsuboshi.ride();
        mitsuboshi.startEngine();
        mitsuboshi.ride();
        mitsuboshi.changeWheel(21);
        System.out.println("Пробег автомобиля составляет " + mitsuboshi.getMileage() + " км.");
        System.out.println("Остаток топлива " + mitsuboshi.getFuel() + " литров.");

        System.out.println(mitsuboshi.toString());
    }

    public static void inicializateCar(Car car){
        car.setExpense(7);
        car.setCarName("Lancer");
        car.setTank(120);
    }
}
class Engine {

    private int mileage = 0;
    private boolean hasStarted = false;
    private int expense=5;

    public Engine(int expense){
        this.expense = expense;
    }

    public void startEngine(){
        this.hasStarted = true;
        System.out.println("Двигатель заведён");
    }
    public void stopEngine(){
        this.hasStarted = false;
    }

    public boolean hasSterted(){
        return this.hasStarted;
    }

    public void setExpense(int expense){
        this.expense = expense;
    }

    public int getExpense(){
        return this.expense;
    }

    public int getMileage(){
        return this.mileage;
    }
    public void increase(){
        this.mileage++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;

        Engine engine = (Engine) o;

        if (expense != engine.expense) return false;
        if (hasStarted != engine.hasStarted) return false;
        if (mileage != engine.mileage) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mileage;
        result = 31 * result + (hasStarted ? 1 : 0);
        result = 31 * result + expense;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Engine{");
        sb.append("mileage=").append(mileage);
        sb.append(", hasStarted=").append(hasStarted);
        sb.append(", expense=").append(expense);
        sb.append('}');
        return sb.toString();
    }
}
class Wheel {

    private final double RADIUS = 15;

    private double radius;

    Wheel(){
        this.radius = RADIUS;
    }

    Wheel(double radius){
        if(radius < 14 || radius > 32){
            throw new IllegalArgumentException("Размер колеса должен быть от 14 до 32 дюймов");
        } else
            this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRaduis(double radius){
        if(radius < 14 || radius > 32){
            throw new IllegalArgumentException("Размер колеса должен быть от 14 до 32 дюймов");
        } else
            this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wheel)) return false;

        Wheel wheel = (Wheel) o;

        if (Double.compare(wheel.radius, radius) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wheel{");
        sb.append("radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }
}
