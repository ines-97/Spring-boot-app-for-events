package com.event.events.evnt;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record event(
        Integer id,
        @NotEmpty
        Integer id_Admin,
        @NotEmpty
        String name,
        @NotEmpty
        String entreprise,
        LocalDateTime start_date,
        LocalDateTime end_date,
        String location,
        String description
) {
}
