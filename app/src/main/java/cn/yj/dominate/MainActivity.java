package cn.yj.dominate;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import cn.yj.dominate.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {


    private ListView lv;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager packageManager = getPackageManager();
        final List<PackageInfo> pkgAppsList = packageManager.getInstalledPackages(0);


        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new MainAdapter(this, packageManager, pkgAppsList));

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        configureToolbar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * 配置toolbar属性
     */
    private void configureToolbar() {
        toolbar.setTitle("主宰");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        // 监听方法只有在setSupportActionBar(toolbar);的下方时才生效
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_setting:
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                    break;
                }
                return false;
            }
        });

    }

}
