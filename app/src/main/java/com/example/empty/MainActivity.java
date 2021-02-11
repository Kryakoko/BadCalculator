package com.example.empty;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(v -> {
            if (getString(R.string.display).equals(display.getText().toString())){
                display.setText("0");
            }
        });

    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        String leftStr = oldStr.substring(0, oldStr.length() - 1);
        String lastChar = oldStr.substring(oldStr.length() - 1);

        boolean isPreLastNum = true, isLastNum, isAddNum;
        String charBfrLast;

        isLastNum = isNum(lastChar);
        isAddNum = isNum(strToAdd);

        if (lastChar.equals("0")) {
            if (oldStr.length() > 1) {
                charBfrLast = oldStr.substring(oldStr.length() - 2, oldStr.length() - 1);
                isPreLastNum = isNum(charBfrLast);
            }
        }

        if (display.length() < 14) {
            if (oldStr.equals("0") || oldStr.equals("NaN") || oldStr.equals("Infinity")) {
                if (isAddNum)
                    display.setText(strToAdd);
                else if (strToAdd.equals("-"))
                    display.setText(strToAdd);
            } else if (oldStr.equals("-") && isAddNum) {
                display.setText(String.format("%s%s", oldStr, strToAdd));
            } else if (lastChar.equals("0") && !isPreLastNum && isAddNum) {
                display.setText(String.format("%s%s", leftStr, strToAdd));
            } else if (isAddNum) {
                display.setText(String.format("%s%s", oldStr, strToAdd));
            } else if (isLastNum) {
                display.setText(String.format("%s%s", oldStr, strToAdd));
            }
            display.setSelection(display.length());
        }
    }

    private boolean isNum(String charToCheck) {
        boolean isNum = true;
        switch (charToCheck) {
            case "+":
            case "-":
            case "x":
            case "÷":
                isNum = false;
                break;
        }
        return isNum;
    }

    public void zeroBTN(View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");
    }

    public void twoBTN(View view){
        updateText("2");
    }

    public void threeBTN(View view){
        updateText("3");
    }

    public void fourBTN(View view){
        updateText("4");
    }

    public void fiveBTN(View view){
        updateText("5");
    }

    public void sixBTN(View view){
        updateText("6");
    }

    public void sevenBTN(View view){
        updateText("7");
    }

    public void eightBTN(View view){
        updateText("8");
    }

    public void nineBTN(View view){
        updateText("9");
    }


    public void addBTN(View view){
        updateText("+");
    }

    public void subtractBTN(View view){
        updateText("-");
    }

    public void multiplyBTN(View view){
        updateText("x");
    }

    public void divideBTN(View view){
        updateText("÷");
    }

    public void equalBTN(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("x", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void clearBTN(View view){
        display.setText("0");
    }

}