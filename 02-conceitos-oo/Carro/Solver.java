import java.util.Scanner;
import java.text.*;

class Car{
    public int pass = 0; // Passageiros
    public int passMax = 2; // limite de Passageiros
    public int gas = 0; // tanque
    public int gasMax = 100; // limite do tanque
    public int km = 0; // quantidade de quilometragem
    
    public String toString(){
        return "pass: " + pass + ", gas: " + gas + ", km: " + km;
    };
    public void enter(){
        if(pass == passMax)
            System.out.println("fail: limite de pessoas atingido");
        else pass++;
    };
    public void leave(){
        if(pass == 0)
            System.out.println("fail: nao ha ninguem no carro");
        else pass--;
    };
    public void fuel(int gas){
        this.gas += gas;
        this.gas = this.gas > gasMax ? gasMax : this.gas;
    };
    public void drive (int km){
        if(gas == 0)
            System.out.println("fail: tanque vazio");
        else if(pass == 0)
            System.out.println("fail: nao ha ninguem no carro");
        else if(km > gas){
            System.out.println("fail: tanque vazio apos andar " + gas + " km");
            this.km += gas;
            gas = 0;
        }
        else {
            gas -= km;
            this.km += km;
        }
    };

    
};

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("enter")) {
                car.enter();
            } else if(ui[0].equals("leave")) {
                car.leave();
            } else if(ui[0].equals("show")) {
                System.out.println(car.toString());
            } else if (ui[0].equals("drive")) {//km
                car.drive(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("fuel")) {//gas
                car.fuel(Integer.parseInt(ui[1]));
            } else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}