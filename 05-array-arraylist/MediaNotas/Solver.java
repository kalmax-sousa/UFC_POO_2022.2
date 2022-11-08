import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;


class MediaNotas{

    private ArrayList<Double> notas = new ArrayList<Double>();

    public void addNota(double nota){
        notas.add(nota);
    }

    public void removeNota(int index){
        if(index > notas.size() - 1){
            System.out.println("falha: indice invalido");
        }
        else {
            notas.remove(index);
        }
    }

    public void mudaNota(int index, double valor){
        notas.set(index, valor);
    }

    public double maiorNota(){
        double max = 0;
        for(double x : notas){
            if(x > max) max = x;
        }
        
        return max;
    }

    public double menorNota(){
        double min = 0;
        for(double x : notas){
            if(x < min) min = x;
        }
        
        return min;
    }

    double media(){
        double sum = 0;
        for(double x : notas){
            sum += x;
        }
        
        return sum/notas.size();
    }

    void parametriza(){
        double max = maiorNota();
        for (int i = 0; i < notas.size(); i++) {
            notas.set(i, notas.get(i)/max*10);
        }
    }

    public String toString(){
        String r = "[";
        for(int i = 0; i < notas.size(); i++){
            if(i == 0){
                r += String.format("%.2f", notas.get(i));    
            }
            else{
                r += String.format(", %.2f", notas.get(i));
            }
        }
        
        return r + "]";
    }
}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaNotas m = new MediaNotas();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break; 
            } else if(ui[0].equals("addNota")) {
                m.addNota( Double.parseDouble( ui[1]) );
            } else if(ui[0].equals("removeNota")) {
                m.removeNota( Integer.parseInt( ui[1]) ); 
            } else if(ui[0].equals("maiorNota")) {
                System.out.println( m.maiorNota() );
            } else if(ui[0].equals("menorNota")) {
                System.out.println( m.menorNota() );
            } else if(ui[0].equals("media")) {
                System.out.printf( Locale.US, "%.2f\n",  m.media() );
            }else if(ui[0].equals("parametriza")) {
                m.parametriza(); 
            }else if(ui[0].equals("show")) {
                System.out.println( m );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
