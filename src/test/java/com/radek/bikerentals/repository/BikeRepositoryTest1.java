package com.radek.bikerentals.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class BikeRepositoryTest1 {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private TestEntityManager testEntityManager;



}
