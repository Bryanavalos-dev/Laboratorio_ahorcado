package com.example.laboratorio_ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //creando obejtos para enlazar los componente
    EditText edtTryWord, edtE, edtT, edtP, edtS;
    TextView tvCounter, tvResult;


    Button btnVerify, btnClean;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enlazando los componente
        edtTryWord = findViewById(R.id.edtWordToTry);
        edtE = findViewById(R.id.edtLetterE);
        edtT = findViewById(R.id.edtLetterT);
        edtP = findViewById(R.id.edtLetterP);
        edtS = findViewById(R.id.edtLetterS);

        btnVerify = findViewById(R.id.btnVerify);
        btnClean = findViewById(R.id.btnClean);
        tvCounter = findViewById(R.id.tvCounter);
        tvResult = findViewById(R.id.tvResult);
btnClean.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        edtTryWord.setText("");
    }
});
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                String word = edtTryWord.getText().toString().trim();


                if(TextUtils.isEmpty(word)){
                    edtTryWord.setError("Valor requerido");
                    edtTryWord.requestFocus();
                } else {
                    tvResult.setText("");
                    counter++;
                    tvCounter.setText(String.valueOf(counter));
                  if(counter ==7){
                      tvResult.setText("PERDISTE.");
                      edtTryWord.setText("");
                      counter = 0;
                  }else{

                          int time=1;
                          if(word.contains("e") || word.contains("E")){
                              edtE.setText("E");
                          }
                          if(word.contains("t") || word.contains("T")){
                              edtT.setText("T");

                          }
                          if(word.contains("p") || word.contains("P")){
                              edtP.setText("P");


                          }
                          if(word.contains("s") || word.contains("S")){
                              edtS.setText("S");

                          }
                      String e = edtE.getText().toString();
                      String t = edtT.getText().toString();
                      String p = edtP.getText().toString();
                      String s = edtS.getText().toString();
                          if(TextUtils.isEmpty(e) || TextUtils.isEmpty(t) || TextUtils.isEmpty(p) || TextUtils.isEmpty(s)){
                              Toast.makeText(getApplicationContext(), "continua intentando", time).show();
                              edtTryWord.setText("");

                          }else{
                              tvResult.setText("GANASTE");
                              edtTryWord.setText("");

                          }


                      }
                  }


            }
        });

    }
}