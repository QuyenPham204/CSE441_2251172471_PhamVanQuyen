package com.example.registerpersonalinfomation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtCMND, edtInfo;
    RadioGroup group;
    CheckBox chkNews, chkBooks, chkCode;
    Button btnSend;
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
        edtCMND = findViewById(R.id.edt_cmnd);
        edtInfo = findViewById(R.id.edt_info);
        chkNews = findViewById(R.id.chk_news);
        chkBooks = findViewById(R.id.chk_books);
        chkCode = findViewById(R.id.chk_code);
        btnSend = findViewById(R.id.btn_sendinfo);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInfomation();
            }

            public void doShowInfomation() {
                String name = edtName.getText().toString().trim();
                if(name.length() < 3){
                    edtName.requestFocus();
                    edtName.selectAll();
                    Toast.makeText(getApplicationContext(), "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
                    return;
                }
                String cmnd = edtCMND.getText().toString().trim();
                if(cmnd.length() != 9){
                    edtCMND.requestFocus();
                    edtCMND.selectAll();
                    Toast.makeText(getApplicationContext(), "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
                    return;
                }
                String degree = "";
                group = findViewById(R.id.rad_group);
                int id=group.getCheckedRadioButtonId();
                if(id==-1){
                    Toast.makeText(getApplicationContext(), "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
                    return;
                }
                RadioButton rad = findViewById(id);
                degree=rad.getText().toString();
                String hobby = "";
                if(chkNews.isChecked()){
                    hobby+=chkNews.getText().toString() + "\n";
                }
                if(chkBooks.isChecked()){
                    hobby+=chkBooks.getText().toString() + "\n";
                }
                if(chkCode.isChecked()){
                    hobby+=chkCode.getText().toString() + "\n";
                }
                String info = edtInfo.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin cá nhân");
                builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                String msg = name + "\n";
                msg += cmnd+"\n";
                msg += degree+"\n";
                msg += hobby+"\n";
                msg+="--------------\n";
                msg+="Thông tin bổ sung\n";
                msg+=info+"\n";
                msg+="--------------\n";
                builder.setMessage(msg);

                builder.create();
                builder.show();
            }

        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Question");
                b.setMessage("Are you sure you want to exit?");
                b.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                b.create().show();
            }
        });
    }

}