package com.navi_tunner.atm3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

public class LoginActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText edUid;
    private EditText edPw;
    private CheckBox cbRem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        cbRem.setOnCheckedChangeListener(this);
        boolean remember = getSharedPreferences("ATM",MODE_PRIVATE)
                .getBoolean("REM",false);
        cbRem.setChecked(remember);
        if (remember) {
            String userid = getSharedPreferences("ATM", MODE_PRIVATE)
                    .getString("ID", null);
            edUid.setText(userid);
        }
    }

    private void findView() {
        edUid = findViewById(R.id.ed_uid);
        edPw = findViewById(R.id.ed_pw);
        cbRem = findViewById(R.id.cb_rem);
    }

    public void login(View view)
    {
        String uid = edUid.getText().toString();
        String pw = edPw.getText().toString();
        if (cbRem.isChecked())
        {
            getSharedPreferences("ATM",MODE_PRIVATE)
                    .edit()
                    .putString("ID",uid)
                    .commit();
        }
        if ("jack".equals(uid) && "1234".equals(pw))
        {
            Log.d(TAG, "login: Success");
            getIntent().putExtra("UID",uid);
            getIntent().putExtra("PW",pw);
            setResult(RESULT_OK,getIntent());
            finish();
        }
        else
        {
            Log.d(TAG, "login: Fail");
        }
    }

    public void quit(View view)
    {
        finish();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        getSharedPreferences("ATM",MODE_PRIVATE)
                .edit()
                .putBoolean("REM",isChecked)
                .apply();
    }
}
