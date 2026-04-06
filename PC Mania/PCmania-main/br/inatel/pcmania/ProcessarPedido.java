package br.inatel.pcmania;

public class ProcessarPedido {
    public static void enviar(Computador[] pcs) {
        System.out.println("Pedido enviado...");
        for (int i = 0; i < pcs.length; i++) {
            if (pcs[i] != null) {
                pcs[i].mostraPCConfigs();
            }
        }
    }
}
