package domain;

// un semplice POJO che rappresenta un pappagallino con il suo nome
public class Pappagallino {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "[ Pappagallino: " + nome + " ]";
    }
}
