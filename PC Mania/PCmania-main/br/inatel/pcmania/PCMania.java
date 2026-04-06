package br.inatel.pcmania;

import java.util.Scanner;

public class PCMania {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Informe seu CPF: ");
        String cpf = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, 10);

        Computador[] pcs = new Computador[10];
        int qtdPcs = 0;

        int opcao;
        do {
            System.out.println("\n=== PCMania - Promocoes ===");
            System.out.println("1 - Promocao Apple");
            System.out.println("2 - Promocao Samsung");
            System.out.println("3 - Promocao Dell");
            System.out.println("0 - Sair e finalizar pedido");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    Computador pc1 = criarPromocaoApple();
                    pcs[qtdPcs] = pc1;
                    qtdPcs++;
                    cliente.addComputador(pc1);
                    System.out.println("\nPromocao 1 adicionada ao carrinho!\n");
                    break;
                case 2:
                    Computador pc2 = criarPromocaoSamsung();
                    pcs[qtdPcs] = pc2;
                    qtdPcs++;
                    cliente.addComputador(pc2);
                    System.out.println("\nPromocao 2 adicionada ao carrinho!\n");
                    break;
                case 3:
                    Computador pc3 = criarPromocaoDell();
                    pcs[qtdPcs] = pc3;
                    qtdPcs++;
                    cliente.addComputador(pc3);
                    System.out.println("\nPromocao 3 adicionada ao carrinho!\n");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        if (qtdPcs > 0) {
            System.out.println("\n======= RESUMO DO PEDIDO =======");
            cliente.mostraInfoCliente();

            System.out.println("======= ENVIANDO PEDIDO =======");
            ProcessarPedido.enviar(pcs);
        } else {
            System.out.println("Nenhum computador foi selecionado.");
        }

        sc.close();
    }

    private static Computador criarPromocaoApple() {
        SistemaOperacional so = new SistemaOperacional("macOS Sequoia", 64);
        Computador pc = new Computador("Apple", 566.0, so, 3);

        pc.addHardware(new HardwareBasico("Pentium Core i3 - 2200 Mhz", 0));
        pc.addHardware(new HardwareBasico("8 Gb RAM", 8));
        pc.addHardware(new HardwareBasico("500 Gb HD", 500));

        pc.addMemoriaUSB(new MemoriaUSB("Pen-drive 16Gb", 16));

        return pc;
    }

    private static Computador criarPromocaoSamsung() {
        SistemaOperacional so = new SistemaOperacional("Windows 8", 64);
        Computador pc = new Computador("Samsung", 566.0 + 1234.0, so, 3);

        pc.addHardware(new HardwareBasico("Pentium Core i5 - 3370 Mhz", 0));
        pc.addHardware(new HardwareBasico("16 Gb RAM", 16));
        pc.addHardware(new HardwareBasico("1 Tb HD", 1000));

        pc.addMemoriaUSB(new MemoriaUSB("Pen-drive 32Gb", 32));

        return pc;
    }

    private static Computador criarPromocaoDell() {
        SistemaOperacional so = new SistemaOperacional("Windows 10", 64);
        Computador pc = new Computador("Dell", 566.0 + 5678.0, so, 3);

        pc.addHardware(new HardwareBasico("Pentium Core i7 - 4500 Mhz", 0));
        pc.addHardware(new HardwareBasico("32 Gb RAM", 32));
        pc.addHardware(new HardwareBasico("2 Tb HD", 2000));

        pc.addMemoriaUSB(new MemoriaUSB("HD Externo 1Tb", 1000));

        return pc;
    }
}
