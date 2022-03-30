package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class Function {

    @JsonProperty("id")
    public String id;
    @JsonProperty("macroserviceLabel")
    public String macroserviceLabel;
    @JsonProperty("macroserviceId")
    public String macroserviceId;
    @JsonProperty("serviceLabel")
    public String serviceLabel;
    @JsonProperty("serviceId")
    public String serviceId;
    @JsonProperty("sousServiceLabel")
    public String sousServiceLabel;
    @JsonProperty("sousServiceId")
    public String sousServiceId;
    @JsonProperty("label")
    public String label;
    @JsonDeserialize(contentAs = Users.class)
    public List<Users> utilisateurs;
    @JsonProperty("dispo")
    public int available;
    @JsonProperty("gsbpmLabel")
    public String gsbpmLabel;
    @JsonProperty("gsbpmId")
    public String gsbpmId;
    @JsonDeserialize(contentAs = Tool.class)
    public List<Tool> outils;
    @JsonProperty("produitLabel")
    public String produitLabel;
    @JsonProperty("produitId")
    public String produitId;
    @JsonProperty("description")
    public String description;
    @JsonDeserialize(contentAs = Task.class)
    public List<Task> taches;

    public Function() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMacroserviceLabel() {
        return macroserviceLabel;
    }

    public void setMacroserviceLabel(String macroserviceLabel) {
        this.macroserviceLabel = macroserviceLabel;
    }

    public String getMacroserviceId() {
        return macroserviceId;
    }

    public void setMacroserviceId(String macroserviceId) {
        this.macroserviceId = macroserviceId;
    }

    public String getServiceLabel() {
        return serviceLabel;
    }

    public void setServiceLabel(String serviceLabel) {
        this.serviceLabel = serviceLabel;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSousServiceLabel() {
        return sousServiceLabel;
    }

    public void setSousServiceLabel(String sousServiceLabel) {
        this.sousServiceLabel = sousServiceLabel;
    }

    public String getSousServiceId() {
        return sousServiceId;
    }

    public void setSousServiceId(String sousServiceId) {
        this.sousServiceId = sousServiceId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Users> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Users> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getGsbpmLabel() {
        return gsbpmLabel;
    }

    public void setGsbpmLabel(String gsbpmLabel) {
        this.gsbpmLabel = gsbpmLabel;
    }

    public String getGsbpmId() {
        return gsbpmId;
    }

    public void setGsbpmId(String gsbpmId) {
        this.gsbpmId = gsbpmId;
    }

    public List<Tool> getOutils() {
        return outils;
    }

    public void setOutils(List<Tool> outils) {
        this.outils = outils;
    }

    public String getProduitLabel() {
        return produitLabel;
    }

    public void setProduitLabel(String produitLabel) {
        this.produitLabel = produitLabel;
    }

    public String getProduitId() {
        return produitId;
    }

    public void setProduitId(String produitId) {
        this.produitId = produitId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTaches() {
        return taches;
    }

    public void setTaches(List<Task> taches) {
        this.taches = taches;
    }
}
