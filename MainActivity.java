package com.example.popup_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = (Button) findViewById(R.id.buttonMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });
    }

    private void ShowMenu()
    {
        // this : contex, btn : view(muốn click view nào để sổ sub menu)
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        // lấy layout vào. vì menu này không trả về menu nên ta dùng popup.getmenu
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        //bắt sự kiện, và dựa vào item trả lại id với switchcase
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menuThem: btnMenu.setText("Menu Thêm");
                        break;
                    case R.id.menuXoa: btnMenu.setText("Menu Xóa");
                        break;
                    case R.id.menuSua: btnMenu.setText("MEnu Sữa");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}