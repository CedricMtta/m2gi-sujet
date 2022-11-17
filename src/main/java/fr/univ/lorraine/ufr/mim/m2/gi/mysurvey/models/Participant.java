package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long participantId;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<Commentaire> commentaire = new ArrayList<>();

    @OneToMany(mappedBy = "createBy", cascade = CascadeType.ALL)
    private List<Sondage> sondages = new ArrayList<>();

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<DateSondee> dateSondee = new ArrayList<>();

    public Participant() {}

    public Participant(Long participantId, String nom, String prenom) {
        this.participantId = participantId;
        this.nom = nom;
        this.prenom = prenom;
    }

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

    public List<Commentaire> getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(List<Commentaire> commentaire) {
        this.commentaire = commentaire;
    }

    public List<Sondage> getSondages() {
        return sondages;
    }

    public void setSondages(List<Sondage> sondages) {
        this.sondages = sondages;
    }

    public List<DateSondee> getDateSondee() {
        return dateSondee;
    }

    public void setDateSondee(List<DateSondee> dateSondee) {
        this.dateSondee = dateSondee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return Objects.equals(getParticipantId(), that.getParticipantId()) && Objects.equals(getNom(), that.getNom()) && Objects.equals(getPrenom(), that.getPrenom()) && Objects.equals(getCommentaire(), that.getCommentaire()) && Objects.equals(getSondages(), that.getSondages()) && Objects.equals(getDateSondee(), that.getDateSondee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParticipantId(), getNom(), getPrenom(), getCommentaire(), getSondages(), getDateSondee());
    }

    @Override
    public String toString() {
        return "Participant{" + "participantId=" + participantId + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + '}';
    }
}
