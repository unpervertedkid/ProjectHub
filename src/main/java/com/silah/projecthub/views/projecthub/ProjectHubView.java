package com.silah.projecthub.views.projecthub;

import com.silah.projecthub.entities.Project;
import com.silah.projecthub.services.ProjectService;
import com.silah.projecthub.views.projecthub.components.Card;
import com.silah.projecthub.views.projecthub.pagesections.NavigationBar;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.List;

@PageTitle("ProjectHub")
@Route(value = "projects")
@RouteAlias(value = "")
public class ProjectHubView extends AppLayout {
    FlexLayout projectLayout;

    public ProjectHubView(ProjectService projectService, Card card) {
        addToNavbar(new NavigationBar());

        getElement().getStyle().set("height", "100%");

        List<Project> projects = projectService.getAllProjects();

        MenuBar menuBar = getMenuBar();

        projectLayout = card.getProjectLayout(projects);

        setContent(projectLayout);
    }

    private MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();

        MenuItem categories = menuBar.addItem("Categories");
        MenuItem languages = menuBar.addItem("Languages");
        MenuItem sort = menuBar.addItem("Sort");

        return menuBar;
    }


}
