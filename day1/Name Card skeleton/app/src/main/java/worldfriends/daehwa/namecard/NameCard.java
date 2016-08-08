package worldfriends.daehwa.namecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.Button;

public class NameCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_name_card);

        Button fb = (Button) findViewById(R.id.facebook);
        Button gitHub = (Button) findViewById(R.id.github);

        fb.setMovementMethod(LinkMovementMethod.getInstance());
        gitHub.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
