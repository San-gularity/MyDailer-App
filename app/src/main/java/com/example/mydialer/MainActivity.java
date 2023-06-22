package com.example.mydialer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build; import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget. EditText;

public class MainActivity extends AppCompatActivity {

    Button one, two, three, four, five, six, seven, eight, nine, zero, del, hash, star, save, call;
    EditText inputNum;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.butt1); //Finds
        two = findViewById(R.id.butt2);
        three = findViewById(R.id.butt3);
        four  = findViewById(R.id.butt4);
        five = findViewById(R.id.butt5);
        six = findViewById(R.id.butt6);
        seven  = findViewById(R.id.butt7);
        eight = findViewById(R.id.butt8);
        nine = findViewById(R.id.butt9);
        zero = findViewById(R.id.butt0);
        del = findViewById(R.id.buttdel);
        save = findViewById(R.id.buttsave);
        call = findViewById(R.id.buttcall);

        inputNum = findViewById(R.id.inputnum);
        star= findViewById(R.id.buttstar);
        hash = findViewById(R.id.butthash);
        one.setOnClickListener(this::onClick); //When this button is clicked then call the use
        two.setOnClickListener(this::onClick);
        three.setOnClickListener(this::onClick);
        four.setOnClickListener(this::onClick);
        five.setOnClickListener(this::onClick);
        six.setOnClickListener(this::onClick);
        seven.setOnClickListener(this::onClick);
        eight.setOnClickListener(this::onClick);
        nine.setOnClickListener(this::onClick);
        zero.setOnClickListener(this::onClick);
        del.setOnClickListener(this::onClick);
        save.setOnClickListener(this::onClick);
        call.setOnClickListener(this::onClick);
        star.setOnClickListener(this::onClick);
        hash.setOnClickListener(this::onClick);
    }

    private void onClick(View v) {

        Editable str;

        str = inputNum.getText();
        switch(v.getId())
        {
            case R.id.butt0:
                str = str.append(zero.getText());
                inputNum.setText(str);
                break;
            case R.id.butt1:
                str = str.append(one.getText());
                inputNum.setText(str);
                break;
            case R.id.butt2:
                str = str.append(two.getText());
                inputNum.setText(str);
                break;
            case R.id.butt3:
                str = str.append(three.getText());
                inputNum.setText(str);
                break;
            case R.id.butt4:
                str = str.append(four.getText());
                inputNum.setText(str);
                break;
            case R.id.butt5:
                str = str.append(five.getText());
                inputNum.setText(str);
                break;
            case R.id.butt6:
                str = str.append(six.getText());
                inputNum.setText(str);
                break;
            case R.id.butt7:
                str = str.append(seven.getText());
                inputNum.setText(str);
                break;
            case R.id.butt8:
                str = str.append(eight.getText());
                inputNum.setText(str);
                break;
            case R.id.butt9:
                str = str.append(nine.getText());
                inputNum.setText(str);
                break;
            case R.id.butthash:
                str = str.append(hash.getText());
                inputNum.setText(str);
                break;
            case R.id.buttstar:
                str = str.append(star.getText());
                inputNum.setText(str);
                break;
            case R.id.buttdel:
                if(str.length()> 0)
                {
                    str = (Editable)str.subSequence(0, str.length()-1);
                }
                inputNum.setText(str);
                break;
            case R.id.buttsave:
                String contact= inputNum.getText().toString();
                Intent intentsave = new Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+contact));
                startActivity (intentsave);
                break;

            case R.id.buttcall:
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M &&
                    checkSelfPermission (Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, 1);
                }
                else
                {
                    String phonenum = inputNum.getText().toString();
                    Intent intentcall = new Intent(Intent.ACTION_CALL);
                    intentcall.setData(Uri.parse("tel: " + phonenum));
                    startActivity(intentcall);
                    break;
                }
        }
    }
}
