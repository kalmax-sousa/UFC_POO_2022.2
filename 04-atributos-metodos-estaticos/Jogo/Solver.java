import java.util.Scanner;
import java.util.Locale;


class Jogo{
    
    private int numJogadores;
    private int [] armadilha = new int[3];
    private int [] posicao = {0, 0};
    private boolean [] podeJogar = {true, true};
    private int numCasas;
    private int numArmadilha = 0;
    private int prox = 0;
    private boolean fimDoJogo = false;
    
    public Jogo(int numJogadores, int numCasas){
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;
    }
    
    public void addArmadilha(int t){
        armadilha[numArmadilha] = t;
        numArmadilha++;
    }
    
    public boolean caiuArmadilha(int t){
        for(int i = 0; i < numArmadilha; i++){
            if(armadilha[i] == t){
                return true;
            }
        }
        
        return false;
    }
    
    public void addMove(int d1, int d2){
        if(fimDoJogo){
            System.out.println("O jogo acabou");
        }
        else{
            
            if(!podeJogar[prox]){
                podeJogar[prox] = true;
                System.out.printf("O jogador %d passa a vez\n", prox+1);
                prox = prox == 0 ? 1 : 0;
            }
            
            posicao[prox] += d1 + d2;
            System.out.printf("O jogador %d vai para a casa %d\n", prox+1, posicao[prox]);
            
            if(caiuArmadilha(posicao[prox])){
                podeJogar[prox] = false;
                System.out.printf("O jogador %d caiu em um armadilha\n", prox+1);
            }
            
            if(posicao[prox] > numCasas) {
                fimDoJogo = true;
                System.out.printf("O jogador %d venceu o jogo\n", prox+1);
            }
            else {
                prox = prox == 0 ? 1 : 0;
            }
        }
    }
    public String toString(){
        return String.format("PosJogador[1] = %d\nPosJogador[2] = %d\n", posicao[0], posicao[1]);
    }
}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault ( Locale.US ) ;
        Jogo jogo = new Jogo(0,0);

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("init")) {
                jogo = new Jogo( Integer.parseInt( ui[1]),  Integer.parseInt( ui[2]) );
            } else if(ui[0].equals("end")) {
                break; 
            } else if(ui[0].equals("addArmadilha")) {
                jogo.addArmadilha( Integer.parseInt( ui[1]) ); 
            } else if(ui[0].equals("addMove")) {
                int d1 = Integer.parseInt( ui[1]);
                int d2 = Integer.parseInt( ui[2]);
                jogo.addMove(d1, d2);
            } else if(ui[0].equals("show")) {
                System.out.println(jogo);
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}