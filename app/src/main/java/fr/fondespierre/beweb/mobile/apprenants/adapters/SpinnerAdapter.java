package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import org.json.JSONArray;

import fr.fondespierre.beweb.mobile.apprenants.R;

/**
 * Created by hicham on 07/07/17.
 */

public class SpinnerAdapter extends ArrayAdapter {
    private final Activity activity;
    private final int resource = R.layout.support_simple_spinner_dropdown_item;
    private final JSONArray skills;

    public SpinnerAdapter(@NonNull Activity activity, @LayoutRes int resource, JSONArray liste) {
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
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
