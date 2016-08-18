package worldfriends.daehwa.facebook_splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class IdentiActivity extends AppCompatActivity{
    String IDStr;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);
        TextView id=(TextView)findViewById(R.id.fb_id);
        TextView password=(TextView)findViewById(R.id.fb_password);

        Intent intent = getIntent();

        IDStr=intent.getExtras().getString("intentID");
        id.setText("ID: "+IDStr);
        password.setText("PASSWORD: "+intent.getExtras().getString("intentPASSWORD"));


    }
    public void sendID(View view){
        Intent intentSend=new Intent(android.content.Intent.ACTION_SEND);
        intentSend.setPackage(Intent.ACTION_SEND);
        //intentSend.setPackage("com.kakao.talk");
        intentSend.setType("text/plain");
        intentSend.putExtra(Intent.EXTRA_TEXT, IDStr);
        startActivity(Intent.createChooser(intentSend,"My ID"));
    }
}
