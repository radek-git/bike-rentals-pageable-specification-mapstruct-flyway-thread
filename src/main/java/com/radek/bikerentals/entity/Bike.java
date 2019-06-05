package com.radek.bikerentals.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "bikes")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Bike extends AbstractEntity{

    @NonNull
    @Column(unique = true, updatable = false)
    private String serialNumber;

    @NonNull
    private boolean isBusy;

    @NonNull
    private LocalDate dateOfProduction;

    @NonNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id")
    private Color color;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    nie jest to potrzebne ponieważ ściągane byłoby za dużo zbednych danych dot. historii lokalizacji
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id")
//    List<BikeLocation> locations = new ArrayList<>();
}


