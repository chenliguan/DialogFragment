package com.guan.dialogfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rad_dialog_alert)
    RadioButton radDialogAlert;
    @Bind(R.id.rad_dialog_date)
    RadioButton radDialogDate;
    @Bind(R.id.rad_dialog_time)
    RadioButton radDialogTime;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    @Bind(R.id.btn_dialog)
    Button btnDialog;

    public static final int DIALOG_TYPR_ALERT = 1;
    public static final int DIALOG_TYPR_DATE = 2;
    public static final int DIALOG_TYPR_TIME = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_dialog)
    public void submit() {

        int resId = radioGroup.getCheckedRadioButtonId();
        MyDialogFragment myDialogFragment = null;

        switch (resId) {
            case R.id.rad_dialog_alert:
                Toast.makeText(MainActivity.this,"R.id.rad_dialog_alert",Toast.LENGTH_SHORT).show();
                myDialogFragment = MyDialogFragment.newInstance(DIALOG_TYPR_ALERT);
                break;

            case R.id.rad_dialog_date:
                Toast.makeText(MainActivity.this,"R.id.rad_dialog_date",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rad_dialog_time:
                Toast.makeText(MainActivity.this,"R.id.rad_dialog_time",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        if (myDialogFragment != null) {
            myDialogFragment.show(getSupportFragmentManager(), "dialog");
        }
    }

}
