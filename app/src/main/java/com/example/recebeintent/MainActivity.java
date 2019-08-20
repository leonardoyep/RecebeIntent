package com.example.recebeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSend;
    private EditText name;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentImplicita();
            }
        });


    }


    private void init() {

        buttonSend = findViewById(R.id.buttonSend);
        texto = findViewById(R.id.caixaTexto);
    }


    private void intentImplicita() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "");
        sendIntent.setType("text/plain");

        startActivityForResult(sendIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == 1) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                String result = data.getStringExtra("Key");
                Toast.makeText(this, "This is the result: " + result, Toast.LENGTH_SHORT).show();
                texto.setText(result);
                // Do something with the contact here (bigger example below)
            }
        }
    }
}
