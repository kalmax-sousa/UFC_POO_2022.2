import java.util.Scanner;
import java.util.TreeMap;

public class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agiota a = new Agiota(0);
        
        while(true){
            String line = sc.nextLine();
            System.out.println("$" + line);
            String[] param = line.split(" ");
            
            if(param[0].equals("init")){
                int balance = Integer.parseInt(param[1]);
                a = new Agiota(balance);
            }
            else if(param[0].equals("addCli")){
                String codename = param[1];
                int limit = Integer.parseInt(param[2]);
                a.addClient(codename, limit);
            }
            else if(param[0].equals("lend")){
                String codename = param[1];
                int value = Integer.parseInt(param[2]);
                a.lends(codename, value);
            }
            else if(param[0].equals("show")){
                System.out.println(a);
            }
            else if(param[0].equals("receive")){
                String codename = param[1];
                int value = Integer.parseInt(param[2]);
                a.receive(codename, value);
            }
            else if(param[0].equals("kill")){
                String codename = param[1];
                a.kill(codename);
            }
            else if(param[0].equals("end")){
                break;
            }
        }
    }
}