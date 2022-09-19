package com.example.ui_design;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class activity2 extends baseactivity {
private ImageView imageView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity2);

        final EditText editText1 = new EditText(this);
        Button button5=(Button)findViewById(R.id.sbutton5) ;
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity2.this,activity5.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.sbutton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity2.this,activity4.class);
                startActivity(intent);
            }
        });
        Button button1 = (Button) findViewById(R.id.sbutton1);
        imageView =(ImageView)findViewById(R.id.image_view_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                switch (v.getId())
                {
                    case R.id.sbutton1:

                        AlertDialog.Builder dialog = new AlertDialog.Builder(activity2.this);
                        dialog.setTitle("请输入你的答案");
                        EditText editText1 = new EditText(activity2.this);
                        dialog.setView(editText1);
                        dialog.setIcon(android.R.drawable.btn_star);
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String inputText=editText1.getText().toString();

                                if(inputText.equals("柯基")&& imageView.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.keji).getConstantState())) {
                                    Toast toast = Toast.makeText(activity2.this, "回答正确", Toast.LENGTH_SHORT);
                                    toast.show();
                                    imageView.setImageResource(R.drawable.guibinquan);
                                }
                                else if(inputText.equals("贵宾犬")&& imageView.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.guibinquan).getConstantState()))
                                {
                                    Toast toast = Toast.makeText(activity2.this, "回答正确", Toast.LENGTH_SHORT);

                                    toast.show();
                                    imageView.setImageResource(R.drawable.hashiqi);
                                }
                                else if(inputText.equals("哈士奇")&& imageView.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.hashiqi).getConstantState()))
                                {
                                    Toast toast = Toast.makeText(activity2.this, "回答正确", Toast.LENGTH_SHORT);

                                    toast.show();
                                    Intent intent = new Intent(activity2.this,activity4.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast toast = Toast.makeText(activity2.this, "回答错误", Toast.LENGTH_SHORT);

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