package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean isNew = true;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editText);
    }


    public void Addnumber(View view) {

        String number = editText.getText().toString();
        if (isNew)
        {
            number = "";
            isNew = false;
        }
        if (view.getId() == R.id.Ninebutton) {
            number = number + "9";
        }
        else if (view.getId() == R.id.eightbutton) {
            number = number + "8";
        }
        else if (view.getId() == R.id.Sevenbutton) {
            number = number + "7";
        }
        else if (view.getId() == R.id.Sixbutton) {
            number = number + "6";
        }
        else if (view.getId() == R.id.Fivebutton) {
            number = number + "5";
        }
        else if (view.getId() == R.id.Fourbutton) {
            number = number + "4";
        }
        else if (view.getId() == R.id.Threebutton) {
            number = number + "3";
        }
        else if (view.getId() == R.id.Twobutton) {
            number = number + "2";
        }
        else if (view.getId() == R.id.Onebutton) {
            number = number + "1";
        }
        else if (view.getId() == R.id.Zerobutton) {
            number = number + "0";
        }
        else if (view.getId() == R.id.Ebutton) {
            number = number + "e";
        }

        /*
        switch (view.getId())
        {
            case (R.id.eightbutton):
                number = number + "8";
                break;

            case (R.id.Sevenbutton):
                number = number + "7";
                break;
        }

         */

        editText.setText(number);
    }

    public void Backspace(View view) {
        String number = editText.getText().toString();

        if (number != "") {
            number = number.substring(0, number.length() - 1);
            editText.setText(number);
        }


    }


    public void Divide(View view) {
        String number = editText.getText().toString();
        editText.setText(number + "/" + "\n");

    }

    public void Clear(View view) {
        editText.setText("0");
        isNew = true;
    }

    public void Reverse(View view) {
        String number = editText.getText().toString();
        String min = number.substring(0, 0);
        if (min == "-") {
            number = number.substring(0, number.length() - 1);
            editText.setText(number);
        }
        else
        {
            number = number.substring(0, number.length() - 1);
            editText.setText(number);
        }
    }
}