package com.navi_tunner.atm3;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private static final String TAG = AddActivity.class.getSimpleName();
    private EditText edDate;
    private EditText edInfo;
    private EditText edMoney;
    private DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        findView();
        helper = new DbHelper(this);
    }

    private void findView() {
        edDate = findViewById(R.id.ed_date);
        edInfo = findViewById(R.id.ed_info);
        edMoney = findViewById(R.id.ed_money);
    }

    public void add(View view)
    {
        String cdate = edDate.getText().toString();
        String info = edInfo.getText().toString();
        int money = Integer.parseInt(edMoney.getText().toString());
        ContentValues values = new ContentValues();
        values.put("cdate",cdate);
        values.put("info",info);
        values.put("money",money);
        long id = helper.getWritableDatabase().insert("exp",null,values);
        Log.d(TAG, "add: " + id);

    }
}
