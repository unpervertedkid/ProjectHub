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

        VerticalLayout PageNotFound = getLayout();

        Image img = getImage();

        H2 header = getHeader();

        Paragraph description = getDescription();

        PageNotFound.add(img, header, description);

        add(PageNotFound);
    }

    private static VerticalLayout getLayout() {
        VerticalLayout PageNotFound = new VerticalLayout();
        PageNotFound.setSizeFull();
        PageNotFound.setJustifyContentMode(JustifyContentMode.CENTER);
        PageNotFound.setAlignItems(Alignment.CENTER);
        PageNotFound.getStyle().set("text-align", "center");
        PageNotFound.setSpacing(false);
        return PageNotFound;
    }

    private static Paragraph getDescription() {
        Paragraph description = new Paragraph("The page you are looking for does not exist😔.");
        return description;
    }

    private static H2 getHeader() {
        H2 header = new H2("Yeah we know its a bummer, but...");
        header.addClassNames(LumoUtility.Margin.Top.XLARGE, LumoUtility.Margin.Bottom.MEDIUM);
        return header;
    }

    private static Image getImage() {
        Image img = new Image("images/PageNotFound.png", "404 image ");
        img.setWidth("200px");
        return img;
    }
}
