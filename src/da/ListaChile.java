
package da;

/**
 *
 * @author joser
 */
public class ListaChile {
    
    private Nodo cabeza;
    private int size;

    public ListaChile() {
        
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
        String resultado = "SELECCION DE CHILE \n\n";
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
     * <h1>remove</h1>
     * <p>
     * Metodo que elimina un jugador de la lista.</p>
     *
     * @param nombre
     * @return boolean: true/false
     */
    public boolean remove(String nombre){
        
        Nodo temp = cabeza;
        int index = 0;
        
        while(!nombre.equals(temp.getPlayer().getNombre())){           
            index++;
            temp = temp.getSig();            
        }
        
//        for (int i = 0; i < size; i++) {
//            
//            if(!nombre.equals(temp.getPlayer().getNombre())){
//                index++;
//                temp = temp.getSig(); 
//            }
//            
//        }
        
        if(index < 0 || index >= size){       
            throw new ArrayIndexOutOfBoundsException("El indice es invalido");   
        }
        if(index == 0){   
            cabeza = cabeza.getSig();   
        }else{   
            if(index == size-1){
                
                Nodo aux = cabeza;
                
                for(int i = 0; i < index-1; i++){
                    
                    aux = aux.getSig();
                    
                }
                
                aux.setSig(null);
                
            }else{
                
                Nodo aux = cabeza;
                
                for(int i = 0; i < index-1; i++){
                    
                    aux = aux.getSig();
                    
                }                
                aux.setSig(aux.getSig().getSig());
                aux.getSig().getSig().setAnt(aux);    
            } 
        }
        size--;
        return true;
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
        }else if (player.getEdad() < cabeza.getPlayer().getEdad()) {
            nuevo.setSig(cabeza);
            cabeza.setAnt(nuevo);
            cabeza = nuevo;
            size++;
        } else {
            Nodo aux = cabeza;
            Nodo aux2 = cabeza.getSig();
            while (aux2 != null) {
                if (player.getEdad() < aux2.getPlayer().getEdad()) {
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
     * Metodo que imprime la alineacion de Chile.</p>
     *
     * @param lineUp
     * @return String: alineacion del equipo
     */
    public String printLineUp(String lineUp){
        
        int por = Integer.parseInt(lineUp.substring(0,1));
        int def = Integer.parseInt(lineUp.substring(2,3));
        int med = Integer.parseInt(lineUp.substring(4,5));
        int dela = Integer.parseInt(lineUp.substring(6));
        
        int totalFormacion = por+def+med+dela;
        
        String alineacion = "-------CHILE \n\n          ";
        
        if(totalFormacion > 11 || totalFormacion < 11){
            
            System.out.println("¡¡¡¡¡¡¡ALINEACION ERRONEA!!!!!!!!!");
            
        }else if(por != 1){
            
            System.out.println("SOLO PUEDE HABER UN PORTERO EN LA PORTERIA");
            
            }else{

                ListaChile porteros = new ListaChile();
                ListaChile defensas = new ListaChile();
                ListaChile mediocampos = new ListaChile();
                ListaChile delanteros = new ListaChile();

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

                /////////////////////////////////////////////////////////////// Inicia creacion de formacion
                
                Nodo auxPor = porteros.getCabeza();

                for(int i = 1; i <= por; i++){ // PORTEROS

                    alineacion +=  auxPor.getPlayer().getApellido() + "\n\n";
                    auxPor = auxPor.getSig();

                }

                Nodo auxDef = defensas.getCabeza();

                for(int i = 1; i <= def; i++){ // DEFENSAS

                    alineacion +=  auxDef.getPlayer().getApellido() + " - ";
                    auxDef = auxDef.getSig();
                }

                alineacion = alineacion.substring(0, alineacion.length()-2);
                alineacion += "\n\n";

                Nodo auxMed = mediocampos.getCabeza();

                for(int i = 1; i <= med; i++){ // MEDIOCAMPOS

                    alineacion +=  auxMed.getPlayer().getApellido() + " - ";
                    auxMed = auxMed.getSig();
                }

                alineacion = alineacion.substring(0, alineacion.length()-2);
                alineacion += "\n\n";

                Nodo auxDela = delanteros.getCabeza();

                for(int i = 1; i <= dela; i++){ // DELANTEROS

                    alineacion +=  auxDela.getPlayer().getApellido() + " - ";
                    auxDela = auxDela.getSig();
                }

                /////////////////////////////////////////////////////////////// Termina creacion de formacion
                
                System.out.println("\n");

            }//fin else
        
        alineacion = alineacion.substring(0, alineacion.length()-2);
        alineacion += "\n\n";
        
        return alineacion;
    }
    
    /**
     * <h1>ordenarPorEdad</h1>
     * <p>
     * Metodo que oderna la lista segun la edad de los jugadores.</p>
     *
     * @return boolean: true/false
     */
    public boolean ordenarPorEdad() {
        
        if (size > 1) {
            boolean cambio;
            do {
                Nodo actual = cabeza;
                Nodo anterior = null;
                Nodo siguiente = cabeza.getSig();
                cambio = false;
                while ( siguiente != null ) {
                    if (actual.getPlayer().getEdad() > siguiente.getPlayer().getEdad()) {
                        cambio = true;
                        if ( anterior != null ) {
                            Nodo sig = siguiente.getSig();
                            anterior.setSig(siguiente);
                            siguiente.setSig(actual);
                            actual.setSig(sig);
                        } else {
                            Nodo sig = siguiente.getSig();
                            cabeza = siguiente;
                            siguiente.setSig(actual);
                            actual.setSig(sig);
                        }
                        anterior = siguiente;
                        siguiente = actual.getSig();
                    } else { 
                        anterior = actual;
                        actual = siguiente;
                        siguiente = siguiente.getSig();
                    }
                } 
            } while( cambio );
        }
        
        return true;
        
    }
    
}
