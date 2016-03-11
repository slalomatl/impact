package com.slalom.labs.impact.service;

import com.slalom.labs.impact.domain.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ted on 3/10/16.
 */
public interface TeamRepository extends PagingAndSortingRepository<Team, String> {

    List<Team> findByName(@Param("name") String name);
}
