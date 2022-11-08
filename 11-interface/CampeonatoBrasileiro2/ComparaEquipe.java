import java.util.Comparator;

class ComparaEquipe implements Comparator<Equipe> {
    public int compare(Equipe t1, Equipe t2){
        if(t1.getTotalPontos() > t2.getTotalPontos()){
            return -1;
        }
        else if(t1.getTotalPontos() < t2.getTotalPontos()){
            return 1;
        }
        else{
            if(t1.getTotalVitorias() > t2.getTotalVitorias()){
                return -1;
            }
            else if(t1.getTotalVitorias() < t2.getTotalVitorias()){
                return 1;
            }
            else{
                if(t1.getSaldoGols() > t2.getSaldoGols()){
                    return -1;
                }
                else if(t1.getSaldoGols() < t2.getSaldoGols()){
                    return 1;
                }
                
                else{
                    if(t1.getGolsPro() > t2.getGolsPro()){
                        return -1;
                    }
                    else if(t1.getGolsPro() < t2.getGolsPro()){
                        return 1;
                    }
                    
                    else if(t1.getGolsPro() == t2.getGolsPro()){
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
