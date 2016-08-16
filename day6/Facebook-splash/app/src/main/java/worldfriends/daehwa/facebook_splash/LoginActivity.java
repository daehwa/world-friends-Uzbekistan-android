package worldfriends.daehwa.facebook_splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by snote on 2016-07-22.
 */
public class LoginActivity extends Activity{
    EditText ID,PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
        else {
            Toast.makeText(this, "Login..", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,IdentiActivity.class);
            intent.putExtra("intentID",ID.getText().toString());
            intent.putExtra("intentPASSWORD",PW.getText().toString());
            startActivity(intent);
        }
    }


}
