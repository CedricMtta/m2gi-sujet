package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.repositories;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    @Query("SELECT c FROM Commentaire c WHERE c.sondage.sondageId = :id")
    List<Commentaire> getAllBySondage(Long id);
}
