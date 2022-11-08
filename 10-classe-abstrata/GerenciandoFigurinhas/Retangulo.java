public class Retangulo extends Shape{
    private Ponto2D infEsq;
    private Ponto2D subDir;
    
    public Retangulo(Ponto2D infEsq, Ponto2D subDir){
        this.infEsq = infEsq;
        this.subDir = subDir;
    }
    
    public double area(){
        return (this.subDir.getX() - this.infEsq.getX())*(this.subDir.getY() - this.infEsq.getY());
    }
    
    public double perimeter(){
        return (this.subDir.getX() - this.infEsq.getX())*2 + (this.subDir.getY() - this.infEsq.getY())*2;
    }
    
    public boolean inside(Ponto2D p){
        if(p.getX() < this.infEsq.getX() || p.getX() > this.subDir.getX() || p.getY() < this.infEsq.getY() || p.getY() > this.subDir.getY())
            return false;
            
        return true;
    }
    
    public String toString(){
        return String.format("Retângulo com cantos (%.1f,%.1f) e (%.1f,%.1f)", 
        this.infEsq.getX(), this.infEsq.getY(), this.subDir.getX(), this.subDir.getY());
    }
    
}