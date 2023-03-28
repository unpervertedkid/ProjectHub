package com.silah.projecthub.views.projecthub.pagesections;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;

public class NavigationBar extends AppLayout {
    public NavigationBar() {
        addNavigationBar();
    }
    public void addNavigationBar(){
        Tabs iconTab = getIconTab();

        HorizontalLayout buttons = getButtons();

        Tabs navigationTabs = getNavigationTabs();

        addToNavbar(iconTab,navigationTabs,buttons);
    }

    private Tabs getNavigationTabs() {
        Tab projectsTab = getProjectTab();
        Tab createTab = getCreateTab();
        Tab communityTab = getCommunityTab();

        Tabs navigationTabs = new Tabs(projectsTab, createTab, communityTab);
        navigationTabs.setAutoselect(false);
        navigationTabs.addThemeVariants(TabsVariant.LUMO_CENTERED);

        navigationTabs.addSelectedChangeListener(selectedChangeEvent -> {
            navigateToSelected(projectsTab, createTab, communityTab, selectedChangeEvent);
        });

        return navigationTabs;

    }

    private static void navigateToSelected(Tab projectsTab, Tab create, Tab profile, Tabs.SelectedChangeEvent selectedChangeEvent) {
        if (selectedChangeEvent.getSelectedTab() == create) {
            UI.getCurrent().navigate("projects/create");
        } else if (selectedChangeEvent.getSelectedTab() == projectsTab) {
            UI.getCurrent().navigate("projects");
        } else if (selectedChangeEvent.getSelectedTab() == profile) {
            UI.getCurrent().navigate("community");
        }
    }

    private static Tab getCommunityTab() {
        Tab profile = new Tab("Community");
        return profile;
    }

    private static Tab getCreateTab() {
        Tab create = new Tab("Create");
        return create;
    }

    private static Tab getProjectTab() {
        Tab projectsTab = new Tab("Projects");
        return projectsTab;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttonLayout = new HorizontalLayout();

        Button loginButton = getLoginButton();
        Button registerButton = getRegisterButton();

        buttonLayout.add(loginButton, registerButton);

        buttonLayout.setMargin(true);
        buttonLayout.setSizeFull();
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

    private Tabs getIconTab() {
        Tab iconTab = new Tab(VaadinIcon.BULLSEYE.create(), new Span("ProjectHub"));
        Tabs iconTabs = new Tabs(iconTab);
        iconTabs.setSelectedTab(null);

        iconTabs.setAutoselect(false);

        iconTabs.addSelectedChangeListener(selectedChangeEvent -> {
            if (selectedChangeEvent.getSelectedTab() == iconTab) {
                UI.getCurrent().navigate("");
            }
        });
        return iconTabs;
    }
}
