package ies.alandalus.org.cuatroenraya.modelo;

public enum PosicionFicha {
    PRIMERA_FILA(0),
    SEGUNDA_FILA(1),
    TERCERA_FILA(2),
    CUARTA_FILA(3),
    QUINTA_FILA(4),
    SEXTA_FILA(5);

    private final int indice;

    PosicionFicha(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        return "Fila " + (indice + 1);
    }
}
