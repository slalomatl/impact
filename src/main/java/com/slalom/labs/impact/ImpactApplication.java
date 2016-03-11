package com.slalom.labs.impact;

import com.slalom.labs.impact.domain.Organization;
import com.slalom.labs.impact.service.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ted on 3/10/16.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class ImpactApplication {

    private static final Logger log = LoggerFactory.getLogger(ImpactApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ImpactApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(OrganizationRepository repository) {
        return (args) -> {
            // Save some organizations
            repository.save(new Organization("slalom-internal", "Slalom Internal"));
            repository.save(new Organization("homedepot", "The Home Depot"));
            repository.save(new Organization("mckesson", "McKesson"));
            repository.save(new Organization("coke", "Coca Cola"));

            // fetch all orgs
            log.info("Organizations found with findAll():");
            log.info("-----------------------------------");
            repository.findAll()
                    .forEach(organization -> log.info(organization.getPresentedName()));
            log.info("");

            // fetch an organization by name
            log.info("Organization found with name('coke'):");
            log.info("-----------------------------------");
            repository.findByName("coke")
                    .forEach(organization -> log.info(organization.getPresentedName()));
            log.info("");
        };
    }
}
