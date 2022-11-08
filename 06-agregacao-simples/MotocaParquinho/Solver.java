import java.util.*;

class Person {
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age  = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String toString(){
        return String.format("%s:%d", name, age);
    }
}

class Motorcycle { //todo
    private Person person; //agregacao
    private int power;
    private int time;
    
    //Inicia o atributo power, time com zero e person com null
    public Motorcycle(int power){
        this.power = power;
    }
    public int getPower() {
        return power;
    }
    public int getTime() {
        return time;
    }
    public Person getPerson() {
        return person;
    }
    //Comprar mais tempo
    public void buy(int time){
        this.time += time;
    }
    
    //Se estiver vazio, coloca a pessoa na moto e retorna true
    public boolean enter(Person person) {
        if(this.person == null){
            this.person = person;
            return true;
        }
        
        System.out.println("fail: busy motorcycle");
        return false;
    }
    public Person leave() {
        if(this.person != null){
            Person p = this.person;
            this.person = null;
            return p;
        }
        
        System.out.println("fail: empty motorcycle");
        return this.person;
    }
    public void drive(int time){
        if(this.person.getAge() > 10){
            System.out.println("fail: too old to drive");
            return;
        }
        else if(this.time > 0){
            if(this.time >= time){
                this.time -= time;
            } else {
                System.out.printf("fail: time finished after %d minutes\n", this.time);
                this.time = 0;
            }
        } else{
            System.out.println("fail: buy time first");
        }
    }
    //buzinar
    public void honk(){
        StringBuilder s = new StringBuilder("P");
        for (int i = 0; i < this.power; i++) {
            s.append("e");
        }
        s.append("m");
        
        System.out.println(s);
        
    }
    
    public String toString(){
        if(this.person == null)
            return String.format("power:%d, time:%d, person:(empty)", this.power, this.time);
        
        return String.format("power:%d, time:%d, person:(%s)", this.power, this.time, this.person);
    }
}

class Solver{
    static Shell sh = new Shell();
    static Motorcycle motoca  = new Motorcycle(1);
    public static void main(String[] args) {
    
        sh.setfn("init",   () -> motoca = new Motorcycle(toInt(sh.par(1))));
        sh.setfn("buy",    () -> motoca.buy(toInt(sh.par(1))));
        sh.setfn("enter",  () -> motoca.enter(new Person(sh.par(1), toInt(sh.par(2)))));
        sh.setfn("drive",  () -> motoca.drive(toInt(sh.par(1))));
        sh.setfn("leave",  () ->  {
            Person person = motoca.leave();
            if(person != null) {
                System.out.println(person.toString());
            }
        });
        sh.setfn("honk",   () -> motoca.honk());
        sh.setfn("show",   () -> System.out.println(motoca));
    
        sh.execute();
    }
    static int toInt(String s){
        return Integer.parseInt(s);
    }
}

class Shell {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Runnable> chain = new HashMap<>();
    private ArrayList<String> ui = new ArrayList<>();
    public Shell() {
        Locale.setDefault(new Locale("en", "US"));
    }
    public void setfn(String key, Runnable value) {
        chain.put(key, value);
    }
    public String par(int index) {
        return ui.get(index);
    }
    public void execute() {
        while(true) {
            ui.clear();
            String line = scanner.nextLine();
            Collections.addAll(ui, line.split(" "));
            System.out.println("$" + line);
            if(ui.get(0).equals("end")) {
                break;
            } else if (chain.containsKey(ui.get(0))) {
                chain.get(ui.get(0)).run();
            } else {
                System.out.println ("fail: comando invalido");
            }
        }
    }
    
}