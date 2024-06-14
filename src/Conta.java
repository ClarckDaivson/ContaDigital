import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    // ... outros campos e métodos
    private List<Transacao> transacaos;

    public Conta(int numero, Cliente cliente, List<Transacao> transacaos) {
        this.transacaos = transacaos;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao(valor, "DEPOSITO"));
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao(valor, "SAQUE"));
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && valor <= saldo) {
            sacar(valor);
            contaDestino.depositar(valor);
            transacoes.add(new Transacao(valor, "TRANSFERENCIA"));
        }
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public int getNumero() {
    }

    public abstract String getSaldo();
}
