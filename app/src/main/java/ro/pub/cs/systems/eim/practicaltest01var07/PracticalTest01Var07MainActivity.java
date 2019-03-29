package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private EditText first;
    private EditText sec;
    private EditText third;
    private EditText fourth;

    private Button set_button;

    private IntentFilter intentFilter = new IntentFilter();

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {


            if (view.getId() == R.id.button_set) {
                Log.d("[Message]", "Button Set");
                if (first.getText() == null) {

                } else if (sec.getText() == null) {

                } else if(third.getText() == null) {

                } else if(fourth.getText() == null) {

                } else {

                    int v1 = Integer.valueOf(first.getText().toString());
                    int v2 = Integer.valueOf(sec.getText().toString());
                    int v3 = Integer.valueOf(third.getText().toString());
                    int v4 = Integer.valueOf(fourth.getText().toString());

                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);


                    intent.putExtra("v1", v1);
                    intent.putExtra("v2", v2);
                    intent.putExtra("v3", v3);
                    intent.putExtra("v4", v4);
                    startActivityForResult(intent,1);

                }


            }



        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        first= findViewById(R.id.unu);
        sec = findViewById(R.id.doi);
        third = findViewById(R.id.trei);
        fourth = findViewById(R.id.patru);

        set_button = findViewById(R.id.button_set);
        set_button.setOnClickListener(genericButtonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("save_f")) {
                first.setText(savedInstanceState.getString("save_f"));
            } else {
                first.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("save_s")) {
                sec.setText(savedInstanceState.getString("save_s"));
            } else {
                sec.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("save_t")) {
                third.setText(savedInstanceState.getString("save_t"));
            } else {
                third.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("save_ft")) {
                fourth.setText(savedInstanceState.getString("save_ft"));
            } else {
                fourth.setText(String.valueOf(0));
            }

        }
    }

        @Override
        protected void onSaveInstanceState(Bundle savedInstanceState) {
            super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putString("save_f", first.getText().toString());
            savedInstanceState.putString("save_s", sec.getText().toString());
            savedInstanceState.putString("save_t", third.getText().toString());
            savedInstanceState.putString("save_ft", fourth.getText().toString());
        }

        @Override
        protected void onRestoreInstanceState(Bundle savedInstanceState) {
            if (savedInstanceState.containsKey("save_f")) {
                first.setText(savedInstanceState.getString("save_f"));
            } else {
                first.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("save_s")) {
                sec.setText(savedInstanceState.getString("save_s"));
            } else {
                sec.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("save_t")) {
                third.setText(savedInstanceState.getString("save_t"));
            } else {
                third.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("save_ft")) {
                fourth.setText(savedInstanceState.getString("save_ft"));
            } else {
                fourth.setText(String.valueOf(0));
            }
        }
}
