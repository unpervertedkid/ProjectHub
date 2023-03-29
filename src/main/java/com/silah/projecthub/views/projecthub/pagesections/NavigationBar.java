package com.silah.projecthub.views.projecthub.pagesections;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServletRequest;

public class NavigationBar extends AppLayout {
    public NavigationBar() {
        addNavigationBar();
    }

    public void addNavigationBar() {
        Tab iconTab = getIconTab();

        HorizontalLayout buttons = getButtons();

        Tabs navigationTabs = getNavigationTabs();

        addToNavbar(iconTab, navigationTabs, buttons);
    }

    private Tabs getNavigationTabs() {
        Tab projectsTab = new Tab("Projects");
        Tab createTab = new Tab("Create");
        Tab communityTab = new Tab("Community");

        Tabs navigationTabs = new Tabs(projectsTab, createTab, communityTab);
        navigationTabs.setSelectedTab(currentUrlTab(projectsTab, createTab, communityTab));
        navigationTabs.setSizeFull();
        navigationTabs.setAutoselect(false);
        navigationTabs.addThemeVariants(TabsVariant.LUMO_CENTERED);

        navigationTabs.addSelectedChangeListener(selectedChangeEvent -> navigateToSelected(projectsTab, createTab, communityTab, selectedChangeEvent));

        return navigationTabs;

    }

    private Tab currentUrlTab(Tab projectsTab, Tab createTab, Tab communityTab) {

        // TODO: This is a hacky way to get the current url. Find a better way to do this.
        VaadinServletRequest req = (VaadinServletRequest) VaadinService.getCurrentRequest();
        StringBuffer uriString = req.getRequestURL();
        String uri = uriString.toString();

        System.out.println(uri);

        if (uri.contains("create")) {
            return createTab;
        } else if (uri.contains("community")) {
            return communityTab;
        } else {
            return projectsTab;
        }
    }

    private static void navigateToSelected(Tab projectsTab, Tab create, Tab community, Tabs.SelectedChangeEvent selectedChangeEvent) {
        if (selectedChangeEvent.getSelectedTab() == create) {
            UI.getCurrent().navigate("projects/create");
        } else if (selectedChangeEvent.getSelectedTab() == projectsTab) {
            UI.getCurrent().navigate("projects");
        } else if (selectedChangeEvent.getSelectedTab() == community) {
            UI.getCurrent().navigate("community");
        }
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttonLayout = new HorizontalLayout();

        Button loginButton = getLoginButton();
        Button registerButton = getRegisterButton();

        buttonLayout.add(loginButton, registerButton);

        buttonLayout.setMargin(true);
        buttonLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        buttonLayout.setPadding(false);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        return buttonLayout;
    }

    private Button getRegisterButton() {
        Button registerButton = new Button("Register");
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        registerButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        registerButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("register"));
        return registerButton;
    }

    private Button getLoginButton() {
        Button loginButton = new Button("Login");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        loginButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("login"));
        return loginButton;
    }

    private Tab getIconTab() {
        Icon logo = new Icon(VaadinIcon.BULLSEYE);
        logo.getStyle().set("cursor", "pointer");
        logo.addClickListener(iconClickEvent -> UI.getCurrent().navigate(""));

        Label projectName = new Label("ProjectHub");
        HorizontalLayout labelLayout = new HorizontalLayout(projectName);
        labelLayout.add(projectName);
        labelLayout.getStyle().set("cursor", "pointer");
        labelLayout.addClickListener(labelClickEvent -> UI.getCurrent().navigate(""));

        return new Tab(logo, labelLayout);
    }
}
