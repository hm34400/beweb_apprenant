package fr.fondespierre.beweb.mobile.apprenants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeApprenantAdapter;
import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeProjetAdapter;
import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeSkillAdapter;
import fr.fondespierre.beweb.mobile.apprenants.dal.Datas;

/**
 * Created by hicham on 04/07/17.
 */

public class DetailApprenantActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_apprenant);



        try {
            JSONObject apprenant = Datas.apprenant;
            ((TextView)findViewById(R.id.detailA_nom)).setText(apprenant.getString("nom"));
            ((TextView)findViewById(R.id.detailA_prenom)).setText(apprenant.getString("prenom"));
            ((TextView)findViewById(R.id.detailA_age)).setText(apprenant.getString("age"));
        }catch (JSONException e) {
            e.printStackTrace();
        }

        ListView listeSkills = (ListView)findViewById(R.id.detailA_liste_skills);
        ListView listeProjets = (ListView)findViewById(R.id.detailA_liste_projet);

        ListeSkillAdapter skillAdapter = null;
        ListeSkillAdapter projetAdapter = null;

//        try {
//
//            skillAdapter = new ListeSkillAdapter(this,0,apprenant);
//            projetAdapter = new ListeProjetAdapter(this,0,apprenant);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        listeSkills.setAdapter(skillAdapter);
        listeProjets.setAdapter(projetAdapter);

    }
}
