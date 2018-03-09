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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_analysis_main);

        final SeekBar lept_no_sb = findViewById(R.id.lept_no_sb);
        final RadioGroup lept_charge_rg = findViewById(R.id.charge_rg);
        final RadioButton lept_charge_same = findViewById(R.id.charge_same);
        final RadioButton lept_charge_diff = findViewById(R.id.charge_different);
        final RadioGroup lept_flavour_rg = findViewById(R.id.flavour_rg);
        final RadioButton lept_flavour_same = findViewById(R.id.flavour_same);
        final RadioButton lept_flavour_diff = findViewById(R.id.flavour_different);
        final SeekBar lept_inv_mass1_sb = findViewById(R.id.inv_mass1_sb);
        final SeekBar lept_inv_mass2_sb = findViewById(R.id.inv_mass2_sb);
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
                leptInvMass();
            }
        });

        lept_charge_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (lept_charge_same.isChecked()) {
                    lept_charge = 1;
                }
                if (lept_charge_diff.isChecked()) {
                    lept_charge = -1;
                }
            }
        });

        lept_flavour_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (lept_flavour_same.isChecked()) {
                    lept_flavour = 1;
                }
                if (lept_flavour_diff.isChecked()) {
                    lept_flavour = -1;
                }
            }
        });

        lept_inv_mass1_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lept_1_inv_mass = progress*50;
            }
        });

        lept_inv_mass2_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lept_2_inv_mass = progress*50;
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
                analyse();
                Intent goToTab = new Intent(Analysis_main.this, Analysis_samples.class);
                goToTab.putExtra("HistKey", key);
                startActivity(goToTab);
            }
        });
    }

    /**
     * When "analyse" button is clicked compile variables into a string, navigate to choose samples.
     */
    public void analyse() {
        key = "__nlep_val-" +lept_no+ "__LepTmass_val-" +lept_min_mass+ "__LepTmassMax_val-"
                +lept_max_mass+ "__InvariantM_val-" +lept_1_inv_mass+ "__InvariantM2_val-"
                +lept_2_inv_mass+ "__Range_val-" +lept_err_inv_mass+ "__leppt_val-" +lept_mom+
                "__minnjet_val-" +jets_no_min+ "__maxnjet_val-" +jets_no_max+ "__btagmin_val-"
                +bTag_jets_no_min+ "__btagmax_val-" +bTag_jets_no_max+ "__minmissE_val-"
                +missing_trans_mom_min+ "__maxmissE_val-" +missing_trans_mom_max+ "__percentg_val-"
                + percent_data + ".0__TwoLepcharge_val-" +lept_charge+ "__TwoLepflavour_val-"
                +lept_flavour+ "__st_lepchargecb-" +lept_charge_chk+ "__st_lepflavourcb-"
                +lept_flavour_chk+ "__st_InvMasscb-" +lept_inv_mass_chk+ "__st_lepptcb-"
                +lept_mom_chk+ "__st_btagjetcb-" +bTag_jets_chk+ "__st_lepcb-" +lept_no_chk+
                "__st_jetcb-" +jets_chk+ "__st_missPcb-" +missing_trans_chk;
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
        CheckBox chk2 = findViewById(R.id.lept_charge_chk);
        CheckBox chk3 = findViewById(R.id.lept_flavour_chk);
        ConstraintLayout cl = findViewById(R.id.lept_no_labels_layout);
        //set visibility of SeekBar depending on current visibility
        if (cl.getVisibility() == View.GONE) {
            chk1.setVisibility(View.VISIBLE);
            cl.setVisibility(View.VISIBLE);
            lept_no_chk = 1;
        } else {
            sb1.setProgress(0);
            chk1.setVisibility(View.GONE);
            cl.setVisibility(View.GONE);
            lept_no_chk = 0;
            //reset min. transverse lepton momentum checkbox
            if(chk1.isChecked()){
                chk1.toggle();
                leptMomSeekBar(view);
            }
            //reset choose lepton charge checkbox
            if(chk2.isChecked()){
                chk2.toggle();
                leptCharge(view);
            }
            //reset choose lepton flavour checkbox
            if(chk3.isChecked()){
                chk3.toggle();
                leptFlavour(view);
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
        CheckBox chk1 = findViewById(R.id.lept_charge_chk);
        CheckBox chk2 = findViewById(R.id.lept_flavour_chk);
        RadioGroup rg1 = findViewById(R.id.charge_rg);
        RadioGroup rg2 = findViewById(R.id.flavour_rg);
        //set visibility of SeekBar depending on lepton number
        if (lept_no == 2 || lept_no == 3 || lept_no == 4) {
            chk1.setVisibility(View.VISIBLE);
            chk2.setVisibility(View.VISIBLE);
        }
        else {
            chk1.setVisibility(View.GONE);
            chk2.setVisibility(View.GONE);
            if (chk1.isChecked()) {
                chk1.toggle();
                rg1.setVisibility(View.GONE);
                rg1.clearCheck();
            }
            if (chk2.isChecked()) {
                chk2.toggle();
                rg2.setVisibility(View.GONE);
                rg2.clearCheck();
            }
        }
    }

    /**
     * @param view checkbox "Choose lepton charge"
     */
    public void leptCharge(View view) {
        RadioGroup rg1 = findViewById(R.id.charge_rg);
        //set SeekBar visibility depending on current visibility
        if (rg1.getVisibility() == View.GONE) {
            rg1.setVisibility(View.VISIBLE);
            lept_charge_chk = 1;
        } else {
            rg1.setVisibility(View.GONE);
            rg1.clearCheck();
            lept_charge_chk = 0;
        }
    }

    /**
     * @param view checkbox "Choose lepton flavour"
     */
    public void leptFlavour(View view) {
        RadioGroup rg1 = findViewById(R.id.flavour_rg);
        //set SeekBar visibility depending on current visibility
        if (rg1.getVisibility() == View.GONE) {
            rg1.setVisibility(View.VISIBLE);
            lept_flavour_chk = 1;
        } else {
            rg1.setVisibility(View.GONE);
            rg1.clearCheck();
            lept_flavour_chk = 0;
        }
    }

    /**
     *
     */
    public void leptInvMass() {
        CheckBox chk1 = findViewById(R.id.inv_mass_pair1);
        CheckBox chk2 = findViewById(R.id.inv_mass_pair2);
        ConstraintLayout cl = findViewById(R.id.inv_mass1_layout);
        ConstraintLayout cl2 = findViewById(R.id.inv_mass2_layout);
        SeekBar sb1 = findViewById(R.id.inv_mass1_sb);
        SeekBar sb2 = findViewById(R.id.inv_mass2_sb);
        //set visibility of SeekBar depending on lepton number
        if (lept_no == 2 || lept_no == 3 || lept_no == 4) {
            chk1.setVisibility(View.VISIBLE);
        }
        if (lept_no == 4) {
            chk2.setVisibility(View.VISIBLE);
        }
        if (lept_no != 4) {
            chk2.setVisibility(View.GONE);
            cl2.setVisibility(View.GONE);
            sb2.setProgress(0);
            if (chk2.isChecked()) {
                chk2.toggle();
            }
            if (!chk1.isChecked()) {
                lept_inv_mass_chk = 0;
            }
        }
        if (lept_no == 0 || lept_no == 1) {
            chk1.setVisibility(View.GONE);
            cl.setVisibility(View.GONE);
            sb1.setProgress(0);
            if (chk1.isChecked()) {
                chk1.toggle();
            }
            if (!chk2.isChecked()) {
                lept_inv_mass_chk = 0;
            }
        }
    }

    public void invMassPair1(View view) {
        ConstraintLayout cl = findViewById(R.id.inv_mass1_layout);
        SeekBar sb1 = findViewById(R.id.inv_mass1_sb);
        CheckBox chk1 = findViewById(R.id.inv_mass_pair2);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
            sb1.setVisibility(View.VISIBLE);
            lept_inv_mass_chk = 1;
        }
        else {
            cl.setVisibility(View.GONE);
            sb1.setVisibility(View.GONE);
            sb1.setProgress(0);
            if (!chk1.isChecked()) {
                lept_inv_mass_chk = 0;
            }
        }
    }

    public void invMassPair2(View view) {
        ConstraintLayout cl = findViewById(R.id.inv_mass2_layout);
        SeekBar sb1 = findViewById(R.id.inv_mass2_sb);
        CheckBox chk1 = findViewById(R.id.inv_mass_pair1);
        if (cl.getVisibility() == View.GONE) {
            cl.setVisibility(View.VISIBLE);
            sb1.setVisibility(View.VISIBLE);
            lept_inv_mass_chk = 1;
        }
        else {
            cl.setVisibility(View.GONE);
            sb1.setVisibility(View.GONE);
            sb1.setProgress(0);
            if (!chk1.isChecked()) {
                lept_inv_mass_chk = 0;
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
            lept_mom_chk = 1;
        } else {
            cl.setVisibility(View.GONE);
            sb1.setProgress(1);
            lept_mom_chk = 0;
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
            jets_chk = 1;
        }
        else {
            cl.setVisibility(View.GONE);
            sb1.setProgress(0);
            cl2.setVisibility(View.GONE);
            sb2.setProgress(9);
            chk1.setVisibility(View.GONE);
            jets_chk = 0;
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
            bTag_jets_chk = 1;
        } else {
            cl.setVisibility(View.GONE);
            sb1.setProgress(0);

            cl2.setVisibility(View.GONE);
            sb2.setProgress(0);
            bTag_jets_chk = 0;
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
            missing_trans_chk = 1;
        } else {
            cl.setVisibility(View.GONE);
            sb1.setProgress(0);
            cl2.setVisibility(View.GONE);
            sb2.setProgress(4);
            missing_trans_chk = 0;
        }
    }
}