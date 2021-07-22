package com.example.proect;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private ImageView rul;
    private Random random;
    private int old_deegre = 0;
    private int deegre = 0;
    int money = 1000;
    Button button;
    Button button2;
    TextView moneytv;
    EditText rate;

    private static final float FACTOR = 4.86f;
        private String[] numbers = {"32 RED", "15 BLACK", "19 RED", "4 BLACK", "21 RED",
        "2 BLACK", "25 RED", "17 BLACK","34 RED", "6 BLACK", "27 RED", "13 BLACK", "36 RED",
        "11 BLACK", "30 RED", "8 BLACK", "23 RED", "10 BLACK", "5 RED", "24 BLACK", "16 RED",
        "33 BLACK", "1 RED", "20 BLACK", "14 RED", "31 BLACK", "9 RED", "22 BLACK", "18 RED",
        "29 BLACK", "7 RED", "28 BLACK", "12 RED", "35 BLACK", "3 RED", "26 BLACK", "0"};
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rate = findViewById(R.id.rate);
        moneytv = findViewById(R.id.money);
        moneytv.setText(String.valueOf(money));  //инициализируются кнопки
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    //обрабатывается чт опроисходит при гажатии на кнопку ЧЁРНЫЙ и КРАСНЫЙ
                String Daya = rate.getText().toString();      //переводится в строку значение из ЭдитТЕкста //перевод в инт ставку
                if (rate.getText().toString().trim().length()!=0) {
                    int dengi = Integer.parseInt(rate.getText().toString());
                    if (Daya.trim().length() != 0 && dengi < money) {          //условия для ставки
                        old_deegre = deegre % 360;
                        deegre = random.nextInt(3600) + 720;
                        RotateAnimation rotate = new RotateAnimation(old_deegre, deegre, RotateAnimation.RELATIVE_TO_SELF,
                                0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                        rotate.setDuration(3600);
                        rotate.setFillAfter(true);
                        rotate.setInterpolator(new DecelerateInterpolator());
                        rotate.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {

                                tvResult.setText(getResult(360 - (deegre % 360)));
                                String a = tvResult.getText().toString();

                                if (a == "15 BLACK" || a == "4 BLACK" || a == "2 BLACK" || a == "17 BLACK" || a == "6 BLACK" || a == "13 BLACK" || a == "11 BLACK" || a == "8 BLACK" || a == "10 BLACK" || a == "24 BLACK" || a == "33 BLACK" || a == "20 BLACK" || a == "31 BLACK" || a == "22 BLACK" || a == "29 BLACK" || a == "28 BLACK" || a == "35 BLACK" || a == "26 BLACK") {
                                    money = money + dengi;
                                    moneytv.setText(String.valueOf(money));
                                } else {
                                    money = money - dengi;
                                    moneytv.setText(String.valueOf(money));
                                }
                            }


                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        rul.startAnimation(rotate);
                    } else if (Daya.trim().length() != 0 && dengi > money) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Недостаточно средств!", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Не сделана ставка!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Не сделана ставка!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Daya = rate.getText().toString();
                if (rate.getText().toString().trim().length() != 0) {
                    int dengi = Integer.parseInt(rate.getText().toString());
                    if (Daya.trim().length() != 0 && dengi < money) {
                        old_deegre = deegre % 360;
                        deegre = random.nextInt(3600) + 720;
                        RotateAnimation rotate = new RotateAnimation(old_deegre, deegre, RotateAnimation.RELATIVE_TO_SELF,
                                0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                        rotate.setDuration(3600);
                        rotate.setFillAfter(true);
                        rotate.setInterpolator(new DecelerateInterpolator());
                        rotate.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {

                                tvResult.setText(getResult(360 - (deegre % 360)));
                                String a = tvResult.getText().toString();


                                if (a == "15 BLACK" || a == "4 BLACK" || a == "2 BLACK" || a == "17 BLACK" || a == "6 BLACK" || a == "13 BLACK" || a == "11 BLACK" || a == "8 BLACK" || a == "10 BLACK" || a == "24 BLACK" || a == "33 BLACK" || a == "20 BLACK" || a == "31 BLACK" || a == "22 BLACK" || a == "29 BLACK" || a == "28 BLACK" || a == "35 BLACK" || a == "26 BLACK" || a == "0") {
                                    money = money - dengi;
                                    moneytv.setText(String.valueOf(money));
                                } else {
                                    money = money + dengi;
                                    moneytv.setText(String.valueOf(money));
                                }
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });

                        rul.startAnimation(rotate);

                    } else if (Daya.trim().length() != 0 && dengi > money) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Недостаточно средств!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Не сделана ставка!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }


    private void init()
    {
        tvResult = findViewById(R.id.tvResult);
        rul = findViewById(R.id.rul);
        random = new Random();
    }
    private String getResult(int deegre)
    {
        String text = "";

        int factor_x = 1;
        int factor_y = 3;
        for(int i = 0; i < 37; i++) {
        if(deegre >= (FACTOR * factor_x) && deegre < (FACTOR * factor_y))   //инит рандомит, а это определяет что выпадет
        {
            text = numbers[i];
        }
        factor_x += 2;
        factor_y += 2;
        }
        if(deegre >= (FACTOR * 73) && deegre < 360 || deegre >= 0 && deegre < (FACTOR * 1)) text = numbers[numbers.length - 1];

        return text;
    }
}