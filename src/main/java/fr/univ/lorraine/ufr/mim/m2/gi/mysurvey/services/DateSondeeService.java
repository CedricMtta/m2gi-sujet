package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.DateSondage;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.DateSondee;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.repositories.DateSondeeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DateSondeeService {

    private final DateSondeeRepository repository;
    private final DateSondageService sdate;
    private final ParticipantService ps;

    public DateSondeeService(DateSondeeRepository repository, DateSondageService d, ParticipantService p) {
        this.repository = repository;
        this.sdate = d;
        this.ps = p;
    }

    public DateSondee create(Long id, Long participantId, DateSondee dateSondee) {
        DateSondage date = sdate.getById(id);
        if (Boolean.FALSE.equals(date.getSondage().getCloture())) {
            dateSondee.setDateSondage(date);
            dateSondee.setParticipant(ps.getById(participantId));
            return repository.save(dateSondee);
        }
        return null;
    }

    public List<Date> bestDate(Long id) {
        return repository.bestDate(id);
    }

    public List<Date> maybeBestDate(Long id) {
        return repository.maybeBestDate(id);
    }
}
