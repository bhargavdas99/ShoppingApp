package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private Button button2;
    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button4);
        button2 = findViewById(R.id.button6);
        textView = findViewById(R.id.textView10);
        editText1 = findViewById(R.id.editTextNumberDecimal);
        editText2= findViewById(R.id.editTextNumberDecimal2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText1.getText().toString();
                String u = editText2.getText().toString();
                if(s.isEmpty() || u.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Enter Value in Blank Space!!", Toast.LENGTH_SHORT).show();
                    textView.setText("Enter Value in Blank Space!!");
                }
                else {
                    Toast.makeText(MainActivity2.this, "RESULT CALCULATED", Toast.LENGTH_SHORT).show();
                    double a = Double.parseDouble(s);
                    double b = Double.parseDouble(u);
                    double result;
                    result = a * (100 - b) / 100;

                    textView.setText("Rs " + result);

            }
        }});
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity2.this, "CLEARED", Toast.LENGTH_SHORT).show();
                    editText1.setText("");
                    editText2.setText("");
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