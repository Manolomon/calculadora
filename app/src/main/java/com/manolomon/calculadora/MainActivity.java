package com.manolomon.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Double valorTemp;
    private int operacion;
    /*
        0: No hay operación
        1: Dividir
        2: Multiplicar
        3: Sumar
        4: Restar
     */

    private TextView pantalla;
    private String valorPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = (TextView)findViewById(R.id.txt_pantalla);
        valorPantalla = "";
        valorTemp = 0.0;
    }

    private void almacenarTemporal() {
        try {
            valorTemp = Double.parseDouble(valorPantalla);
            valorPantalla = "";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void hacerOperacion () {
        if (operacion != 0) {
            try {
                Double resultado = 0.0;
                Double nuevoValor = Double.parseDouble(valorPantalla);
                switch (operacion) {
                    case 1:
                        if (nuevoValor != 0.0) {
                            resultado = valorTemp / nuevoValor;
                            valorPantalla = "" + resultado;
                        } else {
                            Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 2:
                        resultado = valorTemp * nuevoValor;
                        valorPantalla = "" + resultado;
                        break;
                    case 3:
                        resultado = valorTemp + nuevoValor;
                        valorPantalla = "" + resultado;
                        break;
                    case 4:
                        resultado = valorTemp - nuevoValor;
                        valorPantalla = "" + resultado;
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void onClickGenererico(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                valorPantalla += "0";
                break;
            case R.id.btn_1:
                valorPantalla += "1";
                break;
            case R.id.btn_2:
                valorPantalla += "2";
                break;
            case R.id.btn_3:
                valorPantalla += "3";
                break;
            case R.id.btn_4:
                valorPantalla += "4";
                break;
            case R.id.btn_5:
                valorPantalla += "5";
                break;
            case R.id.btn_6:
                valorPantalla += "6";
                break;
            case R.id.btn_7:
                valorPantalla += "7";
                break;
            case R.id.btn_8:
                valorPantalla += "8";
                break;
            case R.id.btn_9:
                valorPantalla += "9";
                break;
            case R.id.btn_limpiar:
                valorPantalla = "";
                break;
            case R.id.btn_borrar:
                if (valorPantalla.length() > 0) {
                    valorPantalla = valorPantalla.substring(0, valorPantalla.length()-1);
                }
                break;
            case R.id.btn_igual:
                hacerOperacion();
                break;
            case R.id.btn_punto:
                if (!valorPantalla.contains(".")) {
                    valorPantalla += ".";
                }
                break;
            case R.id.btn_div:
                almacenarTemporal();
                operacion = 1;
                break;
            case R.id.btn_mult:
                almacenarTemporal();
                operacion = 2;
                break;
            case R.id.btn_sum:
                almacenarTemporal();
                operacion = 3;
                break;
            case R.id.btn_res:
                almacenarTemporal();
                operacion = 4;
                break;
        }
        pantalla.setText(this.valorPantalla);
    }
}
