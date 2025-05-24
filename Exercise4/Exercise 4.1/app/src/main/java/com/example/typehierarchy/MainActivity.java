package com.example.typehierarchy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtFar, edtCel;
    Button btnCF, btnFC, btnClear;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtFar = findViewById(R.id.edt_fahrenheit);
        edtCel = findViewById(R.id.edt_celsius);
        btnCF = findViewById(R.id.btn_cf);
        btnFC = findViewById(R.id.btn_fc);
        btnClear = findViewById(R.id.btn_clear);

        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String cel = edtCel.getText()+"";
                int C = Integer.parseInt(cel);
                edtFar.setText(""+dcf.format(C*1.8+32));
            }
        });
        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String cel = edtCel.getText()+"";
                int C = Integer.parseInt(cel);
                edtFar.setText(""+dcf.format(C*1.8+32));
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtFar.setText("");
                edtCel.setText("");
            }
        });
    }
}