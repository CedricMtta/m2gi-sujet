package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.repositories;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.DateSondage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateSondageRepository extends JpaRepository<DateSondage, Long> {

    @Query("SELECT c FROM DateSondage c WHERE c.sondage.sondageId = :id")
    List<DateSondage> getAllBySondage(Long id);
}
