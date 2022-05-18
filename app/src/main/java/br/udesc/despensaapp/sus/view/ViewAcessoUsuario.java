package br.udesc.despensaapp.sus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.udesc.despensaapp.R;

public class ViewAcessoUsuario extends AppCompatActivity {

    TextView txtCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_acesso_usuario);

        onCreateTextViewCadastrar();
    }

    private void onCreateTextViewCadastrar(){
        txtCadastrar = findViewById(R.id.vau_txt_cadastrar);
        txtCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent ivCadastroUsuario = new Intent(getApplicationContext(), ViewCadastroUsuario.class);
                startActivity(ivCadastroUsuario);
            }
        });
    }
}