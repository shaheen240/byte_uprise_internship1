package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonDiv, buttonMul;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);

    }

    public Integer getIntFromEditText(EditText editText) {

        String input = editText.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();

            return null;
        } else {

            try {

                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number Format", Toast.LENGTH_SHORT).show();
                return null;

            }
        }


    }


    @Override
    public void onClick(View view) {
        Integer num1 = getIntFromEditText(editTextN1);
        Integer num2 = getIntFromEditText(editTextN2);

        if (num1 != null && num2 != null) {
            switch (view.getId()) {
                case R.id.btn_add:
                    textView.setText("Answer = " + (num1 + num2));
                    break;

                case R.id.btn_sub:
                    textView.setText("Answer = " + (num1 - num2));
                    break;

                case R.id.btn_mul:
                    textView.setText("Answer = " + (num1 * num2));
                    break;

                case R.id.btn_div:
                    if (num2 != 0) {
                        textView.setText("Answer = " + ((float) num1 / (float)num2));
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }


        }
    }
}


