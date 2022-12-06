import java.util.Set;
import java.util.HashSet;

public class Relation {
    private Set<Integer> domain = new HashSet<>();
    private Set<Pair> pares = new HashSet<>();
    
    public Relation(Set<Integer> s){
        for(Integer e : s){
            this.domain.add(e);
        }
    }
    
    public void addPair(int a, int b) throws InvalidPairException {
        if(!(this.domain.contains(a) || this.domain.contains(b)))
            throw new InvalidPairException("The pair is out of domain");
            
        Pair p = new Pair(a, b);
        if(this.pares.contains(p))
            throw new InvalidPairException("This pair already belongs to the set");
        else
            this.pares.add(p);
    }
    
    public boolean hasPair(int a, int b){
        return this.pares.contains(new Pair(a, b));
    }
    
    public boolean isReflexive(){
        boolean reflexive  = true;
        for(Integer e : this.domain){
            if(!hasPair(e, e)){
                reflexive = false;
            }
        }
        
        return reflexive;
    }
    
    public void checkReflexive(){
        for(Integer e : this.domain){
            if(hasPair(e, e))
                System.out.printf("hasPair(%d,%d) = true\n", e, e);
            else{
                System.out.printf("hasPair(%d,%d) = false\n", e, e);
                break;
            }
        }
        
        if(isReflexive())
            System.out.println("Relation is reflexive");
        else
            System.out.println("Relation is not reflexive");
    }
    
    public boolean isSymmetric(){
        boolean symmetric  = true;
        for(Integer e : this.domain){
            for(Integer f : this.domain){
                if(hasPair(e, f) && !hasPair(f, e)){
                    symmetric = false;
                }
            }
        }
        
        return symmetric;
    }
    
    public void checkSymmetric(){
        boolean symmetric = true;
        for(Integer e : this.domain){
            for(Integer f : this.domain){
                if(hasPair(e, f) && hasPair(f, e))
                    System.out.printf("hasPair(%d,%d) = true, hasPair(%d,%d) = true\n", e, f, f, e);
                else if(hasPair(e, f) && !hasPair(f, e)){
                    System.out.printf("hasPair(%d,%d) = true, hasPair(%d,%d) = false\n", e, f, f, e);
                    symmetric = false;
                    break;
                }
                else{
                    System.out.printf("hasPair(%d,%d) = false, hasPair(%d,%d) = false\n", e, f, f, e);
                }
            }
            
            if(!symmetric)
                break;
        }
        
        if(isSymmetric())
            System.out.println("Relation is symmetric");
        else
            System.out.println("Relation is not symmetric");
    }
    
    public boolean isTransitive(){
        boolean transitive = true;
        for(Integer e : this.domain){
            for(Integer f : this.domain){
                for(Integer g : this.domain){
                    if((hasPair(e, f) && hasPair(f, g)) == true && hasPair(e, g) == false){
                        transitive = false;
                        break;
                    }
                }
                
                if(!transitive) break;
            }
            if(!transitive) break;
        }
        
        return transitive;
    }
    
    public void checkTransitive(){
        boolean transitive = true;
        for(Integer e : this.domain){
            for(Integer f : this.domain){
                for(Integer g : this.domain){
                    String p1 = hasPair(e, f) ? "true" : "false";
                    String p2 = hasPair(f, g) ? "true" : "false";
                    String p3 = hasPair(e, g) ? "true" : "false";
                    
                    System.out.printf("hasPair(%d,%d) = %s, hasPair(%d,%d) = %s, hasPair(%d,%d) = %s\n", e, f, p1, f, g, p2, e, g, p3);
                    
                    if((hasPair(e, f) && hasPair(f, g)) == true && hasPair(e, g) == false){
                        transitive = false;
                        break;
                    }
                }
                
                if(!transitive) break;
            }
            if(!transitive) break;
        }
        
        
        if(isTransitive())
            System.out.println("Relation is transitive");
        else
            System.out.println("Relation is not transitive");
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("domain : ");
        sb.append(domain);
        sb.append(", pairs : {");
        for(Pair e : pares){
            sb.append(e);
            sb.append(",");
        }
        sb.delete(sb.length()-1, sb.length());
        sb.append("}");
        
        return sb.toString();
    }
}