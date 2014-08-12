package com.home.organiza;

import com.vaadin.cdi.CDIUI;
import com.vaadin.data.Property;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.io.File;

/**
 *
 * @author ajar
 */
@CDIUI
public class WelcomePage extends UI {

    public static final String C = "C:\\";
    FilesystemContainer docs=createFileSystem(C);
    Table fileList= new Table("",docs);

    @Override
    protected void init(VaadinRequest request) {
        setContent(createContent());
        setSizeFull();
    }

    private VerticalLayout createContent() {
        VerticalLayout content = new VerticalLayout();
        TextField textField = createTextField();
        content.addComponent(textField);
        content.addComponent(fileList);
        return content;
    }

    private TextField createTextField() {
        TextField  textField = new TextField();
        textField.setValue(C);
        textField.setImmediate(true);
        textField.addValueChangeListener((Property.ValueChangeEvent event) -> {
            // Do something with the value
            fileList.setContainerDataSource(createFileSystem((String) event.getProperty().getValue()));
            Notification.show("Value is: " + event.getProperty().getValue());
        });
        return textField;
    }

    private FilesystemContainer createFileSystem(String path) {
        return new FilesystemContainer(new File(path),false);
    }


}
