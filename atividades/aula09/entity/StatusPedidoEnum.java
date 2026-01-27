public enum StatusPedidoEnum {
    
    PROCESSANDO(1),
    ENVIADO(2),
    ENTREGUE(3),
    CANCELADO(4);

    private int codigo;

    StatusPedidoEnum(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}
