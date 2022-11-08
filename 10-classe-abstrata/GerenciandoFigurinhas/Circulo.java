public class Circulo extends Shape{
    private Ponto2D centro;
    private double raio;
    
    public Circulo(Ponto2D centro, double raio){
        this.centro = centro;
        this.raio = raio;
    }
    
    public double area(){
        return Math.PI * this.raio * this.raio;
    }
    
    public double perimeter(){
        return 2* Math.PI *this.raio;
    }
    
    public boolean inside(Ponto2D p){
        double distance = Math.sqrt(Math.pow(this.centro.getX()-p.getX(), 2) + Math.pow(this.centro.getY()-p.getY(), 2));
        
        if(distance > this.raio)
            return false;
        
        return true;
    }
    
    public String toString(){
        return String.format("Círculo com centro em (%.1f,%.1f) e raio %.1f", this.centro.getX(), this.centro.getY(), this.raio);
    }
}