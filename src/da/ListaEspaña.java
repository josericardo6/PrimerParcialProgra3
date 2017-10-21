/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

/**
 *
 * @author joser
 */
public class ListaEspaña {
    
    private Nodo cabeza;
    private int size;

    public ListaEspaña() {
        
        this.cabeza = null;
        this.size = 0;
       
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public int Size() {
        return size;
    }

    /**
     * <h1>toString</h1>
     * <p>
     * Metodo que imprime la lista de los jugadores guardados</p>
     *
     * @return String: Lista de jugadores y caracteristicas
     */
    @Override
    public String toString(){
        
        Nodo aux = cabeza; //Inicializa el nodo auxiliar con el valor de la cabeza
        String resultado = "SELECCION DE ESPAÑA \n\n";
        int cont = 1;
        
        for(int i = 0; i < size; i++){
            
            resultado += cont + ") "
                    +"Jugador: " + aux.getPlayer().getNombre()
                    + " " + aux.getPlayer().getApellido() 
                    + " / " + aux.getPlayer().getEdad()
                    + " años / " + aux.getPlayer().getPosicion()
                    + "\n"; 
            
            aux = aux.getSig(); 
            cont++;
        }
        
        return resultado;
    }
    
    /**
     * <h1>add</h1>
     * <p>
     * Metodo que añade un jugador a la lista.</p>
     *
     * @param player
     * @return boolean: true/false
     */
    public boolean add(Jugador player){
        
        Nodo nuevo = new Nodo(player);
        
        if(cabeza == null){
            cabeza = nuevo;
            size++;
        }else if (player.getPosicion().compareTo(cabeza.getPlayer().getPosicion()) > 0) {
            nuevo.setSig(cabeza);
            cabeza.setAnt(nuevo);
            cabeza = nuevo;
            size++;
        } else {
            Nodo aux = cabeza;
            Nodo aux2 = cabeza.getSig();
            while (aux2 != null) {
                if (player.getPosicion().compareTo(aux2.getPlayer().getPosicion()) > 0) {
                    break;
                }
                aux = aux2;
                aux2 = aux2.getSig();
            }
            nuevo.setSig(aux.getSig());
            aux.setSig(nuevo);
            size++;
        
        }
    
        return true;
        
    }
     
    /**
     * <h1>printLineUp</h1>
     * <p>
     * Metodo que imprime la alineacion de españa.</p>
     *
     * @return String: alineacion del equipo
     */
    public String printLineUp(){
        
        String resultado = "-------ESPAÑA \n\n";
        
        ListaEspaña porteros = new ListaEspaña();
        ListaEspaña defensas = new ListaEspaña();
        ListaEspaña mediocampos = new ListaEspaña();
        ListaEspaña delanteros = new ListaEspaña();
        
        Nodo aux = cabeza;
 
            for(int i = 0; i < size; i++){

                switch(aux.getPlayer().getPosicion()){
                    case "Portero":
                        porteros.add(aux.getPlayer());
                        break;
                    case "Defensa":
                        defensas.add(aux.getPlayer());
                        break;
                    case "Mediocampo":
                        mediocampos.add(aux.getPlayer());
                        break;
                    case "Delantero": 
                        delanteros.add(aux.getPlayer());
                        break;
                }
                aux = aux.getSig();
            }
                
            resultado += "                "+porteros.getCabeza().getPlayer().getApellido()+"\n\n" + "    ";
            
            Nodo auxDef = defensas.getCabeza();
            
            while(auxDef != null){
                
                resultado += auxDef.getPlayer().getApellido() + " - ";
                auxDef = auxDef.getSig();
                
            }
            
            resultado = resultado.substring(0, resultado.length()-2);
            resultado += "\n\n";
            
            Nodo auxMed = mediocampos.getCabeza();
            
            while(auxMed != null){
                
                resultado += auxMed.getPlayer().getApellido() + " - ";
                auxMed = auxMed.getSig();
                
            }
            
            resultado = resultado.substring(0, resultado.length()-2);
            resultado += "\n\n" + "                  ";
            
            Nodo auxDel = delanteros.getCabeza();
            
            while(auxDel != null){
                
                resultado += auxDel.getPlayer().getApellido() + " - ";
                auxDel = auxDel.getSig();
                
            }
            
            resultado = resultado.substring(0, resultado.length()-2);
            resultado += "\n\n";
 
        return resultado;
    }
    
    /**
     * <h1>imprimeConMarca</h1>
     * <p>
     * Metodo que imprime la lista de jugadores con sus respectivas marcas.</p>
     *
     * @return String: lista de jugadores con sus marcas
     */
    public String imprimeConMarca(){
        
        Nodo aux = cabeza; //Inicializa el nodo auxiliar con el valor de la cabeza
        String resultado = "MARCAS ASIGNADAS \n\n";
        int cont = 1;
        
        for(int i = 0; i < size; i++){
            
            resultado += cont + ") "
                    +"Jugador: " + aux.getPlayer().getNombre()
                    + " " + aux.getPlayer().getApellido()
                    + " / Marca asignada: " +aux.getPlayer().getMarca();
            
            if(i == 0){
                
                resultado = resultado.substring(0, resultado.length()-23);
                
            }
            
            resultado += "\n";
            
            aux = aux.getSig(); 
            cont++;
        }
        
        return resultado;
    }
    
}
