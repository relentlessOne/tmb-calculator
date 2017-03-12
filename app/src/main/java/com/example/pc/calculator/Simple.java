package com.example.pc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Simple extends AppCompatActivity implements View.OnClickListener {

    private double number;
    private double memory;

    private TextView out;

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

        out = (TextView) findViewById(R.id.out);
        number = 0;
        memory = 0;

        out.setText(new DecimalFormat("##").format(number));
        initButtons();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bksp:
                break;
            case R.id.c:
                break;
            case R.id.sign:
                break;
            case R.id.divide:
                break;
            case R.id.multiply:
                break;
            case R.id.minus:
                break;
            case R.id.plus:
                break;
            case R.id.equals:
                break;
            case R.id.dot:
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

    private void updateNumber(double num) {

        int length = String.valueOf(number).length();
        String tmp = new DecimalFormat("##").format(number);
        if (length < 9) {

            if (number == 0) {
                tmp = new DecimalFormat("##").format(num);
            } else {
                tmp += new DecimalFormat("##").format(num);
            }

        }
        out.setText(tmp);


    }
}
