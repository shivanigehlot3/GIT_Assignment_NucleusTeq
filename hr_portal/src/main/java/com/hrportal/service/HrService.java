package com.hrportal.service;

import com.hrportal.model.Hr;
import com.hrportal.repository.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HrService {

    @Autowired
    private HrRepository hrRepository;

    public boolean login(String email, String password) {
        Optional<Hr> hr = hrRepository.findByEmail(email);
        return hr.isPresent() && hr.get().getPassword().equals(password);
    }
}
