package br.inatel.pcmania;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int qtdComputadores;

    public Cliente(String nome, String cpf, int tamanhoComputadores) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[tamanhoComputadores];
        this.qtdComputadores = 0;
    }

    public void addComputador(Computador c) {
        if (qtdComputadores < computadores.length) {
            computadores[qtdComputadores] = c;
            qtdComputadores++;
        }
    }

    public double calculaTotalCompra() {
        double total = 0;
        for (int i = 0; i < qtdComputadores; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }

    public void mostraInfoCliente() {
        System.out.println("Cliente: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Total da compra: R$ " + calculaTotalCompra());
        System.out.println("Computadores comprados:");
        for (int i = 0; i < qtdComputadores; i++) {
            computadores[i].mostraPCConfigs();
        }
    }
}
