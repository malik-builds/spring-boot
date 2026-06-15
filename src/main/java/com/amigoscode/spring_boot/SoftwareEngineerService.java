package com.amigoscode.spring_boot;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository){
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
         softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(()-> new IllegalStateException(id + " not found"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
        softwareEngineerRepository.deleteById(id);
    }
    public void updateSoftwareEngineerById(Integer id, SoftwareEngineer softwareEngineer){
        SoftwareEngineer old = softwareEngineerRepository.findById(id).orElseThrow(()-> new IllegalStateException(id + " not found"));
        old.setName(softwareEngineer.getName());
        old.setTechStack(softwareEngineer.getTechStack());
        softwareEngineerRepository.save(old);
    }
}
