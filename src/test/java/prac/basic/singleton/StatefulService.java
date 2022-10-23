package prac.basic.singleton;

public class StatefulService {
    public int price;

    public void order(String user, int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
