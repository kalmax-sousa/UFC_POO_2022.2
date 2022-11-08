import java.util.Scanner;

public class garcom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int coposDerrubados = 0;
        for (int i = 0; i < n; i++) {
            int latas = sc.nextInt();
            int copos = sc.nextInt();

            if(latas > copos) coposDerrubados += copos;
        }

        System.out.println(coposDerrubados);
    }
}