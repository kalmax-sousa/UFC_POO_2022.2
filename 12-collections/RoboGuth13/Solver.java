import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;

class Robo {
    String palavra;

    public Robo(String palavra) {
        this.palavra = palavra;
    }

    public Collection<String> palavrasValidas(){
        return geraPalavras(this.palavra);
    }
    
    public int palavraCompleta(String palavra){
        for (int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) == '?'){
                return i;
            }
        }
        
        return -1;
    }
    
    private ArrayList<String> geraPalavras(String palavra){
        int ret = this.palavraCompleta(palavra);
        ArrayList<String> palavras = new ArrayList<>();
        if(ret == -1){
            palavras.add(palavra);
            return palavras;
        }else{
            char[] chars = palavra.toCharArray();
            if((ret == 0) || 
            (ret > 0 && palavra.charAt(ret-1) != 'a') && (ret == palavra.length()-1 || 
            (ret < palavra.length()-1 && palavra.charAt(ret + 1) != 'a'))){
                chars[ret] = 'a';
                String p = String.valueOf(chars);
                palavras.addAll(this.geraPalavras(p));
            }
            chars[ret] = 'b';
            String p = String.valueOf(chars);
            palavras.addAll(this.geraPalavras(p));
            return palavras;
        }
    }

}

class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Robo r = new Robo(s);
        for(String palavra : r.palavrasValidas()){
            System.out.println(palavra);
        }

    }   
}