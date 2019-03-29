package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {



    private EditText first2;
    private EditText sec2;
    private EditText third2;
    private EditText fourth2;

    private Button sum_button;
    private Button prod_button;
    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {




        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_sum:
                    int sum = Integer.valueOf(first2.getText().toString()) +
                            Integer.valueOf(sec2.getText().toString()) +
                            Integer.valueOf(third2.getText().toString()) +
                            Integer.valueOf(fourth2.getText().toString());
                    Log.d("[Message]", "Sum");
                    Toast.makeText(getApplicationContext(), "Sum is" + sum, Toast.LENGTH_LONG).show();
                    break;
                case R.id.button_prod:
                    int prod = Integer.valueOf(first2.getText().toString()) *
                            Integer.valueOf(sec2.getText().toString())*
                            Integer.valueOf(third2.getText().toString())*
                            Integer.valueOf(fourth2.getText().toString());
                    Log.d("[Message]", "Prod");
                    Toast.makeText(getApplicationContext(), "PRod is " + prod, Toast.LENGTH_LONG).show();
                    break;

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_practical_test01_var07_main);
        first2 = findViewById(R.id.unu_sec);
        sec2 = findViewById(R.id.doi_sec);
        third2 = findViewById(R.id.trei_sec);
        fourth2 = findViewById(R.id.patru_sec);

        sum_button = findViewById(R.id.button_sum);
        sum_button.setOnClickListener(genericButtonClickListener);

        prod_button = findViewById(R.id.button_prod);
        prod_button.setOnClickListener(genericButtonClickListener);



        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("v1")) {
            System.out.println("Aici1");
            int v1 = intent.getIntExtra("v1", -1);
            first2.setText(String.valueOf(v1));
        }
        if (intent != null && intent.getExtras().containsKey("v2")) {
            System.out.println("Aici2");
            int v2 = intent.getIntExtra("v2", -1);
            sec2.setText(String.valueOf(v2));
        }
        if (intent != null && intent.getExtras().containsKey("v3")) {
            System.out.println("Aici3");
            int v3 = intent.getIntExtra("v3", -1);
            third2.setText(String.valueOf(v3));
        }
        if (intent != null && intent.getExtras().containsKey("v4")) {
            System.out.println("Aici4");
            int v4 = intent.getIntExtra("v4", -1);
            fourth2.setText(String.valueOf(v4));
        }
    }

}
