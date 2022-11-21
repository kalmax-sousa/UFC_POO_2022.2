public class Client {
    private int balance;
    private String codename;
    private int limit;
    
    public Client(String codename, int limit){
        this.codename = codename;
        this.limit = limit;
        this.balance = 0;
    }
    
    public int getBalance(){
        return this.balance;
    }
    
    public void setBalance(int newBalance){
        this.balance = newBalance;
    }
    
    public int getLimit(){
        return this.limit;
    }
    
    public String getCodename(){
        return this.codename;
    }
    
    public String toString(){
        return String.format("%s:%d/%d\n", this.codename, this.balance, this.limit);
    }
}