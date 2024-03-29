package com.keyin.rest;

import com.keyin.domain.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    public Division createDivision(Division newDivision) {
        return divisionRepository.save(newDivision);
    }

    public Division updateDivision(Long id, Division updatedDivision) {
        Optional<Division> divisionToUpdateOptional = divisionRepository.findById(id);

        if (divisionToUpdateOptional.isPresent()) {
            Division divisionToUpdate = divisionToUpdateOptional.get();

            divisionToUpdate.setName(updatedDivision.getName());
            divisionToUpdate.setStartBirthYear(updatedDivision.getStartBirthYear());
            divisionToUpdate.setEndBirthYear(updatedDivision.getEndBirthYear());

            return divisionRepository.save(divisionToUpdate);
        }

        return null;
    }
}
