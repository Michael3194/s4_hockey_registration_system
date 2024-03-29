package com.keyin.rest;

import com.keyin.domain.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @PostMapping("/division")
    public Division createDivision(@RequestBody Division division) {
        return divisionService.createDivision(division);
    }

    @PutMapping("/division/{id}")
    public ResponseEntity<Division> updateDivision(@PathVariable long id, @RequestBody Division division) {
        return ResponseEntity.ok(divisionService.updateDivision(id, division));
    }
}
