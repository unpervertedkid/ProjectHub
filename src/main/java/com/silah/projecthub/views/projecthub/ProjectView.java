package com.silah.projecthub.views.projecthub;

import com.silah.projecthub.entities.Project;
import com.silah.projecthub.services.ProjectService;
import com.silah.projecthub.views.projecthub.pagesections.Header;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.richtexteditor.RichTextEditorVariant;
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
            loadProject(project);
            loadFeedbackButtons();

        }
        else {
            add(new PageNotFoundView());
        }
    }

    private void loadFeedbackButtons() {
        Icon likeIcon = new Icon("lumo", "thumbs-up");
        Icon dislikeIcon = new Icon("lumo", "thumbs-down");

        likeIcon.getStyle().set("margin-right", "5px");
        dislikeIcon.getStyle().set("margin-right", "5px");

        //Make the icons clickable
        likeIcon.addClickListener(e -> {
            Notification notification = new Notification("You liked this project", 3000);
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        });
        dislikeIcon.addClickListener(e -> {
            Notification notification = new Notification("You disliked this project", 3000);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });

        add(likeIcon, dislikeIcon);
    }

    private void loadProject(Optional<Project> project) {
        if (project.isEmpty()) add(new PageNotFoundView());

        add(Header.createHeader(Optional.of(List.of(new H1(project.get().getName())))));
        H1  descriptionTitle =new H1("Description");
        Text description = new Text(project.get().getDescription());
        add(descriptionTitle, description);

        H1 guideHeader = new H1("Guide");
        RichTextEditor guide = new RichTextEditor();
        guide.setValue(project.get().getGuide());
        guide.setReadOnly(true);
        guide.addThemeVariants(RichTextEditorVariant.LUMO_COMPACT);
        add(guideHeader,guide);
    }

}
