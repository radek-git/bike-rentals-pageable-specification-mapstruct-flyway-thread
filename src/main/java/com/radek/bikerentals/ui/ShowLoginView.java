package com.radek.bikerentals.ui;

import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "login")
public class ShowLoginView extends VerticalLayout {

    private LoginOverlay login;

    public ShowLoginView() {
        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("Vaadin Test App");
        i18n.getHeader().setDescription("...");
        i18n.setAdditionalInformation(null); //dezaktywacja dodatkowego opisu poniżej Description

        login = new LoginOverlay();
        login.setI18n(i18n);
        login.setForgotPasswordButtonVisible(false);
        login.setAction("login");
        login.setOpened(true);

        add(login);
    }


}
