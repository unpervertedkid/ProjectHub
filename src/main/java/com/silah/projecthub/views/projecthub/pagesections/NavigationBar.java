package com.silah.projecthub.views.projecthub.pagesections;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class NavigationBar extends AppLayout {
    public NavigationBar() {
        addNavigationBar();
    }
    public void addNavigationBar(){
        HorizontalLayout iconTab = getIconTab();

        HorizontalLayout buttons = getButtons();

        addToNavbar(iconTab, buttons);
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttonLayout = new HorizontalLayout();

        Button loginButton = getLoginButton();
        Button registerButton = getRegisterButton();

        buttonLayout.add(loginButton, registerButton);

        buttonLayout.setMargin(true);
        buttonLayout.setSizeFull();
        buttonLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        return buttonLayout;
    }

    private Button getRegisterButton() {
        Button registerButton = new Button("Register");
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        registerButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("register"));
        return registerButton;
    }

    private Button getLoginButton() {
        Button loginButton = new Button("Login");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("login"));
        return loginButton;
    }

    private HorizontalLayout getIconTab() {
        HorizontalLayout iconLayout = new HorizontalLayout();

        Icon homeIcon = new Icon(VaadinIcon.BULLSEYE);
        homeIcon.getStyle().set("cursor", "pointer");
        homeIcon.addClickListener(iconClickEvent -> UI.getCurrent().navigate(""));

        Span homeSpan = new Span("ProjectHub");
        homeSpan.getStyle().set("cursor", "pointer");
        homeSpan.addClickListener(spanClickEvent -> UI.getCurrent().navigate(""));

        iconLayout.add(homeIcon, homeSpan);
        iconLayout.setMargin(true);
        iconLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        iconLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        iconLayout.setSpacing(true);

        return iconLayout;
    }
}
