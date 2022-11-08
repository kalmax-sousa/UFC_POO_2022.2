import java.lang.Comparable;

class Equipe implements Comparable<Equipe> {
    private String nome;
    private int totalPontos;
    private int totalVitorias;
    private int saldoGols;
    private int golsPro;
    
    public Equipe(String nome, int totalPontos, int totalVitorias, int saldoGols, int golsPro){
        this.nome = nome;
        this.totalPontos = totalPontos;
        this.totalVitorias = totalVitorias;
        this.saldoGols = saldoGols;
        this.golsPro = golsPro;
    }
    
    public String toString(){
        return String.format("Equipe [nome=%s, totalPontos=%d, totalVitorias=%d, saldoGols=%d, golsPro=%d]",
                            nome, totalPontos, totalVitorias, saldoGols, golsPro);
    }
    
    public int compareTo(Equipe t){
        if(this.totalPontos > t.totalPontos){
            return -1;
        }
        else if(this.totalPontos < t.totalPontos){
            return 1;
        }
        else{
            if(this.totalVitorias > t.totalVitorias){
                return -1;
            }
            else if(this.totalVitorias < t.totalVitorias){
                return 1;
            }
            else{
                if(this.saldoGols > t.saldoGols){
                    return -1;
                }
                else if(this.saldoGols < t.saldoGols){
                    return 1;
                }
                
                else{
                    if(this.golsPro > t.golsPro){
                        return -1;
                    }
                    else if(this.golsPro < t.golsPro){
                        return 1;
                    }
                    
                    else if(this.golsPro == t.golsPro){
                        return 0;
                    }
                    else {
                        System.out.println("Informações insuficientes");
                        return 0;
                    }
                }
            }
        }
    }
}
