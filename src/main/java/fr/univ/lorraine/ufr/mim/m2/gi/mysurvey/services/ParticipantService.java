package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.Participant;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository repository;

    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public Participant getById(Long id) {
        return repository.getById(id);
    }

    public List<Participant> getAll() {
        return repository.findAll();
    }

    public Participant create(Participant participant) {
        return repository.save(participant);
    }

    public Participant update(Long id, Participant participant) {
        if (repository.findById(id).isPresent()) {
            participant.setParticipantId(id);
            return repository.save(participant);
        }
        return null;
    }

    public int delete(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return 1;
        }
        return 0;
    }
}
