package com.silah.projecthub.views.projecthub;

import com.silah.projecthub.entities.Project;
import com.silah.projecthub.entities.ProjectCategory;
import com.silah.projecthub.services.ProjectService;
import com.silah.projecthub.views.projecthub.components.Card;
import com.silah.projecthub.views.projecthub.pagesections.NavigationBar;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("ProjectHub")
@Route(value = "projects")
@RouteAlias(value = "")
public class ProjectHubView extends HorizontalLayout {
    private final ProjectService projectService;

    public ProjectHubView(ProjectService projectService) {
        this.projectService = projectService;
        add(new NavigationBar());

        getElement().getStyle().set("height", "100%");


        Project testProject = new Project("Project 1", "Description 1", ProjectCategory.BACKEND, "A simple guide to doing this");


        FlexLayout flexLayout = getProjectLayout(testProject);

        add(flexLayout);


    }

    private static FlexLayout getProjectLayout(Project testProject) {
        FlexLayout flexLayout = new FlexLayout();
        flexLayout.setWidthFull();
        flexLayout.getStyle().set("padding", "10px");
        flexLayout.getStyle().set("gap", "10px");
        flexLayout.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        flexLayout.setAlignContent(FlexLayout.ContentAlignment.CENTER);

        int maxCardsPerRow = 6;
        int currentCardsInRow = 0;

        for (int i = 0; i < 10; i++) {
            FlexLayout customCard = Card.createCard(testProject);
            flexLayout.add(customCard);

            currentCardsInRow++;
            if (currentCardsInRow == maxCardsPerRow) {
                currentCardsInRow = 0;
            }
        }
        return flexLayout;
    }

    private void loadAllProjects() {
        // TODO: Load all projects from the database and display them
    }

}
