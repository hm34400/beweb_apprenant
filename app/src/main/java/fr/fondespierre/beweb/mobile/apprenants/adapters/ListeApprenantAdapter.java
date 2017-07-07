package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import fr.fondespierre.beweb.mobile.apprenants.DetailApprenantActivity;
import fr.fondespierre.beweb.mobile.apprenants.ListeApprenantsActivity;
import fr.fondespierre.beweb.mobile.apprenants.R;
import fr.fondespierre.beweb.mobile.apprenants.dal.Datas;

/**
 * Created by hicham on 05/07/17.
 */

public class ListeApprenantAdapter extends ArrayAdapter {


    private final Activity activity;
    private final int resource = R.layout.liste_apprenant_item;
    private final JSONArray apprenants;


    public ListeApprenantAdapter(@NonNull Activity activity, @LayoutRes int resource, JSONArray liste){
        super(activity.getApplicationContext(), resource);
        this.activity = activity;
        this.apprenants = liste;
    }



    @Override
    public int getCount() {
        return apprenants.length();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int index = position;
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(resource,null);

        TextView textNom = (TextView)convertView.findViewById(R.id.laItem_textView_nom);
        TextView textPrenom = (TextView)convertView.findViewById(R.id.laItem_textView_prenom);
        ImageButton detail = (ImageButton)convertView.findViewById(R.id.laItem_button_more);

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(activity.getApplicationContext(), DetailApprenantActivity.class);
                    Datas.apprenant = apprenants.getJSONObject(index);

                    activity.startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });


        try {
            textNom.setText(apprenants.getJSONObject(position).getString("nom"));
            textPrenom.setText(apprenants.getJSONObject(position).getString("prenom"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
