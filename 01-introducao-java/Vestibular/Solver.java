import java.util.Scanner;

public class vestib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String gabarito = sc.nextLine();
        String respostas = sc.nextLine();

        int acertos = 0;
        for (int i = 0; i < gabarito.length(); i++) {
            if(gabarito.charAt(i) == respostas.charAt(i)) acertos++;
        }

        System.out.println(acertos);
    }
}