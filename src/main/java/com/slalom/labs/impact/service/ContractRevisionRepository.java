package com.slalom.labs.impact.service;

import com.slalom.labs.impact.domain.ContractRevision;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ted on 3/24/16.
 */
public interface ContractRevisionRepository extends PagingAndSortingRepository<ContractRevision, String> {

}
