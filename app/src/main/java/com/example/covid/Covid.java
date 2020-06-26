package com.example.covid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.login.LoginManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Covid extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);
        this.setTitle("Seleccione un Continente");
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottonNava);
            ContinentesFragment continentesFragment = new ContinentesFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, continentesFragment, ContinentesFragment.TAG)
                    .commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.Inicio)
                {
                    ContinentesFragment continentesFragment = new ContinentesFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, continentesFragment, ContinentesFragment.TAG)
                            .commit();
                }else if(item.getItemId()== R.id.Hospitales)
                {
                    FragmentoMenu2 fragmentoMenu2 = new FragmentoMenu2();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,fragmentoMenu2,FragmentoMenu2.TAG)
                            .commit();
                }
                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cerrar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.btnCerrar:
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                goLoginScreen();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void goLoginScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
