package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.repositories;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.Sondage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SondageRepository extends JpaRepository<Sondage, Long> { }
