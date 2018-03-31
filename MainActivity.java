package com.example.sadafhussain.alertdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] sequence={"java","Android","spring","C#","C++"};//for multi-choice dialog,2nd method is
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);//1- to alert, use alertDialog class with message builder
       // builder.setMessage("Alert dialog");
        builder.setTitle("Alert!!");
        builder.setIcon(R.mipmap.ic_launcher);//default icon which is in mipmap in layout
         //in alert dialog, we have two functions either it is +ve,or -ve.
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener()// 1st parameter is "which we want to set" and
            //2nd is jis type ka action krwana chahty hain
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Hello ",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener()// 1st parameter is "which we want to set" and
                //2nd is jis type ka action krwana chahty hain
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT);
                startActivity(new Intent(MainActivity.this,MainActivity.class));//when clicked on cancel button, then go to main activity

            }
        });
        builder.setMultiChoiceItems(sequence, new boolean[sequence.length], new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this,sequence[i]+ (b? "  checked":" unchecked"),Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();//to show alert message

    }
}
