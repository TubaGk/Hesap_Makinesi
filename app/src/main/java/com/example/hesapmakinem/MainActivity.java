package com.example.hesapmakinem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected TextView yaz,sonuc;
    protected Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    protected Button sil,btnbol,btncarp,btncik,btnnok,btnes,btntop,btnyz,btnAc;

    protected String sayi="",sayi1="",sayi2="";
    protected  String islem = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yaz=findViewById(R.id.yaz);
        sonuc=findViewById(R.id.sonuc);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn0=findViewById(R.id.btn0);
        btnbol=findViewById(R.id.btnbol);
        btncarp=findViewById(R.id.btncarp);
        btncik=findViewById(R.id.btncik);
        btntop=findViewById(R.id.btntop);
        btnes=findViewById(R.id.btnes);
        btnnok=findViewById(R.id.btnnok);
        sil=findViewById(R.id.sil);
        btnyz=findViewById(R.id.btnyz);
        btnAc=findViewById(R.id.btnAc);
    }

    @SuppressLint("SetTextI18n")
    public void click(View view) {
        int id = view.getId();
        if (id == R.id.btn0 || id == R.id.btn1 || id == R.id.btn2 || id == R.id.btn3 || id == R.id.btn4 ||
                id == R.id.btn5 || id == R.id.btn6 || id == R.id.btn7 || id == R.id.btn8 || id == R.id.btn9) {
            String ekran = yaz.getText().toString();
            if (ekran.equals("0")) {
                yaz.setText(((Button) view).getText());
            } else {
                yaz.setText(ekran + ((Button) view).getText());
            }
        }else if (id == R.id.btnnok) {
            String ekran = yaz.getText().toString();
            if (!ekran.contains(".")) {
                yaz.setText(ekran + ".");
            }
        } else if (id == R.id.btntop || id == R.id.btncik || id == R.id.btncarp || id == R.id.btnbol) {
            if (!sayi1.equals("")) {
                sayi2 = yaz.getText().toString();
                double sonucc = 0;
                switch (islem) {
                    case "+":
                        sonucc = Double.parseDouble(sayi1) + Double.parseDouble(sayi2);
                        break;
                    case "-":
                        sonucc = Double.parseDouble(sayi1) - Double.parseDouble(sayi2);
                        break;
                    case "x":
                        sonucc = Double.parseDouble(sayi1) * Double.parseDouble(sayi2);
                        break;
                    case "÷":
                        if (!sayi2.equals("0")) {
                            sonucc =  Double.parseDouble(sayi1) / Double.parseDouble(sayi2);
                        } else {
                            sonuc.setText("Hata");
                            return;
                        }
                        break;
                }
                sayi1 = String.valueOf(sonucc);
                yaz.setText(sayi1);
                sonuc.setText(yaz.getText());
            }
            sayi1 = yaz.getText().toString();
            islem = ((Button) view).getText().toString();
            yaz.setText("0");
        } else if (id == R.id.sil) {
            String silinen = yaz.getText().toString();
            silinen = silinen.substring(0,silinen.length()-1);
            yaz.setText(silinen);
        } else if (id == R.id.btnAc) {
            yaz.setText(" ");
            sonuc.setText(" ");
            sayi1 = "";
            sayi2 = "";
            islem = "";


        }else if (id == R.id.btnyz) {
            sayi1 = yaz.getText().toString();
            double sonucc = Double.parseDouble(sayi1) / 100;
            sonuc.setText(String.valueOf(sonucc));


        } else if (id == R.id.btnes || id == R.id.btnyz) {
            if (!sayi1.equals("")) {
                sayi2 = yaz.getText().toString();
                double sonucc = 0;
                switch (islem) {
                    case "+":
                        sonucc =Double.parseDouble(sayi1) + Double.parseDouble(sayi2);
                        break;
                    case "-":
                        sonucc = Double.parseDouble(sayi1) - Double.parseDouble(sayi2);
                        break;
                    case "x":
                        sonucc =Double.parseDouble(sayi1) * Double.parseDouble(sayi2);
                        break;
                    case "÷":
                        if (!sayi2.equals("0")) {
                            sonucc =Double.parseDouble(sayi1) / Double.parseDouble(sayi2);
                        } else {
                            sonuc.setText("Hata");
                            return;
                        }
                        break;

                }
                sonuc.setText(String.valueOf(sonucc));
            }
            sayi1 = "";
            sayi2 = "";
            islem = "";
            yaz.setText("0");

        }
    }
}