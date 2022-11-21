import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;

public class Agiota {
    private int balance;
    private int nextTrId;
    Map<String,Client> repCli;
    Map<Integer, Transaction> repTr; 
    
    public Agiota(int balance){
        this.balance = balance;
        this.nextTrId = 0;
        repCli = new TreeMap<String, Client>();
        repTr = new TreeMap<Integer, Transaction>();
    }
    
    public void addClient(String codename, int limit){
        if(repCli.containsKey(codename)){
            System.out.println("fail: cliente ja existe");
        }
        else {
            repCli.put(codename, new Client(codename, limit));
        }
    }
    
    public void lends(String codename, int value){
        if(!repCli.containsKey(codename)){
            System.out.println("fail: cliente nao existe");
        }
        else {
            Client c = repCli.get(codename);
            if(this.balance < value){
                System.out.println("fail: fundos insuficientes");
            }
            else if((c.getBalance() + value) > c.getLimit()){
                System.out.println("fail: limite excedido");
            }
            else{
                Transaction t = new Transaction(this.nextTrId, codename, value);
                repTr.put(this.nextTrId, t);
                this.nextTrId++;
                this.balance -= value;
                c.setBalance(c.getBalance() + value);
            }
        }
    }
    
    public void kill(String codename){
        Iterator<Map.Entry<Integer, Transaction>> it = repTr.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Transaction> entry = it.next(); 
            if(entry.getValue().getCodename().equals(codename)){
                it.remove();
            }
        }
        repCli.remove(codename);
    }
    
    public void receive(String codename, int value){
        Client c = repCli.get(codename);
        if(c.getBalance() < value){
            System.out.println("fail: valor maior que a divida");
        }
        else {
            c.setBalance(c.getBalance()-value);
            Transaction t = new Transaction(this.nextTrId, codename, -value);
            repTr.put(this.nextTrId, t);
            this.nextTrId++;
            this.balance += value;
        }
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("clients:\n");
        
        for(String codename : repCli.keySet()){
            sb.append("- " + repCli.get(codename));
        }
        sb.append("transactions:\n");
        
        for(int id : repTr.keySet()){
            sb.append("- " + repTr.get(id));
        }
        
        sb.append("balance: " + this.balance);
        
        return sb.toString();
    }
    
    
    
    

    
}
