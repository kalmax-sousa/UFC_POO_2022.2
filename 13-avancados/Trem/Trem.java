import java.util.ArrayList;
import java.util.Arrays;

class Movimento {
    Passageiro passageiro;
    Direcao dir;

    public Movimento(Passageiro passageiro, Direcao dir) {
        this.passageiro = passageiro;
        this.dir = dir;
    }

    public String toString() {
        return String.format("%s %s", passageiro, dir.getValue());
    }
}

class Registro {
    ArrayList<Passageiro> passageiros;
    ArrayList<Movimento> movimentos;

    public Registro() {
       this.passageiros = new ArrayList<Passageiro>();
       this.movimentos = new ArrayList<Movimento>();
    }

    public void cadastrar(Passageiro p) {
        this.passageiros.add(p);
    }

    public void movimentar(String passId, Direcao dir) {
        this.movimentos.add(new Movimento(new Passageiro(passId), dir));
    }

    public ArrayList<Passageiro> getPassageiros() {
        return this.passageiros;
    }

    public ArrayList<Movimento> getMovimentos() {
        return this.movimentos;
    }
}

public class Trem {
    int maxVagoes;
    Vagao[] vagoes;
    int totalVagoes;

    Registro registro;

    public Trem(int maxVagoes) {
        this.maxVagoes = maxVagoes;
        this.totalVagoes = 0;
        this.vagoes = new Vagao[maxVagoes];
        this.registro = new Registro();
    }

    public void add(Vagao vagao) {
        if(totalVagoes == maxVagoes){
            System.out.println("fail: limite de vagões atingido");
            return;
        }
        
        vagoes[totalVagoes] = vagao;
        totalVagoes++;
    }

    public void embarcar(Passageiro pass) {
        if(!this.exists(pass.getId())){
            this.registro.cadastrar(pass);
            
            for(Vagao e : vagoes){
                if(!e.isFull()){
                    e.embarcar(pass);
                    this.registro.movimentar(pass.getId(), Direcao.IN);
                    return;
                }
            }
            
            System.out.println("fail: trem lotado");
        }
        else
            System.out.printf("fail: %s já está no trem\n", pass.getId());
    }

    public boolean exists(String idPass) {
        for(Vagao e : vagoes){
            if(e.exists(idPass)){
                return true;
            }
        }
        
        return false;
    }

    public void desembarcar(String idPass) {
        if(this.exists(idPass))
            for(Vagao e : vagoes){
                if(e.exists(idPass)){
                    e.desembarcar(idPass);
                    this.registro.movimentar(idPass, Direcao.OUT);
                    return;
                }
            }
        else
            System.out.printf("fail: %s nao esta no trem\n", idPass);
    }

    public void cadastro(){
        for(Passageiro e : this.registro.getPassageiros())
            System.out.println(e);
    }
    
    public void movimentos(){
        for(Movimento e : this.registro.getMovimentos())
            System.out.println(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trem ");
        for(Vagao e : this.vagoes){
            if(e != null)
                sb.append(e);
        }
        
        return sb.toString();
    }
}