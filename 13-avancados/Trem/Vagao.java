import java.util.Arrays;

public class Vagao {
    Passageiro [] cadeiras;
    int totalPassageiros;
    int maxPassageiros;
    
    public Vagao(int capacidade) {
        this.maxPassageiros = capacidade;
        this.totalPassageiros = 0;
        this.cadeiras = new Passageiro[capacidade];
        for(int i = 0; i < capacidade; i++)
            cadeiras[i] = new Passageiro("-");
    }    

    void embarcar(Passageiro pass){
        for(int i = 0; i < this.maxPassageiros; i++)
            if(this.cadeiras[i].getId().equals("-")){
                this.cadeiras[i] = pass;
                this.totalPassageiros++;
                return;
            }
    }

    void desembarcar(String idPass){
        for(int i = 0; i < this.maxPassageiros; i++)
            if(idPass.equals(this.cadeiras[i].getId())){
                this.cadeiras[i] = new Passageiro("-");
                this.totalPassageiros--;
                return;
            }
    }

    boolean exists(String idPass){
        for(Passageiro e : this.cadeiras){
            if(idPass.equals(e.getId()))
                return true;
        }
        
        return false;
    }
    
    boolean isFull(){
        return this.totalPassageiros == this.maxPassageiros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(Passageiro e : this.cadeiras){
            sb.append(e + " ");
        }
        sb.append("]");
        
        return sb.toString();
    }
}