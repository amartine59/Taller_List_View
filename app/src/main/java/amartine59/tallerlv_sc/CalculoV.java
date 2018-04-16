package amartine59.tallerlv_sc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CalculoV extends AppCompatActivity {
    private LinearLayout volumen_esfera;
    private LinearLayout volumen_cilindro;
    private LinearLayout volumen_cono;
    private LinearLayout volumen_cubo;
    private EditText radio_esfera;
    private EditText radio_cilindro;
    private EditText altura_cilindro;
    private EditText radio_cono;
    private EditText altura_cono;
    private EditText arista_cubo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_v);

        volumen_esfera = findViewById(R.id.volEsfera);
        volumen_cilindro = findViewById(R.id.volCilindro);
        volumen_cono = findViewById(R.id.volCono);
        volumen_cubo = findViewById(R.id.volCubo);

        radio_esfera = findViewById(R.id.txtRadioEsfera);

        radio_cilindro = findViewById(R.id.txtRadioCilindro);
        altura_cilindro = findViewById(R.id.txtRadioCilindro);

        radio_cono = findViewById(R.id.txtRadioCono);
        altura_cono = findViewById(R.id.txtAlturaCono);

        arista_cubo = findViewById(R.id.txtAristaCubo);

        Intent in_operacion = getIntent();
        String operacion_a_realizar = in_operacion.getStringExtra("Calculo_A_Realizar");

        volumen_esfera.setVisibility(LinearLayout.GONE);
        volumen_cilindro.setVisibility(LinearLayout.GONE);
        volumen_cono.setVisibility(LinearLayout.GONE);
        volumen_cubo.setVisibility(LinearLayout.GONE);

        switch (operacion_a_realizar){
            case "esfera":
                volumen_esfera.setVisibility(LinearLayout.VISIBLE);
                break;
            case "cilindro":
                volumen_cilindro.setVisibility(LinearLayout.VISIBLE);
                break;
            case "cono":
                volumen_cono.setVisibility(LinearLayout.VISIBLE);
                break;
            case "cubo":
                volumen_cubo.setVisibility(LinearLayout.VISIBLE);
                break;
        }

    }
    public void almacenarOperacion(String operacion,String []datosOperacion,String resultado){
        Operacion op_actual = new Operacion(operacion,datosOperacion,resultado);
        op_actual.guardarOp();

    }

    public void limpiar(){
        radio_esfera.setText("");
        radio_cilindro.setText("");
        altura_cilindro.setText("");
        radio_cono.setText("");
        altura_cono.setText("");
        arista_cubo.setText("");
    }
    public void borrar(View v){
        limpiar();
    }

    public boolean validar(EditText valor_ingresado){
        if (valor_ingresado.getText().toString().trim().isEmpty()){
            valor_ingresado.requestFocus();
            valor_ingresado.setError(getResources().getString(R.string.error_valor_vacio));
            return false;
        }
        if (Double.parseDouble(valor_ingresado.getText().toString())<=0){
            valor_ingresado.requestFocus();
            valor_ingresado.setError(getResources().getString(R.string.error_valor_menor_igual_cero));
            return false;
        }
        return true;
    }

    public void calcular_volumen_esfera(View v){
        if (validar(radio_esfera)){
            Double valor_radio = Double.parseDouble(radio_esfera.getText().toString());
            Double resultado = (4*(3.141592653589793*(valor_radio * valor_radio * valor_radio)))/3;
            String radio = getResources().getString(R.string.radio)+"= "+valor_radio;
            String [] datos_operacion = {radio};

            almacenarOperacion(getResources().getString(R.string.volumen_esfera),datos_operacion,resultado+"");
            Toast.makeText(this,getResources().getString(R.string.resultado)+"\n"+(resultado+""),Toast.LENGTH_SHORT);
            limpiar();
        }
    }

    public void calcular_volumen_cilindro(View v){
        if (validar(radio_cilindro)&& validar(altura_cilindro)){
            Double valor_radio = Double.parseDouble(radio_cilindro.getText().toString());
            Double valor_altura = Double.parseDouble(altura_cilindro.getText().toString());
            Double resultado = 3.141592653589793*(valor_radio * valor_radio)*valor_altura;
            String radio_altura = getResources().getString(R.string.radio)+"= "+valor_radio+"\n"+
                    getResources().getString(R.string.altura)+"= "+valor_altura;
            String [] datos_operacion = {radio_altura};

            almacenarOperacion(getResources().getString(R.string.volumen_cilindro),datos_operacion,resultado+"");
            Toast.makeText(this,getResources().getString(R.string.resultado)+"\n"+(resultado+""),Toast.LENGTH_SHORT);
            limpiar();
        }
    }

    public void calcular_volumen_cono(View v){
        if (validar(radio_cono)&& validar(altura_cono)){
            Double valor_radio = Double.parseDouble(radio_cono.getText().toString());
            Double valor_altura = Double.parseDouble(altura_cono.getText().toString());
            Double resultado = (3.141592653589793*(valor_radio * valor_radio)*valor_altura)/3;
            String radio_altura = getResources().getString(R.string.radio)+"= "+valor_radio+"\n"+
                    getResources().getString(R.string.altura)+"= "+valor_altura;
            String [] datos_operacion = {radio_altura};

            almacenarOperacion(getResources().getString(R.string.volumen_cono),datos_operacion,resultado+"");
            Toast.makeText(this,getResources().getString(R.string.resultado)+"\n"+(resultado+""),Toast.LENGTH_SHORT);
            limpiar();
        }
    }

    public void calcular_volumen_cubo(View v){
        if (validar(arista_cubo)){
            Double valor_arista = Double.parseDouble(arista_cubo.getText().toString());
            Double resultado = valor_arista * valor_arista * valor_arista ;
            String arista = getResources().getString(R.string.arista)+"= "+valor_arista;
            String [] datos_operacion = {arista};

            almacenarOperacion(getResources().getString(R.string.volumen_cubo),datos_operacion,resultado+"");
            Toast.makeText(this,getResources().getString(R.string.resultado)+"\n"+(resultado+""),Toast.LENGTH_SHORT);
            limpiar();
        }
    }

}
