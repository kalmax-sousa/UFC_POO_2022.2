import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        ArrayList<Shape> lista = new ArrayList<Shape>();
        Scanner sc = new Scanner(System.in);
        while(true){
            String line = sc.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(line.equals("end")) {
                break;
            } else if(ui[0].equals("circulo")) {
                double x = Double.parseDouble(ui[1]);
                double y = Double.parseDouble(ui[2]);
                double r = Double.parseDouble(ui[3]);
                Ponto2D pc = new Ponto2D( x, y);
                Circulo c = new Circulo(pc, r);
                lista.add(c);

            } else if(ui[0].equals("retangulo")) {
                double x1 = Double.parseDouble(ui[1]);
                double y1 = Double.parseDouble(ui[2]);
                double x2 = Double.parseDouble(ui[3]);
                double y2 = Double.parseDouble(ui[4]);
                Retangulo r = new Retangulo(new Ponto2D(x1, y1), new Ponto2D (x2, y2));
                lista.add(r);
                
            } else if(ui[0].equals("area")) {
                double total = 0;
                for(Shape el : lista){
                    total += el.area();
                }
                
                System.out.printf("area total: %.2f\n", total);
                
                
            } else if(ui[0].equals("perimetro")) {
                double total = 0;
                for(Shape el : lista){
                    total += el.perimeter();
                }
                
                System.out.printf("perimetro total: %.2f\n", total);
                
                
            } else if(ui[0].equals("inside")) {//value value
                double x = Double.parseDouble(ui[1]);
                double y = Double.parseDouble(ui[2]);
                Ponto2D p = new Ponto2D(x, y);
                for(Shape el : lista){
                    System.out.println(el.inside(p));
                }
                
                
            } else if(ui[0].equals("mostra")) {
                System.out.println("Figura:");
                for(Shape el : lista){
                    System.out.println(el);
                }
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
        sc.close();
    }

}