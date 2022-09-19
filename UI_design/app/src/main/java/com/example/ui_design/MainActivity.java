package com.example.ui_design;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends baseactivity {
private ImageView imageView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button5 = (Button) findViewById(R.id.button5);
button5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,activity5.class);
        startActivity(intent);
    }
});
        imageView =(ImageView)findViewById(R.id.image_view_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this, "对不起，东币不足", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        Button button3 = (Button) findViewById(R.id.fbutton1);
        button3.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v)
            {

                switch (v.getId())
                {
                    case R.id.fbutton1:

                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("请输入你的答案");
                         EditText editText = new EditText(MainActivity.this);
                        dialog.setView(editText);
                        dialog.setIcon(android.R.drawable.btn_star);
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String inputText=editText.getText().toString();
                                Log.d("MainActivity",inputText);
                                if(inputText.equals("波斯猫") && imageView.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.bosimao).getConstantState())) {
                                    Toast toast = Toast.makeText(MainActivity.this, "回答正确", Toast.LENGTH_SHORT);

                                    toast.show();
                                    imageView.setImageResource(R.drawable.xianluomao);
                                }
                                else if(inputText.equals("暹罗猫")&& imageView.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.xianluomao).getConstantState()))
                                {
                                    Toast toast = Toast.makeText(MainActivity.this, "回答正确", Toast.LENGTH_SHORT);

                                    toast.show();
                                    imageView.setImageResource(R.drawable.mengmaimao);
                                }
                                else if(inputText.equals("孟买猫")&& imageView.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.mengmaimao).getConstantState()))
                                {
                                    Toast toast = Toast.makeText(MainActivity.this, "回答正确", Toast.LENGTH_SHORT);

                                    toast.show();
                                   Intent intent = new Intent(MainActivity.this,activity2.class);
                                   startActivity(intent);
                                }
                                else{
                                    Toast toast = Toast.makeText(MainActivity.this, "回答错误", Toast.LENGTH_SHORT);

                                    toast.show();
                                }
                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.show();

                        break;
                    default:
                        break;

                }}




        });

    }
}