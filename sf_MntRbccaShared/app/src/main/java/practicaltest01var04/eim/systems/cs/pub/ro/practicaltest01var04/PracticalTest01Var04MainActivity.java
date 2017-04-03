package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private static int apasari = 0;
    static String apasariKey = "bla";
    static final int ACT_REQUEST_CODE = 2018;

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            TextView tv1 = (TextView) findViewById(R.id.tv1);
            Log.d("TAG_Apasari", apasari+"");
            if ( ((Button)view).getId() == R.id.btn_1 ) {
                String txt = tv1.getText().toString() + "," + ((Button)view).getText();
                tv1.setText(txt);
                apasari++;

            }
            if ( ((Button)view).getId() == R.id.btn_2 ) {
                String txt = tv1.getText().toString() + "," + ((Button)view).getText();
                tv1.setText(txt);
                apasari++;
            }
            if ( ((Button)view).getId() == R.id.btn_3 ) {
                String txt = tv1.getText().toString() + "," + ((Button)view).getText();
                tv1.setText(txt);
                apasari++;
            }
            if ( ((Button)view).getId() == R.id.btn_4 ) {
                String txt = tv1.getText().toString() + "," + ((Button)view).getText();
                tv1.setText(txt);
                apasari++;
            }
            if ( ((Button)view).getId() == R.id.btn_5 ) {
                String txt = tv1.getText().toString() + "," + ((Button)view).getText();
                tv1.setText(txt);
                apasari++;
            }

            if ( ((Button)view).getId() == R.id.btn_0 ) {
                Intent intent = new Intent("practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04.PracticalTest01Var04SecondaryActivity");
                intent.putExtra("key1", tv1.getText().toString());

                startActivityForResult(intent, ACT_REQUEST_CODE);
            }
            if (tv1.getText().toString().length() > 10) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04",
                        "practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04.service.PracticalTest01Var04Service"));
                intent.putExtra("key2",tv1.getText().toString());
                startService(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);
        Button btn;
        btn = (Button) findViewById(R.id.btn_0);
        btn.setOnClickListener(buttonClickListener);

        btn = (Button) findViewById(R.id.btn_1);
        btn.setOnClickListener(buttonClickListener);

        btn = (Button) findViewById(R.id.btn_2);
        btn.setOnClickListener(buttonClickListener);

        btn = (Button) findViewById(R.id.btn_3);
        btn.setOnClickListener(buttonClickListener);

        btn = (Button) findViewById(R.id.btn_4);
        btn.setOnClickListener(buttonClickListener);

        btn = (Button) findViewById(R.id.btn_5);
        btn.setOnClickListener(buttonClickListener);

    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent("ACTIONSTR");
        stopService(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.d("TAG", "Value saved");
        savedInstanceState.putInt(apasariKey, apasari);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int val = savedInstanceState.getInt(apasariKey);
        apasari = val;
        Log.d("TAG", "Value restored");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d("CVA", "OnActResult Called");
        switch(requestCode) {
            case ACT_REQUEST_CODE:
                Toast.makeText(PracticalTest01Var04MainActivity.this, resultCode+"", Toast.LENGTH_LONG).show();
                break;
        }
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText("");
        apasari = 0;
    }
}

class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }
    public StartedServiceBroadcastReceiver() {
        messageTextView = null;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        String data = null;
        if ("ACTIONSTR".equals(action)) {
            data = intent.getStringExtra("key3");
        }
        Log.d("ReceiverTag", data);
    }
}