package com.silah.projecthub.views.projecthub;

import com.silah.projecthub.entities.Project;
import com.silah.projecthub.services.ProjectService;
import com.silah.projecthub.views.projecthub.pagesections.Header;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.Optional;

@PageTitle("Project")
@Route(value = "projects")
public class ProjectView extends VerticalLayout implements HasUrlParameter<Long> {
    private final ProjectService projectService;

    public ProjectView(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long projectId) {
        Optional<Project> project = projectService.getProjectById(projectId);
        if (project.isPresent()){
            add(Header.createHeader(Optional.of(List.of(new H1(project.get().getName())))));
            Text text = new Text(project.get().getDescription());
            add(text);

            Text guide = new Text(project.get().getGuide());
            add(guide);

        }
        else {
            display404();
        }
    }

    private void display404() {
        add(Header.createHeader(Optional.of(List.of(new H1("404")))));
        H1 h1 = new H1("404");
        h1.getStyle().set("margin-left", "auto");
        h1.getStyle().set("margin-right", "auto");
        h1.getStyle().set("display", "block");
        add(h1);
    }
}
