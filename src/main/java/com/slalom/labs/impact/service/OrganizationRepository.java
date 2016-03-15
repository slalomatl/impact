package com.slalom.labs.impact.service;

import com.slalom.labs.impact.domain.Organization;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ted on 3/10/16.
 */
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, String> {

    List<Organization> findByName(@Param("name") String name);
}
