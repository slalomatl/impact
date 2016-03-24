package com.slalom.labs.impact.service;

import com.slalom.labs.impact.domain.Endpoint;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ted on 3/24/16.
 */
public interface EndpointRepository extends PagingAndSortingRepository<Endpoint, String> {

}
