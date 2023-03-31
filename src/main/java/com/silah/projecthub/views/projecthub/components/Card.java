package com.silah.projecthub.views.projecthub.components;

import com.silah.projecthub.entities.Project;
import com.silah.projecthub.entities.ProjectCategory;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Card {
    public   FlexLayout createCard(Project project) {
        FlexLayout card = new FlexLayout();
        card.setHeight("200px");
        card.setWidth("200px");

        //Make the card clickable
        card.getStyle().set("cursor", "pointer");
        //Add a click listener to the card
        card.addClickListener(event -> UI.getCurrent().navigate("projects/" + project.getId()));

        //Add a border and shadow to the card according to material design
        card.getStyle().set("border", "1px solid #e0e0e0");
        card.getStyle().set("box-shadow", "0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12)");
        card.getStyle().set("border-radius", "10px");
        card.getStyle().set("padding", "10px");
        card.getStyle().set("margin", "10px");

        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.setAlignItems(FlexComponent.Alignment.START);

        //Image placeholder.jpeg is in images folder in resources
        Image image = new Image("/images/CardPlaceHolder.jpg", "Project Image");
        image.setHeight("300px");
        image.setWidth("200px");

        H4 name = new H4(project.getName());
        ProjectCategory category = project.getCategory();

        card.add(image, name, new Text(category.toString()));

        return card;
    }

    public FlexLayout getProjectLayout(List<Project> projects) {
        FlexLayout flexLayout = new FlexLayout();
        flexLayout.setWidthFull();
        flexLayout.getStyle().set("padding", "10px");
        flexLayout.getStyle().set("gap", "10px");
        flexLayout.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        flexLayout.setAlignContent(FlexLayout.ContentAlignment.CENTER);

        int maxCardsPerRow = 6;
        int currentCardsInRow = 0;

        Div menuBarDiv = getMenuBarDiv();
        flexLayout.add(menuBarDiv);

        for (Project project : projects) {
            FlexLayout customCard = createCard(project);
            flexLayout.add(customCard);

            currentCardsInRow++;
            if (currentCardsInRow == maxCardsPerRow) {
                currentCardsInRow = 0;
            }
        }
        return flexLayout;
    }

    private Div getMenuBarDiv() {
        Div menuBarDiv = new Div();
        FlexLayout menuBarFlexLayout = new FlexLayout();
        menuBarFlexLayout.setJustifyContentMode(FlexLayout.JustifyContentMode.BETWEEN);
        menuBarFlexLayout.setWidthFull();
        menuBarFlexLayout.getStyle().set("padding", "10px");
        menuBarFlexLayout.getStyle().set("gap", "10px");
        menuBarFlexLayout.getStyle().set("margin-bottom", "10px");

        MenuBar menuBar = getMenuBar();
        TextField searchField = getSearchField();
        menuBarFlexLayout.add(menuBar, searchField);

        menuBarDiv.add(menuBarFlexLayout);

        menuBarDiv.setWidth("100%");

        return menuBarDiv;
    }

    private TextField getSearchField() {
        TextField searchField = new TextField();
        searchField.setPlaceholder("Search");
        searchField.setWidth("200px");
        searchField.setPrefixComponent(VaadinIcon.SEARCH.create());
        return searchField;
    }

    private MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();

        menuBar.setOpenOnHover(true);

        MenuItem categories = menuBar.addItem("Categories");
        SubMenu categorySubMenu = categories.getSubMenu();
        for(ProjectCategory category : ProjectCategory.values()){
            categorySubMenu.addItem(category.toString());
        }

        MenuItem languages = menuBar.addItem("Languages");
        SubMenu languageSubMenu = languages.getSubMenu();
        languageSubMenu.addItem("Java");
        languageSubMenu.addItem("Python");
        languageSubMenu.addItem("C++");
        languageSubMenu.addItem("C#");
        languageSubMenu.addItem("JavaScript");
        languageSubMenu.addItem("PHP");
        languageSubMenu.addItem("Ruby");
        languageSubMenu.addItem("Go");
        languageSubMenu.addItem("Swift");


        MenuItem sort = menuBar.addItem("Sort");
        SubMenu sortSubMenu = sort.getSubMenu();
        sortSubMenu.addItem("Newest");
        sortSubMenu.addItem("Oldest");
        sortSubMenu.addItem("Most Popular");
        sortSubMenu.addItem("Least Popular");
        sortSubMenu.addItem("Most Viewed");
        sortSubMenu.addItem("Least Viewed");



        return menuBar;
    }

}
