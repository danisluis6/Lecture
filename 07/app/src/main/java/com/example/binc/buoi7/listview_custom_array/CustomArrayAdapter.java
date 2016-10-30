package com.example.binc.buoi7.listview_custom_array;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.binc.buoi7.R;
import com.example.binc.buoi7.User;

import java.util.List;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by Binc on 03/04/2016.
 */
public class CustomArrayAdapter extends ArrayAdapter<User> {
    private List<User> mUsers;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public CustomArrayAdapter(Context context, List<User> users) {
        super(context, 0, users);
        mContext = context;
        mUsers = users;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        if (mUsers.isEmpty()) {
            return 0;
        }
        return mUsers.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final User user = mUsers.get(position);
        ViewHolder viewHolder;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_listview_user, null, false);
            // Lookup view for data population
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tVContent = (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(user.getTitle());
        viewHolder.tVContent.setText(user.getContent());
        // Return the completed view to render on screen
        return convertView;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView tvTitle;
        TextView tVContent;
    }

}
