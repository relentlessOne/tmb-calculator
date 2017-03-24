package com.example.pc.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Simple extends AppCompatActivity implements View.OnClickListener {

    private double firstNum;
    private double secondNum;
    private double memory;
    private double out;
    private boolean allowDot;
    private boolean loadFirstNumber;
    private boolean initalRun;

    private TextView input1;
    private TextView input2;
    private TextView sum;
    private TextView operator;

    private Button bksp;
    private Button c;
    private Button sign;
    private Button divide;
    private Button multiply;
    private Button minus;
    private Button plus;
    private Button equals;
    private Button dot;
    private Button num9;
    private Button num8;
    private Button num7;
    private Button num6;
    private Button num5;
    private Button num4;
    private Button num3;
    private Button num2;
    private Button num1;
    private Button num0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        memory = 0;
        out = 0.0;
        allowDot = true;
        loadFirstNumber = true;
        initalRun = true;

        input1 = (TextView) findViewById(R.id.input1);
        input2 = (TextView) findViewById(R.id.input2);
        sum = (TextView) findViewById(R.id.sum);
        operator = (TextView) findViewById(R.id.operator);

        input1.setText("0");
        input2.setText("");
        sum.setText("");
        operator.setText("");

        initButtons();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bksp:
                backspace();
                break;
            case R.id.c:
                clear();
                break;
            case R.id.sign:
                changeSign();
                break;
            case R.id.divide:
                operation("/");
                break;
            case R.id.multiply:
                operation("*");
                break;
            case R.id.minus:
                operation("-");
                break;
            case R.id.plus:
                operation("+");
                break;
            case R.id.equals:
                sum();
                break;
            case R.id.dot:
                dot();
                break;
            case R.id.num9:
                updateNumber(9);
                break;
            case R.id.num8:
                updateNumber(8);
                break;
            case R.id.num7:
                updateNumber(7);
                break;
            case R.id.num6:
                updateNumber(6);
                break;
            case R.id.num5:
                updateNumber(5);
                break;
            case R.id.num4:
                updateNumber(4);
                break;
            case R.id.num3:
                updateNumber(3);
                break;
            case R.id.num2:
                updateNumber(2);
                break;
            case R.id.num1:
                updateNumber(1);
                break;
            case R.id.num0:
                updateNumber(0);
                break;
        }
    }

    private void initButtons() {
        bksp = (Button) findViewById(R.id.bksp);
        c = (Button) findViewById(R.id.c);
        sign = (Button) findViewById(R.id.sign);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);
        equals = (Button) findViewById(R.id.equals);
        dot = (Button) findViewById(R.id.dot);
        num9 = (Button) findViewById(R.id.num9);
        num8 = (Button) findViewById(R.id.num8);
        num7 = (Button) findViewById(R.id.num7);
        num6 = (Button) findViewById(R.id.num6);
        num5 = (Button) findViewById(R.id.num5);
        num4 = (Button) findViewById(R.id.num4);
        num3 = (Button) findViewById(R.id.num3);
        num2 = (Button) findViewById(R.id.num2);
        num1 = (Button) findViewById(R.id.num1);
        num0 = (Button) findViewById(R.id.num0);

        bksp.setOnClickListener(this);
        c.setOnClickListener(this);
        sign.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        equals.setOnClickListener(this);
        dot.setOnClickListener(this);
        num9.setOnClickListener(this);
        num8.setOnClickListener(this);
        num7.setOnClickListener(this);
        num6.setOnClickListener(this);
        num5.setOnClickListener(this);
        num4.setOnClickListener(this);
        num3.setOnClickListener(this);
        num2.setOnClickListener(this);
        num1.setOnClickListener(this);
        num0.setOnClickListener(this);

    }

    private TextView whichToLoad() {
        if (loadFirstNumber) {
            return input1;
        } else {
            return input2;
        }
    }

    private void updateNumber(int num) {


        if(!sum.getText().equals("")){

            if(sum.getText().toString().indexOf('E') >= 1){
                AlertDialog alertDialog = new AlertDialog.Builder(Simple.this).create();
                alertDialog.setTitle("Warning");
                alertDialog.setMessage("\nNumber is too big\n");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "CLOSE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            } else {

                sum.setText(sum.getText()+ Integer.toString(num));
            }

        } else {

            TextView tmp = whichToLoad();


            if (tmp.getText().equals("0") || tmp.getText().equals("0.0")) {
                tmp.setText(Integer.toString(num));
            } else {
                tmp.setText(tmp.getText() + Integer.toString(num));
            }
        }



    }

    private void clear() {
        input1.setText("0");
        input2.setText("");
        sum.setText("");
        operator.setText("");
        allowDot = true;
        loadFirstNumber = true;
        out = 0.0;
        initalRun = true;
    }

    private void backspace() {

        if(!sum.getText().equals("")){

            if(sum.getText().toString().indexOf('E') >= 1){
                AlertDialog alertDialog = new AlertDialog.Builder(Simple.this).create();
                alertDialog.setTitle("Warning");
                alertDialog.setMessage("\nNumber is too big\n");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "CLOSE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            } else {

                if (sum.length() != 2) {

                    sum.setText(sum.getText().subSequence(0, sum.length() - 1));
                    out = Double.parseDouble(sum.getText().toString().substring(2, sum.length()));
                } else {
                    sum.setText("= 0.0");
                    out = 0.0;
                }
            }

        } else {
            TextView tmp = whichToLoad();
            String lastChar = tmp.getText().toString().substring(tmp.length() - 1);

            if (tmp.length() != 1) {

                if (lastChar.equals("."))
                    allowDot = true;

                tmp.setText(tmp.getText().subSequence(0, tmp.length() - 1));
            } else {
                tmp.setText("0");
            }
        }



    }

    private void operation(String op) {
        String input1LastChar = input1.getText().toString().substring(input1.length() - 1);


        if (operator.getText().equals("")) {
            if (input1LastChar.equals(".")) {
                input1.setText(input1.getText().subSequence(0, input1.length() - 1));
            }

            operator.setText(op);
            loadFirstNumber = false;
            input2.setText("0");
            allowDot = true;

        } else {
            input1.setText(Double.toString(out));
            input2.setText("");
            sum.setText("");
            operator.setText(op);
        }

    }

    private void dot() {
        TextView tmp = whichToLoad();

        if (allowDot) {
            tmp.setText(tmp.getText() + ".");
            allowDot = false;
        }
    }

    private void changeSign() {

        if(!sum.getText().equals("")){
            //String firstChar = sum.getText().toString().substring(2, 3);

            out *= -1;
            sum.setText("= "+Double.toString(out));

        } else {
            TextView tmp = whichToLoad();

            String firstChar = tmp.getText().toString().substring(0, 1);

            if (!tmp.getText().toString().equals("0")) {
                if (firstChar.equals("-")) {
                    tmp.setText(tmp.getText().toString().substring(1, tmp.length()));
                } else {
                    tmp.setText("-" + tmp.getText());
                }
            }
        }




    }

    private void sum() {


        if(!operator.getText().equals("")){



        String input2LastChar = input2.getText().toString().substring(input2.length() - 1);

        if (input2LastChar.equals(".")) {
            input2.setText(input2.getText().subSequence(0, input2.length() - 1));
        }


        double num1 = 0;
        double num2 = 0;

        if(initalRun){
            num1 = Double.parseDouble(input1.getText().toString());
            num2 = Double.parseDouble(input2.getText().toString());
            initalRun = false;
        } else {
            input1.setText(Double.toString(out));
            num1 = out;
            num2 = Double.parseDouble(input2.getText().toString());
        }





        switch (operator.getText().toString()){
            case "/":
                if(num2 != 0.0){
                    out = num1 / num2;
                    sum.setText("= "+ out);
                } else{
                    clear();
                    AlertDialog alertDialog = new AlertDialog.Builder(Simple.this).create();
                    alertDialog.setTitle("Warning");
                    alertDialog.setMessage("\nCannot divide by zero\n");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "CLOSE",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                break;
            case "+":
                out = num1 + num2;
                sum.setText("= "+ out);
                break;
            case "-":
                out = num1 - num2;
                sum.setText("= "+ out);
                break;
            case "*":
                out = num1 * num2;
                sum.setText("= "+ out);
                break;
        }

        }

    }


}
