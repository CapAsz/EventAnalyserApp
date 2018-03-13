package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Tutorial_coordinates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_coordinates);

        //button to return to choosing values to analyse
        Button backButton = findViewById(R.id.back_button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_coordinates.this, Tutorial_Step1.class);
                startActivity(goToTab);
            }
        });

        //button to return to choosing values to analyse
        Button nextButton = findViewById(R.id.next_button2);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_coordinates.this, Tutorial_Step2.class);
                startActivity(goToTab);
            }
        });

        //button to return to choosing values to analyse
        ImageButton home = findViewById(R.id.home11);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_coordinates.this, Menu.class);
                startActivity(goToTab);
            }
        });
    }
}
