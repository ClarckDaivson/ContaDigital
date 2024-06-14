import java.util.Scanner;

public class BancoDigital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco Digital!");

        // Criar cliente
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);

        // Criar conta corrente
        System.out.println("Digite o número da conta corrente:");
        int numeroContaCorrente = scanner.nextInt();
        System.out.println("Digite o limite da conta corrente:");
        double limite = scanner.nextDouble();
        ContaCorrente contaCorrente = new ContaCorrente(numeroContaCorrente, cliente, limite);
        cliente.adicionarConta(contaCorrente);

        // Criar conta poupança
        System.out.println("Digite o número da conta poupança:");
        int numeroContaPoupanca = scanner.nextInt();
        System.out.println("Digite o rendimento mensal da conta poupança:");
        double rendimentoMensal = scanner.nextDouble();
        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroContaPoupanca, cliente, rendimentoMensal);
        cliente.adicionarConta(contaPoupanca);

        // Interação básica
        System.out.println("Escolha uma operação: 1. Depositar 2. Sacar 3. Transferir 4. Consultar saldo 5. Consultar extrato 0. Sair");
        int operacao = scanner.nextInt();

        while (operacao != 0) {
            System.out.println("Digite o número da conta:");
            int numeroConta = scanner.nextInt();
            Conta conta = null;
            for (Conta c : cliente.getContas()) {
                if (c.getNumero() == numeroConta) {
                    conta = c;
                    break;
                }
            }
            if (conta == null) {
                System.out.println("Conta não encontrada.");
            } else {
                switch (operacao) {
                    case 1:
                        System.out.println("Digite o valor para depositar:");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        break;
                    case 2:
                        System.out.println("Digite o valor para sacar:");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        break;
                    case 3:
                        System.out.println("Digite o número da conta destino:");
                        int numeroContaDestino = scanner.nextInt();
                        Conta contaDestino = null;
                        for (Conta c : cliente.getContas()) {
                            if (c.getNumero() != numeroContaDestino) {
                            } else {
                                contaDestino = c;
                                break;
                            }
                        }
                        if (contaDestino == null) {
                            System.out.println("Conta destino não encontrada.");
                        } else {
                            System.out.println("Digite o valor para transferir:");
                            double valorTransferencia = scanner.nextDouble();
                            conta.transferir(valorTransferencia, contaDestino);
                        }
                        break;
                    case 4:
                        System.out.println("Saldo atual: " + conta.getSaldo());
                        break;
                    case 5:
                        System.out.println("Extrato:");
                        for (Transacao t : conta.getTransacoes()) {
                            System.out.println(t.getData() + " - " + t.getTipo() + " - " + t.getValor());
                        }
                        break;
                    default:
                        System.out.println("Operação inválida.");
                }
            }

            System.out.println("Escolha uma operação: 1. Depositar 2. Sacar 3. Transferir 4. Consultar saldo 5. Consultar extrato 0. Sair");
            operacao = scanner.nextInt();
        }

        System.out.println("Obrigado por usar o Banco Digital!");
        scanner.close();
    }
}
