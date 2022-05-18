package br.udesc.despensaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import br.udesc.despensaapp.sus.view.ViewAcessoUsuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        executeThreadTransition();
    }

    private void executeThreadTransition(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ivAcessoUsuario = new Intent(getApplicationContext(), ViewAcessoUsuario.class);
                startActivity(ivAcessoUsuario);

                finish();
            }
        },1000);
    }
}