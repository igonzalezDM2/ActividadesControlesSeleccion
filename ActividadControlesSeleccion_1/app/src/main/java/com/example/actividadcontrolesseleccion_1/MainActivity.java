package com.example.actividadcontrolesseleccion_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final Map<String, String> INFO_PAISES = new HashMap<>(4);
    static {
        INFO_PAISES.put("España", "Superficie: 506.030 km²; Habitantes: 47,42 millones");
        INFO_PAISES.put("Portugal", "Superficie: 92.152 km²; Habitantes: 10,33 millones");
        INFO_PAISES.put("Venezuela", "Superficie: 916.445 km²; Habitantes: 28,2 millones");
        INFO_PAISES.put("México", "Superficie: 1,973 millones km²; Habitantes: 126,7 millones");
    }

    Spinner spPaises;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spPaises = findViewById(R.id.spPaises);
        tvInfo = findViewById(R.id.tvInfo);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.valores_array_paises, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPaises.setAdapter(adaptador);
        spPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pais = (String) spPaises.getSelectedItem();
                tvInfo.setText(INFO_PAISES.get(pais));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvInfo.setText("");
            }
        });
    }
}