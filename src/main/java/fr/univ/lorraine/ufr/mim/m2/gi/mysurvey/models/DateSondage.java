package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Liste des dates du {@link Sondage}
 */
@Entity
@Table(name = "date_sondage", uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "sondage_id"})})
public class DateSondage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_sondage_id")
    private Long dateSondageId;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sondage_id")
    private Sondage sondage = new Sondage();

    @OneToMany(mappedBy = "dateSondage", cascade = CascadeType.ALL)
    private List<DateSondee> dateSondee = new ArrayList<>();

    public DateSondage() {}

    public DateSondage(Long dateSondageId, Date date, Sondage sondage, List<DateSondee> dateSondee) {
        this.dateSondageId = dateSondageId;
        this.date = date;
        this.sondage = sondage;
        this.dateSondee = dateSondee;
    }

    public Long getDateSondageId() {
        return dateSondageId;
    }

    public void setDateSondageId(Long dateSondageId) {
        this.dateSondageId = dateSondageId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
    }

    public List<DateSondee> getDateSondee() {
        return dateSondee;
    }

    public void setDateSondee(List<DateSondee> dateSondee) {
        this.dateSondee = dateSondee;
    }
}
