package com.radek.bikerentals.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User extends AbstractEntity{

    @NonNull //anotacja do @RequiredArgsConstructor - stworzy konstruktor tylko z @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    @Column(unique = true)
    private String username;

    @NonNull
    private String password;

    @NonNull
    @Column(unique = true, updatable = false)
    private String pesel;

    @NonNull
    private BigDecimal balance;

    private boolean isExpired;
    private boolean isLocked;
    private boolean isCredentialsExpired;
    private boolean isEnabled;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Set<Rental> rentals = new HashSet<>();




}
