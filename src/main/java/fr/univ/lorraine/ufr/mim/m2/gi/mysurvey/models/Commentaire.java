package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models;

import javax.persistence.*;

/**
 * Classe de commentaire d'un {@link Sondage}
 */
@Entity
@Table(name = "commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentaire_id")
    private Long commentaireId;

    @Column(name = "commentaire")
    private String commentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sondage_id")
    private Sondage sondage = new Sondage();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private Participant participant = new Participant();

    public Commentaire() {}

    public Long getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Long commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
