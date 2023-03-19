package com.silah.projecthub.views.projecthub;

import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Login")
@Route(value = "login")
public class LoginView extends VerticalLayout {
    public LoginView() {
        createLoginForm();
    }

    private void createLoginForm() {
        HorizontalLayout loginLayout = new HorizontalLayout();
        loginLayout.setWidthFull();
        loginLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        LoginOverlay loginForm = new LoginOverlay();
        loginForm.setTitle("ProjectHub");
        loginForm.setDescription("Please login to continue");
        loginForm.setOpened(true);
        loginForm.setForgotPasswordButtonVisible(false);

        loginLayout.add(loginForm);

        add(loginLayout);
    }
}
