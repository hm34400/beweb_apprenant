package fr.fondespierre.beweb.mobile.apprenants;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeApprenantAdapter;
import fr.fondespierre.beweb.mobile.apprenants.dal.Datas;

/**
 * Created by hicham on 04/07/17.
 */



public class ListeApprenantsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_apprenants);
//  Declaration our variable
        final ListView listeApprenant = (ListView)findViewById(R.id.listeApprenant);
        final JSONArray listeDatas = null;
        final Activity activity = this;
//we initialize our queries
        RequestQueue request = Volley.newRequestQueue(this);
//we put our request in a variable
        String url = "http://192.168.1.48/beweb_api/index.php/";
//we store the request fo type GET + apprenants + reponse
        JsonArrayRequest jr = new JsonArrayRequest(Request.Method.GET, url + "apprenants", listeDatas, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                /**
                 * you create a list of learning objects to display in the view
                 */
                ListeApprenantAdapter adapter = new ListeApprenantAdapter(activity,R.layout.liste_apprenant_item,response);

                listeApprenant.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
//then add the variable jr in the query
        request.add(jr);

//        try {
//            listeDatas = Datas.getApprenants();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//        ArrayAdapter adapter = new ListeApprenantAdapter(this,0,listeDatas);
//
//        listeApprenant.setAdapter(adapter);
//
//        try {
//            JSONArray a1 = Datas.getApprenants();
////            System.out.println("nom de l'apprenant a l'id 1 :" +a1.getJSONObject(1).getString("nom"));
//        } catch (JSONException e) {
//            System.out.println("Marche pas");
//            e.printStackTrace();
//        }



    }
}
