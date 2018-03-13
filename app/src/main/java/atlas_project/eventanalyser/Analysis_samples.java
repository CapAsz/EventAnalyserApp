package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Analysis_samples extends AppCompatActivity {
    ArrayList<String> samples_list = new ArrayList<>();
    String key = ""; //key of values to analyse
    int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_analysis_samples);

        key = getIntent().getStringExtra("HistKey");

        final Button aButton = findViewById(R.id.analyse_button);
        final CheckBox WW = findViewById(R.id.WW);
        final CheckBox ZZ = findViewById(R.id.ZZ);
        final CheckBox WZ = findViewById(R.id.WZ);
        final CheckBox stop_tchan_top = findViewById(R.id.stop_tchan_top);
        final CheckBox stop_tchan_antitop = findViewById(R.id.stop_tchan_antitop);
        final CheckBox stop_schan = findViewById(R.id.stop_schan);
        final CheckBox stop_wtchan = findViewById(R.id.stop_wtchan);
        final CheckBox ttbar_had = findViewById(R.id.ttbar_had);
        final CheckBox ttbar_lep = findViewById(R.id.ttbar_lep);
        final CheckBox Zee = findViewById(R.id.Zee);
        final CheckBox Zmumu = findViewById(R.id.Zmumu);
        final CheckBox Ztautau = findViewById(R.id.Ztautau);
        final CheckBox DYeeM08to15 = findViewById(R.id.DYeeM08);
        final CheckBox DYeeM15to40 = findViewById(R.id.DYeeM15);
        final CheckBox DYmumuM08to15 = findViewById(R.id.DYmumuM08);
        final CheckBox DYmumuM15to40 = findViewById(R.id.DYmumuM15);
        final CheckBox DYtautauM08to15 = findViewById(R.id.DYtautauM08);
        final CheckBox DYtautauM15to40 = findViewById(R.id.DYtautauM15);
        final CheckBox WenuWithB = findViewById(R.id.WenuWithB);
        final CheckBox WenuJetsBVeto = findViewById(R.id.WenuJetsBVeto);
        final CheckBox WenuNoJetsBVeto = findViewById(R.id.WenuNoJetsBVeto);
        final CheckBox WmunuWithB = findViewById(R.id.WmunuWithB);
        final CheckBox WmunuJetsBVeto = findViewById(R.id.WmunuJetsBVeto);
        final CheckBox WmunuNoJetsBVeto = findViewById(R.id.WmunuNoJetsBVeto);
        final CheckBox WtaunuWithB = findViewById(R.id.WtaunuWithB);
        final CheckBox WtaunuJetsBVeto = findViewById(R.id.WtaunuJetsBVeto);
        final CheckBox WtaunuNoJetsBVeto = findViewById(R.id.WtaunuNoJetsBVeto);
        final CheckBox ZPrime400 = findViewById(R.id.ZPrime400);
        final CheckBox ZPrime500 = findViewById(R.id.ZPrime500);
        final CheckBox ZPrime750 = findViewById(R.id.ZPrime750);
        final CheckBox ZPrime1000 = findViewById(R.id.ZPrime1000);
        final CheckBox ZPrime1250 = findViewById(R.id.ZPrime1250);
        final CheckBox ZPrime1500 = findViewById(R.id.ZPrime1500);
        final CheckBox ZPrime1750 = findViewById(R.id.ZPrime1750);
        final CheckBox ZPrime2000 = findViewById(R.id.ZPrime2000);
        final CheckBox ZPrime2250 = findViewById(R.id.ZPrime2250);
        final CheckBox ZPrime2500 = findViewById(R.id.ZPrime2500);
        final CheckBox ZPrime3000 = findViewById(R.id.ZPrime3000);
        final CheckBox data_Egamma = findViewById(R.id.data_Egamma);
        final CheckBox data_Muons = findViewById(R.id.data_Muons);

        HashMap<String, CheckBox> allchk = new HashMap<>();
        allchk.put("WW", WW);
        allchk.put("ZZ", ZZ);
        allchk.put("WZ", WZ);
        allchk.put("stop_tchan_top", stop_tchan_top);
        allchk.put("stop_tchan_antitop", stop_tchan_antitop);
        allchk.put("stop_schan", stop_schan);
        allchk.put("stop_wtchan", stop_wtchan);
        allchk.put("ttbar_had", ttbar_had);
        allchk.put("ttbar_lep", ttbar_lep);
        allchk.put("Zee", Zee);
        allchk.put("Zmumu", Zmumu);
        allchk.put("Ztautau", Ztautau);
        allchk.put("DYeeM08to15", DYeeM08to15);
        allchk.put("DYeeM15to40", DYeeM15to40);
        allchk.put("DYmumuM08to15", DYmumuM08to15);
        allchk.put("DYmumuM15to40", DYmumuM15to40);
        allchk.put("DYtautauM08to15", DYtautauM08to15);
        allchk.put("DYtautauM15to40", DYtautauM15to40);
        allchk.put("WenuWithB", WenuWithB);
        allchk.put("WenuJetsBVeto", WenuJetsBVeto);
        allchk.put("WenuNoJetsBVeto", WenuNoJetsBVeto);
        allchk.put("WmunuWithB", WmunuWithB);
        allchk.put("WmunuJetsBVeto", WmunuJetsBVeto);
        allchk.put("WmunuNoJetsBVeto", WmunuNoJetsBVeto);
        allchk.put("WtaunuWithB", WtaunuWithB);
        allchk.put("WtaunuJetsBVeto", WtaunuJetsBVeto);
        allchk.put("WtaunuNoJetsBVeto", WtaunuNoJetsBVeto);
        allchk.put("ZPrime400", ZPrime400);
        allchk.put("ZPrime500", ZPrime500);
        allchk.put("ZPrime750", ZPrime750);
        allchk.put("ZPrime1000", ZPrime1000);
        allchk.put("ZPrime1250", ZPrime1250);
        allchk.put("ZPrime1500", ZPrime1500);
        allchk.put("ZPrime1750", ZPrime1750);
        allchk.put("ZPrime2000", ZPrime2000);
        allchk.put("ZPrime2250", ZPrime2250);
        allchk.put("ZPrime2500", ZPrime2500);
        allchk.put("ZPrime3000", ZPrime3000);
        allchk.put("data_Egamma", data_Egamma);
        allchk.put("data_Muons", data_Muons);

        for (String string : allchk.keySet()) {
            final String sample = "___" +string;
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

        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalysisKey analysisKey = new AnalysisKey(key);
                key = analysisKey.getKey(samples_list);
                Intent goToTab = new Intent(Analysis_samples.this, Analysis_results.class);
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
        CheckBox dibos = findViewById(R.id.diboson);
        CheckBox stop = findViewById(R.id.stop);
        CheckBox ttbar = findViewById(R.id.ttbar);
        CheckBox Zjets = findViewById(R.id.Zjets);
        CheckBox drellYan = findViewById(R.id.DrellYan);
        CheckBox Wjets = findViewById(R.id.Wjets);
        CheckBox Zprime = findViewById(R.id.Zprime);
        CheckBox data = findViewById(R.id.data);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
            samples_list.clear();
        }
        else {
            cl.setVisibility(View.GONE);
            if (dibos.isChecked()) {
                dibos.toggle();
                dibosonSamples(view);
            }
            if (stop.isChecked()) {
                stop.toggle();
                stopSamples(view);
            }
            if (ttbar.isChecked()) {
                ttbar.toggle();
                ttbarSamples(view);
            }
            if (Zjets.isChecked()) {
                Zjets.toggle();
                ZjetsSamples(view);
            }
            if (drellYan.isChecked()) {
                drellYan.toggle();
                DrellYanSamples(view);
            }
            if (Wjets.isChecked()) {
                Wjets.toggle();
                WjetsSamples(view);
            }
            if (Zprime.isChecked()) {
                Zprime.toggle();
                ZprimeSamples(view);
            }
            if (data.isChecked()) {
                data.toggle();
                dataSamples(view);
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

    /**
     * On toggle, set visibility of sample checkboxes depending on current visibility. If checkboxes
     * are gone, iterate over them and uncheck them.
     * @param view "Diboson processes:" CheckBox
     */
    public void dibosonSamples(View view) {
        ConstraintLayout cl = findViewById(R.id.diboson_layout);
        CheckBox chk1 = findViewById(R.id.WW);
        CheckBox chk2 = findViewById(R.id.ZZ);
        CheckBox chk3 = findViewById(R.id.WZ);
        ArrayList<CheckBox> list = new ArrayList<>();
        list.add(chk1);
        list.add(chk2);
        list.add(chk3);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        }
        else {
            cl.setVisibility(View.GONE);
            chkIterator(list);
        }
    }

    public void stopSamples(View view) {
        ConstraintLayout cl = findViewById(R.id.stop_layout);
        CheckBox chk1 = findViewById(R.id.stop_tchan_top);
        CheckBox chk2 = findViewById(R.id.stop_tchan_antitop);
        CheckBox chk3 = findViewById(R.id.stop_schan);
        CheckBox chk4 = findViewById(R.id.stop_wtchan);
        ArrayList<CheckBox> list = new ArrayList<>();
        list.add(chk1);
        list.add(chk2);
        list.add(chk3);
        list.add(chk4);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        }
        else {
            cl.setVisibility(View.GONE);
            chkIterator(list);
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

    public void ZjetsSamples(View view) {
        ConstraintLayout cl = findViewById(R.id.Zjets_layout);
        CheckBox chk1 = findViewById(R.id.Zee);
        CheckBox chk2 = findViewById(R.id.Zmumu);
        CheckBox chk3 = findViewById(R.id.Ztautau);
        ArrayList<CheckBox> list = new ArrayList<>();
        list.add(chk1);
        list.add(chk2);
        list.add(chk3);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        }
        else {
            cl.setVisibility(View.GONE);
            chkIterator(list);
        }
    }

    public void DrellYanSamples(View view) {
        ConstraintLayout cl = findViewById(R.id.DrellYan_layout);
        CheckBox chk1 = findViewById(R.id.DYeeM08);
        CheckBox chk2 = findViewById(R.id.DYeeM15);
        CheckBox chk3 = findViewById(R.id.DYmumuM08);
        CheckBox chk4 = findViewById(R.id.DYmumuM15);
        CheckBox chk5 = findViewById(R.id.DYtautauM08);
        CheckBox chk6 = findViewById(R.id.DYtautauM15);
        ArrayList<CheckBox> list = new ArrayList<>();
        list.add(chk1);
        list.add(chk2);
        list.add(chk3);
        list.add(chk4);
        list.add(chk5);
        list.add(chk6);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        }
        else {
            cl.setVisibility(View.GONE);
            chkIterator(list);
        }
    }

    public void WjetsSamples(View view) {
        ConstraintLayout cl = findViewById(R.id.Wjets_layout);
        CheckBox chk1 = findViewById(R.id.WenuWithB);
        CheckBox chk2 = findViewById(R.id.WenuJetsBVeto);
        CheckBox chk3 = findViewById(R.id.WenuNoJetsBVeto);
        CheckBox chk4 = findViewById(R.id.WmunuWithB);
        CheckBox chk5 = findViewById(R.id.WmunuJetsBVeto);
        CheckBox chk6 = findViewById(R.id.WmunuNoJetsBVeto);
        CheckBox chk7 = findViewById(R.id.WtaunuWithB);
        CheckBox chk8 = findViewById(R.id.WtaunuJetsBVeto);
        CheckBox chk9 = findViewById(R.id.WtaunuNoJetsBVeto);
        ArrayList<CheckBox> list = new ArrayList<>();
        list.add(chk1);
        list.add(chk2);
        list.add(chk3);
        list.add(chk4);
        list.add(chk5);
        list.add(chk6);
        list.add(chk7);
        list.add(chk8);
        list.add(chk9);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        }
        else {
            cl.setVisibility(View.GONE);
            chkIterator(list);
        }
    }

    public void ZprimeSamples(View view) {
        ConstraintLayout cl = findViewById(R.id.Zprime_layout);
        CheckBox chk1 = findViewById(R.id.ZPrime400);
        CheckBox chk2 = findViewById(R.id.ZPrime500);
        CheckBox chk3 = findViewById(R.id.ZPrime750);
        CheckBox chk4 = findViewById(R.id.ZPrime1000);
        CheckBox chk5 = findViewById(R.id.ZPrime1250);
        CheckBox chk6 = findViewById(R.id.ZPrime1500);
        CheckBox chk7 = findViewById(R.id.ZPrime1750);
        CheckBox chk8 = findViewById(R.id.ZPrime2000);
        CheckBox chk9 = findViewById(R.id.ZPrime2250);
        CheckBox chk10 = findViewById(R.id.ZPrime2500);
        CheckBox chk11 = findViewById(R.id.ZPrime3000);
        ArrayList<CheckBox> list = new ArrayList<>();
        list.add(chk1);
        list.add(chk2);
        list.add(chk3);
        list.add(chk4);
        list.add(chk5);
        list.add(chk6);
        list.add(chk7);
        list.add(chk8);
        list.add(chk9);
        list.add(chk10);
        list.add(chk11);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        }
        else {
            cl.setVisibility(View.GONE);
            chkIterator(list);
        }
    }

    public void dataSamples(View view) {
        ConstraintLayout cl = findViewById(R.id.data_layout);
        CheckBox chk1 = findViewById(R.id.data_Egamma);
        CheckBox chk2 = findViewById(R.id.data_Muons);
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