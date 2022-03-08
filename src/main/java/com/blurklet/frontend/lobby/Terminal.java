package com.blurklet.frontend.lobby;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Route("terminal")
public class Terminal extends AppLayout{

    private DrawerToggle dg;
    private Tabs nav_tabs = new Tabs();

    public Terminal(){

        nav_tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        nav_tabs.setWidthFull();

        final boolean touchOptimized = true;
        addToNavbar(touchOptimized,nav_tabs);

        drawer_organiser();
        tab_organiser();
    }

    private void drawer_organiser() {
        VerticalLayout  layout  = new VerticalLayout();

        HorizontalLayout h1 = new HorizontalLayout();
        HorizontalLayout h2 = new HorizontalLayout();

        Checkbox box = new Checkbox("Select all");
        CheckboxGroup<String> group = new CheckboxGroup<>();

        Set<String> items = new LinkedHashSet<>(
                                      Arrays.asList("Option one", "Option two"));
        group.setItems(items);
        group.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        group.setValue(Collections.singleton("Option one"));
        h1.add(box,group);

        listener_selection(group,box,items);
        listener_action(group,box,items);

        layout.add(h1,h2);
        addToDrawer(layout);
    }

    private void tab_organiser() {
        dg = new DrawerToggle();

        nav_tabs.add(
                new Tab(dg),
                new Tab(get_h_layout()),
                new Tab(get_h_layout()),
                new Tab(get_h_layout())
                );

        nav_tabs.setFlexGrowForEnclosedTabs(1);
        addToNavbar(nav_tabs);
    }

    private Image get_image(){
        Image image = new Image(
                "https://randomuser.me/api/portraits/men/76.jpg", "Peter");
        image.setWidth("24px");
        image.setHeight("24px");
        image.getStyle().set("borderRadius", "50%");

        return  image;
    }

    private Span get_span(){
        Span span= new Span("cool guy");
        span.getStyle().set("fontSize", "75%");
        return span;
    }

    private HorizontalLayout get_h_layout(){
        HorizontalLayout layout = new HorizontalLayout(get_image(), get_span());
        layout.getStyle().set("alignItems", "center");
        return layout;
    }

    private void listener_selection(CheckboxGroup<String> group,Checkbox box,
                                  Set<String> items){
        group.addValueChangeListener(event -> {
            if (event.getValue().size() == items.size()) {
                box.setValue(true);
                box.setIndeterminate(false);
            }
            else if (event.getValue().size() == 0) {
                box.setValue(false);
                box.setIndeterminate(false);
            }
            else {
                box.setIndeterminate(true);
                if(group.isSelected("Option one")){
                    notification("option 1:"+getData());
                }
                else if(group.isSelected("Option two")){
                    notification("option 2");
                }
            }
        });
    }

    private void listener_action(CheckboxGroup<String> group,Checkbox box, Set<String> items){
     box.addValueChangeListener(event -> {
         if (box.getValue()) {
            group.setValue(items);
            notification("select either 1 or 2");
         }
         else {
            group.deselectAll();
            notification("Option is Reset");
         }
      });
    }

    private void notification(String msg){
        Notification notification = new Notification(
                                        msg,
                                       3000,
                                        Notification.Position.MIDDLE);
        notification.open();
    }

    private String getData(){
        return  "data taken from firebase";
    }
}
