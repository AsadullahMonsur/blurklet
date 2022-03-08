package com.blurklet.frontend.zomba;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

//@Route("boom")
//@StyleSheet("resources://styles/tab/tablet.css")
public class Boom extends VerticalLayout {
    public Boom() {

        addClassName("tablet");
        Button b = new Button("bbb");
        b.addClassName("tablet");
        b.addFocusListener(event -> {

            b.getStyle().set("background-color","black");
        });

        add(b);
    }
}
