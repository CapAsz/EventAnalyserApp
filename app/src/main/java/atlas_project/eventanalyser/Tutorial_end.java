package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial_end extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_end);

        Button tutorial_button = findViewById(R.id.tutorial);
        tutorial_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_end.this, Tutorial_main.class);
                startActivity(goToTab);
            }
        });

        Button analysis_button = findViewById(R.id.analysis);
        analysis_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Tutorial_end.this, Analysis_main.class);
                startActivity(goToTab);
            }
        });
    }
}
