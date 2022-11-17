package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos;

import java.util.Date;
import java.util.Objects;

public class SondageDto {

    private Long sondageId;
    private String nom;
    private String description;
    private Date fin;
    private Boolean cloture;
    private Long createBy;

    public SondageDto() {}

    public Long getSondageId() {
        return sondageId;
    }

    public void setSondageId(Long sondageId) {
        this.sondageId = sondageId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Boolean getCloture() {
        return cloture;
    }

    public void setCloture(Boolean cloture) {
        this.cloture = cloture;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SondageDto)) return false;
        SondageDto that = (SondageDto) o;
        return Objects.equals(getSondageId(), that.getSondageId()) && Objects.equals(getNom(), that.getNom()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getFin(), that.getFin()) && Objects.equals(getCloture(), that.getCloture()) && Objects.equals(getCreateBy(), that.getCreateBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSondageId(), getNom(), getDescription(), getFin(), getCloture(), getCreateBy());
    }
}
