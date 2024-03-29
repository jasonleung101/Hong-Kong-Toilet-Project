package hk.edu.ouhk.android.afinal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SettingPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigation_view;
    public static final String EXTRA_MESSAGE = "hk.edu.ouhk.android.final.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //nav drawer
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    ChangeToHome();
                    return true;
                } else if (id == R.id.nav_setting) {
                    return true;
                }
                return false;
            }
        });
    }

    public void ChangeToHome(){
        Intent home = new Intent(this, MainActivity.class);
        finish();
        startActivity(home);
        overridePendingTransition(0, 0);
    }

    public void Apply(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = findViewById(R.id.editRow);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        finish();
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

}
