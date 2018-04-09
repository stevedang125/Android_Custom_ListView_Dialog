package com.steve.rumi_transactions;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 4/9/2018.
 */

// extrends the ArrayAdapter and pass in a Transaction Object
//          extends ArrayAdapter<Transaction>
// need a TAG and a Context (dont forget to import them)
//      import android.content.Context;
//      import android.widget.ArrayAdapter;
//
    // get a constructor ALT + INSERT:
    //      use the 5th one: ArrayAdapter(Context, Resource, Object List<T>)
    //      change the List<Tracsaction> to ArrayList<Transaction>
    //      dont forget to import ArrayList class
    // After that the error in MainA go away:
    //      take in the context, custom layout that made, arraylist(which is transactionList)
    //      TransactionListAdapter adapter = new TransactionListAdapter(this, R.layout.adapter_view_layout, transactionList);
    //      listViewItems.setAdapter(adapter);
    // Alt Insert/Override Methods/getView (delete super)
    //      This will get the view and attach it to the listview we have
    // Bring in names, items, prices string
    // Create a transaction object to hold these strings
    // Create LayoutInflater inflater = LayoutInflater.from(mContext);
    // Create a gobal mresource var to use it in a diff. method, dont forget to get it from
    //      TransactionListAdapter           mResource = resource;





public class TransactionListAdapter extends ArrayAdapter<Transaction> {

    private static final String TAG = "TransactionListAdapter";
    private Context mContext;
    int mResource;

    public TransactionListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Transaction> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    // Alt Insert/Override Methods/getView
    // This will get the view and attach it to the listview we have
    // Bring in names, items, prices string
    // Create a transaction object to hold these strings
    // LayoutInflater inflater = LayoutInflater.from(mContext);

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get transaction information
        final String item = getItem(position).getItem();
        final String names = getItem(position).getNames();
        final String price = getItem(position).getPrice();

        // Create a transaction object to hold these strings
        Transaction transaction = new Transaction(item, names, price);

        // Create layoutinflatter, take convertView from the getView
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        // Declare TextView objects:
        // In Main: don't need to call the View, but in here yes: convertView
        TextView tvItem = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvNames = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.textView3);



        Button dotsButton = (Button) convertView.findViewById(R.id.threeDotsButton);
        dotsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog(item, price);

            }
        });

        // Set the text for the TextView
        tvItem.setText(item);
        tvNames.setText(names);
        tvPrice.setText(price);

        return convertView;
    }



    public void openDialog(String item, String price){

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View dialogView = inflater.inflate(R.layout.edit_item_layout,null);

        builder.setView(dialogView);

        builder.setTitle("Edit Item");

        final EditText editText_item_name = (EditText) dialogView.findViewById(R.id.edit_item_name);
        final EditText editText_item_price = (EditText) dialogView.findViewById(R.id.edit_item_price);

        editText_item_name.setText(item);
        editText_item_price.setText(price);

        // Set the positive button
        builder.setPositiveButton("Save",null);

        // Set the negative button
        builder.setNegativeButton("Cancel", null);

        // Create the alert dialog
        AlertDialog dialog = builder.create();

        // Finally, display the alert dialog
        dialog.show();

        // Get the alert dialog buttons reference
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);


        // Change the alert dialog buttons text and background color
        positiveButton.setTextColor(Color.parseColor("#FF0B8B42"));
        positiveButton.setBackgroundColor(Color.parseColor("#FFE1FCEA"));

        negativeButton.setTextColor(Color.parseColor("#FFFF0400"));
        negativeButton.setBackgroundColor(Color.parseColor("#FFFCB9B7"));

    }
}



















