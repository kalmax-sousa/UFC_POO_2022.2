import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class TestRelation {

    public static void main(String[] args) {
        Relation r = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if (line.equals("end")) {
                break;
            } else if (ui[0].equals("createRelation")) {
                Set<Integer> s = new HashSet<>();
                for (int i = 1; i < ui.length; i++) {
                    s.add(Integer.parseInt(ui[i]));
                }
                r = new Relation(s);

            } else if (ui[0].equals("addPair")) {

                int a = Integer.parseInt(ui[1]);
                int b = Integer.parseInt(ui[2]);
                try {
                    r.addPair(a, b);
                } catch (InvalidPairException e) {
                    System.out.println(e);
                }
            } else if (ui[0].equals("hasPair")) {
                int a = Integer.parseInt(ui[1]);
                int b = Integer.parseInt(ui[2]);
                System.out.println(r.hasPair(a, b));
            } else if (ui[0].equals("isReflexive")) {// value value
                System.out.println(r.isReflexive());

            } else if (ui[0].equals("checkReflexive")) {// value value
                r.checkReflexive();

            } else if (ui[0].equals("isSymmetric")) {// value value
                System.out.println(r.isSymmetric());

            } else if (ui[0].equals("checkSymmetric")) {// value value
                r.checkSymmetric();

            } else if (ui[0].equals("isTransitive")) {// value value
                System.out.println(r.isTransitive());

            } else if (ui[0].equals("checkTransitive")) {// value value
                r.checkTransitive();

            } else if (ui[0].equals("show")) {// value value
                System.out.println(r);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        sc.close();

    }

}