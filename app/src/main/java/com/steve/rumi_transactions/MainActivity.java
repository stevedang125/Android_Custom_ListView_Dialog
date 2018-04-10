package com.steve.rumi_transactions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // type: log Enter
    private static final String TAG = "MainActivity";


    // Based on this video to design a different listview:
    // https://www.youtube.com/watch?v=E6vE8fqQPTE
    // https://github.com/mitchtabian/ListViews

    // create:
    // a log started
    // create the listViewItems and listViewNames and get their ids
    // Create transaction objects:
    //         Transaction john = new Transaction("banana", "", "34.9");
    // Create an array list to hold the transaction objects.
    // Add transaction objects to the arraylist
    // Create transaction adapter:
    //              take in the context, custom layout that made, arraylist(which is transactionList)
    // Take the list view items and set the adapter.
    // Create TransactionListAdapter java class

    EditText addThisName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate: Started.");
        ListView listViewItems = (ListView) findViewById(R.id.listView_items);
        ListView listViewNames = (ListView) findViewById(R.id.listView_names);
        LinearLayout linearLayoutNames = (LinearLayout) findViewById(R.id.names_layout);

        Transaction step_fart_nee = new Transaction("banana", "step_fart_nee", "$34.9");
        Transaction john = new Transaction("egg", "john", "$3.9");
        Transaction steve = new Transaction("beer", "steve", "$4.89");
        Transaction abe = new Transaction("steak", "abe", "$5.93");
        Transaction dita = new Transaction("banana", "dita", "$6.88");
        Transaction jordan = new Transaction("banana", "jordan", "$23.4");
        Transaction joshua = new Transaction("steak", "joshua", "$12.3");
        Transaction subhash = new Transaction("egg", "subhash", "$6.7");
        Transaction steven = new Transaction("beer", "steven", "$21.3");
        Transaction biem = new Transaction("banana", "biem", "$43.2");
        Transaction no_name = new Transaction("steak", "no_name", "$89.2");

// //     Objects with empty names:
//        Transaction step_fart_nee = new Transaction("banana", "", "34.9");
//        Transaction john = new Transaction("egg", "", "3.9");
//        Transaction steve = new Transaction("beer", "", "4.89");
//        Transaction abe = new Transaction("steak", "", "5.93");
//        Transaction dita = new Transaction("banana", "", "6.88");
//        Transaction jordan = new Transaction("banana", "", "23.4");
//        Transaction joshua = new Transaction("steak", "", "12.3");
//        Transaction subhash = new Transaction("egg", "", "6.7");
//        Transaction steven = new Transaction("beer", "", "21.3");
//        Transaction biem = new Transaction("banana", "", "43.2");
//        Transaction no_name = new Transaction("steak", "", "89.2");


        // Add transactions to the arraylist: take Transactions objects
        ArrayList<Transaction> transactionList = new ArrayList<>();
        transactionList.add(step_fart_nee );
        transactionList.add(john );
        transactionList.add(steve );
        transactionList.add(abe );
        transactionList.add(dita );
        transactionList.add(jordan );
        transactionList.add(joshua );
        transactionList.add(subhash );
        transactionList.add(biem );
        transactionList.add(no_name );

        // take in the context, custom layout that made, arraylist(which is transactionList)
        TransactionListAdapter adapter = new TransactionListAdapter(this, R.layout.adapter_view_layout, transactionList);
        listViewItems.setAdapter(adapter);

        // ========================== Custom Add Splitters =========================================

        NamesAdded mrSteve = new NamesAdded("Steve");
        NamesAdded mrAbe = new NamesAdded("Abe");

        final ArrayList<NamesAdded> namesAddedList = new ArrayList<>();
        namesAddedList.add(mrSteve);
        namesAddedList.add(mrAbe);


        Button addButton = (Button)this.findViewById(R.id.addNameButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                View dialogView = inflater.inflate(R.layout.add_name_layout,null);

                builder.setView(dialogView);

                builder.setTitle("Add Person");


                // Set the positive button
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        System.out.println("============== Im in Save =====================");
                        System.out.println("Names List: "+namesAddedList);
                        System.out.println("============== Im in Save =====================");
                        addThisName = (EditText)findViewById(R.id.edit_add_name);
                        System.out.println("Names : "+addThisName);
                    }
                });

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
        });

        NameAddedListAdapter name_adapter = new NameAddedListAdapter(this, R.layout.adapter_names_view_layout, namesAddedList);
        listViewNames.setAdapter(name_adapter);

        listViewNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("============== Im in click =====================");
            }
        });

//        listViewNames.setRotation(90);


    }
}
