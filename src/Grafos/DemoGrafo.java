package Grafos;

public class DemoGrafo {
    
    public static void main(String[] args) {
    Grafo g=new Grafo("Pruebas de Grafo");
        g.addNodo("A");
        g.addNodo("B");
        g.addNodo("C");
        g.addNodo("D");
        g.addNodo("E");
        g.addNodo("F");
        g.addNodo("F");
        System.out.println();
        System.out.println("Impresion de grafo sin aristas");
        System.out.println(g);
        System.out.println();
        System.out.println("Agregando Aristas");
        System.out.println( g.addArista("A","B",40));
        System.out.println(g.addArista("A","D",30));
        System.out.println(g.addArista("B","F",20));
        System.out.println(g.addArista("B","D",40));
        System.out.println( g.addArista("C","B",40));
        System.out.println(g.addArista("C","D",30));
        System.out.println(g.addArista("C","F",20));
   //     System.out.println(g.addArista("D","D",40));
       // System.out.println( g.addArista("F","B",40));
        System.out.println(g.addArista("F","D",30));
    //    System.out.println(g.addArista("C","F",20));
        System.out.println(g.addArista("R","D",40));
        System.out.println();
        System.out.println("Imprimiendo info del grafo con Aristas");
        System.out.println(g);
      //  System.out.println("Busca nodo tres");
       // System.out.println(g.busca("D"));
        
       //nuestro VMC
        g.imprimeRecorridoVMC("B", "A");
  //     g.nna("B");
    }
}
