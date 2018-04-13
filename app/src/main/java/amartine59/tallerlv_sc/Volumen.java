package amartine59.tallerlv_sc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Volumen extends AppCompatActivity {
    private ListView lv_volumen;
    private String [] op_volumen;
    private Intent in_volumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);

        lv_volumen = findViewById(R.id.lvVolumenes);
        op_volumen = getResources().getStringArray(R.array.op_volumenes);
        ArrayAdapter<String> adp_volumen = new ArrayAdapter(this,android.R.layout.simple_list_item_1,op_volumen);
        lv_volumen.setAdapter(adp_volumen);
        lv_volumen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                switch (i){
                    case 0:
                        in_volumen = new Intent(Volumen.this,Esfera.class);
                        startActivity(in_volumen);
                        break;
                    case 1:
                        in_volumen = new Intent(Volumen.this,Cilindro.class);
                        startActivity(in_volumen);
                        break;
                    case 2:
                        in_volumen = new Intent(Volumen.this,Cono.class);
                        startActivity(in_volumen);
                        break;
                    case 3:
                        in_volumen = new Intent(Volumen.this,Cubo.class);
                        startActivity(in_volumen);
                        break;
                }
            }
        });
    }
}
