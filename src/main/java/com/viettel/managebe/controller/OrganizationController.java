package com.viettel.managebe.controller;

import com.viettel.managebe.model.Organization;
import com.viettel.managebe.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/organization")
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;

    private void buildUnitTree(Organization organization, List<Long> processedIds) {
        List<Organization> children = organizationRepository.findByParentId(organization.getId());
        for (Organization child : children) {
            if (!processedIds.contains(child.getId())) {
                child.setChildren(organizationRepository.findByParentId(child.getId()));
                processedIds.add(child.getId());
                buildUnitTree(child, processedIds);
            }
        }
        organization.setChildren(children);
        System.out.println("Organization: " + organization.getName() + ", Children: " + children.size());
    }

    @GetMapping("/tree")
    public List<Organization> getUnitTree() {
        List<Organization> units = organizationRepository.findByParentIdIsNull();
        List<Long> processedIds = new ArrayList<>();
        for (Organization unit : units) {
            processedIds.add(unit.getId());
            buildUnitTree(unit, processedIds);
        }
        return units;
    }

    @GetMapping("/organization")
    public List<Organization> getAllOrganization() {
        return organizationRepository.findAll();
    }

}
