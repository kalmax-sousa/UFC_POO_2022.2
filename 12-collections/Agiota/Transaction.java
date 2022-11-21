public class Transaction {
    private String codename;
    private int id;
    private int value;

    public Transaction(int id, String codename, int value){
        this.id = id;
        this.codename = codename;
        this.value = value;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getCodename(){
        return this.codename;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public String toString(){
        return String.format("id:%d %s:%d\n", this.id, this.codename, this.value);
    }

}
