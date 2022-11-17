package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.controllers;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos.CommentaireDto;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.Commentaire;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services.CommentaireService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/commentaire")
public class CommentaireController {

    private final CommentaireService service;
    private final ModelMapper mapper;

    public CommentaireController(CommentaireService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommentaireDto update(@PathVariable("id") Long id, @RequestBody CommentaireDto commentaireDto) {
        var model = mapper.map(commentaireDto, Commentaire.class);
        var result = service.update(id, model);
        return mapper.map(result, CommentaireDto.class);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
