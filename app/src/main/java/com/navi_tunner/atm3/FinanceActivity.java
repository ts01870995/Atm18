package com.navi_tunner.atm3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class FinanceActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.list);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(FinanceActivity.this,AddActivity.class));
            }
        });

        DbHelper helper = new DbHelper(this);
        Cursor cursor = helper.getReadableDatabase().query
                ("exp",null,null,null,null,null,null);
        String[] from = {"cdate","info","money"};
        int[] to = {R.id.cdate,R.id.info,R.id.money};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter
                (this,
                        R.layout.row,
//                        android.R.layout.simple_list_item_2,
                        cursor,
                        from,
                        to,
//                        new String[]{"cdate","info"},
//                        new int[]{android.R.id.text1,android.R.id.text2},
                        0);
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.functions));
        listView.setAdapter(adapter);
    }

}
