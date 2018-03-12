package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Tutorial_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tutorial_main);

        //button to start tutorial
        Button start_bt = findViewById(R.id.Start);
        start_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_main.this, Tutorial_Step1.class);
                startActivity(goToTab);
            }
        });

        //button to go to step 1 of tutorial
        Button Step1bt = findViewById(R.id.button1);
        Step1bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_main.this, Tutorial_Step1.class);
                startActivity(goToTab);
            }
        });

        //button to go to step 2 of tutorial
        Button Step2bt = findViewById(R.id.button2);
        Step2bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_main.this, Tutorial_Step2.class);
                startActivity(goToTab);
            }
        });

        //button to go to step 3 of tutorial
        Button Step3bt = findViewById(R.id.button3);
        Step3bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_main.this, Tutorial_Step3.class);
                startActivity(goToTab);
            }
        });

        //button to go to step 4 of tutorial
        Button Step4bt = findViewById(R.id.button4);
        Step4bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_main.this, Tutorial_Step4.class);
                startActivity(goToTab);
            }
        });

        //button to go to step 5 of tutorial
        Button Step5bt = findViewById(R.id.button5);
        Step5bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_main.this, Tutorial_Step5.class);
                startActivity(goToTab);
            }
        });

        //button to go to full analysis
        Button gotoAnalysis_bt = findViewById(R.id.full_analysis_bt);
        gotoAnalysis_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_main.this, Analysis_main.class);
                startActivity(goToTab);
            }
        });
    }
}
