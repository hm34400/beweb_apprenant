package fr.fondespierre.beweb.mobile.apprenants.dal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespierre.beweb.mobile.apprenants.dal.enumeration.Status;

/**
 * Created by hicham on 05/07/17.
 */

public class Datas {

    public static JSONObject apprenant;

    /**
     * nos données mis en dur
     * @return
     * @throws JSONException
     */
    public static JSONArray getApprenants() throws JSONException {
            JSONArray apprenants = new JSONArray();
            JSONObject alex = new JSONObject();
            JSONObject jc = new JSONObject();
            JSONObject marie = new JSONObject();

            alex.putOpt("id",1);
            alex.putOpt("nom","LeForestier");
            alex.putOpt("prenom","Alexandre");
            alex.putOpt("age","30");
            alex.putOpt("promotion",1);
            alex.putOpt("session",1);
            alex.putOpt("status", Status.Chomage);

            jc.putOpt("id",2);
            jc.putOpt("nom","Petetin");
            jc.putOpt("prenom","Jean Christian");
            jc.putOpt("age","12");
            jc.putOpt("promotion",1);
            jc.putOpt("session",1);
            jc.putOpt("status",Status.Formation);

            marie.putOpt("id",3);
            marie.putOpt("nom","Urbano");
            marie.putOpt("prenom","Marie");
            marie.putOpt("age","5");
            marie.putOpt("promotion",2);
            marie.putOpt("session",1);
            marie.putOpt("status",Status.Formation);

            apprenants.put(alex);
            apprenants.put(jc);
            apprenants.put(marie);



            return apprenants;
    }

    public static JSONArray getPromotions() throws JSONException {
        JSONArray promotions = new JSONArray();
        JSONObject beweb1 = new JSONObject();
        JSONObject beweb2 = new JSONObject();
        JSONObject beweb3 = new JSONObject();

        beweb1.putOpt("id",1);
        beweb1.putOpt("ville","lunel");
        beweb2.putOpt("id",2);
        beweb2.putOpt("ville","lunel");
        beweb3.putOpt("id",3);
        beweb3.putOpt("ville","beziers");

        promotions.put(beweb1);
        promotions.put(beweb2);
        promotions.put(beweb3);

        return promotions;

    }
    public static JSONObject getPromotions(int id){
        JSONObject promotion = new JSONObject();
        return promotion;
    }
    public static JSONArray getProjets() throws JSONException {
        JSONArray projets = new JSONArray();
        JSONObject projet1 = new JSONObject();
        JSONObject projet2 = new JSONObject();
        JSONObject projet3 = new JSONObject();
        JSONObject projet4 = new JSONObject();

        projet1.putOpt("id",1);
        projet1.putOpt("nom","monprojet1");
        projet1.putOpt("apprenant",1);
        projet2.putOpt("id",2);
        projet2.putOpt("nom","monprojet2");
        projet2.putOpt("apprenant",1);
        projet3.putOpt("id",3);
        projet3.putOpt("nom","monprojet3");
        projet3.putOpt("apprenant",1);
        projet4.putOpt("id",4);
        projet4.putOpt("nom","monprojet4");
        projet4.putOpt("apprenant",1);

        projets.put(projet1);
        projets.put(projet2);
        projets.put(projet3);
        projets.put(projet4);

        return projets;

    }

    /**
     *
     * @param apprenantID
     * @return
     * @throws JSONException
     */
    public static JSONArray getProjets(int apprenantID) throws JSONException{
        JSONArray projets = Datas.getProjets();
        JSONArray projetsApprenant = new JSONArray();
        for(int i=0;i<projets.length();i++){
            if(projets.getJSONObject(i).getInt("apprenant") == apprenantID){
                projetsApprenant.put(projets.getJSONObject(i));
            }
        }
        return projetsApprenant;

    }

    public static JSONArray getSkills() throws JSONException {

        JSONArray skills = new JSONArray();
        JSONObject skill1 = new JSONObject();
        JSONObject skill2 = new JSONObject();
        JSONObject skill3 = new JSONObject();
        JSONObject skill4 = new JSONObject();

        skill1.putOpt("id",1);
        skill1.putOpt("nom","html");
        skill1.putOpt("apprenant",1);

        skill2.putOpt("id",2);
        skill2.putOpt("nom","javascript");
        skill1.putOpt("apprenant",1);

        skill3.putOpt("id",3);
        skill3.putOpt("nom","css");
        skill1.putOpt("apprenant",1);

        skill4.putOpt("id",4);
        skill4.putOpt("nom","php");
        skill1.putOpt("apprenant",1);

        skills.put(skill1);
        skills.put(skill2);
        skills.put(skill3);
        skills.put(skill4);


        return skills;


    }

    /**
     *
     * @param apprenantID
     * @return
     * @throws JSONException
     */
    public static JSONArray getSkills(int apprenantID) throws JSONException {
        JSONArray skills = Datas.getSkills();
        JSONArray skillsApprenant = new JSONArray();
        for(int i=0;i<skills.length();i++){
            if(skills.getJSONObject(i).getInt("apprenant") == apprenantID){
                skillsApprenant.put(skills.getJSONObject(i));
            }
        }
        return skillsApprenant;
    }

    public static JSONObject getApprenant(int id) throws JSONException{
        JSONObject apprenant = new JSONObject();
        JSONArray apprenants = Datas.getApprenants();

        for(int i=0;i<apprenants.length();i++){
            if (apprenants.getJSONObject(i).getInt("id") == id){
                apprenant = apprenants.getJSONObject(i);
                apprenant.putOpt("skills",Datas.getSkills(id));
                apprenant.putOpt("projets",Datas.getProjets(id));
            }
        }
        return apprenant;
    }

}
