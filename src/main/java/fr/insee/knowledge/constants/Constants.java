package fr.insee.knowledge.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Constants class");
    }

    //MongoDb Collection
    public static final String CollectionFunctions = "functions";
    public static final String CollectionHierarchy = "hierarchy";


    //Github Filename
    public static final String GithubFunctionFile = "functions/fonctions.json";
    public static final String GithubStatusFile = "hierarchy/statuts.json";
    public static final String GithubServicesFile = "hierarchy/services.json";
    public static final String GithubProductsFile = "hierarchy/produits.json";
    public static final String GithubUserFile = "hierarchy/utilisateurs.json";
    public static final String GithubGsbpmFile = "hierarchy/gsbpm.json";

    public static final List<String> ListHierarchy = Arrays.asList(GithubUserFile, GithubGsbpmFile, GithubProductsFile, GithubServicesFile, GithubStatusFile);

    //Function JsonFields
    public static final String functionField = "function";
    public static final String idField = "id";
    public static final String idProductsDocument = "products";
    public static final String idGsbpmDocument = "gsbpm";
    public static final String idServicesDocument = "services";
    public static final String idUsersDocument = "users";
    public static final String idStatusDocument = "status";

    public static final String labelField = "label";
    public static final String serviceField = "service";
    public static final String descriptionField = "description";
    public static final String dispoField = "dispo";
    public static final String tasksField = "tasks";
    public static final String usersField = "users";
    public static final String toolsField = "tools";


}
