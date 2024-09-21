package com.example.ejercicioindividual3calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText input1, input2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        result = findViewById(R.id.result);

        Button buttonSum = findViewById(R.id.button_sum);
        Button buttonResta = findViewById(R.id.button_resta);
        Button buttonMultiplicacion = findViewById(R.id.button_multiplicacion);
        Button buttonDivision = findViewById(R.id.button_division);

        buttonSum.setOnClickListener(v -> performOperation("sumar"));
        buttonResta.setOnClickListener(v -> performOperation("restar"));
        buttonMultiplicacion.setOnClickListener(v -> performOperation("multiplicar"));
        buttonDivision.setOnClickListener(v -> performOperation("dividir"));
    }

    private void performOperation(String operation) {
        String input1Text = input1.getText().toString();
        String input2Text = input2.getText().toString();

        // Validación de entradas
        if (input1Text.isEmpty() || input2Text.isEmpty()) {
            result.setText("Hola! Por favor, ingrese ambos números primero");
            return;
        }

        int num1 = Integer.parseInt(input1Text);
        int num2 = Integer.parseInt(input2Text);
        int resultado = 0;

        switch (operation) {
            case "sumar":
                resultado = num1 + num2;
                break;
            case "restar":
                resultado = num1 - num2;
                break;
            case "multiplicar":
                resultado = num1 * num2;
                break;
            case "dividir":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    result.setText("Error: División por cero");
                    return;
                }
                break;
        }
        result.setText("Resultado: " + resultado);
    }
}

