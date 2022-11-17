package fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.controllers;

import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.dtos.DateSondeeDto;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.models.DateSondee;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services.DateSondageService;
import fr.univ.lorraine.ufr.mim.m2.gi.mysurvey.services.DateSondeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/date")
public class DateSondageController {

    private final DateSondageService service;
    private final DateSondeeService sds;
    private final ModelMapper mapper;

    public DateSondageController(DateSondageService service, ModelMapper mapper, DateSondeeService s) {
        this.service = service;
        this.mapper = mapper;
        this.sds = s;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/{id}/participer")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DateSondeeDto createParticipation(@PathVariable("id") Long id, @RequestBody DateSondeeDto dto) {
        var model = mapper.map(dto, DateSondee.class);
        var result = sds.create(id, dto.getParticipant(), model);
        return mapper.map(result, DateSondeeDto.class);
    }
}
