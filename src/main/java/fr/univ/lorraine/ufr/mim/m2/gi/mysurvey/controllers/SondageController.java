package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.controllers;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos.CommentaireDto;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos.DateSondageDto;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos.SondageDto;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.Commentaire;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.DateSondage;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.Sondage;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services.CommentaireService;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services.DateSondageService;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services.DateSondeeService;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services.SondageService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/sondage")
public class SondageController {

    private final SondageService service;
    private final CommentaireService scommentaire;
    private final DateSondageService sdate;
    private final DateSondeeService request;
    private final ModelMapper mapper;

    public SondageController(SondageService service, ModelMapper mapper, CommentaireService c, DateSondageService d, DateSondeeService r) {
        this.service = service;
        this.mapper = mapper;
        this.sdate = d;
        this.scommentaire = c;
        this.request = r;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SondageDto get(@PathVariable("id") Long id) {
        var model = service.getById(id);
        return mapper.map(model, SondageDto.class);
    }

    @GetMapping(value = "/{id}/best")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Date> getBest(@PathVariable("id") Long id) {
        return request.bestDate(id);
    }

    @GetMapping(value = "/{id}/maybe")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Date> getMaybeBest(@PathVariable("id") Long id) {
        return request.maybeBestDate(id);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<SondageDto> get() {
        var models = service.getAll();

        return models.stream()
                .map(model -> mapper.map(model, SondageDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}/commentaires")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CommentaireDto> getCommentaires(@PathVariable("id") Long id) {
        var models = scommentaire.getBySondageId(id);
        return models.stream()
                .map(model -> mapper.map(model, CommentaireDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}/dates")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DateSondageDto> getDates(@PathVariable("id") Long id) {
        var models = sdate.getBySondageId(id);
        return models.stream()
                .map(model -> mapper.map(model, DateSondageDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SondageDto create(@RequestBody SondageDto sondageDto) {
        var model = mapper.map(sondageDto, Sondage.class);
        var result = service.create(sondageDto.getCreateBy(), model);
        return mapper.map(result, SondageDto.class);
    }

    @PostMapping(value = "/{id}/commentaires")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CommentaireDto createCommantaire(@PathVariable("id") Long id, @RequestBody CommentaireDto commantaireDto) {
        var model = mapper.map(commantaireDto, Commentaire.class);
        var result = scommentaire.addCommantaire(id, commantaireDto.getParticipant(), model);
        return mapper.map(result, CommentaireDto.class);
    }

    @PostMapping(value = "/{id}/dates")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DateSondageDto createDate(@PathVariable("id") Long id, @RequestBody DateSondageDto dto) {
        var model = mapper.map(dto, DateSondage.class);
        var result = sdate.create(id, model);
        return mapper.map(result, DateSondageDto.class);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SondageDto update(@PathVariable("id") Long id, @RequestBody SondageDto sondageDto) {
        var model = mapper.map(sondageDto, Sondage.class);
        var result = service.update(id, model);
        return mapper.map(result, SondageDto.class);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
