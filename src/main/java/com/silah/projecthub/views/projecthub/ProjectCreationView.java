package com.silah.projecthub.views.projecthub;

import com.silah.projecthub.services.ProjectService;
import com.silah.projecthub.views.projecthub.pagesections.NavigationBar;
import com.silah.projecthub.views.projecthub.pagesections.ProjectCreationForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Project Creation")
@Route(value = "projects/create")
public class ProjectCreationView extends VerticalLayout {
    private final ProjectService projectService;
    public ProjectCreationView(ProjectService projectService) {
        this.projectService = projectService;
        add(new NavigationBar());
        add(new ProjectCreationForm(projectService));
    }
}
