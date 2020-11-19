package Grafos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoGrafo {
 
    static void añadir( Grafo g ) throws IOException{
     
        //abro el archivo claves
        String nombreFichero = "claves.txt";
       BufferedReader br = null;
       
    try {//leo la primera linea
        br = new BufferedReader(new FileReader(nombreFichero));
        
        String texto = br.readLine();
        while(texto != null){
        //añado la clave como nodo
        g.addNodo(texto);
        //leo la siguiente linea
        texto = br.readLine();

        }//acaba si la siguiente linea es null
    } catch (FileNotFoundException ex) {
        Logger.getLogger(DemoGrafo.class.getName()).log(Level.SEVERE, null, ex);
    }   
    }
    static void aristas( Grafo g , String d) throws IOException{
     
        //leo el archivo con el nombre del dia de la semana 
       String nombreFichero = d+".txt";
       BufferedReader br = null;
       
    try {
        //hago lo mismo que el anterior
        br = new BufferedReader(new FileReader(nombreFichero));
        //leo la primera linea
        String texto = br.readLine();
        String[] palabras;
        
        while (texto != null){
            //separo el texto en espacios
        palabras = texto.split(" ");
        //del arreglo obtengo: origen, destino y costo
        g.addArista(palabras[0], palabras[1], Integer.parseInt(palabras[2]));
        texto = br.readLine();
        }//salgo cuando ya no hay vuelos
         
        System.out.println("Los vuelos del "+d);
        System.out.println(g);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(DemoGrafo.class.getName()).log(Level.SEVERE, null, ex);
    }   
    }
 
 
    public static void main(String[] args) throws IOException {
    Grafo g=new Grafo("Pruebas de Grafo");
    //AÑADIENDO LOS NODOS "AEROPUERTOS" AL GRAFO  
        añadir(g);
       Grafo gr=new Grafo("Pruebas de Grafo"); 
        
        
      //PREGUNTE QUE DIA ES
      System.out.println("¿Qué día de la semana quiere su vuelo?");
        Scanner leer = new Scanner(System.in);
        String dia = leer.nextLine();
      //AÑADE ARISTAS DEPENDIENDO DEL DIA
      aristas(g,dia);
      
      //---Prueba para ver si el dijkstra funciona-----
       gr.addNodo("A");
        gr.addNodo("B");
        gr.addNodo("C");
        gr.addNodo("D");
        gr.addNodo("E");
        gr.addArista("A", "B", 40);
        gr.addArista("B", "A", 40);
        gr.addArista("A", "D", 30);
        gr.addArista("B", "C", 40);
        gr.addArista("B", "E", 20);
        gr.addArista("E","B", 20);
        gr.addArista("B", "D", 40);
        gr.addArista("C", "E", 20);
        gr.addArista("D", "E", 30);
        gr.addArista("D", "C", 30);
      
      
      //SE PREGUNTA POR ORIGEN Y DESTINO
        
        System.out.println("¿Cual es tu origen?");
        String O = leer.nextLine();
        System.out.println("¿Cual es tu destino?");
        String D =leer.nextLine() ;
        //OPERACION
      
     // int min = Integer.parseInt("12");
       // System.out.println(min);
        ArrayList<Arista> array = new ArrayList<>();

        ArrayList<ArrayList<Arista>> ArrayDeCaminos = new ArrayList();

        

        System.out.println("Funcion BuscaFinal");
        gr.BuscaFinal(O, D, array, ArrayDeCaminos);

        System.out.println("Array De Caminos");
        System.out.println(ArrayDeCaminos);
        System.out.println(" ");

        // COSTOS
        if (!ArrayDeCaminos.isEmpty()) {

            int min = 9999999;
            String Ccorto = null;
            for (int i = 0; i < ArrayDeCaminos.size(); i++) {
                int s = 0;
                System.out.println(ArrayDeCaminos.get(i));
                for (int j = 0; j < ArrayDeCaminos.get(i).size(); j++) {
                    System.out.println("    --->" + ArrayDeCaminos.get(i).get(j).costo);
                    s = ArrayDeCaminos.get(i).get(j).costo + s;

                }

                System.out.println(s);

                if (s < min) {
                    min = s;
                    Ccorto = ArrayDeCaminos.get(i).toString();

                }

                System.out.println("");

            }

            System.out.println("El camino minimo de " + O + " a " + D + " cuesta "
                    + min + " y la ruta es " + Ccorto);

        } else {
            System.out.println("No hay camino de " + O + " a " + D);
        }
       
      /*
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
        g.imprimeRecorridoVMC("B", "A");*/
    }
}
