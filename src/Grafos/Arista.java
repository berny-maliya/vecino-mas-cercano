package Grafos;

public class Arista {
    int costo;
    Arista sigArista;
    Nodo conector;

    public Arista() {
    }

    public Arista(int costo, Nodo conector) {
        this.costo = costo;
        this.conector = conector;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Arista getSigArista() {
        return sigArista;
    }

    public Nodo getConector() {
        return conector;
    }

    @Override
    public String toString() {
        return  conector.getNombre()+"-"+this.costo;
    }
}
