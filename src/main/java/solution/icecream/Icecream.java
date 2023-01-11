package solution.icecream;

public class Icecream {
    public String name;
    public int price;

    public Icecream() {

    }

    public Icecream (Icecream icecream) {
        this.name = icecream.getName();
        this.price = icecream.getPrice();
    }

    public Icecream(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Icecream{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
