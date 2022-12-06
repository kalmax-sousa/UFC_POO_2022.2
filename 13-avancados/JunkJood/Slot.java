public class Slot{
    String name;
    int quantity;
    float price;

    public Slot() {
        this.name = "empty";
        this.price = 0;
        this.quantity = 0;
    }

    public Slot(String name, int quantity, float price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return String.format("[ %7s : %d U : %.2f RS]", this.name, this.quantity, this.price);
    }
}