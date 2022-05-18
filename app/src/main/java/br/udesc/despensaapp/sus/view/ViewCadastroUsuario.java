package br.udesc.despensaapp.sus.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Switch;

import br.udesc.despensaapp.R;

public class ViewCadastroUsuario extends AppCompatActivity {

    private ImageView imgUsuario;
    private EditText  edtUsuarioEmail;
    private EditText  edtUsuarioSenha;
    private EditText  edtUsuarioConfirmSenha;
    private EditText  edtPessoaNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cadastro_usuario);

        imgUsuario             = findViewById(R.id.vcu_img_pessoa);
        edtUsuarioEmail        = findViewById(R.id.vcu_edt_usuario_email);
        edtUsuarioSenha        = findViewById(R.id.vcu_edt_usuario_senha);
        edtUsuarioConfirmSenha = findViewById(R.id.vcu_edt_usuario_confirm_senha);
        edtPessoaNome          = findViewById(R.id.vcu_edt_pessoa_nome);

        onCreateCheckPermission();
        onCreateComponentes();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        onActivityResultImgCamera(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void onCreateCheckPermission() {
        checkPermissionCamera();
    }

    private int checkPermissionCamera(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }

        return ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
    }

    private void onCreateComponentes() {
        onCreateImgCamera();
        onCreateSwUsuarioAndPessoa();
        onCreateBtnConfirmar();
    }

    private void onCreateImgCamera() {
        ImageView imgCamera = findViewById(R.id.vcu_img_camera);
        imgCamera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkPermissionCamera() == PackageManager.PERMISSION_GRANTED){
                    Intent ivImageCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(ivImageCapture, 1);
                }
            }
        });
    }

    private void onCreateSwUsuarioAndPessoa(){
        ConstraintLayout clUsuario = findViewById(R.id.vcu_cl_usuario);
        ConstraintLayout clPessoa  = findViewById(R.id.vcu_cl_pessoa);
        Switch           swUsuario = findViewById(R.id.vcu_sw_usuario);
        Switch           swPessoa  = findViewById(R.id.vcu_sw_pessoa);

        clUsuario.setVisibility(View.GONE);
        swUsuario.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    clUsuario.setVisibility(View.VISIBLE);
                    clPessoa.setVisibility(View.GONE);
                }else{
                    clUsuario.setVisibility(View.GONE);
                }
            }
        });

        clPessoa.setVisibility(View.GONE);
        swPessoa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    clPessoa.setVisibility(View.VISIBLE);
                    clUsuario.setVisibility(View.GONE);
                }else{
                    clPessoa.setVisibility(View.GONE);
                }
            }
        });
    }

    private void onCreateBtnConfirmar(){

    }

    private void onActivityResultImgCamera(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1 &&
           resultCode  == RESULT_OK){
            Bundle bdlImageResult = data.getExtras();
            Bitmap bmpImageResult = (Bitmap) bdlImageResult.get("data");
            imgUsuario.setImageBitmap(bmpImageResult);
        }
    }
}