package Grafos;

public class Nodo {
    String nombre;
    Nodo sigHermano;
    Arista primeraArista;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getSigHermano() {
        return sigHermano;
    }

    public void setSigHermano(Nodo sigHermano) {
        this.sigHermano = sigHermano;
    }

    public Arista getPrimeraArista() {
        return primeraArista;
    }

    public void setPrimeraArista(Arista primeraArista) {
        this.primeraArista = primeraArista;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        sb.append("Nodo "+nombre + "\n(" );
        if(primeraArista!=null) {
            sb.append(primeraArista);
            Arista temp=primeraArista;
            while(temp.sigArista!=null){
                temp=temp.sigArista;
                sb.append(" , "+temp);
            }
        }
        else{
            sb.append("Vacio");
        }
        sb.append(")");

        return sb.toString();
    }
}
