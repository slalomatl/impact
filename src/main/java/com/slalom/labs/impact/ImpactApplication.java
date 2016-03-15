package com.slalom.labs.impact;

import com.slalom.labs.impact.domain.Organization;
import com.slalom.labs.impact.domain.Team;
import com.slalom.labs.impact.service.OrganizationRepository;
import com.slalom.labs.impact.service.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Collectors;

/**
 * Created by Ted Hunter <t.hunt750@gmail.com> on 3/10/16.
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
    public CommandLineRunner demo(OrganizationRepository orgRepository, TeamRepository teamRepository) {
        return (args) -> {
            // Save some organizations
            orgRepository.save(new Organization("slalom", "Slalom Consulting", null));
            orgRepository.save(new Organization("homedepot", "The Home Depot", null));
            orgRepository.save(new Organization("mckesson", "McKesson", null));
            orgRepository.save(new Organization("coke", "Coca Cola", null));

            // fetch all orgs
            log.info("Organizations found with findAll():");
            log.info("-----------------------------------");
            orgRepository.findAll()
                    .forEach(organization -> log.info(organization.getPresentedName()));
            log.info("");

            // fetch an organization by name
            log.info("Organization found with name('coke'):");
            log.info("-----------------------------------");
            orgRepository.findByName("coke")
                    .forEach(organization -> log.info(organization.getPresentedName()));
            log.info("");


            // Save some teams
            teamRepository.save(new Team(orgRepository.findByName("slalom").get(0),
                    "atl-custom-dev", "Atlanta Custom Dev", null));
            teamRepository.save(new Team(orgRepository.findByName("slalom").get(0),
                    "atl-xsd", "Atlanta XSD", null));
            // fetch all teams
            log.info("Teams found with findAll():");
            log.info("-----------------------------------");
            teamRepository.findAll()
                    .forEach(team -> log.info(team.getPresentedName()));
            log.info("");

            // fetch a team by name
            log.info("Team found with name('atl-custom-dev'):");
            log.info("-----------------------------------");
            teamRepository.findByName("atl-custom-dev")
                    .forEach(team -> log.info(team.getPresentedName()));
            log.info("");

            // see teams in Slalom Internal
            log.info("Slalom's teams:");
            log.info("-----------------------------------");
            orgRepository.findByName("slalom")
                    .stream()
                    .flatMap(l -> l.getTeams().stream())
                    .collect(Collectors.toList())
                    .forEach(team -> log.info(team.getName()));
            log.info("");
        };
    }
}
