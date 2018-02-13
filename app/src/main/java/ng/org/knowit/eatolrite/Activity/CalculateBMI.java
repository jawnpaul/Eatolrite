package ng.org.knowit.eatolrite.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import ng.org.knowit.eatolrite.R;

public class CalculateBMI extends AppCompatActivity {

    public int spinnerPosition;
    String[] weightUnitList = {"KG", "LBS"};
    String[] heightUnitList = {"m", "in"};
    private double height;
    private double weight;
    private double bmiResult;
    private TextView mResultTextView, mStatusTextView;
    private EditText heightInput, weightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.bmi_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        initViews();
        saveBMIResult();
        resetBMI();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, weightUnitList);
        MaterialBetterSpinner weightMaterialBetterSpinner = (MaterialBetterSpinner)
                findViewById(R.id.weight_material_design_spinner);
        weightMaterialBetterSpinner.setAdapter(arrayAdapter);
        weightMaterialBetterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                spinnerPosition = position;
                switch (position) {
                    case 0:
                        Toast.makeText(CalculateBMI.this, "KG chosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(CalculateBMI.this, "pound chosen", Toast.LENGTH_SHORT).show();
                        break;
                }

                parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, heightUnitList);
        MaterialBetterSpinner heightMaterialBetterSpinner = (MaterialBetterSpinner)
                findViewById(R.id.height_material_design_spinner);
        heightMaterialBetterSpinner.setAdapter(arrayAdapter1);
    }

    public void saveBMIResult() {
        Button btn_save = (Button) findViewById(R.id.save_button);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculateBMI.this, "Good", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void resetBMI() {
        Button btn_reset = (Button) findViewById(R.id.reset_button);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heightInput.clearFocus();
                weightInput.clearFocus();
                heightInput.getText().clear();
                weightInput.getText().clear();
                mStatusTextView.setText("");
                mResultTextView.setText("");
            }
        });
    }

    public void calculateBmi(double weight, double height) {

        bmiResult = weight / Math.pow(height, 2);
        mResultTextView.setText(String.valueOf(bmiResult));
        showStatus(bmiResult);
    }

    public void showStatus(double bmiResult) {
        this.bmiResult = bmiResult;
        if (bmiResult < 18.5) {
            mStatusTextView.setText("Underweight");
        } else if (bmiResult >= 18.5 && bmiResult < 25) {
            mStatusTextView.setText("normal weight");
        } else if (bmiResult >= 25 && bmiResult >= 30) {
            mStatusTextView.setText("over weight");
        }
    }

    public void initViews() {
        mResultTextView = (TextView) findViewById(R.id.bmi_result_textView);
        heightInput = (EditText) findViewById(R.id.height_editText);
        heightInput.addTextChangedListener(new GenericTextWatcher(heightInput));
        weightInput = (EditText) findViewById(R.id.weight_editText);
        weightInput.addTextChangedListener(new GenericTextWatcher(weightInput));
        mStatusTextView = (TextView) findViewById(R.id.status_response_textView);

    }

    private class GenericTextWatcher implements TextWatcher {
        private View view;


        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            String text = editable.toString();
            switch (view.getId()) {


                case R.id.weight_editText:
                    //To do code

                    if (TextUtils.isEmpty(text)) {
                        weight = 0;
                    } else
                        weight = Double.parseDouble(text);
                    calculateBmi(weight, height);

                    break;

                case R.id.height_editText:
                    // to do code
                    if (TextUtils.isEmpty(text)) {
                        height = 0;
                    } else
                        height = Double.parseDouble(text);
                    calculateBmi(weight, height);
                    break;

            }

        }
    }
}
