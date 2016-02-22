package edu.scu.lecture4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ViewExamples extends AppCompatActivity {

    private EditText interestRate;
    private EditText term;
    private TextView result;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_examples);

        interestRate = (EditText) findViewById(R.id.interest_rate_2);
        term = (EditText) findViewById(R.id.term);
        result = (TextView) findViewById(R.id.result);
        button = (Button) findViewById(R.id.calculate_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double interestRateValue = Double.parseDouble(interestRate.getText().toString());
                double termValue = Double.parseDouble(term.getText().toString());
                result.setText(Double.toString(interestRateValue + termValue));
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
                if (checked)
                    Toast.makeText(this, "Yes meat", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "No meat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkbox_cheese:
                if (checked)
                    Toast.makeText(this, "Yes cheese", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "No cheese", Toast.LENGTH_SHORT).show();
                break;
            // TODO: Veggie sandwich
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    Toast.makeText(this, "Pirates", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    Toast.makeText(this, "Ninjas", Toast.LENGTH_SHORT).show();
                    break;
        }
    }
}
