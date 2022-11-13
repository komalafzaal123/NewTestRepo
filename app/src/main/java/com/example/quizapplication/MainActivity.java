package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Random;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener
{

    String Questions[]={"How to get a response from an activity in Android?.",
            "What is the time limit of broadcast receiver in android?","What is fragment in android?",
    "Can a class be immutable in android?","How many threads are there in asyncTask in android?"};

    String OptionsOfQ1[]={"startActivityToResult()","startActiivtyForResult()","Bundle()", "None of the above"};//B startActiivtyForResult
    String OptionsOfQ2[]={"10 sec","15 sec","5 sec","45 sec"};//10sec
    String OptionsOfQ3[]={"JSON","Peace of Activity","Layout","None of the above"};//Peace of Activity"
    String OptionsOfQ4[]={"No, it can't","Yes, Class can be immutable","Can't make the class as final class",
            "None of the above"};//Yes, Class can be immutable
    String OptionsOfQ5[]={"Only one","Two"," AsyncTask doesn't have tread","None of the Above"};//Only one

    TextView tv1;
    Button btnAns1, btnAns2, btnAns3, btnAns4, btnSub;

    String choosedAnswer = "";
    int right = 0, wrong = 0;
    int questionNumber = 0;
    int index = 0, next = 0;
    int r1 = 0, r2 = 0, r3 = 0, r4 = 0 ;


    ArrayList<Integer> l = UniqueRandomNumbers(Questions.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.Question);
        btnAns1 = findViewById(R.id.ans_A);
        btnAns1.setOnClickListener(this);
        btnAns2 = findViewById(R.id.ans_B);
        btnAns2.setOnClickListener(this);
        btnAns3 = findViewById(R.id.ans_C);
        btnAns3.setOnClickListener(this);
        btnAns4 = findViewById(R.id.ans_D);
        btnAns4.setOnClickListener(this);
        btnSub = findViewById(R.id.Submit);
        btnSub.setOnClickListener(this);

        displayQuestion();


    }

    private void displayQuestion()
    {

        if (questionNumber == Questions.length)
        {
            finishQuiz();
            return;
        }

        index = l.get(next);
        tv1.setText(Questions[index]);
        next++;

        if(index == 0)
        {

            ArrayList<Integer> list = UniqueRandomNumbers(OptionsOfQ1.length);
            r1 = list.get(0);
            btnAns1.setText(OptionsOfQ1[r1]);
            r2 = list.get(1);
            btnAns2.setText(OptionsOfQ1[r2]);
            r3 = list.get(2);
            btnAns3.setText(OptionsOfQ1[r3]);
            r4 = list.get(3);
            btnAns4.setText(OptionsOfQ1[r4]);
        }
        else if(index == 1)
        {
            ArrayList<Integer> list = UniqueRandomNumbers(OptionsOfQ2.length);
            r1 = list.get(0);
            btnAns1.setText(OptionsOfQ2[r1]);
            r2 = list.get(1);
            btnAns2.setText(OptionsOfQ2[r2]);
            r3 = list.get(2);
            btnAns3.setText(OptionsOfQ2[r3]);
            r4 = list.get(3);
            btnAns4.setText(OptionsOfQ2[r4]);
        }
        else if(index == 2)
        {
            ArrayList<Integer> list = UniqueRandomNumbers(OptionsOfQ3.length);
            r1 = list.get(0);
            btnAns1.setText(OptionsOfQ3[r1]);
            r2 = list.get(1);
            btnAns2.setText(OptionsOfQ3[r2]);
            r3 = list.get(2);
            btnAns3.setText(OptionsOfQ3[r3]);
            r4 = list.get(3);
            btnAns4.setText(OptionsOfQ3[r4]);
        }
        else if(index == 3)
        {
            ArrayList<Integer> list = UniqueRandomNumbers(OptionsOfQ4.length);
            r1 = list.get(0);
            btnAns1.setText(OptionsOfQ4[r1]);
            r2 = list.get(1);
            btnAns2.setText(OptionsOfQ4[r2]);
            r3 = list.get(2);
            btnAns3.setText(OptionsOfQ4[r3]);
            r4 = list.get(3);
            btnAns4.setText(OptionsOfQ4[r4]);
        }
        else if(index == 4)
        {
            ArrayList<Integer> list = UniqueRandomNumbers(OptionsOfQ5.length);
            r1 = list.get(0);
            btnAns1.setText(OptionsOfQ5[r1]);
            r2 = list.get(1);
            btnAns2.setText(OptionsOfQ5[r2]);
            r3 = list.get(2);
            btnAns3.setText(OptionsOfQ5[r3]);
            r4 = list.get(3);
            btnAns4.setText(OptionsOfQ5[r4]);
        }
    }

    public  ArrayList<Integer> UniqueRandomNumbers (int length) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<length; i++)
            list.add(i);
            Collections.shuffle(list);
        return list;
    }
    void finishQuiz()
    {
        System.out.println("finish.");
        displayResult();
        return;
    }

    private void displayResult() {

    }

    public void onClick(View view) {
        btnAns1.setBackgroundColor(Color.WHITE);
        btnAns2.setBackgroundColor(Color.WHITE);
        btnAns3.setBackgroundColor(Color.WHITE);
        btnAns4.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.Submit) {

            if(choosedAnswer == "startActiivtyForResult()"|| choosedAnswer == "10 sec" ||
            choosedAnswer == "Peace of Activity" || choosedAnswer == "Yes, Class can be immutable" || choosedAnswer == "Only one")
            {
                right++;
                System.out.println("right"+right);
            }
            else
            {
                wrong++;
                System.out.println("wrong"+wrong);
            }
            questionNumber ++;
            displayQuestion();
        }
        else
        {
            choosedAnswer = clickedButton.getText().toString();
            System.out.println(choosedAnswer);
            clickedButton.setBackgroundColor(Color.YELLOW);
        }
    }
}
