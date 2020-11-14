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
public class EjemploArbol {
    public static void main(String[] args) {
        
        Arbol a=new Arbol("Nodo Raiz");
        a.insertar(a.getRaiz(),"Nodo 1 Hijo de Raiz");
        a.insertar(a.getRaiz(),"Nodo 2 Hijo de Raiz");
        a.insertar(a.getRaiz(),"Nodo 3 Hijo de Raiz");
        a.imprimir();
        System.out.println(a.buscar(a.getRaiz(),"Nodo 3 Hijo de Raiz"));
        a.insertar(a.buscar(a.getRaiz(),"Nodo 3 Hijo de Raiz"),"prueba");
        System.out.println(a.buscar(a.getRaiz(),"prueba"));
        System.out.println("imp berny:");
        a.impBerny(a.raiz);
    }
}
