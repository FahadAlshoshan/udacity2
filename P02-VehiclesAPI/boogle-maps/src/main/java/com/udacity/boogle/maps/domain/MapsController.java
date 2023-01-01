package com.udacity.boogle.maps.domain;

import com.udacity.boogle.maps.service.MapsService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class MapsController {
    private final MapsService service;

    public MapsController(MapsService service) {
        this.service = service;
    }

    @GetMapping
    public Address get(@RequestParam String lat, @RequestParam String lon) {
        return service.get(new Coordinates(Double.valueOf(lat),Double.valueOf(lon)));
    }
}
