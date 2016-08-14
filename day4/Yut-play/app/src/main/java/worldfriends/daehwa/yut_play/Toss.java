package worldfriends.daehwa.yut_play;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Toss extends Activity implements SensorEventListener {

    ImageView [] yut=new ImageView[4];
    TextView result,acc;
    Button tossBtn;
    SensorManager sm;
    Sensor accSensor;
    float x,y,z;
    SoundPool sound_pool;
    int sound_yut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);

        yut[0]=(ImageView)findViewById(R.id.yut1);
        yut[1]=(ImageView)findViewById(R.id.yut2);
        yut[2]=(ImageView)findViewById(R.id.yut3);
        yut[3]=(ImageView)findViewById(R.id.yut4);

        result=(TextView)findViewById(R.id.result);
        acc=(TextView)findViewById(R.id.acc);

        tossBtn=(Button)findViewById(R.id.toss_btn);
        tossBtn.setOnClickListener(tossClickListener);
        tossBtn.getBackground().setColorFilter(0xAB0000ff, PorterDuff.Mode.MULTIPLY);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        accSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sound_pool=new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        sound_yut=sound_pool.load(getBaseContext(),R.raw.yut_sound,1);
    }

    Button.OnClickListener tossClickListener = new View.OnClickListener(){
        public void onClick(View v){
            TossingYut();
        }
    };

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        x=event.values[0];
        y=event.values[1];
        z=event.values[2];
        if(x>19||y>15||z>20) {
            acc.setText("x: "+x+"  y: "+y+"  z: "+z);
            TossingYut();
        }
    }

    public void onResume(){
        super.onResume();
        sm.registerListener(this,accSensor,SensorManager.SENSOR_DELAY_NORMAL);
        sound_pool.resume(sound_yut);
    }
    public void onPause(){
        super.onPause();
        sm.unregisterListener(this);
        sound_pool.pause(sound_yut);
    }
    public void TossingYut()
    {
        playSound();
        int [] yutState=new int [4];//0:front,1:back
        Random random=new Random();
        for(int i=0;i<4;i++) {
            yutState[i] = random.nextInt(2);
            if(yutState[i]==0) yut[i].setImageResource(R.drawable.front);
            else if(i!=3) yut[i].setImageResource(R.drawable.back);
            else yut[i].setImageResource(R.drawable.back_do);
        }
        int sum=yutState[0]+yutState[1]+yutState[2]+yutState[3];
        if(sum==1&&yutState[3]==0) result.setText("Do");
        else if(sum==2) result.setText("Ge");
        else if(sum==3) result.setText("Geol");
        else if(sum==4) result.setText("Yut");
        else if(sum==0) result.setText("Mo");
        else result.setText("Back-Do");
    }
    public void playSound()
    {
        sound_pool.play(sound_yut,10,10,1,0,1);
        // ** parameters **
        // 1: select resource
        // 2-3: magnitude of sound
        // 4: priority
        // 5: repeat(0==no repeat,
        //          1==repeat once(total twice),
        //          -1==repeat infinitely)
        // 6: speed(1==1x, 2==2x)
    }
}
