package amartine59.tallerlv_sc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CalculoA extends AppCompatActivity {
    private LinearLayout area_cuadrado;
    private LinearLayout area_rectangulo;
    private LinearLayout area_triangulo;
    private LinearLayout area_circulo;
    private EditText lado_cuadrado;
    private EditText base_rectangulo,altura_rectangulo;
    private EditText base_triangulo,altura_triangulo;
    private EditText radio_circulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_a);

        area_cuadrado = findViewById(R.id.arCuadrado);
        area_rectangulo = findViewById(R.id.arRectangulo);
        area_triangulo = findViewById(R.id.arTriangulo);
        area_circulo = findViewById(R.id.arCirculo);

        lado_cuadrado = findViewById(R.id.txtLadoCuadrado);

        base_rectangulo = findViewById(R.id.txtBaseRectangulo);
        altura_rectangulo = findViewById(R.id.txtAlturaRectangulo);

        base_triangulo = findViewById(R.id.txtBaseTriangulo);
        altura_triangulo = findViewById(R.id.txtAlturaTriangulo);

        radio_circulo = findViewById(R.id.txtRadioCirculo);
        Intent in_operacion = getIntent();
        String operacion_a_realizar = in_operacion.getStringExtra("Calculo_A_Realizar");

        area_cuadrado.setVisibility(LinearLayout.GONE);
        area_rectangulo.setVisibility(LinearLayout.GONE);
        area_triangulo.setVisibility(LinearLayout.GONE);
        area_circulo.setVisibility(LinearLayout.GONE);

        switch (operacion_a_realizar){
            case "cuadrado":
                area_cuadrado.setVisibility(LinearLayout.VISIBLE);
                break;
            case "rectangulo":
                area_rectangulo.setVisibility(LinearLayout.VISIBLE);
                break;
            case "triangulo":
                area_triangulo.setVisibility(LinearLayout.VISIBLE);
                break;
            case "circulo":
                area_circulo.setVisibility(LinearLayout.VISIBLE);
                break;
        }

    }
    public void almacenarOperacion(String operacion,String []datosOperacion,String resultado){
        Operacion op_actual = new Operacion(operacion,datosOperacion,resultado);
        op_actual.guardarOp();

    }

    public void limpiar(){
        lado_cuadrado.setText("");
        base_rectangulo.setText("");
        altura_rectangulo.setText("");
        base_triangulo.setText("");
        altura_triangulo.setText("");
        radio_circulo.setText("");
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

    public void calcular_area_cuadrado(View v){
        if (validar(lado_cuadrado)){
            Double valor_lado = Double.parseDouble(lado_cuadrado.getText().toString());
            Double resultado = valor_lado * valor_lado;
            String lado = getResources().getString(R.string.lado)+"= "+valor_lado;
            String [] datos_operacion = {lado};

            almacenarOperacion(getResources().getString(R.string.area_cuadrado),datos_operacion,resultado+"");
            Toast.makeText(this,getResources().getString(R.string.resultado)+"\n"+(resultado+""),Toast.LENGTH_SHORT);
            limpiar();
        }
    }

    public void calcular_area_rectangulo(View v){
        if (validar(base_rectangulo)&& validar(altura_rectangulo)){
            Double valor_base = Double.parseDouble(base_rectangulo.getText().toString());
            Double valor_altura = Double.parseDouble(altura_rectangulo.getText().toString());
            Double resultado = valor_base * valor_altura;
            String base_altura = getResources().getString(R.string.base)+"= "+valor_base+"\n"+
                                 getResources().getString(R.string.altura)+"= "+valor_altura;
            String [] datos_operacion = {base_altura};

            almacenarOperacion(getResources().getString(R.string.area_rectangulo),datos_operacion,resultado+"");
            Toast.makeText(this,getResources().getString(R.string.resultado)+"\n"+(resultado+""),Toast.LENGTH_SHORT);
            limpiar();
        }
    }

    public void calcular_area_triangulo(View v){
        if (validar(base_triangulo)&& validar(altura_triangulo)){
            Double valor_base = Double.parseDouble(base_triangulo.getText().toString());
            Double valor_altura = Double.parseDouble(altura_triangulo.getText().toString());
            Double resultado = (valor_base * valor_altura)/2;
            String base_altura = getResources().getString(R.string.base)+"= "+valor_base+"\n"+
                    getResources().getString(R.string.altura)+"= "+valor_altura;
            String [] datos_operacion = {base_altura};

            almacenarOperacion(getResources().getString(R.string.area_triangulo),datos_operacion,resultado+"");
            Toast.makeText(this,getResources().getString(R.string.resultado)+"\n"+(resultado+""),Toast.LENGTH_SHORT);
            limpiar();
        }
    }

    public void calcular_area_circulo(View v){
        if (validar(radio_circulo)){
            Double valor_radio = Double.parseDouble(lado_cuadrado.getText().toString());
            Double resultado = 3.141592653589793*(valor_radio*valor_radio);
            String radio = getResources().getString(R.string.radio)+"= "+valor_radio;
            String [] datos_operacion = {radio};

            almacenarOperacion(getResources().getString(R.string.area_circulo),datos_operacion,resultado+"");
            Toast.makeText(this,getResources().getString(R.string.resultado)+"\n"+(resultado+""),Toast.LENGTH_SHORT);
            limpiar();
        }
    }
}
