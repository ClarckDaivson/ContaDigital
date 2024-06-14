public class ContaPoupanca extends Conta {
    private double rendimentoMensal;

    public ContaPoupanca(int numero, Cliente cliente, double rendimentoMensal) {
        super(numero, cliente);
        this.rendimentoMensal = rendimentoMensal;
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void aplicarRendimento() {
        saldo += saldo * rendimentoMensal;
    }
}
