package amartine59.tallerlv_sc;

import java.util.ArrayList;

public class Datos {

    private static ArrayList<Operacion> operacionesR = new ArrayList<>();

    public static void guardar(Operacion p){
        operacionesR.add(p);
    }

    public static ArrayList<Operacion>obtener(){return operacionesR;}

}
