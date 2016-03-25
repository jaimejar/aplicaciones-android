package com.example.jaimejar.micontador;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Mi_Actividad extends AppCompatActivity {

    public int contador;
    TextView resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_mi__actividad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        resultado = (TextView) findViewById(R.id.cuenta);
        contador = 0;
        TextView.OnEditorActionListener teclado;
        teclado = new TextView.OnEditorActionListener() {

            public boolean onEditorAction(TextView v, int accion, KeyEvent evento) {

                if (accion == EditorInfo.IME_ACTION_DONE) {
                    reset(null);
                }
                return false;
            }
        };
            EditText set = (EditText) findViewById(R.id.set);
            set.setOnEditorActionListener(teclado);
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    public void incrementar(View vista){
        contador++;
        resultado.setText("" + contador);
    }

    public void decrementar(View vista){
        contador--;
        if(contador<0){
            CheckBox negativos= (CheckBox)findViewById(R.id.negativos);
            if(!negativos.isChecked()) contador=0;
        }


        resultado.setText("" + contador);
    }
    public void reset(View vista){
        EditText e = (EditText)findViewById(R.id.set);
        try {
            contador = Integer.parseInt(e.getText().toString());
        }catch(Exception excepcion){
            contador=0;
        }
        e.setText("");
        resultado.setText("" + contador);
        InputMethodManager im = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(e.getWindowToken(),0);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mi__actividad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
