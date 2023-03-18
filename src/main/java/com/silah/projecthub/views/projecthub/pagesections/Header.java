package com.silah.projecthub.views.projecthub.pagesections;

import com.silah.projecthub.entities.ProjectCategory;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;


public class Header extends HorizontalLayout {
    public static HorizontalLayout createHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setAlignItems(Alignment.CENTER);
        header.setPadding(true);

        Icon logo = new Icon(VaadinIcon.BULLSEYE);
        Button login = createButton("Login");
        Button register = createButton("Register");
        TextField searchField = createSearchField();
        Select<ProjectCategory> projectDropDown = getProjectDropDown();

        HorizontalLayout buttons = new HorizontalLayout(login, register);
        HorizontalLayout logoLayout = new HorizontalLayout(logo);
        HorizontalLayout searchLayout = new HorizontalLayout(searchField, projectDropDown);


        header.add(logoLayout, searchLayout, buttons);

        header.setWidthFull();
        header.setJustifyContentMode(JustifyContentMode.BETWEEN);
        return header;
    }
    private static Button createButton(String name) {
        Button button = new Button(name);
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return button;
    }

    public static TextField createSearchField() {
        TextField searchField = new TextField();
        searchField.setWidth("300px");
        searchField.setPlaceholder("Search Projects");
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        searchField.addFocusShortcut(Key.KEY_S, KeyModifier.CONTROL);


        searchField.addKeyPressListener(Key.ENTER, keyPressEvent -> {
            String searchValue = searchField.getValue();
            Notification notification = Notification.show("Project: " + searchValue + " not found! Please try another.", 3000, Notification.Position.BOTTOM_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

        });
        return searchField;
    }

    public static Select<ProjectCategory> getProjectDropDown(){
        Select<ProjectCategory> projectDropDown = new Select<>();
        projectDropDown.setItems(ProjectCategory.values());
        projectDropDown.setValue(ProjectCategory.BACKEND);
        return projectDropDown;
    }
}
