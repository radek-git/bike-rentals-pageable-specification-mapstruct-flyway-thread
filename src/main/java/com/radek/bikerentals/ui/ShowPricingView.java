package com.radek.bikerentals.ui;

import com.radek.bikerentals.dto.PricingDTO;
import com.radek.bikerentals.mapper.PricingMapper;
import com.radek.bikerentals.service.PricingService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "pricing", layout = MainView.class)
public class ShowPricingView extends VerticalLayout {

    private Grid<PricingDTO> pricingDTOGrid = new Grid<>();

    private PricingService pricingService;
    private PricingMapper pricingMapper;

    @Autowired
    public ShowPricingView(PricingService pricingService, PricingMapper pricingMapper) {
        this.pricingService = pricingService;
        this.pricingMapper = pricingMapper;

        pricingDTOGrid.setItems(pricingMapper.toDTO(pricingService.findAll()));

        pricingDTOGrid.setColumnReorderingAllowed(true);
        pricingDTOGrid.addColumn(PricingDTO::getId).setHeader("Id");
        pricingDTOGrid.addColumn(PricingDTO::getName).setHeader("Name");
        pricingDTOGrid.addColumn(PricingDTO::getPrice).setHeader("Price");

        add(pricingDTOGrid);

    }
}
