package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Tutorial_Step5_samples extends AppCompatActivity {
    ArrayList<String> samples_list = new ArrayList<>();
    String key = ""; //key of values to analyse
    public int step = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial__step5_samples);

        key = getIntent().getStringExtra("HistKey");

        final CheckBox ttbar_had = findViewById(R.id.ttbar_had);
        final CheckBox ttbar_lep = findViewById(R.id.ttbar_lep);

        HashMap<String, CheckBox> allchk = new HashMap<>();
        allchk.put("ttbar_had", ttbar_had);
        allchk.put("ttbar_lep", ttbar_lep);

        for (String string : allchk.keySet()) {
            final String sample = "__" +string;
            final CheckBox chk = allchk.get(string);
            chk.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (chk.isChecked()) {
                        samples_list.add(sample);
                    }
                    else {
                        samples_list.remove(sample);
                    }
                }
            });
        }

        Button go_button = findViewById(R.id.go2);
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalysisKey analysisKey = new AnalysisKey(key);
                key = analysisKey.getKey(samples_list);
                Intent goToTab = new Intent(Tutorial_Step5_samples.this, Analysis_results.class);
                goToTab.putExtra("HistKey", key);
                goToTab.putExtra("Step", step);
                startActivity(goToTab);
            }
        });
    }

    /**
     * Change visibility of sample group checkboxes depending on current visibility. Reset all
     * sample checkBoxes if sample group checkboxes are gone.
     * @param view "Choose samples to analyse:" CheckBox
     */
    public void setSamples(View view) {
        LinearLayout cl = findViewById(R.id.samples_layout);
        CheckBox ttbar = findViewById(R.id.ttbar);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
            samples_list.clear();
        }
        else {
            if (ttbar.isChecked()) {
                ttbar.toggle();
                ttbarSamples(view);
            }
        }
    }

    /**
     * Uncheck ArrayList of CheckBoxes
     * @param list ArrayList of CheckBoxes
     */
    public void chkIterator(ArrayList<CheckBox> list) {
        Iterator<CheckBox> itr = list.iterator();
        while (itr.hasNext()) {
            CheckBox chk = itr.next();
            if (chk.isChecked()) {
                chk.toggle();
            }
        }
    }

    public void ttbarSamples(View view) {
        ConstraintLayout cl = findViewById(R.id.ttbar_layout);
        CheckBox chk1 = findViewById(R.id.ttbar_had);
        CheckBox chk2 = findViewById(R.id.ttbar_lep);
        ArrayList<CheckBox> list = new ArrayList<>();
        list.add(chk1);
        list.add(chk2);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        }
        else {
            cl.setVisibility(View.GONE);
            chkIterator(list);
        }
    }
}
