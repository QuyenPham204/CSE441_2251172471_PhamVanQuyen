package com.example.bmi;

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
    EditText edtName, edtHeight, edtWeight, edtBMI, edtDiagnose;
    Button btnCalculateBMI;
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
        edtName = findViewById(R.id.edt_name);
        edtHeight = findViewById(R.id.edt_height);
        edtWeight = findViewById(R.id.edt_weight);
        edtBMI = findViewById(R.id.edt_bmi);
        edtDiagnose = findViewById(R.id.edt_diagnose);
        btnCalculateBMI = findViewById(R.id.btn_calculatebmi);
        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double h = Double.parseDouble(edtHeight.getText().toString());
                double w = Double.parseDouble(edtWeight.getText().toString());
                double bmi = w/Math.pow(h, 2);
                String diagnose = "";
                if(bmi < 18){
                    diagnose = "Bạn gầy";
                }else if(bmi <= 24.9){
                    diagnose = "Bạn bình thường";
                }else if(bmi<=29.9){
                    diagnose = "Bạn bị béo phì độ 1";
                }else if(bmi<=34.9){
                    diagnose = "Bạn bị béo phì độ 2";
                }else{
                    diagnose = "Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                edtBMI.setText(dcf.format(bmi));
                edtDiagnose.setText(diagnose);
            }
        });
    }
}