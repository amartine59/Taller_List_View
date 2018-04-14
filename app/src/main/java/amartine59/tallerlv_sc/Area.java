package amartine59.tallerlv_sc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Area extends AppCompatActivity {
    private ListView lv_area;
    private String [] op_area;
    private Intent in_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        lv_area = findViewById(R.id.lvAreas);
        op_area = getResources().getStringArray(R.array.op_areas);
        ArrayAdapter<String> adp_area = new ArrayAdapter(this,android.R.layout.simple_list_item_1,op_area);
        lv_area.setAdapter(adp_area);
        lv_area.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                switch (i){
                    case 0:
                        in_area = new Intent(Area.this,CalculoA.class);
                        startActivity(in_area);
                        break;
                    case 1:
                        in_area = new Intent(Area.this,CalculoA.class);
                        startActivity(in_area);
                        break;
                    case 2:
                        in_area = new Intent(Area.this,CalculoA.class);
                        startActivity(in_area);
                        break;
                    case 3:
                        in_area = new Intent(Area.this,CalculoA.class);
                        startActivity(in_area);
                        break;

                }
            }
        });
    }
}
