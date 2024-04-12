
package com.MVRGroup.Service;

import com.MVRGroup.entity.SubServiceEntity;
import com.MVRGroup.repository.SubServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubServiceService {

    private final SubServiceRepository subserviceRepository;

    @Autowired
    public SubServiceService(SubServiceRepository subserviceRepository) {
        this.subserviceRepository = subserviceRepository;
    }

    public List<SubServiceEntity> getAllSubServices() {
        return subserviceRepository.findAll();
    }
}