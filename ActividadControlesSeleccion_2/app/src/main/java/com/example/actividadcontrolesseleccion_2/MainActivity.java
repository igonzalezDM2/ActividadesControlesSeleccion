package com.example.actividadcontrolesseleccion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final PaginaWeb[] PAGINAS = new PaginaWeb[] {
            new PaginaWeb().setNombre("UnionFansub").setUrl("https://foro.unionfansub.com/").setImagen(R.drawable.uf),
            new PaginaWeb().setNombre("MyAnimeList").setUrl("https://myanimelist.net/").setImagen(R.drawable.mal_logo),
            new PaginaWeb().setNombre("ForoCoches").setUrl("https://forocoches.com/").setImagen(R.drawable.forocoches)
    };
    private ListView lvPaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPaginas = findViewById(R.id.lvPaginas);
        PaginaWebAdapter adaptador = new PaginaWebAdapter(this, PAGINAS);
        lvPaginas.setAdapter(adaptador);



    }
}