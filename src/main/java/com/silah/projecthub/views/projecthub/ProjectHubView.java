package com.silah.projecthub.views.projecthub;

import com.silah.projecthub.entities.Project;
import com.silah.projecthub.entities.ProjectCategory;
import com.silah.projecthub.services.ProjectService;
import com.silah.projecthub.views.projecthub.components.Card;
import com.silah.projecthub.views.projecthub.pagesections.NavigationBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("ProjectHub")
@Route(value = "projects")
@RouteAlias(value = "")
public class ProjectHubView extends VerticalLayout{
    private final ProjectService projectService;

    public ProjectHubView(ProjectService projectService) {
        this.projectService = projectService;
        add(new NavigationBar());
        for (int i = 0; i < 10; i++){
            add(Card.createCard(new Project("Project 1", "Description 1", ProjectCategory.BACKEND, "A simple guide to doing this")));
        }
        add(Card.createCard(new Project("Project 1", "Description 1", ProjectCategory.BACKEND, "A simple guide to doing this")));

    }
    private void loadAllProjects() {
        // TODO: Load all projects from the database and display them
    }

}
