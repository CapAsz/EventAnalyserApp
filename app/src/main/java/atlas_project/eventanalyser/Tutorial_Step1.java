package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Tutorial_Step1 extends AppCompatActivity {
    public int lept_no = 0;
    public int lept_charge = 1;
    public int lept_flavour = 1;
    public int lept_1_inv_mass = 0;
    public int lept_2_inv_mass = 0;
    public int lept_err_inv_mass = 0;
    public int lept_min_mass = 0;
    public int lept_max_mass = 200;
    public int lept_mom = 25;
    public int jets_no_min = 0;
    public int jets_no_max = 9;
    public int bTag_jets_no_min = 0;
    public int bTag_jets_no_max = 9;
    public int missing_trans_mom_min = 0;
    public int missing_trans_mom_max = 200;
    public int percent_data = 1;
    //values representing checkbox states (1 if checked, 0 if not)
    public int lept_charge_chk = 0;
    public int lept_flavour_chk = 0;
    public int lept_inv_mass_chk = 0;
    public int lept_mom_chk = 0;
    public int bTag_jets_chk = 0;
    public int lept_no_chk = 0;
    public int jets_chk = 0;
    public int missing_trans_chk = 0;
    public String key = ""; //key for fetching histograms (missing samples)
    public int step = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial__step1);

        final SeekBar percent_data_sb = findViewById(R.id.percent_sb);

        percent_data_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percent_data = progress*10;
            }
        });

        //button to return to choosing values to analyse
        Button analyse_button = findViewById(R.id.Go);
        analyse_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalysisKey aKey = new AnalysisKey(key);
                key = aKey.getValuesKey(lept_no, lept_charge, lept_flavour, lept_1_inv_mass,
                        lept_2_inv_mass, lept_err_inv_mass, lept_min_mass, lept_max_mass, lept_mom,
                        jets_no_min, jets_no_max, bTag_jets_no_min, bTag_jets_no_max,
                        missing_trans_mom_min, missing_trans_mom_max, percent_data, lept_charge_chk,
                        lept_flavour_chk, lept_inv_mass_chk, lept_mom_chk, bTag_jets_chk,
                        lept_no_chk, jets_chk, missing_trans_chk);
                Intent goToTab = new Intent(Tutorial_Step1.this, Analysis_results.class);
                goToTab.putExtra("HistKey", key);
                goToTab.putExtra("Step", step);
                startActivity(goToTab);
            }
        });
    }
}
