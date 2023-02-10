package com.microservices.demo.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.microservices.demo.dto.OrganizationDto;
import com.microservices.demo.entity.Organization;
import com.microservices.demo.mapper.OrganizationMapper;
import com.microservices.demo.repository.OrganizationRepository;
import com.microservices.demo.service.OrganizationService;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}