package br.inatel.pcmania;

public class Computador {
    private String marca;
    private double preco;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;
    private HardwareBasico[] hardware;
    private int qtdHardware;

    public Computador(String marca, double preco, SistemaOperacional sistemaOperacional, int tamanhoHardware) {
        this.marca = marca;
        this.preco = preco;
        this.sistemaOperacional = sistemaOperacional;
        this.hardware = new HardwareBasico[tamanhoHardware];
        this.qtdHardware = 0;
        this.memoriaUSB = null;
    }

    public void addHardware(HardwareBasico hb) {
        if (qtdHardware < hardware.length) {
            hardware[qtdHardware] = hb;
            qtdHardware++;
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public double getPreco() {
        return preco;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preco: R$ " + preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");
        System.out.println("Hardware:");
        for (int i = 0; i < qtdHardware; i++) {
            System.out.println("  - " + hardware[i].getNome());
        }
        if (memoriaUSB != null) {
            System.out.println("Brinde: " + memoriaUSB.getNome());
        }
        System.out.println("---------------------------");
    }
}
