package worldfriends.daehwa.facebook_newsfeed_tab_easy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

public class TabActivity extends AppCompatActivity {
    TabHost host;
    int here=0;
    int [] imageList={R.drawable.newsfeed,R.drawable.friend,R.drawable.new_event,R.drawable.others};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_tab);

        host = (TabHost)findViewById(R.id.tabHost);
        host.setOnTabChangedListener(TabChangeLs);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("NewsFeed");
        spec.setContent(R.id.newsfeed);
        spec.setIndicator("");
        host.addTab(spec);

        spec = host.newTabSpec("Friend");
        spec.setContent(R.id.friend);
        spec.setIndicator("");
        host.addTab(spec);

        spec = host.newTabSpec("NewEvent");
        spec.setContent(R.id.newevent);
        spec.setIndicator("");
        host.addTab(spec);

        spec = host.newTabSpec("Others");
        spec.setContent(R.id.others);
        spec.setIndicator("");
        host.addTab(spec);
        for (int i=1;i<4;i++)
            host.getTabWidget().getChildAt(i).setBackgroundResource(imageList[i]);

    }
    TabHost.OnTabChangeListener TabChangeLs = new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String tabId) {
            String [] tabList={"NewsFeed","Friend","NewEvent","Others"};
            host.getTabWidget().getChildAt(here).setBackgroundResource(imageList[here]);
            here=host.getCurrentTab();
            switch (tabId){
                case "NewsFeed":
                    host.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.newsfeed_actived);
                    break;
                case "Friend":
                    host.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.friend_actived);
                    break;
                case "NewEvent":
                    host.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.new_event_actived);
                    break;
                case "Others":
                    host.getTabWidget().getChildAt(3).setBackgroundResource(R.drawable.others_actived);
                    break;
            }
        }
    };

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            Toast.makeText(this, "searching", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == android.R.id.home){
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
