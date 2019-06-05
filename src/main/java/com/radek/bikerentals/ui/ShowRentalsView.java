package com.radek.bikerentals.ui;

import com.radek.bikerentals.dto.RentalDTO;
import com.radek.bikerentals.mapper.RentalMapper;
import com.radek.bikerentals.service.RentalService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "rentals", layout = MainView.class)
public class ShowRentalsView extends VerticalLayout {

    private Grid<RentalDTO> rentals = new Grid<>();

    private RentalService rentalService;
    private RentalMapper rentalMapper;

    @Autowired
    public ShowRentalsView(RentalService rentalService, RentalMapper rentalMapper) {
        this.rentalService = rentalService;
        this.rentalMapper = rentalMapper;

        //rentals.setItems(rentalMapper.toDTO(rentalService.findAll()));

        rentals.setColumnReorderingAllowed(true);

        rentals.addColumn(RentalDTO::getId).setHeader("Id");
        rentals.addColumn(RentalDTO::getBikeId).setHeader("Bike id");
        rentals.addColumn(RentalDTO::getUserId).setHeader("User id");
        rentals.addColumn(RentalDTO::getStartedAt).setHeader("Started at");
        rentals.addColumn(RentalDTO::getFinishedAt).setHeader("Finished at");
        rentals.addColumn(RentalDTO::getStartLatitude).setHeader("Start latitude");
        rentals.addColumn(RentalDTO::getEndLatitude).setHeader("End latitude");
        rentals.addColumn(RentalDTO::getStartLongitude).setHeader("Start longitude");
        rentals.addColumn(RentalDTO::getEndLongitude).setHeader("End longitude");
        rentals.addColumn(RentalDTO::getPrice).setHeader("Price");

        add(rentals);
    }


}
