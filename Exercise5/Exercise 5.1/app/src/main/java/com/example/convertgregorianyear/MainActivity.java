package com.example.convertgregorianyear;

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

public class MainActivity extends AppCompatActivity {
    EditText edtSolar;
    Button btnChange;
    TextView txtLunar;
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
        edtSolar = findViewById(R.id.edt_solar);
        btnChange = findViewById(R.id.btn_change);
        txtLunar = findViewById(R.id.txt_lunar);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int solar = Integer.parseInt(edtSolar.getText().toString());
                String can, chi;
                switch (solar%10){
                    case 1: can = "Tân";
                    case 2: can = "Nhâm";
                    case 3: can = "Quý";
                    case 4: can = "Giáp";
                    case 5: can = "Ất";
                    case 6: can = "Bính";
                    case 7: can = "Đinh";
                    case 8: can = "Mậu";
                    case 9: can = "Kỷ";
                    default:
                        can = "Canh";
                }
                switch (solar%12){
                    case 1: chi = "Dậu";
                    case 2: chi = "Tuất";
                    case 3: chi = "Hợi";
                    case 4: chi = "Tý";
                    case 5: chi = "Sửu";
                    case 6: chi = "Dần";
                    case 7: chi = "Mẹo";
                    case 8: chi = "Thìn";
                    case 9: chi = "Tỵ";
                    case 10: chi = "Ngọ";
                    case 11: chi = "Mùi";
                    default: chi = "Thân";
                }
                txtLunar.setText(can + chi);
            }
        });
    }
}