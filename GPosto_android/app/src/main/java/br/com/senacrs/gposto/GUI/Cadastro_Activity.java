package br.com.senacrs.gposto.GUI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.senacrs.gposto.R;

public class Cadastro_Activity extends AppCompatActivity {

    Button btnVoltar;
    EditText txtNome;
    EditText txtSenha;
    EditText txtConfirmarSenha;
    EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_);
    }

    public void callMain(View v){
        startActivity(new Intent(Cadastro_Activity.this, MainActivity.class));
    }
}
