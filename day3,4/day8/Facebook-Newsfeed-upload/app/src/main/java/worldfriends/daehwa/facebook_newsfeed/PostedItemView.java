package worldfriends.daehwa.facebook_newsfeed;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by snote on 2016-08-07.
 */
public class PostedItemView extends LinearLayout{
    private ImageView ProfPic;
    private TextView content;

    public PostedItemView(Context context, PostedItemData mItem){
        super(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_post,this,true);

        ProfPic = (ImageView)findViewById(R.id.profile_image);
        ProfPic.setImageDrawable(mItem.getIcon());

        content = (TextView)findViewById(R.id.my_post);
        content.setText(mItem.getData());
    }
    public void setText(String data){
        content.setText(data);
    }

    public void setIcon(Drawable icon){
        ProfPic.setImageDrawable(icon);
    }
}
