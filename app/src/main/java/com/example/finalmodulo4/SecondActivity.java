package com.example.finalmodulo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.finalmodulo4.databinding.ActivityMainBinding;
import com.example.finalmodulo4.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.btnLinkeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkedingWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/enzo-gatica-3ab264230"));
                startActivity(linkedingWeb);
            }
        });

        binding.btnWsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wspWeb = new Intent(Intent.ACTION_DIAL);
                wspWeb.setData(Uri.parse("tel:+56984769464"));
                startActivity(wspWeb);
            }
        });

        binding.btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msj = binding.editMensaje.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, "email@address.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del mensaje");
                intent.putExtra(Intent.EXTRA_TEXT, msj);
                startActivity(Intent.createChooser(intent, "Enviar correo electrónico a través de: "));

            }
        });



    }
}