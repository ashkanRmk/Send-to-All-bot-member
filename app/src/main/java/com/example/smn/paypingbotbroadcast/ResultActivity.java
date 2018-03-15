package com.example.smn.paypingbotbroadcast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setTitle("Result");

        TextView tv_result = (TextView) findViewById(R.id.tv_result);
        TextView tv_ids = (TextView) findViewById(R.id.tv_ids);


        Bundle b = this.getIntent().getExtras();
        ArrayList<String> notSend = b.getStringArrayList("notIds");
        ArrayList<String> chatIds = b.getStringArrayList("chatIds");
        ArrayList<String> testIds = b.getStringArrayList("testIds");
        Boolean test = this.getIntent().getBooleanExtra("test", false);


        if (test)
            tv_result.setText("Your message has NOT been sent to " + (notSend != null ? notSend.size() : 0) + " of " + (testIds != null ? testIds.size() : 0) + " users.");
        else
            tv_result.setText("Your message has NOT been sent to " + (notSend != null ? notSend.size() : 0) + " of " + (chatIds != null ? chatIds.size() : 0) + " users.");


        Map<String, String> names = new HashMap<>();
        names.put("109416039", "ashkan");
        names.put("90210964", "samane");
        names.put("152445158", "nima");
        names.put("55622476", "saeed");
        names.put("56038909", "mohammad");
        names.put("84989023", "masoud");
        names.put("107230941", "amir");

        String tmp;
        if (notSend != null) {
            for (String id : notSend)
            {
                if (test)
                {
                    tmp = tv_ids.getText().toString() + "\n" + id + " " + names.get(id);
                    tv_ids.setText(tmp);
                }
                else {
                    tmp = tv_ids.getText().toString() + "\n" + id;
                    tv_ids.setText(tmp);
                }
            }
        }
        else tv_ids.setText("Nothing!");

    }
}
