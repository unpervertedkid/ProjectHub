package com.silah.projecthub.views.projecthub.components;

import com.silah.projecthub.entities.Project;
import com.silah.projecthub.entities.ProjectCategory;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
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
        card.addClickListener(event -> UI.getCurrent().navigate("projects/create"));

        //Add a border and shadow to the card according to material design
        card.getStyle().set("border", "1px solid #e0e0e0");
        card.getStyle().set("box-shadow", "0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12)");
        card.getStyle().set("border-radius", "10px");
        card.getStyle().set("padding", "10px");
        card.getStyle().set("margin", "10px");

        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.setAlignItems(FlexComponent.Alignment.START);

        //Image placeholder.jpeg is in images folder in resources
        Image image = new Image("/images/PlaceHolder1.jpg", "Project Image");
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

}
