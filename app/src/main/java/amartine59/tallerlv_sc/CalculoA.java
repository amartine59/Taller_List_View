package amartine59.tallerlv_sc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

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



    }
    public void almacenarOperacion(String operacion,String []datosOperacion,String resultado){
        Operacion op_actual = new Operacion(operacion,datosOperacion,resultado);
        op_actual.guardarOp();

    }

    public void limpiar(View v){
        lado_cuadrado.setText("");
        base_rectangulo.setText("");
        altura_rectangulo.setText("");
        base_triangulo.setText("");
        altura_triangulo.setText("");
        radio_circulo.setText("");
    }
    public boolean validar(EditText valor_ingresado){
        if (valor_ingresado.getText().toString().trim().isEmpty()){

        }
    }
}
