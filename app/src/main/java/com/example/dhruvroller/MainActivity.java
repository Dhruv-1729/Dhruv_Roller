package com.example.dhruvroller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button rollerbutton;
    private EditText sides;
    private Random random;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sides = findViewById(R.id.sides);
        rollerbutton = findViewById(R.id.rollerbutton);
        output = findViewById(R.id.numberoutput);
        random = new Random();
       // TextView tv = (TextView)findViewById(R.id.numberoutput);
        output.setVisibility(View.INVISIBLE);


        rollerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this, "Rolling...", Toast.LENGTH_SHORT).show();
                String sides_str = sides.getText().toString();
                if (sides_str.isEmpty() || !sides_str.matches("\\d+")) {
                    Toast.makeText(MainActivity.this, "Please input a valid number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int sideint = Integer.parseInt(sides_str);
                if (sideint > 0) {
                    int randomNumber = random.nextInt(sideint)+1;
                    output.setText(String.valueOf(randomNumber));
                    output.setVisibility(View.VISIBLE);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please input a valid number!", Toast.LENGTH_SHORT).show();
                }






            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}
