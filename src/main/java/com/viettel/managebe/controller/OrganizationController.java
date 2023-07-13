package com.viettel.managebe.controller;

import com.viettel.managebe.model.Organization;
import com.viettel.managebe.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/organization")
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/tree")
    public List<Organization> getUnitTree() {
        List<Organization> units = organizationRepository.findByParentIdIsNull();
        buildUnitTree(units);
        return units;
    }
    private void buildUnitTree(List<Organization> organizations) {
        for (Organization organization : organizations) {
            List<Organization> children = organizationRepository.findByParentId(organization.getId());
            organization.setChildren(children);
            buildUnitTree(children);
        }
    }

}
