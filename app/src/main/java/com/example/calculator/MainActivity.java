package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        textView = findViewById(R.id.textView2);
        editText1=findViewById(R.id.editTextNumberDecimal3);
        editText2=findViewById(R.id.editTextNumberDecimal4);
        editText3=findViewById(R.id.editTextNumberDecimal5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String s = editText1.getText().toString();
                    String u = editText2.getText().toString();
                    String v = editText3.getText().toString();
                    if(s.isEmpty() || u.isEmpty() || v.isEmpty()){
                        Toast.makeText(MainActivity.this, "Enter Value in Blank Space!!", Toast.LENGTH_SHORT).show();
                        textView.setText("Enter Value in Blank Space!!");
                    }
                    else{
                    Toast.makeText(MainActivity.this, "RESULT CALCULATED", Toast.LENGTH_SHORT).show();
                    double a = Double.parseDouble(s);
                    double b = Double.parseDouble(u);
                    double c = Double.parseDouble(v);
                    double result;
                    if (a <= 10) {
                        result = (double) Math.round(b * c / a);
                    } else {
                        result = (double) Math.round((b * c) * (1000 / a));
                    }
                    textView.setText("Rs " + result);
                    }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = editText1.getText().toString();
                String u = editText2.getText().toString();
                String v = editText3.getText().toString();
                if(s.isEmpty() || u.isEmpty() || v.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Value in Blank Space!!", Toast.LENGTH_SHORT).show();
                    textView.setText("Enter Value in Blank Space!!");
                }
                else{
                Toast.makeText(MainActivity.this, "RESULT CALCULATED", Toast.LENGTH_SHORT).show();
                double a = Double.parseDouble(s);
                double b = Double.parseDouble(u);
                double c = Double.parseDouble(v);
                double result;
                if(a<=10){
                    result=(double) Math.round((b*c)/(a*1000));
                }
                else{
                    result=(double) Math.round((b*c)/(a));
                }
                textView.setText("Rs "+result);
            }
        }});
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "CLEARED", Toast.LENGTH_SHORT).show();
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                textView.setText("");
            }
        }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.uni){
            Toast.makeText(this,"Discount Calculator",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.disc){
            Toast.makeText(this,"Unitary Method Calculator",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}