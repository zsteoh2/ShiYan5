package cn.edu.hqu.cst.shiyan5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.appsearch.GetSchemaResponse;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);



        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        CheckBox RememberMe = (CheckBox) findViewById(R.id.RememberMeCheckBox);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etName.getText().toString();
                String password = etPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);

                String userDetails = preferences.getString(user + password + "data","Username or Password is Incorrect. "); // left side data , right side is the print show text
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userDetails); //store the thing on display n show up on display screen text view
                editor.commit();

                Intent displayScreen = new Intent(MainActivity.this,DisplayScreen.class);
                startActivity(displayScreen);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerScreen = new Intent(MainActivity.this,Register.class);
                startActivity((registerScreen ));
            }
        });

        if(RememberMe.isChecked())
        {
            etName.setText(preferences.getString("data",""));
            etPassword.setText(preferences.getString("data",""));
        }

    }
}