class Pair {
    private Integer first;
    private Integer second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String toString() {
        return "(" + this.first + "," + this.second + ")";
    }

    @Override
    public boolean equals(Object obj) {

        // um teste para ver se os objetos são idênticos
        if (this == obj)
            return true;

        // retorna se false se o argumento é nulo
        if (obj == null)
            return false;

        // se as classes não casam, não podem ser iguais
        if (this.getClass() != obj.getClass())
            return false;

        // agora, sabemos que obj é um Empregado não-nulo
        Pair aux = (Pair) obj;

        // checa se os estados dos objetos são idênticos
        return this.first.equals(aux.getFirst())
                && this.second.equals(aux.getSecond());
    }

    @Override
    public int hashCode() {
        return first ^ second;
    }

}
