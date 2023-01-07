package reflction;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car() {

    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAllField(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", position=" + position + '}';
    }
}
