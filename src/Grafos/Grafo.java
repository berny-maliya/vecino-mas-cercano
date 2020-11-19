package Grafos;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo {

    Nodo inicio;
    String nombre;
    String descripcion;

    public Grafo() {
        inicio=null;
    }

    public Grafo(String nombre) {
        this.nombre = nombre;
    }

    public Grafo(Nodo inicio) {
        this.inicio = inicio;
    }

    boolean vacio(){
        return inicio==null;
    }

    Nodo veUltimo(){
        if(!vacio()){
            Nodo temp=inicio;
            while(temp.sigHermano!=null){
                temp=temp.sigHermano;
            }
            return temp;
        }
        return null;
    }

    Nodo busca(String n){
        if(!vacio()){
            Nodo temp=inicio;
            while(temp.sigHermano!=null && temp.nombre.compareTo(n)!=0){
                temp=temp.sigHermano;
            }
            if(temp.nombre.compareTo(n)==0) {
                return temp;
            }
        }
        return null;
    }

    void addNodo(String n){
        if(busca(n)==null) {
            Nodo temp = veUltimo();
            if (temp == null) {
                inicio = new Nodo(n);
            } else {
                temp.sigHermano = new Nodo(n);
            }
            System.out.println("Nodo: "+n+" Agregado");
        }
        else{
            System.out.println("Nodo: "+n+" Ya Existe");
        }
    }

Arista baratoArista(Nodo nodo,LinkedList lista){
    boolean repite=false;
    //Si no tiene aristas
    if (nodo.primeraArista==null) {
        System.out.println("No tiene aristas");
        return null;
    }else{
  
        
  Arista nod = nodo.primeraArista;
  Arista temp =nod; //aqui esta el error
  Arista menor=temp;
        for (int i = 0; i < lista.size(); i++) {
            if(menor.conector.nombre==lista.get(i)){
              menor=menor.sigArista;  
            }
        }
  //si solo tiene un arista: 
    if (nod.sigArista==null) {
        System.out.println("el costo menor es: "+nod.costo);
    }else{       
  //busca el arista con costo menor      
     while (temp.sigArista!=null){
         System.out.println("inicia ciclo");
         temp=temp.sigArista;
       
       
       
         if  (temp.costo < menor.costo)  {//no entra al if
          for (int i = 0; i < lista.size(); i++) {
              System.out.println("nodo menor "+menor.conector.nombre);
              System.out.println("Lista :"+lista.get(i));
              System.out.println("el nodo menor en if (aqui): "+menor.conector.nombre);
             if (menor.conector.nombre ==lista.get(i)){
                 System.out.println("imprimiendo lista desde baratoArista: "+lista.get(i));
                 
                 repite=true;
                 break;
             }else{
                // repite=false;
                 System.out.println("bandera");
                 
                 
 
                 
             }
         }
          
             if (repite==false) {
                System.out.println("el nodo menor en if (repite==false) antes del cambio: "+menor.conector.nombre);
                   return menor;
                
                 
             }

         }else System.out.println("bandera no entra al if");
        }
        if (temp.sigArista!=null) {
            temp=nod;
        }
    }
  
    return menor;
    }
}


Nodo nna (Nodo nodo, LinkedList recorrido){
    System.out.println("----entra nna----");
    Nodo n =nodo;
    System.out.println("Estoy en el nodo: "+n.nombre);
   Arista menor;
   
    System.out.println("");
    
    
    
    
    LinkedList lista = new LinkedList();
   //añadiendo todas las nodos del nodo que me estan mandando 
    Arista arista = n.primeraArista;
    //esta lista es guaradar los nodos a los que apuntan las aristas del nodo que me estan dando 
    lista.add(arista.conector);
    while(arista.sigArista!=null){
        arista=arista.sigArista;
       lista.add(arista.conector); 
    }
    //creo otra lista que va a ser igual a la anterior paro con aristas
    LinkedList aristas = new LinkedList();
    arista=n.primeraArista;
    aristas.add(arista);
    while(arista.sigArista!=null){
        arista=arista.sigArista;
       aristas.add(arista); 
    }
    
    
    //termino de añadir las aristas
    
    
    //imprimo la lista con nodos y la lista de los aristas del nodo que me envian
    System.out.println("imprimo las listas");
    for (int i = 0; i < lista.size(); i++) {
        System.out.println("Nodo: "+lista.get(i));
        System.out.println("Arista: "+aristas.get(i));
        System.out.println("");
    }System.out.println("");
    /*/imprimo la lista de aristas
    System.out.println("imprimo la lista de aristas");
     for (int i = 0; i < aristas.size(); i++) {
        System.out.println(aristas.get(i));
        
    }*/
    //imripimo la lista con el recorrido de lo que me envian
    System.out.println("imprimo la lista recorrido");
     for (int i = 0; i < recorrido.size(); i++) {
        System.out.println(recorrido.get(i));
      
    }System.out.println("");
     
    System.out.println("se supone que quito de la lista lo que se repite:");
    for (int i = 0; i < recorrido.size(); i++) {
        for (int j = 0; j < lista.size(); j++) {
            if (recorrido.get(i)==lista.get(j)) {
                lista.remove(j);//poner i
                aristas.remove(j);
                j=0;
            }
        }System.out.println("");
    }//imprimo la lista para ver como quedo:
     System.out.println("imprimo las listas de nuevo");
    for (int i = 0; i < lista.size(); i++) {
        System.out.println("Nodo: "+lista.get(i));
        System.out.println("Arista: "+aristas.get(i));
        System.out.println("");
    }System.out.println("");

     //   tengo que encontrar el menor
    menor=(Arista) aristas.get(0);
    int ubi=0;
    Arista temp;
    for (int i = 0; i < aristas.size(); i++) {
        temp=(Arista) aristas.get(i);
        
        if (temp.costo<menor.costo) {
            menor=temp;
            ubi=i;
        }System.out.println("");
    }System.out.println("El arista de menor costo se supone que es: "+menor);
    System.out.println("El nodo al que apunta este arista es: "+lista.get(ubi));
    
    
    System.out.println("----termina nna----");
return (Nodo) lista.get(ubi);
}
void imprimeRecorridoVMC(String origen,String destino ){
    LinkedList lista = new LinkedList();
    Nodo o=busca(origen);
    Nodo d=busca(destino);
    Nodo recorre=o;
    
    lista.add(o);
    while (recorre!=d){
        recorre = nna(recorre,lista);
        lista.add(recorre);
    }
    //imprimo el camino de VMC
   
    System.out.println(" el camino de "+o.nombre+ " a "+d.nombre+" segun el algoritmo es: ");
    for (int i = 0; i < lista.size(); i++) {
        System.out.println(lista.get(i));
        System.out.println("|");
        System.out.println("V");
    }
}
void vmc(String origen,String destino){
    LinkedList lista = new LinkedList();
    Nodo o=busca(origen);
    Nodo d=busca(destino);
    Nodo recorre=o;
    boolean fin=false;
    System.out.println("Recorrido vecino mas cercano");
    System.out.println("Empieza con el nodo: "+o.nombre);
    lista.add(o.nombre);
    while(fin==false){
    
    recorre=baratoArista(recorre,lista).conector;
     lista.add(recorre.nombre);
    //  Nodo prueba=nna(recorre,lista);
     
       //imprimiendo lista
         for (int i = 0; i < lista.size(); i++) {
             System.out.println(lista.get(i));
         }
        // fin=true;
    //guardar recorre en un gestor de datos
    //falta akgo que cheque que nodos ya hemos recorrido, un array o algo asi que almacene lo que ya hemos recorrido
        if (recorre==d) {
            System.out.println("Fin recorrido vecino mas cercano");
            fin=true;
        }
   
    }
    
}
    boolean addArista(String origen, String destino, int costo){
        Nodo o=busca(origen);
        Nodo d=busca(destino);
        //para hacer aristas bilaterales: pero para el aeropuerto no se va a armar mi apa
      
     //   addArista2(destino,origen,costo);
        if(o!=null && d!=null ){
            Arista temp=new Arista(costo,d);
            Arista Aristatemp=o.primeraArista;
            if(Aristatemp!=null) {
                while (Aristatemp.sigArista != null) {
                    Aristatemp = Aristatemp.sigArista;
                }
                Aristatemp.sigArista=temp;
            }
            else{
                o.primeraArista=temp;
            }
            return true;
        }
        else{
            return false;
        }


    }
    //el mismo método que el abterior
        boolean addArista2(String origen, String destino, int costo){
        Nodo o=busca(origen);
        Nodo d=busca(destino);
        if(o!=null && d!=null ){
            Arista temp=new Arista(costo,d);
            Arista Aristatemp=o.primeraArista;
            if(Aristatemp!=null) {
                while (Aristatemp.sigArista != null) {
                    Aristatemp = Aristatemp.sigArista;
                }
                Aristatemp.sigArista=temp;
            }
            else{
                o.primeraArista=temp;
            }
            return true;
        }
        else{
            return false;
        }


    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        sb.append(nombre + "\n" );
        if(inicio!=null) {
            Nodo temp = inicio;
            sb.append(temp + "\n");
            while (temp.sigHermano != null) {
                    temp = temp.sigHermano;
                    sb.append(temp+ "\n");
            }
        }
        return sb.toString();
    }
    ArrayList BuscaFinal(String origen, String destino, ArrayList al, ArrayList ArrDeCaminos) {
        Nodo miNodo = busca(origen);
        Arista ar = miNodo.primeraArista;

        ArrayList<Arista> camino = new ArrayList<>();
        camino = (ArrayList<Arista>) al.clone();
        ArrayList<Arista> base = new ArrayList<>();
        base = (ArrayList<Arista>) camino.clone();

        if (!camino.contains(ar)) {
            while (ar != null) {

                Nodo Nodotemp = busca(ar.conector.nombre);
                camino.add(ar);

                if (destino.equals(ar.conector.nombre)) {
                    System.out.println("llegué al destino");
                    System.out.println(camino);
                    System.out.println(" ");
                    ArrDeCaminos.add(camino);

                } else {
                    if (Nodotemp.primeraArista != null) {
                        BuscaFinal(ar.conector.nombre, destino, camino, ArrDeCaminos);
                    }

                }
                ar = ar.sigArista;
                camino = (ArrayList<Arista>) base.clone();
            }
        }
        return camino;
    }

    int costos(ArrayList arr) {
        int suma = 0;
        return suma;
    }

    void probando2(String o, String d) {
        Nodo miNodo = inicio;

        do {
            System.out.println("******  " + miNodo.nombre + "  ******");
            Arista ar = miNodo.primeraArista;

            while (ar != null) {
                System.out.println(ar.conector.nombre);
                System.out.println(ar.costo);

                ar = ar.sigArista;

            }

            miNodo = miNodo.sigHermano;

        } while (miNodo.sigHermano != null);

    }
}
