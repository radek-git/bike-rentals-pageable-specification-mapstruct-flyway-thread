package com.radek.bikerentals.ui;

import com.radek.bikerentals.dto.BikeDTO;
import com.radek.bikerentals.entity.Color;
import com.radek.bikerentals.mapper.BikeMapper;
import com.radek.bikerentals.repository.ColorRepository;
import com.radek.bikerentals.service.BikeService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

@Route(value = "bikes/add", layout = MainView.class)
public class AddBikeView extends VerticalLayout {

    private BikeService bikeService;
    private BikeMapper bikeMapper;
    private ColorRepository colorRepository;

    private TextField serialNumber = new TextField("Serial number");
    private DatePicker dateOfProduction = new DatePicker("Date of production");
    private Select<Color> color = new Select<>();
    private Button save = new Button("Add bike");

    private Binder<BikeDTO> binder = new BeanValidationBinder<>(BikeDTO.class);
    private BikeDTO bikeDTO = new BikeDTO();

    @Autowired
    public AddBikeView(BikeService bikeService, BikeMapper bikeMapper, ColorRepository colorRepository) {
        this.bikeService = bikeService;
        this.bikeMapper = bikeMapper;
        this.colorRepository = colorRepository;

        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        binder.setBean(bikeDTO);

        binder.forField(serialNumber)
                .asRequired("Field can't be empty")
                .withValidator(
                        serialNumber -> serialNumber.length() == 5,
                        "Length must be 5 characters"
                )
                .bind(BikeDTO::getSerialNumber, BikeDTO::setSerialNumber);

        binder.forField(dateOfProduction)
                .asRequired("Field can't be empty")
                .withValidator(
                        date -> date.isBefore(ChronoLocalDate.from(LocalDateTime.now())),
                        "Date must be earleir than now"
                )
                .bind(BikeDTO::getDateOfProduction, BikeDTO::setDateOfProduction);

        binder.forField(color)
                .asRequired("Field can't be empty");



        //binder.forField(dateOfProd).bind(BikeDTO::getDateOfProduction, BikeDTO::setDateOfProduction);

        List<Color> colors = colorRepository.findAll();

        color.setLabel("Color");
        color.setItems(colors);
        color.setValue(colors.get(0));
        color.setTextRenderer(Color::getName);
        color.setItemLabelGenerator(Color::getName);

        save.addClickListener(buttonClickEvent -> {

            binder.validate();
            if (binder.isValid()) {
                bikeDTO.setColor(color.getValue().getName());

                bikeService.save(bikeMapper.toEntity(bikeDTO));
                Notification.show("Bike added");
            } else {
                Notification.show("Try again");
            }

        });

        add(serialNumber, dateOfProduction, color);
        add(save);

    }
}
