package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.DateSondage;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.repositories.DateSondageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateSondageService {

    private final DateSondageRepository repository;
    private final SondageService sondageService;

    public DateSondageService(DateSondageRepository repository, SondageService sondageService) {
        this.repository = repository;
        this.sondageService = sondageService;
    }

    public DateSondage getById(Long id) {
        return repository.getById(id);
    }

    public List<DateSondage> getBySondageId(Long sondageId) {
        return repository.getAllBySondage(sondageId);
    }

    public DateSondage create(Long id, DateSondage date) {
        date.setSondage(sondageService.getById(id));
        return repository.save(date);
    }

    public int delete(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return 1;
        }
        return 0;
    }
}
