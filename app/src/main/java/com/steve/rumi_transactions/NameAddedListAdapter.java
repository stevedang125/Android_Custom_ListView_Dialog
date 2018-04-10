package com.steve.rumi_transactions;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 4/9/2018.
 */

public class NameAddedListAdapter extends ArrayAdapter<NamesAdded> {

    private static final String TAG = "NameAddedListAdapter";
    private Context mContext;
    int mResource;
    ArrayList<NamesAdded> arrayList;

//    // This is for the add button
//    EditText editText_names;

    public NameAddedListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NamesAdded> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        arrayList =  objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final String name = getItem(position).getName();

        // Create a transaction object to hold these strings
        NamesAdded namesAdded = new NamesAdded(name);

        // Create layoutinflatter, take convertView from the getView
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        // Declare TextView objects:
        // In Main: don't need to call the View, but in here yes: convertView
        TextView tvName = (TextView) convertView.findViewById(R.id.textViewNames);

        tvName.setText(name);

        return convertView;
    }
}
