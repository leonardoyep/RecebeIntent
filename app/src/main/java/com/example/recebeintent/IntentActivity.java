package com.example.recebeintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity extends AppCompatActivity {

    private TextView dados, textoParaRetoarnar;
    private Button buttonRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dados);

        dados = findViewById(R.id.textFild_Dados);
        textoParaRetoarnar = findViewById(R.id.eTReturn);
        buttonRetornar = findViewById(R.id.button);

        // Get the intent that started this activity
        Intent intent = getIntent();
        Uri data = intent.getData();

        // Figure out what to do based on the intent type
        if (intent.getType().indexOf("image/") != -1) {
            // Handle intents with image data ...
        } else if (intent.getType().equals("text/plain")) {
            // Handle intents with text ...
            handleSendText(intent);

        }
    }

    void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (sharedText != null) {
            // Update UI to reflect text being shared
            dados.setText(sharedText);
        }
    }


    public void submitMessage(View view) {

        Intent intentRetorna = new Intent();
        intentRetorna.putExtra("Key", "");
        setResult(1, intentRetorna);

        finish();
    }
}