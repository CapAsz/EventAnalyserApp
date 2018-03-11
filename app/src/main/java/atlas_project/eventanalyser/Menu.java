package atlas_project.eventanalyser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;

import com.google.firebase.firestore.FirebaseFirestore;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button tutorialButton = findViewById(R.id.tutorial_button);
        Button eaButton = findViewById(R.id.ea_button);
        Button aboutButton = findViewById(R.id.about_button);

        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Menu.this, Tutorial_main.class);
                startActivity(goToTab);
            }
        });

        eaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Menu.this, Analysis_main.class);
                startActivity(goToTab);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Menu.this, About_main.class);
                startActivity(goToTab);
            }
        });
    }

}