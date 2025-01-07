package com.comercio_digital.comercio.enums;

public enum PedidoStatus {
    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int cod;

    private PedidoStatus(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public static PedidoStatus valueOf(int cod) {
        // percorre todos os valores possiveis da classe enum
        for (PedidoStatus status : PedidoStatus.values()) {
            // testa se o codigo é o selecionado para retornar o status
            if (status.getCod() == cod) {
                return status;
            }
            // caso nao tenha nenhuma correspondencia com o codigo e o status
        } throw new IllegalArgumentException("Codigo de status invalido");
    }
}
