package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos;

import java.util.Objects;

public class DateSondeeDto {

    private Long dateSondeeId;
    private Long participant;
    private String choix;

    public DateSondeeDto() {}

    public Long getDateSondeeId() {
        return dateSondeeId;
    }

    public void setDateSondeeId(Long dateSondeeId) {
        this.dateSondeeId = dateSondeeId;
    }

    public Long getParticipant() {
        return participant;
    }

    public void setParticipant(Long participant) {
        this.participant = participant;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateSondeeDto)) return false;
        DateSondeeDto that = (DateSondeeDto) o;
        return Objects.equals(getDateSondeeId(), that.getDateSondeeId()) && Objects.equals(getParticipant(), that.getParticipant()) && Objects.equals(getChoix(), that.getChoix());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateSondeeId(), getParticipant(), getChoix());
    }
}
