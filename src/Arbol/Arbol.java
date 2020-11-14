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
public class Arbol {
    Nodo raiz,puntero;
    public Arbol(Object c) {
        insertarR(c);
    }
    private void insertarR(Object c){
        raiz=new Nodo(c);
        raiz.primerHijo=null;
        raiz.sigHermano=null;
    }
    void borrar(Object c){
        insertarR(c);
    }
    Nodo getRaiz(){
        return raiz;
    }
    void imprimir(){
        System.out.println(raiz);
        if(raiz.primerHijo!=null){
            puntero=raiz.primerHijo;
            System.out.print(puntero+"->");
            while(puntero.sigHermano!=null){
                puntero=puntero.sigHermano;
                System.out.print(puntero+"->");
            }
        }

    }
    void insertar(Nodo n,Object c ){
        if(n.primerHijo==null){
            //no tiene hijos
            n.primerHijo=new Nodo(c);
        }
        else{
            // no tiene hijos
            puntero=n.primerHijo;
            while(puntero.sigHermano!=null){
                puntero=puntero.sigHermano;
            }
            puntero.sigHermano=new Nodo(c);
        }
    }
    Nodo buscar(Nodo n,Object c){
        Nodo temporal=null;
        puntero=n;
        if(puntero.contenedor==c){
            return puntero;
        }
        else{
            if(puntero.primerHijo!=null){
                temporal=buscar(puntero.primerHijo,c);
            }else{
            if(puntero.sigHermano!=null){
                temporal=buscar(puntero.sigHermano,c);
            }
            }
        }
        return temporal;
    }
    Nodo extrer(Object c){

        return null;
    }
    void preOrden(){
    }
    void impBerny (Nodo t){
        System.out.println(t);
        if (t.primerHijo!=null) {
            impBerny(t.primerHijo);            
        }else {
            if (t.sigHermano!=null) {
                impBerny(t.sigHermano);
            }
        }
    }

}
