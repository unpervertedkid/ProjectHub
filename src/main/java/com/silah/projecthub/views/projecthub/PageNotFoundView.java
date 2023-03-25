package com.silah.projecthub.views.projecthub;

import com.silah.projecthub.views.projecthub.pagesections.Header;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.Optional;

public class PageNotFoundView extends VerticalLayout {
    public PageNotFoundView() {
        add(Header.createHeader(Optional.empty()));
        displayPageNotFound();
    }

    private void displayPageNotFound() {

        VerticalLayout PageNotFound = new VerticalLayout();
        PageNotFound.setSpacing(false);

        Image img = new Image("images/PageNotFound.png", "404 image ");
        img.setWidth("200px");

        H2 header = new H2("Yeah we know its a bummer, but...");
        header.addClassNames(LumoUtility.Margin.Top.XLARGE, LumoUtility.Margin.Bottom.MEDIUM);

        Paragraph paragraph = new Paragraph("The page you are looking for does not exist😔");

        PageNotFound.add(img, header, paragraph);

        PageNotFound.setSizeFull();
        PageNotFound.setJustifyContentMode(JustifyContentMode.CENTER);
        PageNotFound.setAlignItems(Alignment.CENTER);
        PageNotFound.getStyle().set("text-align", "center");

        add(PageNotFound);
    }
}
