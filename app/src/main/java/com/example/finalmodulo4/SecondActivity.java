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
                Intent wspWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.whatsapp.com/"));
                startActivity(wspWeb);
            }
        });

        binding.btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msj = binding.editMensaje.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("APP:"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"contacto");
                intent.putExtra(Intent.EXTRA_TEXT, msj);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                    Toast.makeText(getBaseContext(),"Mensaje enviado", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getBaseContext(),"Mensaje No enviado", Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}