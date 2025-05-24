package com.example.exercise6;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import android.util.Log; // Nếu bạn dùng Log
import android.widget.Toast; // Nếu bạn dùng Toast

public class MainActivity extends AppCompatActivity {

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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); // Lấy đối tượng MenuInflater
        inflater.inflate(R.menu.main_options_menu, menu); // Nạp file menu vào đối tượng menu
        Log.d(TAG, "onCreateOptionsMenu đã được gọi và nạp menu."); // Ghi log (Nhớ khai báo TAG)
        return true; // Trả về true để menu được hiển thị
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); // Lấy ID của mục menu được nhấn
        Log.d(TAG, "onOptionsItemSelected được gọi cho item: " + item.getTitle());

        // Sử dụng if/else if để kiểm tra ID
        if (itemId == R.id.action_settings) {
            // Hành động khi nhấn "Cài đặt"
            Log.i(TAG, "Mục Cài đặt được chọn.");
            Toast.makeText(this, R.string.settings_selected, Toast.LENGTH_SHORT).show();

            // Trong tương lai, bạn có thể mở SettingsActivity tại đây:
            // Intent intent = new Intent(this, SettingsActivity.class);
            // startActivity(intent);

            return true; // Trả về true vì đã xử lý sự kiện

        } else if (itemId == R.id.action_about) {
            // Hành động khi nhấn "Giới thiệu"
            Log.i(TAG, "Mục Giới thiệu được chọn.");
            Toast.makeText(this, R.string.about_selected, Toast.LENGTH_SHORT).show();

            // Trong tương lai, bạn có thể hiển thị Dialog hoặc Activity Giới thiệu
            // showAboutDialog();

            return true; // Trả về true vì đã xử lý sự kiện

        } else {
            // Nếu không phải ID nào trong các nhánh trên,
            // hãy gọi phương thức của lớp cha để xử lý các trường hợp mặc định (như nút Up/Home)
            return super.onOptionsItemSelected(item);
        }
    }

}
