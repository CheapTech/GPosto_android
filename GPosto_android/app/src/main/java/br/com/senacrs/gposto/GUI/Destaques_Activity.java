package br.com.senacrs.gposto.GUI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import br.com.senacrs.gposto.R;

public class Destaques_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destaques_);
    }

    public void listarPostos(View v) {
        startActivity(new Intent(Destaques_Activity.this, ListPosto_Activity.class));
    }

    public void configuracoes(View v) {

    }

    public void historico(View v) {
    }

    public void sair(View view) {
    }
}
