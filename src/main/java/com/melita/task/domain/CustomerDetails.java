package com.melita.task.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CustomerDetails {
    @NotBlank(message = "Field customerDetails.name is required")
    private String name;

    @NotBlank(message = "Field customerDetails.surname is required")
    private String surname;

    @NotBlank(message = "Field customerDetails.installationAddress is required")
    private String installationAddress;

    @NotNull(message = "Field customerDetails.preferredInstallationDate is required. Format: YYYY-MM-DD")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @FutureOrPresent(message = "Field customerDetails.preferredInstallationDate should not be in the past")
    private LocalDate preferredInstallationDate;

    @NotNull(message = "Field customerDetails.preferredInstallationTime is required. Format: HH:mm")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime preferredInstallationTime;
}
