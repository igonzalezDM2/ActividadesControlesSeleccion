package com.example.actividadcontrolesseleccion_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final Waifu[] WAIFUS = new Waifu[] {
            new Waifu(R.drawable.a, "Asirpa", "Golden Kamuy", "https://myanimelist.net/character/138552/Asirpa?q=asirpa&cat=character"),
            new Waifu(R.drawable.y, "Yukinoshita Yukino", "Oregairu", "https://myanimelist.net/character/67067/Yukino_Yukinoshita?q=yukino&cat=character"),
            new Waifu(R.drawable.r, "Urushibara Rukako", "Steins; Gate", null)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdaptadorWaifu adaptadorWaifu = new AdaptadorWaifu(this, WAIFUS);
        ListView lvWaifus = findViewById(R.id.lvWaifus);
        lvWaifus.addHeaderView(getLayoutInflater().inflate(R.layout.cabecera_layout, null));
        View pie = getLayoutInflater().inflate(R.layout.pie_layout, null);
        pie.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND, null);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Tengo problemas");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"09iker05@gmail.com"});
            startActivity(intent);
        });
        lvWaifus.addFooterView(pie);
        lvWaifus.setAdapter(adaptadorWaifu);
    }
}