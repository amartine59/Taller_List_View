package amartine59.tallerlv_sc;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class HistorialOperaciones extends AppCompatActivity {
    private TableLayout tabla_operaciones;
    private ArrayList<Operacion>hst_operaciones;

    public String DatoStr(ArrayList<Operacion> d,int posicion){
        String datoOperacion = "";
        for (int j = 0; j < d.get(posicion).getDatos_op().length; j++) {
            datoOperacion += d.get(posicion).getDatos_op() + "\n";

        }
        return datoOperacion;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_operaciones);

        tabla_operaciones = findViewById(R.id.hstOperaciones);
        hst_operaciones = Datos.obtener();

        for (int i = 0; i < hst_operaciones.size(); i++) {
            TableRow fila = new TableRow(this);

            TextView iterador = new TextView(this);
            TextView operacion = new TextView(this);
            TextView datos = new TextView(this);
            TextView resultado = new TextView(this);


            iterador.setText(""+(i + 1));
            operacion.setText(hst_operaciones.get(i).getOperacion_realizada());
            datos.setText(DatoStr(hst_operaciones,i));
            resultado.setText(hst_operaciones.get(i).getResultado_op());

            fila.addView(iterador);
            fila.addView(operacion);
            fila.addView(datos);
            fila.addView(resultado);

            tabla_operaciones.addView(fila);

        }
    }
}
