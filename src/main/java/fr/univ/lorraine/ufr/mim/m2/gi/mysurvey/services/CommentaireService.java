package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.Commentaire;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.repositories.CommentaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService {

    private final CommentaireRepository repository;
    private final SondageService sondageService;
    private final ParticipantService participantService;

    public CommentaireService(CommentaireRepository repository, SondageService s, ParticipantService p) {
        this.repository = repository;
        this.sondageService = s;
        this.participantService = p;
    }

    public List<Commentaire> getBySondageId(Long sondageId) {
        return repository.getAllBySondage(sondageId);
    }

    public Commentaire addCommantaire(Long idSondage, Long idParticipant, Commentaire commentaire) {
        commentaire.setSondage(sondageService.getById(idSondage));
        commentaire.setParticipant(participantService.getById(idParticipant));
        return repository.save(commentaire);
    }

    public Commentaire update(Long id, Commentaire commentaire) {
        if (repository.findById(id).isPresent()) {
            commentaire.setCommentaireId(id);
            return repository.save(commentaire);
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
