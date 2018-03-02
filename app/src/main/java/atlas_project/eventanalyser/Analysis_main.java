package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.*;

public class Analysis_main extends AppCompatActivity {
    public int lept_no = 0;
    public int lept_charge = 0;
    public int lept_flavour = 0;
    public int lept_min_mass = 0;
    public int lept_max_mass = 200;
    public int lept_mom = 25;
    public int jets_no_min = 0;
    public int jets_no_max = 9;
    public int bTag_jets_no_min = 0;
    public int bTag_jets_no_max = 9;
    public int missing_trans_mom_min = 0;
    public int missing_trans_mom_max = 200;
    public int percent_data = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_analysis_main);

        final SeekBar lept_no_sb = findViewById(R.id.lept_no_sb);
        final RadioButton lept_charge_same = findViewById(R.id.charge_same);
        final RadioButton lept_charge_diff = findViewById(R.id.charge_different);
        final SeekBar lept_min_mass_sb = findViewById(R.id.lept_mass_min_sb);
        final SeekBar lept_max_mass_sb = findViewById(R.id.lept_mass_max_sb);
        final SeekBar lept_mom_sb = findViewById(R.id.lept_mom_sb);
        final SeekBar jets_no_min_sb = findViewById(R.id.jets_no_min_sb);
        final SeekBar jets_no_max_sb = findViewById(R.id.jets_no_max_sb);
        final SeekBar bTag_jets_min_sb = findViewById(R.id.bTag_jets_min_sb);
        final SeekBar bTag_jets_max_sb = findViewById(R.id.bTag_jets_max_sb);
        final SeekBar miss_mom_min_sb = findViewById(R.id.miss_mom_min_sb);
        final SeekBar miss_mom_max_sb = findViewById(R.id.miss_mom_max_sb);
        final SeekBar percent_data_sb = findViewById(R.id.percent_sb);
        final Button aButton = findViewById(R.id.analyse_button);

        lept_no_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lept_no = progress;
                leptMassSeekBar();
                leptChargeFlavour();
            }
        });

        lept_min_mass_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lept_min_mass = progress*50;
            }
        });

        lept_max_mass_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lept_max_mass = progress*50;
            }
        });

        lept_mom_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lept_mom = progress*25;
            }
        });

        final TextView tv_bTag_min = findViewById(R.id.bTag_no_min_9);
        final TextView tv_bTag_max = findViewById(R.id.bTag_no_max_9);
        final CheckBox chk_bTag = findViewById(R.id.bTag_jets);
        jets_no_min_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (jets_no_min == 0 & jets_no_max ==0) {
                    chk_bTag.setVisibility(View.GONE);
                    //reset min. transverse lepton momentum checkbox
                    if(chk_bTag.isChecked()){
                        chk_bTag.toggle();
                        bTagJetsSeekBar(chk_bTag);
                    }
                }
                else if (chk_bTag.getVisibility() == View.GONE) {
                    chk_bTag.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(jets_no_min <= jets_no_max) {
                    jets_no_min = progress;
                }
                else if (jets_no_min > jets_no_max){
                    jets_no_min = jets_no_max;
                }
                bTag_jets_max_sb.setMax(jets_no_max);
                bTag_jets_min_sb.setMax(jets_no_max);
                tv_bTag_min.setText(String.valueOf(jets_no_max));
                tv_bTag_max.setText(String.valueOf(jets_no_max));
            }
        });

        jets_no_max_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (jets_no_min == 0 & jets_no_max ==0) {
                    chk_bTag.setVisibility(View.GONE);
                    //reset min. transverse lepton momentum checkbox
                    if(chk_bTag.isChecked()){
                        chk_bTag.toggle();
                        bTagJetsSeekBar(chk_bTag);
                    }
                }
                else if (chk_bTag.getVisibility() == View.GONE) {
                    chk_bTag.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(jets_no_max >= jets_no_min) {
                    jets_no_max = progress;
                }
                else if (jets_no_max < jets_no_min){
                    jets_no_max = jets_no_min;
                }
                bTag_jets_max_sb.setMax(jets_no_max);
                bTag_jets_min_sb.setMax(jets_no_max);
                tv_bTag_min.setText(String.valueOf(jets_no_max));
                tv_bTag_max.setText(String.valueOf(jets_no_max));
            }
        });

        bTag_jets_min_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(bTag_jets_no_min <= bTag_jets_no_max) {
                    bTag_jets_no_min = progress;
                }
                else if (bTag_jets_no_min > bTag_jets_no_max){
                    bTag_jets_no_min = bTag_jets_no_max;
                }
            }
        });

        bTag_jets_max_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(bTag_jets_no_max >= bTag_jets_no_min) {
                    bTag_jets_no_max = progress;
                }
                else if (bTag_jets_no_max < bTag_jets_no_min){
                    bTag_jets_no_max = bTag_jets_no_min;
                }
            }
        });

        miss_mom_min_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(missing_trans_mom_min <= missing_trans_mom_max) {
                    missing_trans_mom_min = progress;
                }
                else if (missing_trans_mom_min > missing_trans_mom_max){
                    missing_trans_mom_min = missing_trans_mom_max;
                }
            }
        });

        miss_mom_max_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(missing_trans_mom_max >= missing_trans_mom_min) {
                    missing_trans_mom_max = progress;
                }
                else if (missing_trans_mom_max < missing_trans_mom_min){
                    missing_trans_mom_max = missing_trans_mom_min;
                }
            }
        });

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

        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Analysis_main.this, Menu.class);
                startActivity(goToTab);
            }
        });
    }

    /**
     * When checkbox "Number of charged leptons:" is checked show SeekBar for choosing number of
     * leptons (set initially to progress 0) and checkbox "Minimum transverse momentum (GeV):".
     * When checkbox is unchecked hide SeekBar, uncheck "Minimum..." checkbox and reset SeekBar
     * attached to it.
     * @param view ckeckbox "Number of charged leptons:"
     */
    public void leptSeekBar(View view) {
        SeekBar sb1 = findViewById(R.id.lept_no_sb);
        CheckBox chk1 = findViewById(R.id.min_trans_lept_mom);
        ConstraintLayout cl = findViewById(R.id.lept_no_labels_layout);
        //set visibility of SeekBar depending on current visibility
        if (cl.getVisibility() == View.GONE) {
            chk1.setVisibility(View.VISIBLE);
            cl.setVisibility(View.VISIBLE);
        } else {
            sb1.setProgress(0);
            chk1.setVisibility(View.GONE);
            cl.setVisibility(View.GONE);
            //reset min. transverse lepton momentum checkbox
            if(chk1.isChecked()){
                chk1.toggle();
                leptMomSeekBar(view);
            }
        }
    }

    /**
     *
     */
    public void leptMassSeekBar() {
        TextView tv1 = findViewById(R.id.lept_mass_min);
        TextView tv2 = findViewById(R.id.lept_mass_max);
        SeekBar sb1 = findViewById(R.id.lept_mass_min_sb);
        SeekBar sb2 = findViewById(R.id.lept_mass_max_sb);
        ConstraintLayout cl = findViewById(R.id.lept_mass_min_labels_layout);
        ConstraintLayout cl2 = findViewById(R.id.lept_mass_max_labels_layout);
        //set visibility of SeekBar depending on lepton number
        if (lept_no == 1 || lept_no == 3) {
            tv1.setVisibility(View.VISIBLE);
            tv2.setVisibility(View.VISIBLE);
            cl.setVisibility(View.VISIBLE);
            cl2.setVisibility(View.VISIBLE);
        }
        else {
            tv1.setVisibility(View.GONE);
            tv2.setVisibility(View.GONE);
            cl.setVisibility(View.GONE);
            cl2.setVisibility(View.GONE);
            sb1.setProgress(0);
            sb2.setProgress(4);
        }
    }

    /**
     * When lepton number is 2, 3, or 4, show checkboxes "Choose lepton charge" and "Choose lepton
     * flavour". Otherwise, hide checkboxes.
     */
    public void leptChargeFlavour() {
        TextView chk1 = findViewById(R.id.lept_charge_chk);
        TextView chk2 = findViewById(R.id.lept_flavour_chk);
        //set visibility of SeekBar depending on lepton number
        if (lept_no == 2 || lept_no == 3 || lept_no == 4) {
            chk1.setVisibility(View.VISIBLE);
            chk2.setVisibility(View.VISIBLE);
        }
        else {
            chk1.setVisibility(View.GONE);
            chk2.setVisibility(View.GONE);
        }
    }

    /**
     * @param view checkbox "Choose lepton charge"
     */
    public void leptCharge(View view) {
        ConstraintLayout cl = findViewById(R.id.charge_rb_layout);
        RadioButton rb1 = findViewById(R.id.charge_same);
        RadioButton rb2 = findViewById(R.id.charge_different);
        //set SeekBar visibility depending on current visibility
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        } else {
            cl.setVisibility(View.GONE);
            if (rb1.isChecked()) {
                rb1.setChecked(false);
            }
            if (rb2.isChecked()) {
                rb2.setChecked(false);
            }
        }
    }

    /**
     * @param view checkbox "Choose lepton flavour"
     */
    public void leptFlavour(View view) {
        ConstraintLayout cl = findViewById(R.id.flavour_rb_layout);
        RadioButton rb1 = findViewById(R.id.flavour_same);
        RadioButton rb2 = findViewById(R.id.flavour_different);
        //set SeekBar visibility depending on current visibility
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        } else {
            cl.setVisibility(View.GONE);
            if (rb1.isChecked()) {
                rb1.setChecked(false);
            }
            if (rb2.isChecked()) {
                rb2.setChecked(false);
            }
        }
    }

    /**
     * When checkbox "Minimum transverse momentum (GeV):" is checked show SeekBar for choosing
     * minimum transverse momentum (set initially to progress 1). When unchecked reset progress, and
     * hide SeekBar.
     * @param view checkbox "Minimum transverse momentum (GeV):"
     */
    public void leptMomSeekBar(View view) {
        ConstraintLayout cl = findViewById(R.id.min_trans_labels_layout);
        SeekBar sb1 = findViewById(R.id.lept_mom_sb);
        //set SeekBar visibility depending on current visibility
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
        } else {
            cl.setVisibility(View.GONE);
            sb1.setProgress(1);
        }
    }

    /**
     * When checkbox "Number of jets:" is checked show SeekBar for choosing minimum and maximum
     * number of jets and checkbox for selecting number of jets that are b-tagged. When unchecked,
     * reset progress, hide SeekBars and "Any b-tagged jets?" checkbox, and run bTagJetsSeekBar()
     * method.
     * @param view checkbox "Number of jets:"
     */
    public void jetNoSeekBar(View view) {
        //ConstraintLayouta nd SeekBar for minimum number of jets
        ConstraintLayout cl = findViewById(R.id.jet_min_labels_layout);
        SeekBar sb1 = findViewById(R.id.jets_no_min_sb);
        //ConstraintLayout and SeekBar for maximum number of jets
        ConstraintLayout cl2 = findViewById(R.id.jet_max_labels_layout);
        SeekBar sb2 = findViewById(R.id.jets_no_max_sb);
        //checkbox for selecting number of jets that are b-tagged
        CheckBox chk1 = findViewById(R.id.bTag_jets);

        //set visibility depending on current visibility and reset progress and checkbox if gone
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
            cl2.setVisibility(View.VISIBLE);
            chk1.setVisibility(View.VISIBLE);
        } else {
            cl.setVisibility(View.GONE);
            sb1.setProgress(0);
            cl2.setVisibility(View.GONE);
            sb2.setProgress(9);
            chk1.setVisibility(View.GONE);
            //reset min. transverse lepton momentum checkbox
            if(chk1.isChecked()){
                chk1.toggle();
                bTagJetsSeekBar(view);
            }
        }
    }

    /**
     * When checkbox "Any b-tagged jets?" is checked show SeekBar for choosing minimum and maximum
     * number of b-tagged jets. When unchecked, reset progress and hide SeekBars.
     * @param view checkbox "Any b-tagged jets?"
     */
    public void bTagJetsSeekBar(View view) {
        SeekBar sb1 = findViewById(R.id.bTag_jets_min_sb);
        SeekBar sb2 = findViewById(R.id.bTag_jets_max_sb);
        ConstraintLayout cl = findViewById(R.id.bTag_min_labels_layout);
        ConstraintLayout cl2 = findViewById(R.id.bTag_max_labels_layout);
        //set visibility depending on current visibility
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
            cl2.setVisibility(View.VISIBLE);
        } else {
            cl.setVisibility(View.GONE);
            sb1.setProgress(0);

            cl2.setVisibility(View.GONE);
            sb2.setProgress(0);
        }
    }

    /**
     * when checkbox "Missing transverse momentum (GeV):" is checked show SeekBars for choosing
     * maximum and minimum missing transverse momentum. when unchecked, reset progress and hide
     * SeekBars.
     * @param view checkbox "Missing transverse momentum (GeV):"
     */
    public void missTransMomSeekBar(View view) {
        //ConstraintLayout and SeekBar for minimum missing transverse momentum
        ConstraintLayout cl = findViewById(R.id.miss_mom_min_labels_layout);
        SeekBar sb1 = findViewById(R.id.miss_mom_min_sb);
        //ConstraintLayout and SeekBar for maximum missing transverse momentum
        ConstraintLayout cl2 = findViewById(R.id.miss_mom_max_labels_layout);
        SeekBar sb2 = findViewById(R.id.miss_mom_max_sb);

        //set visibility depending on current visibility and reset progress if vis = gone
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
            cl2.setVisibility(View.VISIBLE);
        } else {
            cl.setVisibility(View.GONE);
            sb1.setProgress(0);
            cl2.setVisibility(View.GONE);
            sb2.setProgress(4);
        }
    }

    /**
     * When "analyse" button is clicked compile variables into a string, navigate to results.
     * @param view button "Analyse"
     */
    public void analyse(View view) {
        //TODO constructs string from int variables
    }
}
