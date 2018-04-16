package amartine59.tallerlv_sc;

import android.view.View;

public class Operacion {

    private String operacion_realizada;
    private String [] datos_op;
    private String resultado_op;

    public Operacion(String operacion_realizada, String[] datos_op, String resultado_op) {
        this.operacion_realizada = operacion_realizada;
        this.datos_op = datos_op;
        this.resultado_op = resultado_op;
    }

    public String getOperacion_realizada() {
        return operacion_realizada;
    }

    public void setOperacion_realizada(String operacion_realizada) {
        this.operacion_realizada = operacion_realizada;
    }

    public String[] getDatos_op() {
        return datos_op;
    }

    public void setDatos_op(String[] datos_op) {
        this.datos_op = datos_op;
    }

    public String getResultado_op() {
        return resultado_op;
    }

    public void setResultado_op(String resultado_op) {
        this.resultado_op = resultado_op;
    }

   public void guardarOp(){
        Datos.guardar(this);
   }
}
