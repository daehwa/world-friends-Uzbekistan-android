package worldfriends.daehwa.facebook_login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText ID,PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        android.support.v7.app.ActionBar actionbar;
        actionbar=getSupportActionBar();
        actionbar.hide();

        TextView forgotAccount = (TextView) findViewById(R.id.find_account);
        forgotAccount.setMovementMethod(LinkMovementMethod.getInstance());

        ID=(EditText)findViewById(R.id.IDEditText);
        PW=(EditText)findViewById(R.id.PasswordEditText);
    }
    public void loginBtn(View v){
        if(ID.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please put ID",Toast.LENGTH_SHORT).show();
        else if (PW.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please put password",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Login..",Toast.LENGTH_SHORT).show();
    }
}
