package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Analysis_results extends AppCompatActivity {
    private String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_results);

        key = getIntent().getStringExtra("HistKey");

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Analysis_results.this, Analysis_main.class);
                startActivity(goToTab);
            }
        });
    }


}
