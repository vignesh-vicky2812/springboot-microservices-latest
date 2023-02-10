package com.microservices.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.demo.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}