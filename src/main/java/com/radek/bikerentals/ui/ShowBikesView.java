package com.radek.bikerentals.ui;


import com.radek.bikerentals.dto.BikeDTO;
import com.radek.bikerentals.mapper.BikeMapper;
import com.radek.bikerentals.service.BikeService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "bikes", layout = MainView.class)
public class ShowBikesView extends VerticalLayout {

    private Grid<BikeDTO> bikes = new Grid<>();
    private Button button = new Button("Refresh");

    private BikeService bikeService;
    private BikeMapper bikeMapper;

    @Autowired
    public ShowBikesView(BikeService bikeService, BikeMapper bikeMapper) {
        this.bikeService = bikeService;
        this.bikeMapper = bikeMapper;

        //bikes.setItems(bikeMapper.toDTO(bikeService.findAll()));

        bikes.setColumnReorderingAllowed(true);
        bikes.addColumn(BikeDTO::getId).setHeader("Id");
        bikes.addColumn(BikeDTO::getSerialNumber).setHeader("Serial number");
        bikes.addColumn(BikeDTO::getCreatedAt).setHeader("Created at");
        bikes.addColumn(BikeDTO::getUpdatedAt).setHeader("Updated at");
        bikes.addColumn(BikeDTO::isBusy).setHeader("Is busy");

        button.addClickListener(buttonClickEvent -> {
            //bikes.setItems(bikeMapper.toDTO(bikeService.findAll()));
        });

        add(bikes); //dodaje tabelkę do wyświetlania

        add(button);
    }







}
