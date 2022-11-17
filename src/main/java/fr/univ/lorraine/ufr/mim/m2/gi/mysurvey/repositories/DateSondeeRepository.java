package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.repositories;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.DateSondee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DateSondeeRepository extends JpaRepository<DateSondee, Long> {

    @Query(value = "select d.date " +
            "FROM (SELECT max(nb) " +
            "FROM (SELECT date_sondage_id, count(choix) as nb " +
            "FROM date_sondee " +
            "WHERE choix = 'DISPONIBLE' " +
            "GROUP BY date_sondage_id) f) f1, (SELECT date_sondage_id, count(choix) as nb " +
            "FROM date_sondee " +
            "WHERE choix = 'DISPONIBLE' " +
            "GROUP BY date_sondage_id) f2, date_sondage d " +
            "Where f2.nb = f1.max " +
            "and d.date_sondage_id = f2.date_sondage_id " +
            "and d.sondage_id = ?1", nativeQuery = true)
    List<Date> bestDate(Long id);

    @Query(value = "select d.date " +
            "FROM (SELECT max(nb) FROM (SELECT date_sondage_id, count(choix) as nb FROM date_sondee WHERE choix = 'DISPONIBLE' or choix = 'PEUTETRE' GROUP BY date_sondage_id) f) f1, " +
            "(SELECT date_sondage_id, count(choix) as nb FROM date_sondee WHERE choix = 'DISPONIBLE' or choix = 'PEUTETRE' GROUP BY date_sondage_id) f2, " +
            "date_sondage d " +
            "Where f2.nb = f1.max " +
            "and d.date_sondage_id = f2.date_sondage_id " +
            "and d.sondage_id = ?1", nativeQuery = true)
    List<Date> maybeBestDate(Long id);
}
