package com.slalom.labs.impact.service;

import com.slalom.labs.impact.domain.Webhook;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ted on 3/24/16.
 */
public interface WebhookRepository extends PagingAndSortingRepository<Webhook, String> {
}
