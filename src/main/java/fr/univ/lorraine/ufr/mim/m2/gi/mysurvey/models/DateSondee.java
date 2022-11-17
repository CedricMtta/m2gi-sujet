package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models;

import javax.persistence.*;

@Entity
@Table(name = "date_sondee", uniqueConstraints = {@UniqueConstraint(columnNames = {"date_sondage_id", "participant_id"})})
public class DateSondee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dateSondeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_sondage_id")
    private DateSondage dateSondage = new DateSondage();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private Participant participant = new Participant();

    @Column(name = "choix", nullable = false)
    @Enumerated(EnumType.STRING)
    private Choix choix;

    public DateSondee() {}

    public DateSondee(Long dateSondeeId, DateSondage dateSondage, Participant participant, Choix choix) {
        this.dateSondeeId = dateSondeeId;
        this.dateSondage = dateSondage;
        this.participant = participant;
        this.choix = choix;
    }

    public Long getDateSondeeId() {
        return dateSondeeId;
    }

    public void setDateSondeeId(Long dateSondeeId) {
        this.dateSondeeId = dateSondeeId;
    }

    public DateSondage getDateSondage() {
        return dateSondage;
    }

    public void setDateSondage(DateSondage dateSondage) {
        this.dateSondage = dateSondage;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public String getChoix() {
        return choix.name();
    }

    public void setChoix(String choix) {
        this.choix = Choix.valueOf(choix);
    }
}
