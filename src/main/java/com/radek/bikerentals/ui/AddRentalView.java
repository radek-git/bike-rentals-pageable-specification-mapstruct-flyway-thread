package com.radek.bikerentals.ui;

import com.radek.bikerentals.dto.RentalDTO;
import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.User;
import com.radek.bikerentals.mapper.RentalMapper;
import com.radek.bikerentals.repository.BikeRepository;
import com.radek.bikerentals.service.RentalService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

import java.util.List;


@Route(value = "rentals/add", layout = MainView.class)
public class AddRentalView extends VerticalLayout {

    private RentalService rentalService;
    private RentalMapper rentalMapper;
    private BikeRepository bikeRepository;

    private ComboBox<Bike> bikeComboBox = new ComboBox<>("Bikes");
    private ComboBox<User> userComboBox = new ComboBox<>("Users");

    private Button save = new Button("Add rental");
    private Binder<RentalDTO> binder = new BeanValidationBinder<>(RentalDTO.class);
    private RentalDTO rentalDTO = new RentalDTO();

    public AddRentalView(RentalService rentalService, RentalMapper rentalMapper, BikeRepository bikeRepository) {
        this.rentalService = rentalService;
        this.rentalMapper = rentalMapper;
        this.bikeRepository = bikeRepository;

        List<Bike> bikes = bikeRepository.findAll();
        ListDataProvider<Bike> dataProvider = DataProvider.ofCollection(bikes);
        bikeComboBox.setDataProvider(dataProvider);


        binder.setBean(rentalDTO);

        save.addClickListener(buttonClickEvent -> {
            binder.validate();
            if (binder.isValid()) {
                rentalService.save(rentalMapper.toEntity(rentalDTO));
                Notification.show("Rental added");
            } else {
                Notification.show("Tyr again");
            }
        });




        add(save);

    }
}
