package com.radek.bikerentals.dto;

import lombok.*;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BikeDTO implements Serializable {

    private Long id;

    @NonNull
    @Size(min = 5, max = 5, message = "Length must be 5 characters")
    private String serialNumber;

    @NonNull
    @PastOrPresent(message = "Date of production must be earlier than present")
    @NotNull(message = "Field can't be empty")
    private LocalDate dateOfProduction;

    @NotEmpty
    @NonNull
    private String color;

    @NonNull
    private boolean isBusy;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


//    Set<BikeLocation> locations = new HashSet<>();

}
