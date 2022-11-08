import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Empresa{
    private ArrayList<Empregado> empregados = new ArrayList<Empregado>();

    Empresa(){
        
    }

    public void adicionaEmpregado(Empregado e){
        empregados.add(e);
    }

    public void mostraEmpregado(){
        System.out.println("Empresa: ");
        for(Empregado empregado : this.empregados){
            System.out.println(empregado);
        }
    }

    public double calculaFolha(){
        double r = 0;
        for(Empregado empregado : this.empregados){
            r += empregado.pagamento();
        }
        
        return r;
    }
}