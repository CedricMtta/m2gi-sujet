package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos;

import java.util.Objects;

public class CommentaireDto {

    private Long commentaireId;
    private String commentaire;
    private Long participant;

    public CommentaireDto() {}

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

    public Long getParticipant() {
        return participant;
    }

    public void setParticipant(Long participant) {
        this.participant = participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentaireDto)) return false;
        CommentaireDto that = (CommentaireDto) o;
        return Objects.equals(getCommentaireId(), that.getCommentaireId()) && Objects.equals(getCommentaire(), that.getCommentaire()) && Objects.equals(getParticipant(), that.getParticipant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentaireId(), getCommentaire(), getParticipant());
    }
}
