package worldfriends.daehwa.gesture_password;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordInput extends Activity {

    Context mContext;
    private static final int SWIPE_MIN_DISTANCE = 200;
    private static final int SWIPE_THRESHOLD_VELOCITY = 300;
    private GestureDetector gestureScanner;
    String []password={"right","longTab","up","tab","down"};
    int key=password.length,here=0;
    TextView step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_input);
        step=(TextView) findViewById(R.id.step);
        mContext = this;
        gestureScanner = new GestureDetector(this, mGestureListener );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureScanner.onTouchEvent(event);	// event 전달
    }

    OnGestureListener mGestureListener = new OnGestureListener() {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if(password[here].equals("tab")) key--;
            //Toast.makeText(mContext, "onSingleTapUp", Toast.LENGTH_SHORT).show();
            determineKey();
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            // TODO Auto-generated method stub
            if(password[here].equals("longTab")) key--;
            //Toast.makeText(mContext, "onLongPress", Toast.LENGTH_SHORT).show();
            determineKey();
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            /*if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;*/
            // right to left swipe
            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                if(password[here].equals("left")) key--;
                //Toast.makeText(mContext, "Left Swipe", Toast.LENGTH_SHORT).show();
                determineKey();
            }
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                if(password[here].equals("right")) key--;
                //Toast.makeText(mContext, "Right Swipe", Toast.LENGTH_SHORT).show();
                determineKey();
            }
            else if(e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY){
                if(password[here].equals("down")) key--;
                //Toast.makeText(mContext, "Down Swipe", Toast.LENGTH_SHORT).show();
                determineKey();
            }
            else if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY){
                if(password[here].equals("up")) key--;
                //Toast.makeText(mContext, "Up Swipe", Toast.LENGTH_SHORT).show();
                determineKey();
            }
            return false;
        }
        public void determineKey(){
            System.out.println(key);
            step.setText(Integer.toString(5-(++here)));
            if(key!=0&&here==5){
                Toast.makeText(mContext, "Wrong password", Toast.LENGTH_SHORT).show();
                here=0;
                key=5;
                step.setText("5");
            }
            else if(key==0){
                Toast.makeText(mContext, "unlocked!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(mContext,Unlocked.class);
                startActivity(intent);
                finish();
            }
        }
        @Override
        public boolean onDown(MotionEvent e) {
            // TODO Auto-generated method stub
            return false;
        }
    };

}
