package Work;

public class Ascensor {
    private int[] pisoEdificio= {0,0,0};
    private final int limiteAscensor = 1;
    private int pisoActualAscensor=0;
    private int pisoDestinoAscensor=0;
    private String estadoPuerta="cerrado";

    public String llamarAscensor(int cantidadPersonas,int pisoActual, int pisoDestino)throws Exception{
        verificarCapacidad(cantidadPersonas);
        crearPersona(pisoActual,pisoDestino);
        String mensaje="";
        if(pisoActualAscensor+1 == pisoActual){
            estadoPuerta="abierto";
            mensaje =  "Subirse inmediatamente";
        }else{
            estadoPuerta="abierto";
            mensaje =  "Esperando ascensor";
        }
        estadoPuerta="cerrado";
        limpiarPisoEdificio();
        return mensaje;
    }
    private void limpiarPisoEdificio(){
        for(int i = 0; i < pisoEdificio.length ; i++){
            pisoEdificio [i] = 0 ;
        }
        pisoDestinoAscensor = 0;
    }
    public String verificarEstadoAscensor() throws Exception{
        int auxiliarpisoActual = pisoActualAscensor + 1 ;
        return "Piso actual del ascensor " + auxiliarpisoActual+ " y puerta " +estadoPuerta;
     }

    private void verificarCapacidad(int cantidadPersonas) throws Exception{
        if(cantidadPersonas>limiteAscensor)
            throw new Exception("Capacidad excedida");
    }
    private void verificarPisoActualYDestino(int pisoActual, int pisoDestino) throws Exception{
        if(pisoActual==pisoDestino){
            throw new Exception("Piso actual y el destino es el mismo");
        }
    }
    private void verificarPiso(int pisoDestino) throws Exception{
        if(pisoDestino>pisoEdificio.length || pisoDestino<1){
            throw new Exception("Piso inexistente");
        }
    }

    public String crearPersona(int pisoActual,int pisoDestino) throws Exception{
        verificarPisoActualYDestino(pisoActual,pisoDestino);
        verificarPiso(pisoDestino);
        pisoEdificio[pisoActual-1]=1;
        return "La persona esta en el piso "+pisoActual;

    }


}
