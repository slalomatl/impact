package com.slalom.labs.impact.service;

import com.slalom.labs.impact.domain.Test;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ted on 3/24/16.
 */
public interface TestRepository extends PagingAndSortingRepository<Test, String> {

}
