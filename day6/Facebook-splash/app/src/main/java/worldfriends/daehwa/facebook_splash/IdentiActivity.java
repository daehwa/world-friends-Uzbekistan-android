package worldfriends.daehwa.facebook_splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by snote on 2016-08-16.
 */
public class IdentiActivity extends AppCompatActivity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);
        TextView id=(TextView)findViewById(R.id.fb_id);
        TextView password=(TextView)findViewById(R.id.fb_password);
        Intent intent = getIntent();
        id.setText("ID: "+intent.getExtras().getString("intentID"));
        password.setText("PASSWORD: "+intent.getExtras().getString("intentPASSWORD"));

    }
}
