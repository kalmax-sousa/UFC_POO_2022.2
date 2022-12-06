public class VendingMachine {
    Slot[] slots;
    float profit;
    float cash;
    int capacity;

    VendingMachine(int capacity) {
        this.slots = new Slot[capacity];
        this.profit = 0;
        this.cash = 0;
        this.capacity = capacity;
        
        for(int i = 0; i < capacity; i++){
            this.slots[i] = new Slot();
        }
    }

    Slot getSlot(int index) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >= this.capacity)
            throw new ArrayIndexOutOfBoundsException();
            
        return this.slots[index];
    }

    void setSlot(int index, Slot s) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >= this.capacity)
            throw new ArrayIndexOutOfBoundsException();
            
        this.slots[index] = s;
    }

    void clearSlot(int index) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >= this.capacity)
            throw new ArrayIndexOutOfBoundsException();
            
        this.slots[index] = new Slot();
    }

    void insertCash(float cash) {
        this.profit += cash;
        this.cash = this.profit;
    }

    float withdrawCash(){
        this.profit -= this.cash;
        return this.cash;
    }

    float getCash() {
        return this.cash;
    }

    float getProfit() {
        return this.profit;
    }

    void buyItem(int index) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >= this.capacity)
            throw new ArrayIndexOutOfBoundsException();
        
        else if(this.getSlot(index).price > this.profit){
            System.out.println("fail: saldo insuficiente");
            return;
        }
        
        else if(this.getSlot(index).getQuantity() == 0){
            System.out.println("fail: espiral sem produtos");
            return;
        }
        
        else {
            this.getSlot(index).setQuantity(this.getSlot(index).getQuantity()-1);
            this.cash -= this.getSlot(index).price;
            this.profit -= this.getSlot(index).price;
            System.out.printf("voce comprou um %s\n", this.getSlot(index).getName());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("saldo: %.2f", this.profit));
        for(int i = 0; i < this.capacity; i++){
            sb.append(String.format("\n%d %s", i, this.slots[i]));
        }
        return sb.toString();
    }
}