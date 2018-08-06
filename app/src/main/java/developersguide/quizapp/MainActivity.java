package developersguide.quizapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitBtn = (Button)findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Check result for qsn1

                RadioButton qsn_1_RadioBtn = (RadioButton)findViewById(R.id.keratin);
                boolean qsn1result=qsn_1_RadioBtn.isChecked();

                //check result for qsn2

                RadioButton qsn_2_RadioBtn = (RadioButton)findViewById(R.id._206_bone_number);
                boolean qsn2result=qsn_2_RadioBtn.isChecked();

                //check result for qsn3

                CheckBox qsn_3_CheckBox = (CheckBox)findViewById(R.id.thyroid);
                boolean qsn3result = qsn_3_CheckBox.isChecked();
                CheckBox qsn_3_CheckBox1 = (CheckBox)findViewById(R.id.pituitary);
                boolean qsn3result1 = qsn_3_CheckBox1.isChecked();

                //check wrong result for qsn3
                CheckBox qsn_3_wrong_checkbox=(CheckBox)findViewById(R.id.kidney);
                boolean qsn3WrongResult=qsn_3_wrong_checkbox.isChecked();
                CheckBox qsn_3_wrong_checkbox1=(CheckBox)findViewById(R.id.liver);
                boolean qsn3WrongResult1=qsn_3_wrong_checkbox1.isChecked();


                //check result for qsn4

                EditText qsn_4_EditText = (EditText)findViewById(R.id.weight_of_brain);
                String brain=qsn_4_EditText.getText().toString();

                //check result for qsn5

                EditText qsn_5_EditText = (EditText)findViewById(R.id.acid_from_stomach);
                String acid = qsn_5_EditText.getText().toString();


                //check result for qsn6

                CheckBox aboGroup =(CheckBox)findViewById(R.id.blood_group_a);
                boolean aboGroupResult=aboGroup.isChecked();
                CheckBox aboGroup1 =(CheckBox)findViewById(R.id.blood_group_b);
                boolean aboGroupResult1=aboGroup1.isChecked();
                CheckBox aboGroup2 =(CheckBox)findViewById(R.id.blood_group_ab);
                boolean aboGroupResult2=aboGroup2.isChecked();
                CheckBox aboGroup3 =(CheckBox)findViewById(R.id.blood_group_o);
                boolean aboGroupResult3=aboGroup3.isChecked();

                //check result for qsn7

                RadioButton qsn_7_RadioBtn = (RadioButton)findViewById(R.id.heart);
                boolean qsn7Result=qsn_7_RadioBtn.isChecked();

                //check result for qsn8

                RadioButton qsn_8_RadioBtn = (RadioButton)findViewById(R.id.water_percent_66);
                boolean qsn8Result=qsn_8_RadioBtn.isChecked();

                //check result for qsn9

                RadioButton qsn_9_RadioBtn = (RadioButton)findViewById(R.id._true);
                boolean qsn9Result=qsn_9_RadioBtn.isChecked();

                //check result for qsn10

                RadioButton qsn_10_RadioBtn = (RadioButton)findViewById(R.id.ear);
                boolean qsn10Result=qsn_10_RadioBtn.isChecked();

                //get total result

                int totalScore =checkResult(qsn1result,qsn2result,qsn3result,qsn3result1,qsn3WrongResult,qsn3WrongResult1,brain,acid,aboGroupResult,aboGroupResult1,aboGroupResult2,aboGroupResult3,qsn7Result,qsn8Result,qsn9Result,qsn10Result);

                Toast.makeText(getApplicationContext(),"You scored "+String.valueOf(totalScore)+" out of 10",Toast.LENGTH_LONG).show();
            }
        });
    }

    /***
     * check the result and add score
     *
     * @param qsn1result boolean type
     * @param qsn2result boolean type
     * @param qsn3result boolean type
     * @param qsn3result1 boolean type
     * @param qsn3WrongResult boolean type
     * @param qsn3WrongResult1 boolean type
     * @param brain string
     * @param acid string
     * @param aboGroupResult boolean
     * @param aboGroupResult1 boolean
     * @param aboGroupResult2 boolean
     * @param aboGroupResult3 boolean
     * @param qsn7Result boolean
     * @param qsn8Result boolean
     * @param qsn9Result boolean
     * @param qsn10Result boolean
     * @return integer
     */

    public int checkResult(boolean qsn1result,boolean qsn2result,boolean qsn3result,boolean qsn3result1,boolean qsn3WrongResult,boolean qsn3WrongResult1,String brain,String acid,boolean aboGroupResult,boolean aboGroupResult1,boolean aboGroupResult2,boolean aboGroupResult3,boolean qsn7Result,boolean qsn8Result,boolean qsn9Result,boolean qsn10Result){

        int score=0;

        if(qsn1result){
            score=score+1;
        }

        if(qsn2result){
            score=score+1;
        }


        if (qsn3result&&qsn3result1){

            if (qsn3WrongResult||qsn3WrongResult1){
               score=score;
            }
            else{
                score=score+1;
            }
        }



        if (brain.equals("1.40kg")||brain.equals("1.4kg")){
            score=score+1;
        }

        if (acid.equals("hcl")||acid.equals("HCL")){
            score=score+1;
        }

        if (aboGroupResult&&aboGroupResult1&&aboGroupResult2&&aboGroupResult3){
            score=score+1;
        }
        else {
            score=score;
        }

        if (qsn7Result){
            score=score+1;
        }

        if (qsn8Result){
            score=score+1;
        }

        if (qsn9Result){
            score=score+1;
        }

        if (qsn10Result){
            score=score+1;
        }

       return score;
    }


}
