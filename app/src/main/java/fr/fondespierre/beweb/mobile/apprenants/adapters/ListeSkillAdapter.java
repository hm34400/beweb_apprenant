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

import fr.fondespierre.beweb.mobile.apprenants.R;

/**
 * Created by hicham on 06/07/17.
 */

public class ListeSkillAdapter extends ArrayAdapter {
    private final Activity activity;
    private int resource = R.layout.skills_item;
    private final JSONArray skills;

    public ListeSkillAdapter(@NonNull Activity activity, @LayoutRes int resource, JSONArray liste) {
        super(activity.getApplicationContext(), resource);
        this.activity = activity;
        this.skills = liste;
    }

    @Override
    public int getCount() {
        return skills.length();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(resource,null);

        TextView textNom = (TextView)convertView.findViewById(R.id.skillsItem_textView_nom);
        try {
            textNom.setText(skills.getJSONObject(position).getString("nom"));
        } catch (JSONException e) {

        }
        return convertView;
    }
}
