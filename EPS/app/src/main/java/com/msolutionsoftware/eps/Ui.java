package com.msolutionsoftware.eps;

//import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
//import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Ui extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;
    private String nome = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        if(params!=null)
        {
            //nome = params.getString("nome");
            //Log.d("9001",nome);
            //((TextView)findViewById(R.id.name)).setText(resposta);
            //setContentView(((TextView)findViewById(R.id.name)));
            //resposta = params.getString("email");
            //((TextView)findViewById(R.id.email)).setText(resposta);
            //setContentView(((TextView)findViewById(R.id.email)));
        }

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.nav_pontuacao) {
            onBackPressed();
        }
        else if (id == R.id.nav_coleta) {
            fragmentClass = MapFragmentEps.class;
        } else if (id == R.id.nav_store) {

        } else if (id == R.id.nav_jogo) {

        } else if (id == R.id.nav_historico) {

        } else if (id == R.id.nav_informacoes) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.reciclareps.com.br"));
            startActivity(browserIntent);
        } //else if (id == R.id.nav_settings) {

        //}
        if(id!=R.id.nav_informacoes && id!=R.id.nav_pontuacao) {
            try {

                fragment = (Fragment) fragmentClass.newInstance();

            } catch (Exception e) {
                e.printStackTrace();
            }


        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        }


        // Highlight the selected item, update the title, and close the drawer

        item.setChecked(true);

        setTitle(item.getTitle());

        mDrawer.closeDrawers();

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
