package fr.fondespierre.beweb.mobile.apprenants.dal.enumeration;

/**
 * Created by hicham on 05/07/17.
 */

public enum Status {
    Chomage("chomage"), En_poste("en poste"), Formation("en formation");

    private String name ="";

    Status(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
