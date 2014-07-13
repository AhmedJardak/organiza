package com.home.organiza;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 *
 * @author ajar
 */
@CDIUI
public class WelcomePage extends UI {


    public static final String ORGANIZA_WELCOME_PAGE = "organiza Welcome Page";

    @Override
    protected void init(VaadinRequest request) {
        setSizeFull();

        String message = ORGANIZA_WELCOME_PAGE;
        Label label = new Label(message);
        setContent(new HorizontalLayout(label));
    }
}
