class Equipe {
    private String nome;
    private int totalPontos;
    private int totalVitorias;
    private int saldoGols;
    private int golsPro;
    
    public String getNome(){
        return this.nome;
    }
    
    public int getTotalPontos(){
        return this.totalPontos;
    }
    
    public int getTotalVitorias(){
        return this.totalVitorias;
    }
    
    public int getSaldoGols(){
        return this.saldoGols;
    }
    
    public int getGolsPro(){
        return this.golsPro;
    }
    
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
}
