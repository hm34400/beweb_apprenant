package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespierre.beweb.mobile.apprenants.DetailApprenantActivity;
import fr.fondespierre.beweb.mobile.apprenants.R;

/**
 * Created by hicham on 06/07/17.
 */

public class ListeProjetAdapter extends ArrayAdapter {
    private final Activity activity;
    private int resource = R.layout.projets_item;
    private JSONArray projets;

    public ListeProjetAdapter(@NonNull Activity activity, @LayoutRes int resource, JSONArray liste){
        super(activity.getApplicationContext(),resource);
        this.activity = activity;
        this.projets = liste;
    }



    @Override
    public int getCount() {
        return projets.length();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int index = position;
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(resource,null);

        TextView textNom = (TextView)convertView.findViewById(R.id.projetItem_textView_nom_projet);
        TextView textGit = (TextView)convertView.findViewById(R.id.projetItem_textView_github);
        TextView textSkills = (TextView)convertView.findViewById(R.id.projetItem_textView_skills);
        TextView textSiteWeb = (TextView)convertView.findViewById(R.id.projetItem_textView_siteWeb);
        TextView textDetail = (TextView)convertView.findViewById(R.id.projetItem_textView_description);

        try {
            textNom.setText(projets.getJSONObject(position).getString("nom"));
            textGit.setText(projets.getJSONObject(position).getString("github"));
            textSkills.setText(projets.getJSONObject(position).getString("skill"));
            textSiteWeb.setText(projets.getJSONObject(position).getString("siteWeb"));
            textDetail.setText(projets.getJSONObject(position).getString("Detail"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return convertView;
    }
}
