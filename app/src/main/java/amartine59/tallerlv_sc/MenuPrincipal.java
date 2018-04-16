package amartine59.tallerlv_sc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuPrincipal extends AppCompatActivity {
    private ListView lvPrincipal;
    private String [] opc_Principal;
    private Intent in_principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        lvPrincipal = findViewById(R.id.lvMenuPrincipal);
        opc_Principal = getResources().getStringArray(R.array.op_menu_principal);
        ArrayAdapter<String>adpPrincipal = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc_Principal);
        lvPrincipal.setAdapter(adpPrincipal);
        lvPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                switch (i){
                    case 0:
                        in_principal= new Intent(MenuPrincipal.this,Area.class);
                        startActivity(in_principal);
                        break;
                    case 1:
                        in_principal= new Intent(MenuPrincipal.this,Volumen.class);
                        startActivity(in_principal);
                        break;

                    case 2:
                        in_principal= new Intent(MenuPrincipal.this,HistorialOperaciones.class);
                        startActivity(in_principal);
                        break;
                }
            }
        });
    }
}
