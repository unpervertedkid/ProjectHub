package com.silah.projecthub.views.projecthub.pagesections;

import com.silah.projecthub.entities.ProjectCategory;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;

public class ProjectCreationForm extends VerticalLayout {
    public ProjectCreationForm() {
        add(createProjectCreationForm());
    }

    private HorizontalLayout createProjectCreationForm() {
        TextField projectName = new TextField("Project Name");
        projectName.setRequired(true);
        projectName.setRequiredIndicatorVisible(true);

        TextField projectDescription = new TextField("Project Description");
        projectDescription.setRequired(true);
        projectDescription.setRequiredIndicatorVisible(true);

        Select<ProjectCategory> projectCategory = new Select<>();
        projectCategory.setLabel("Project Category");
        projectCategory.setItems(ProjectCategory.values());
        projectCategory.setRequiredIndicatorVisible(true);



        Text description = new Text("Project Guidelines");

        RichTextEditor richTextEditor = new RichTextEditor();
        richTextEditor.setMaxHeight("500px");
        richTextEditor.setMaxWidth("500");

        richTextEditor.setRequiredIndicatorVisible(true);


        Button saveButton = new Button("Save");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.setMaxWidth("10px");

        FormLayout formLayout = new FormLayout();
        formLayout.add(projectName, projectCategory, projectDescription, description, richTextEditor, saveButton);
        formLayout.setColspan(projectDescription,3);
        formLayout.setColspan(richTextEditor,3);

        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1), new FormLayout.ResponsiveStep("21em", 2));

        return new HorizontalLayout(formLayout);

    }


}
