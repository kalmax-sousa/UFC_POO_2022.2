public class Pessoa {
    private String name;

    Pessoa(String name){
        this.name = name;
    }

    public String GetName(){
        return this.name;
    }

    public void SetName(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
