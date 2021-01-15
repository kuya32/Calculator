package com.macode.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

import static java.lang.Math.round;

public class MainActivity extends AppCompatActivity {

    private EditText calculation, result;
    private String curr, res;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, clearButton, backspaceButton, divideButton, multiplyButton, minusButton, plusButton, equalsButton, pointButton;
    private boolean dotInserted, operatorInserted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculations);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";
        dotInserted = false;
        operatorInserted = false;

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
        plusButton = (Button) findViewById(R.id.plusButton);
        equalsButton = (Button) findViewById(R.id.equalsButton);
        pointButton = (Button) findViewById(R.id.pointButton);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0";
                displayCalculation();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayCalculation();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayCalculation();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayCalculation();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayCalculation();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayCalculation();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayCalculation();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayCalculation();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayCalculation();
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayCalculation();
            }
        });

        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curr.isEmpty()) {
                    curr = curr + "0.";
                    dotInserted = true;
                } else if (!dotInserted) {
                    curr = curr + ".";
                    dotInserted = true;
                }
                displayCalculation();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayCalculation();
                displayResult();
            }
        });

        backspaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
                displayCalculation();
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        backspace();
                    }
                    if (!operatorInserted) {
                        curr = curr + " ÷ ";
                        operatorInserted = true;
                    }
                }
                displayCalculation();
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        backspace();
                    }
                    if (!operatorInserted) {
                        curr = curr + " x ";
                        operatorInserted = true;
                    }
                }
                displayCalculation();
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        backspace();
                    }
                    if (!operatorInserted) {
                        curr = curr + " - ";
                        operatorInserted = true;
                    }
                }
                displayCalculation();
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        backspace();
                    }
                    if (!operatorInserted) {
                        curr = curr + " + ";
                        operatorInserted = true;
                    }
                }
                displayCalculation();
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operatorInserted && !curr.substring(curr.length() - 1).equals(" ")) {
                    String[] tokens = curr.split( " ");
                    DecimalFormat df = new DecimalFormat("#.##########");

                    switch (tokens[1].charAt(0)) {
                        case '+':
                            res = Double.toString(Double.parseDouble(df.format(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]))));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(df.format(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]))));
                            break;
                        case 'x':
                            res = Double.toString(Double.parseDouble(df.format(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]))));
                            break;
                        case '÷':
                            res = Double.toString(Double.parseDouble(df.format(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]))));
                            break;
                    }
                    displayResult();
                }
            }
        });
    }

    public void displayCalculation() {
        calculation.setText(curr);
    }

    public void displayResult() {
        result.setText(res);
    }

    public void clear() {
        curr = "";
        res = "0";
        dotInserted = false;
        operatorInserted = false;
    }

    public void backspace() {
        if (!curr.isEmpty()) {
            if (curr.substring(curr.length() - 1).equals(".")) {
                dotInserted = false;
            }
            if (curr.substring(curr.length() - 1). equals(" ")) {
                curr = curr.substring(0, curr.length() - 3);
                operatorInserted = false;
            } else {
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
}