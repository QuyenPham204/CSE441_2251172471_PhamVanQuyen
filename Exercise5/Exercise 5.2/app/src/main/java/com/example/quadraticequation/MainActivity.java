package com.example.quadraticequation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC;
    Button btnContinue, btnSolution, btnExit;
    TextView txtResult;
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
        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);
        edtC = findViewById(R.id.edt_c);
        btnContinue = findViewById(R.id.btn_continue);
        btnSolution = findViewById(R.id.btn_solution);
        btnExit = findViewById(R.id.btn_exit);
        txtResult = findViewById(R.id.txt_result);
        btnSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = Integer.parseInt(edtC.getText().toString());
                String result = "";
                DecimalFormat dcf = new DecimalFormat("0.00");
                if(a==0){
                    if(b==0){
                        if(c==0){
                            result="PT vô số nghiệm";
                        }
                        else {
                            result="PT vô nghiệm";
                        }
                    }
                    else{
                        result="PT có 1 No, x="+dcf.format(-c/b);
                    }
                }else{
                    double delta = b*b - 4*a*c;
                    if(delta<0){
                        result="PT vô nghiệm";
                    }
                    else if(delta==0){
                        result="PT có No kép x1=x2="+dcf.format(-b/(2*a));
                    }
                    else{
                        result="PT có 2 No: x1="+dcf.format((b-Math.sqrt(delta))/(2*a))+"; x2="+dcf.format((-b-Math.sqrt(delta))/(2*a));
                    }
                    txtResult.setText(result);
                }
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                edtA.requestFocus();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}