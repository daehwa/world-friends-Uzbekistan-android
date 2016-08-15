package worldfriends.daehwa.hanbok_dress_up;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DressUpActivity extends Activity {

    private ImageView []mImg=new ImageView[5];
    private static final String IMAGEVIEW_TAG = "드래그 이미지";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dress_up);
        mImg[0] = (ImageView) findViewById(R.id.jeogori);
        mImg[1] = (ImageView)findViewById(R.id.beoseon) ;
        mImg[2] = (ImageView)findViewById(R.id.crown);
        mImg[3] = (ImageView)findViewById(R.id.shoes);
        mImg[4] = (ImageView)findViewById(R.id.skirt);

        for (int i=0;i<5;i++){
            mImg[i].setTag(IMAGEVIEW_TAG);
            mImg[i].setId(i);
            mImg[i].setOnLongClickListener(DressUpLongClick);
        }

        findViewById(R.id.toplinear).setOnDragListener(
                new DragListener());
        findViewById(R.id.bottomlinear).setOnDragListener(
                new DragListener());

    }
    ImageView.OnLongClickListener DressUpLongClick = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData.Item item = new ClipData.Item(
                    (CharSequence) view.getTag());

            String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
            ClipData data = new ClipData(view.getTag().toString(),
                    mimeTypes, item);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                    view);

            view.startDrag(data, // data to be dragged
                    shadowBuilder, // drag shadow
                    view, // View which you want to drop
                    0 // useless flag
            );

            view.setVisibility(View.INVISIBLE);
            return true;
        }
    };

    class DragListener implements OnDragListener {

        public boolean onDrag(View v, DragEvent event) {

            //Start of Event
            switch (event.getAction()) {

                //When the image drag is started
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("DragClickListener", "ACTION_DRAG_STARTED");
                    break;

                // When image is in some area
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENTERED");
                    break;

                // When image is out of some area
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("DragClickListener", "ACTION_DRAG_EXITED");
                    break;

                // When you drop the image
                case DragEvent.ACTION_DROP:
                    Log.d("DragClickListener", "ACTION_DROP");

                    if (v == findViewById(R.id.bottomlinear)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view
                                .getParent();
                        viewgroup.removeView(view);
                        float x=0,y=0;
                        if(viewgroup==findViewById(R.id.toplinear)){
                            x=view.getX();
                            y=view.getY();
                        }
                        view.setX(event.getX()-view.getWidth()/2+x);
                        view.setY(event.getY()-view.getHeight()/2+y);

                        // change the text
                        TextView text = (TextView) v
                                .findViewById(R.id.text);
                        text.setText("Dressed up!");

                        FrameLayout containView = (FrameLayout) v;
                        containView.addView(view);

                        view.setVisibility(View.VISIBLE);

                    }
                    else if (v == findViewById(R.id.toplinear)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view
                                .getParent();
                        viewgroup.removeView(view);
                        if(viewgroup==findViewById(R.id.bottomlinear)) {
                            view.setX(0);
                            view.setY(0);
                        }
                        LinearLayout containView = (LinearLayout) v;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);

                    }else {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context,
                                "Cannot Dress up here!",
                                Toast.LENGTH_LONG).show();
                        break;
                    }
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENDED");
                    break;
                default:
                    break;
            }
            return true;
        }
    }
}
