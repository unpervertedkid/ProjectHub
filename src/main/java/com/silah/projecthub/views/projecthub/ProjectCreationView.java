package com.silah.projecthub.views.projecthub;

import com.silah.projecthub.services.ProjectService;
import com.silah.projecthub.views.projecthub.pagesections.Header;
import com.silah.projecthub.views.projecthub.pagesections.ProjectCreationForm;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.Optional;

@PageTitle("Project Creation")
@Route(value = "projects/create")
public class ProjectCreationView extends VerticalLayout {
    private final ProjectService projectService;
    public ProjectCreationView(ProjectService projectService) {
        this.projectService = projectService;
        add(Header.createHeader(Optional.of(List.of(new H2("Create a new project")))));
        add(new ProjectCreationForm(projectService));
    }
}
