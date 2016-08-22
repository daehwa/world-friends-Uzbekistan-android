package worldfriends.daehwa.facebook_newsfeed;

import android.graphics.drawable.Drawable;

/**
 * Created by snote on 2016-08-07.
 */
public class PostedItemData {
    private Drawable mIcon;
    private String mData;

    public PostedItemData(Drawable icon,String obj){
        mIcon = icon;
        mData = obj;
    }
    public String getData(){
        return mData;
    }
    public Drawable getIcon(){
        return mIcon;
    }
}
