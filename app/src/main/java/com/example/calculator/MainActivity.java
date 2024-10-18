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

    String OldNumber;
    String operator;
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
            OldNumber = number;
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
       /* else if (view.getId() == R.id.Ebutton) {
            number = number + "2,71828183";
        }


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




    public void Operation(View view) {
        String number = editText.getText().toString();
        isNew = true;

        if (view.getId() == R.id.Minusbutton) {
            operator = "-";
        }
        if (view.getId() == R.id.Plusbutton) {
            operator = "+";
        }
        if (view.getId() == R.id.Multiplybutton) {
            operator = "*";
        }
        if (view.getId() == R.id.Dividebutton) {
            operator = "/";
        }
        if (view.getId() == R.id.Resultbutton) {
            double oldNumberDouble = Double.parseDouble(OldNumber);
            double numberDouble = Double.parseDouble(number);
            switch (operator)
            {
                case "-":
                    number = String.valueOf(oldNumberDouble - numberDouble);
                    break;
                case "+":
                    number = String.valueOf(oldNumberDouble + numberDouble);
                    break;
                case "*":
                    number = String.valueOf(oldNumberDouble * numberDouble);
                    break;
                case "/":
                    number = String.valueOf(oldNumberDouble / numberDouble);
                    break;
            }

            editText.setText(number);
        }

    }

    public void Backspace(View view) {
        String number = editText.getText().toString();

        if (number != "") {
            number = number.substring(0, number.length() - 1);
            editText.setText(number);
        }


    }
    public void Clear(View view) {
        editText.setText("0");
        isNew = true;
    }

    public void Reverse(View view) {
        String number = editText.getText().toString();
        String min = number.substring(0, 0);
        if (min == "-") {
            number = number.substring(1, number.length());
            editText.setText(number);
        }
        else
        {
            number = "-" + number;
            editText.setText(number);
        }
    }
}