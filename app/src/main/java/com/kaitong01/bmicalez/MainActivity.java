package com.kaitong01.bmicalez;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_cal = (Button)findViewById(R.id.button_cal);
        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calBMI();

            }
        });
    }
    private void calBMI(){
        EditText textw = (EditText)findViewById(R.id.editText_weight);
        EditText texth = (EditText)findViewById(R.id.editText2_high);

        double w = Double.parseDouble(textw.getText().toString());
        double h = Double.parseDouble(texth.getText().toString());

        h = h/100; // แปลง เซนติเมตร -> เมตร

        double bmi = w/(h*h);

        DecimalFormat decFormat = new DecimalFormat("##.##");
        String msg = "ค่า BMI คือ: " + decFormat.format(bmi) + "\n";
        msg += "ลักษณะ:รูปร่างคือ:";

        if(bmi >= 40) msg += "อ้วนแบบพี่บอลร่าง1";
        else if(bmi >= 35) msg += "อ้วนแบบพี่บอลร่าง2";
        else if(bmi >= 28.5) msg += "อ้วนแบบพี่บอลร่าง1";
        else if(bmi >= 23.5) msg += "อ้วนแบบพี่บอลร่าง2";
        else if(bmi >= 18.5) msg += "อ้วนแบบพี่เบ้น";
        else msg += "ผอมแบบพี่นิ่ม";

        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();;



    }
}
