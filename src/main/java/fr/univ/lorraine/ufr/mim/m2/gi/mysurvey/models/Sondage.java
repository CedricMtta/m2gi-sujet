package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe entité qui représente un sondage
 */
@Entity
@Table(name = "sondage")
public class Sondage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sondage_id")
    private Long sondageId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "fin")
    private Date fin;

    @Column(name = "cloture")
    private Boolean cloture;

    @OneToMany(mappedBy = "sondage", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires = new ArrayList<>();

    @OneToMany(mappedBy = "sondage", cascade = CascadeType.ALL)
    private List<DateSondage> dateSondage = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private Participant createBy = new Participant();

    public Sondage() {}

    public Sondage(Long sondageId, String nom, String description, Date fin, Boolean cloture, List<Commentaire> commentaires, List<DateSondage> dateSondage, Participant createBy) {
        this.sondageId = sondageId;
        this.nom = nom;
        this.description = description;
        this.fin = fin;
        this.cloture = cloture;
        this.commentaires = commentaires;
        this.dateSondage = dateSondage;
        this.createBy = createBy;
    }

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

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<DateSondage> getDateSondage() {
        return dateSondage;
    }

    public void setDateSondage(List<DateSondage> dateSondage) {
        this.dateSondage = dateSondage;
    }

    public Participant getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Participant createBy) {
        this.createBy = createBy;
    }
}
