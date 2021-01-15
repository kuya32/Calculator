package com.macode.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText calculation, result;
    private String curr, res;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, clearButton, backspaceButton, divideButton, multiplyButton, minusButton, addButton, equalsButton, pointButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculations);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        clearButton = (Button) findViewById(R.id.clearButton);
        backspaceButton = (Button) findViewById(R.id.backspaceButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        addButton = (Button) findViewById(R.id.plusButton);
        equalsButton = (Button) findViewById(R.id.equalsButton);
        pointButton = (Button) findViewById(R.id.pointButton);
    }
}