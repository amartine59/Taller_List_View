package amartine59.tallerlv_sc;

import java.util.ArrayList;

public class Datos {

    private static ArrayList<String> operaciones = new ArrayList<>();

    public static void guardar(String p){
        operaciones.add(p);
    }

    public static ArrayList<String>obtener(){return operaciones;}

}
