import java.util.Date;

public class Transacao {
    private Date data;
    private double valor;
    private String tipo;

    public Transacao(double valor, String tipo) {
        this.data = new Date();
        this.valor = valor;
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}
