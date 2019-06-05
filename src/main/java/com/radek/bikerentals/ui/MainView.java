package com.radek.bikerentals.ui;

import com.vaadin.flow.component.applayout.AbstractAppRouterLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;

public class MainView extends AbstractAppRouterLayout {

    public MainView() {
    }



    @Override
    protected void configure(AppLayout appLayout, AppLayoutMenu menu) {

        addMenuItem(menu, new AppLayoutMenuItem("Pokaż rowery", "bikes"));
        addMenuItem(menu, new AppLayoutMenuItem("Pokaż klientów", "users"));
        addMenuItem(menu, new AppLayoutMenuItem("Pokaż wypożyczenia", "rentals"));
        addMenuItem(menu, new AppLayoutMenuItem("Pokaż cennik", "pricing"));
        addMenuItem(menu, new AppLayoutMenuItem("Login", "login"));
        addMenuItem(menu, new AppLayoutMenuItem("Dodaj rower", "bikes/add"));
        addMenuItem(menu, new AppLayoutMenuItem("Doadaj użytkownika", "users/add"));
        addMenuItem(menu, new AppLayoutMenuItem("Dodaj cenę", "pricing/add"));
        addMenuItem(menu, new AppLayoutMenuItem("Dodaj wypożyczenie", "rentals/add"));
        addMenuItem(menu, new AppLayoutMenuItem("Rejestracja użytkownika", "users/save"));

    }


    private void addMenuItem(AppLayoutMenu menu, AppLayoutMenuItem menuItem) {
        menuItem.getElement().setAttribute("theme", "icon-on-top");
        menu.addMenuItem(menuItem);
    }
}
