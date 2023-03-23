package com.silah.projecthub.views.projecthub.pagesections;

import com.silah.projecthub.entities.ProjectCategory;
import com.silah.projecthub.services.ProjectService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.inject.Inject;

public class ProjectCreationForm extends VerticalLayout {
    @Inject
    private final ProjectService projectService;
    public ProjectCreationForm(ProjectService projectService) {
        add(createProjectCreationForm());
        this.projectService = projectService;
    }

    private HorizontalLayout createProjectCreationForm() {
        TextField projectName = getTextField();

        Select<ProjectCategory> projectCategory = getProjectCategorySelect();

        TextField projectDescription = getProjectDescription();

        Text description = new Text("Project Guidelines");

        RichTextEditor richTextEditor = getRichTextEditor();

        Button saveButton = createSaveButton();
        saveButton.addClickListener(click -> {
            Notification notification = Notification.show("Project, " + projectName.getValue() + " is being saved", 3000, Notification.Position.BOTTOM_CENTER);
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

            ProgressBar progressBar = getProgressBar();
            long projectId = projectService.saveProject(projectName.getValue(), projectDescription.getValue(), projectCategory.getValue(), richTextEditor.getValue());

            progressBar.setVisible(false);

            UI.getCurrent().navigate("projects/" + projectId);

            add(progressBar);
        });

        FormLayout formLayout = getFormLayout(projectName, projectCategory, projectDescription, description, richTextEditor, saveButton);

        return new HorizontalLayout(formLayout);

    }

    private static FormLayout getFormLayout(TextField projectName, Select<ProjectCategory> projectCategory, TextField projectDescription, Text description, RichTextEditor richTextEditor, Button saveButton) {
        FormLayout formLayout = new FormLayout();
        formLayout.add(projectName, projectCategory, projectDescription, description, richTextEditor, saveButton);
        formLayout.setColspan(projectDescription,3);
        formLayout.setColspan(richTextEditor,3);

        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1), new FormLayout.ResponsiveStep("21em", 2));
        return formLayout;
    }

    private static RichTextEditor getRichTextEditor() {
        RichTextEditor richTextEditor = new RichTextEditor();
        richTextEditor.setMaxHeight("500px");
        richTextEditor.setMaxWidth("500");
        richTextEditor.setRequiredIndicatorVisible(true);
        return richTextEditor;
    }

    private static TextField getProjectDescription() {
        TextField projectDescription = new TextField("Project Description(300 Characters)");
        projectDescription.setHeight("70px");
        projectDescription.setRequired(true);
        projectDescription.setRequiredIndicatorVisible(true);
        projectDescription.setMaxLength(300);
        return projectDescription;
    }

    private static Select<ProjectCategory> getProjectCategorySelect() {
        Select<ProjectCategory> projectCategory = new Select<>();
        projectCategory.setLabel("Project Category");
        projectCategory.setItems(ProjectCategory.values());
        projectCategory.setRequiredIndicatorVisible(true);
        projectCategory.setHeight("70px");
        return projectCategory;
    }

    private static TextField getTextField() {
        TextField projectName = new TextField("Project Name");
        projectName.setRequired(true);
        projectName.setRequiredIndicatorVisible(true);
        return projectName;
    }

    private static ProgressBar getProgressBar() {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setMinWidth("500px");
        progressBar.setMinHeight("5px");
        progressBar.setMin(0);
        progressBar.setMax(100);
        progressBar.setValue(50);
        return progressBar;
    }

    private Button createSaveButton() {
        Button saveButton = new Button("Save");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.setMaxWidth("10px");

        return saveButton;
    }


}
