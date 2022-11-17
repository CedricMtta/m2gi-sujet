package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos;

import java.util.Date;
import java.util.Objects;

public class DateSondageDto {

    private Long dateSondageId;
    private Date date;

    public DateSondageDto() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateSondageDto)) return false;
        DateSondageDto that = (DateSondageDto) o;
        return Objects.equals(getDateSondageId(), that.getDateSondageId()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateSondageId(), getDate());
    }
}
