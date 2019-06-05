package com.radek.bikerentals.ui;

import com.radek.bikerentals.dto.PricingDTO;
import com.radek.bikerentals.entity.Pricing;
import com.radek.bikerentals.mapper.PricingMapper;
import com.radek.bikerentals.service.PricingService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


@Route(value = "pricing/add",layout = MainView.class)
public class AddPricingView extends VerticalLayout {

    private PricingService pricingService;
    private PricingMapper pricingMapper;

    private TextField name = new TextField("Name");
    private NumberField price = new NumberField("Price");
    private Button save = new Button("Add price");

    private Binder<PricingDTO> binder = new Binder<>();
    private PricingDTO pricingDTO = new PricingDTO();


    @Autowired
    public AddPricingView(PricingService pricingService, PricingMapper pricingMapper) {
        this.pricingService = pricingService;
        this.pricingMapper = pricingMapper;

        binder.setBean(pricingDTO);

        binder.forField(name)
                .asRequired("Field can't be empty")
                .bind(PricingDTO::getName, PricingDTO::setName);

        binder.forField(price)
                .asRequired("Field can't be empty");
//                .bind(price, dto -> dto.getPrice().doubleValue(),
//                        (dto, d) -> {
//                            BigDecimal bigDecimal = new BigDecimal(d);
//                            bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
//
//                            dto.setPrice(bigDecimal);
//                        });

        save.addClickListener(buttonClickEvent -> {
            binder.validate();
            if (binder.isValid()) {
                BigDecimal bigDecimal = new BigDecimal(price.getValue());
                bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
                pricingDTO.setPrice(bigDecimal);

                pricingService.save(pricingMapper.toEntity(pricingDTO));
                Notification.show("Price added");
            } else {
                Notification.show("Try again");
            }
        });


        add(name, price);
        add(save);

    }
}
