package ng.org.knowit.eatolrite.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import ng.org.knowit.eatolrite.R;

public class CalculateBMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
    }

    public void onWeightRadioButtonClicked(View view){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.weight_radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id){
            case R.id.kg_radioButton:
                //To do code
                Toast.makeText(this, "kg radio button", Toast.LENGTH_SHORT).show();
            break;
            case R.id.pound_radioButton:
                //To do code
                Toast.makeText(this, "pound radio button", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onHeightRadioButtonClicked(View view){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.height_radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id){
            case R.id.metres_radioButton:
                //To do code
                Toast.makeText(this, "metres radio button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.inches_radioButton:
                //To do code
                Toast.makeText(this, "inches radio button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
