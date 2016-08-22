package worldfriends.daehwa.facebook_newsfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by snote on 2016-08-07.
 */
public class PostedItemAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<PostedItemData> mItems = new ArrayList<PostedItemData>();

    public PostedItemAdapter(Context context){
        mContext =  context;
    }
    public void addItem(PostedItemData it){
        mItems.add(it);
    }
    public int getCount(){
        return mItems.size();
    }
    public Object getItem(int position){
        return mItems.get(position);
    }
    public long getItemId(int position){
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        PostedItemView itemView;
        if(convertView == null){
            itemView = new PostedItemView(mContext,mItems.get(position));
        }
        else{
            itemView = (PostedItemView)convertView;
            itemView.setIcon(mItems.get(position).getIcon());
            itemView.setText(mItems.get(position).getData());
        }
        return itemView;
    }
}
