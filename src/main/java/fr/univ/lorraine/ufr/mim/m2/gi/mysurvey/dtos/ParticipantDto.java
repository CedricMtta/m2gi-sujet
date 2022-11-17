package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos;

import java.util.Objects;

public class ParticipantDto {

    private Long participantId;
    private String nom;
    private String prenom;

    public ParticipantDto() {}

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantDto)) return false;
        ParticipantDto that = (ParticipantDto) o;
        return Objects.equals(getParticipantId(), that.getParticipantId()) && Objects.equals(getNom(), that.getNom()) && Objects.equals(getPrenom(), that.getPrenom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParticipantId(), getNom(), getPrenom());
    }

    @Override
    public String toString() {
        return "ParticipantDto{" + "participantId=" + participantId + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + '}';
    }
}
