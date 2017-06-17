package com.example.dil.sendmail;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String email,sub,body,username,password;
    EditText ed,ed2,ed3,uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            ed = (EditText)findViewById(R.id.editText);
            ed2 = (EditText)findViewById(R.id.editText4);
            ed3 = (EditText)findViewById(R.id.editText5);
            uname = (EditText)findViewById(R.id.editText2);
            pass = (EditText)findViewById(R.id.editText3);

        }

        public void login(View v)
        {
            username = uname.getText().toString();
            password = pass.getText().toString();
            Toast.makeText(this,"logged in success",Toast.LENGTH_LONG).show();
        }

    public void send(View v)
    {
        email = ed.getText().toString();
        sub = ed2.getText().toString();
        body = ed3.getText().toString();
        new Thread(new Runnable() {
            public void run() {
                try {

                    GMailSender sender = new GMailSender(username,password);

          //          sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                    sender.sendMail(sub,body, username, email);

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }

            }

        }).start();


    }

}

