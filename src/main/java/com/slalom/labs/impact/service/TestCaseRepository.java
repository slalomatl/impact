package com.slalom.labs.impact.service;

import com.slalom.labs.impact.domain.TestCase;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ted on 3/24/16.
 */
public interface TestCaseRepository extends PagingAndSortingRepository<TestCase, String> {

}
