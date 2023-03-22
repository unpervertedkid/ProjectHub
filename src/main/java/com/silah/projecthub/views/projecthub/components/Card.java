package com.silah.projecthub.views.projecthub.components;

import com.silah.projecthub.entities.Project;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class Card extends Composite {
    public  static FlexLayout createCard(Project project) {
        FlexLayout card = new FlexLayout();
        card.setHeight("200px");
        card.setWidth("200px");

        //Make the card clickable
        card.getStyle().set("cursor", "pointer");
        //Add a click listener to the card
        card.addClickListener(event -> {
            UI.getCurrent().navigate("projects/create");
        });

        //Add a border and shadow to the card according to material design
        card.getStyle().set("border", "1px solid #e0e0e0");
        card.getStyle().set("box-shadow", "0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12)");
        card.getStyle().set("border-radius", "10px");
        card.getStyle().set("padding", "10px");
        card.getStyle().set("margin", "10px");

        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.setAlignItems(FlexComponent.Alignment.START);

        //Image placeholder.jpeg is in images folder in resources
        Image image = new Image("https://images.freeimages.com/images/large-previews/1c1/links-1242361.jpg", "Project Image");
        image.setHeight("300px");
        image.setWidth("200px");

        H4 name = new H4(project.getName());
        Text description = new Text(project.getDescription());

        card.add(image, name, description);

        return card;
    }

}
