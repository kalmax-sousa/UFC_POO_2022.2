import java.util.Arrays;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trem trem = new Trem(0);

        while (true) {
            String line = sc.nextLine();
            System.out.println("$" + line);
            
            String[] input = line.split(" ");
            String cmd = input[0];
            String[] param = Arrays.copyOfRange(input, 1, input.length);

            if (cmd.equals("init")) {
                int maxVagoes = Integer.parseInt(param[0]);
                trem = new Trem(maxVagoes);
            } else if (cmd.equals("nwvag")) {
                int capacidade = Integer.parseInt(param[0]);
                trem.add(new Vagao(capacidade));
            } else if (cmd.equals("la")) {
                System.out.println(trem);
            } else if (cmd.equals("entrar")) {
                trem.embarcar(new Passageiro(param[0]));
            } else if (cmd.equals("sair")) {
                trem.desembarcar(param[0]);
            } else if( cmd.equals("cadastro") ){
                trem.cadastro();
            } else if( cmd.equals("movimentacao") ){
                trem.movimentos();
            } else if( cmd.equals("end") ){
                break;
            }
        }
    }
}