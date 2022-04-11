package muhammad.saad.n01366618;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MuhammadActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    //My fragments
    HomeFrag homeFrag = new HomeFrag();
    DownloadFrag downloadFrag = new DownloadFrag();
    SaSrv saSrv = new SaSrv();
    FileContentFrag fileContentFrag = new FileContentFrag();
    SettingsFrag settingsFrag = new SettingsFrag();
    ShapeFrag shapeFrag = new ShapeFrag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureToolBar();
        this.configureDrawerLayout();
        this.configureNavigationView();
        getSupportFragmentManager().beginTransaction().replace(R.id.muhammad_main_frame_layout, homeFrag).commit();
    }

    private void configureToolBar() {
        this.toolbar = (Toolbar) findViewById(R.id.muhammad_main_toolbar);
        setSupportActionBar(toolbar);
    }

    private void configureDrawerLayout() {
        this.drawerLayout = (DrawerLayout) findViewById(R.id.muhammad_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigationView() {
        this.navigationView = (NavigationView) findViewById(R.id.muhammad_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.muhammad_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.muhammad_main_frame_layout, homeFrag).commit();
                this.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.muhammad_download:
                getSupportFragmentManager().beginTransaction().replace(R.id.muhammad_main_frame_layout, downloadFrag).commit();
                this.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.muhammad_weather:
                getSupportFragmentManager().beginTransaction().replace(R.id.muhammad_main_frame_layout, saSrv).commit();
                this.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.muhammad_filecontent:
                getSupportFragmentManager().beginTransaction().replace(R.id.muhammad_main_frame_layout, fileContentFrag).commit();
                this.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.muhammad_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.muhammad_main_frame_layout, settingsFrag).commit();
                this.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.muhammad_shape:
                getSupportFragmentManager().beginTransaction().replace(R.id.muhammad_main_frame_layout, shapeFrag).commit();
                this.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

        }

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_right_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.muhammad_settings:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS ),0);
                return true;
            case R.id.muhammad_help:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wwe.com/"));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}