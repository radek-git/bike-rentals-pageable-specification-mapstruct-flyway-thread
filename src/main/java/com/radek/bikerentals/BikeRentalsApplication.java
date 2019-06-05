package com.radek.bikerentals;

import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.BikeLocation;
import com.radek.bikerentals.entity.Rental;
import com.radek.bikerentals.entity.User;
import com.radek.bikerentals.repository.BikeLocationRepository;
import com.radek.bikerentals.repository.BikeRepository;
import com.radek.bikerentals.repository.RentalRepository;
import com.radek.bikerentals.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.util.Pair;
import org.springframework.scheduling.annotation.Scheduled;

import java.awt.image.Kernel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BikeRentalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeRentalsApplication.class, args);
    }

//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    BikeRepository bikeRepository;
//
//    @Autowired
//    RentalRepository rentalRepository;
//
//    @Autowired
//    BikeLocationRepository bikeLocationRepository;


//    @Scheduled(fixedRate = 5000)
//    public void simulate() {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("nowy");
//
//                //Thread thread = new Thread(new Runnable() {
//////                @Override
////                public void run() {
////                    System.out.println("hjhgkgh");
////                }
////            });
////
////            thread.start();
//
////            while (1 == 1) {
////                System.out.println("działa nieskończenie");
////            }
//
//
//
//                User user = userRepository.findById(ThreadLocalRandom.current().nextLong(1, userRepository.count()))
//                        .orElseThrow(() -> new RuntimeException());
//
//                //user.getRentals().stream().anyMatch(rental -> rental.getFinishedAt()==null);
//                //user.getRentals().stream().filter(rental -> rental.getFinishedAt()==null).findAny().isPresent();
//
//
//                Bike bike;
//                do {
//                    bike = bikeRepository.findById(ThreadLocalRandom.current().nextLong(1, bikeRepository.count()))
//                            .orElseThrow(() -> new RuntimeException());
//                } while (bike.isBusy());
//
//                bike.setBusy(true);
//
//                bikeRepository.save(bike);
//
//                BigDecimal latitude
//                        = BigDecimalUtils.random(new BigDecimal("52.184364"), new BigDecimal("52.263775"));
//
//                BigDecimal longitude
//                        = BigDecimalUtils.random(new BigDecimal("20.864852"), new BigDecimal("21.069315"));
//
//
//
//                Rental rental = Rental.builder()
//                        .user(user)
//                        .bike(bike)
//                        .startedAt(LocalDateTime.now())
//                        .startLatitude(latitude.setScale(6, RoundingMode.HALF_UP).toString())
//                        .startLongitude(longitude.setScale(6, RoundingMode.HALF_UP).toString())
//                        .build();
//
//                rentalRepository.save(rental);
//
//
//
//
//                bikeLocationRepository.save(new BikeLocation(
//                        latitude.setScale(6, RoundingMode.HALF_UP).toString(),
//                        longitude.setScale(6, RoundingMode.HALF_UP).toString(),
//                        bike,
//                        LocalDateTime.now(),
//                        rental
//                ));
//
//
//
//                int points = ThreadLocalRandom.current().nextInt(20,100);
//
//
////            List<Pair<BigDecimal, BigDecimal>> locations = new ArrayList<>();
//                //locations.add(Pair.of(latitude, longitude));
//
//                int direction;
//                int distance;
//                BigDecimal coef;
//                for (int i = 0; i < points; i++) {
//                    direction = ThreadLocalRandom.current().nextInt(4);
//                    distance = ThreadLocalRandom.current().nextInt(1,50);
//                    //1m in degree = 0.0089 /1000 = 0.0000089
//                    coef = new BigDecimal(0.0000089 * distance);
//
//                    System.out.println("*");
//
//                    try {
//                        Thread.sleep(ThreadLocalRandom.current().nextInt(1, 1000));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//
//                    switch (direction) {
//                        case AppConstants.NORTH:
//                            latitude = latitude.add(coef);
//                            break;
//
//                        case AppConstants.SOUTH:
//                            latitude = latitude.subtract(coef);
//                            break;
//
//                        case AppConstants.EAST:
//                            longitude
//                                    = longitude.add(coef.divide(new BigDecimal(Math.cos(latitude.doubleValue() * 0.018)), 6, RoundingMode.HALF_UP));
//                            break;
//
//                        case AppConstants.WEST:
//                            longitude
//                                    = longitude.subtract(coef.divide(new BigDecimal(Math.cos(latitude.doubleValue() * 0.018)), 6, RoundingMode.HALF_UP));
//                            break;
//                    }
//
//
//                    bikeLocationRepository.save(new BikeLocation(
//                            latitude.setScale(6, RoundingMode.HALF_UP).toString(),
//                            longitude.setScale(6, RoundingMode.HALF_UP).toString(),
//                            bike,
//                            LocalDateTime.now(),
//                            rental
//                    ));
//                }
//
//                rental.setEndLatitude(latitude.setScale(6, RoundingMode.HALF_UP).toString());
//                rental.setEndLongitude(longitude.setScale(6, RoundingMode.HALF_UP).toString());
//                rental.setFinishedAt(LocalDateTime.now());
//                rental.setPrice(new BigDecimal(1));
//
//                rentalRepository.save(rental);
//
//                bike.setBusy(false);
//                bikeRepository.save(bike);
//
//                System.out.println("koniec");
//
//            }
//        });
//
//        thread.start();
//
//
//    }



}
