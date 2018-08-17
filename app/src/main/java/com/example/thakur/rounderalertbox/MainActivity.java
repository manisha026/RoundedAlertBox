package com.example.thakur.rounderalertbox;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog;
    TextView textView;
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (x == 0) {
                    textView.setTextColor(0xFF00FF00);
                    x=1;
                } else if (x==1){
                    textView.setTextColor(0xFF034000);
                    x=2;
                }   else if (x==2){
                    textView.setTextColor(0xFF034890);
                    x=0;
                }
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false);
        View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.alert,null,false);
        Button btn_yes=view.findViewById(R.id.btn_yes);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btn_cancel=view.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        builder.setView( view );
        alertDialog=builder.create();
        alertDialog.show();
        alertDialog
                .getWindow()
                .setBackgroundDrawable(new ColorDrawable(Color.argb(0,0,0,0)));

    }
}