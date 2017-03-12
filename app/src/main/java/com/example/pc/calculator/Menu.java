package com.example.pc.calculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private Button simple;
    private Button advanced;
    private Button about;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        loadButtons();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.simple:
                simpleOnClick();
                break;
            case R.id.advanced:
                advancedOnClick();
                break;
            case R.id.about:
                aboutOnClick();
                break;
            case R.id.exit:
                exitOnClick();
                break;
        }

    }

    private void loadButtons() {
        simple = (Button) findViewById(R.id.simple);
        advanced = (Button) findViewById(R.id.advanced);
        about = (Button) findViewById(R.id.about);
        exit = (Button) findViewById(R.id.exit);

        simple.setOnClickListener(this);
        advanced.setOnClickListener(this);
        about.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    private void simpleOnClick() {
        startActivity(new Intent(Menu.this, Simple.class));
    }

    private void advancedOnClick() {
        startActivity(new Intent(Menu.this, Advanced.class));
    }

    private void aboutOnClick() {
        AlertDialog alertDialog = new AlertDialog.Builder(Menu.this).create();
        alertDialog.setTitle("About");
        alertDialog.setMessage("\nApp made by Bartosz Iwaszkiewicz\n\n187705 WEEiA\n");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "CLOSE",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void exitOnClick() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
