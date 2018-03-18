package atlas_project.eventanalyser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Ania on 12/03/2018.
 */

public class AnalysisKey {
    public String key = ""; //key for fetching histograms (missing samples)

    AnalysisKey(String key) {this.key = key;}

    public String getValuesKey(int lept_no, int lept_charge, int lept_flavour, int lept_1_inv_mass,
                int lept_2_inv_mass, int lept_err_inv_mass, int lept_min_mass, int lept_max_mass,
                int lept_mom, int jets_no_min, int jets_no_max, int bTag_jets_no_min,
                int bTag_jets_no_max, int missing_trans_mom_min, int missing_trans_mom_max,
                int percent_data, int lept_charge_chk, int lept_flavour_chk, int lept_inv_mass_chk,
                int lept_mom_chk, int bTag_jets_chk, int lept_no_chk, int jets_chk,
                int missing_trans_chk) {

        key = "__nlep_val-" +lept_no+ "__LepTmass_val-" +(float)lept_min_mass+ "__LepTmassMax_val-"
                +(float)lept_max_mass+ "__InvariantM_val-" +(float)lept_1_inv_mass+ "__InvariantM2_val-"
                +(float)lept_2_inv_mass+ "__Range_val-" +(float)lept_err_inv_mass+ "__leppt_val-" +(float)lept_mom+
                "__minnjet_val-" +jets_no_min+ "__maxnjet_val-" +jets_no_max+ "__btagmin_val-"
                +bTag_jets_no_min+ "__btagmax_val-" +bTag_jets_no_max+ "__minmissE_val-"
                +(float)missing_trans_mom_min+ "__maxmissE_val-" +(float)missing_trans_mom_max+ "__percentg_val-"
                + percent_data + ".0__TwoLepcharge_val-" +lept_charge+ "__TwoLepflavour_val-"
                +lept_flavour+ "__st_lepchargecb-" +lept_charge_chk+ "__st_lepflavourcb-"
                +lept_flavour_chk+ "__st_InvMasscb-" +lept_inv_mass_chk+ "__st_lepptcb-"
                +lept_mom_chk+ "__st_btagjetcb-" +bTag_jets_chk+ "__st_lepcb-" +lept_no_chk+
                "__st_jetcb-" +jets_chk+ "__st_missPcb-" +missing_trans_chk+ "__samplesKey-";
        return key;
    }

    public String getKey(ArrayList<String> samples_list) {
        Collections.sort(samples_list);
        Iterator<String> itr = samples_list.iterator();
        while (itr.hasNext()) {
            key += itr.next();
        }
        return key;
    }
}
