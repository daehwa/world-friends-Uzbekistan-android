package worldfriends.daehwa.facebook_newsfeed;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class NewsfeedActivity extends AppCompatActivity {
    ListView listview;
    PostedItemAdapter adapter;
    String str="";
    Button StateBtn;
    EditText content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_newsfeed);

        StateBtn = (Button)findViewById(R.id.state_btn);
        StateBtn.setOnClickListener(Upload);

        content=(EditText)findViewById(R.id.post_content);

        listview=(ListView)findViewById(R.id.list);

        adapter = new PostedItemAdapter(getApplicationContext());
        listview.setAdapter(adapter);

    }
    Button.OnClickListener Upload= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Resources res = getResources();
            str=content.getText().toString();
            if(str.equals(""))
                Toast.makeText(NewsfeedActivity.this, "Please put content", Toast.LENGTH_SHORT).show();
            else{
                adapter.addItem(new PostedItemData(res.getDrawable(R.drawable.profile_image), str));
                listview.setAdapter(adapter);
                content.setText("");
                Toast.makeText(NewsfeedActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.chatting) {
            Toast.makeText(this, "searching", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.messenger){
            Toast.makeText(this, "messenger", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
