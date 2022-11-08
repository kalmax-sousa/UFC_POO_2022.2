import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

class ComputaSequencia{
    private ArrayList<Integer> v = new ArrayList<Integer>();

    public void cadastra(int valor){
        if(valor == 0){
            v.remove(v.size()-1);
        }
        else{
            v.add(valor);
        }
    }

    public int computa(){
        int sum = 0;
        for(int x : v){
            sum += x;
        }
        
        return sum;
    }

    public String toString(){
        return String.format("valores = %s", v);
    }


    
}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputaSequencia sequencia = new ComputaSequencia();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break; 
            } else if(ui[0].equals("cadastra")) {
                sequencia.cadastra( Integer.parseInt( ui[1]) );
            } else if(ui[0].equals("computa")) {
                System.out.println( sequencia.computa() ); 
            } else if(ui[0].equals("show")) {
                System.out.println( sequencia );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
