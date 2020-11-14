/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author Lain
 */
public class Nodo {
    Object contenedor;
    Nodo primerHijo;
    Nodo sigHermano;
    public Nodo(Object contenedor) {
        this.contenedor = contenedor;
    }
    @Override
    public String toString() {
        return  contenedor.toString() ;
    }
    public Object getContenedor() {
        return contenedor;
    }
    public void setContenedor(Object contenedor) {
        this.contenedor = contenedor;
    }
    public Nodo getPrimerHijo() {
        return primerHijo;
    }
    public void setPrimerHijo(Nodo primerHijo) {
        this.primerHijo = primerHijo;
    }
    public Nodo getSigHermano() {
        return sigHermano;
    }
    public void setSigHermano(Nodo sigHermano) {
        this.sigHermano = sigHermano;
    }
}
