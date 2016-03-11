package com.slalom.labs.impact.service;

import com.slalom.labs.impact.domain.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by ted on 3/10/16.
 */
public interface OrganizationRepository extends CrudRepository<Organization, String> {

    List<Organization> findByName(@Param("name") String name);
}
