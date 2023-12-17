package com.theatre.xyz.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TheatreBatchJob {
    private final TheatreEventProducer theatreEventProducer;
    @Scheduled(fixedRateString = "${kafka.scheduled.fixedRate:60000}") // Execute every 60 seconds
    public void fetchLatestUpdatesFromTheatreAPI() {
        // Implement logic to fetch and update theatres from the external API
        // Update the database with the latest theatre information

        // Send an event to Kafka indicating that theatre information has been updated
        log.info("Theatre information updated");
        theatreEventProducer.sendTheatreUpdateEvent("Theatre information updated");
    }
}
