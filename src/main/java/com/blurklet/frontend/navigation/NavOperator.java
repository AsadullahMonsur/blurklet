package com.blurklet.frontend.navigation;

import com.blurklet.frontend.accessories.PrelimComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.Theme;

import java.util.ArrayList;

public class NavOperator {

    private ArrayList<Tab> tab_list;

    public NavOperator(PrelimComponents main_components) {
        tab_list = new ArrayList<Tab>();
        main_components.getNav_tabs()[0]
                       .setOrientation(Tabs.Orientation.HORIZONTAL);
        main_components.getNav_tabs()[0]
                       .setFlexGrowForEnclosedTabs(1);
        main_components.getNav_tabs()[0].setWidthFull();
        main_components.getNav_tabs()[0].setHeight("85px");

        operate_tab_01(main_components);
        operate_tab_02(main_components);
        operate_tab_03(main_components);
        operate_tab_04(main_components);
        operate_tab_05(main_components);
        operate_tab_06(main_components);
        operate_tab_07(main_components);
        operate_tab_08(main_components);

        attach_all_tabs(main_components);
    }

    public ArrayList<Tab> getTab_list() {
        return tab_list;
    }

    private void operate_tab_08(PrelimComponents main_components) {
        Tab tab_08 = new Tab(get_tab_layout(
                                 get_icon(0),
                                 get_span("Logo")
                             ));
        tab_list.add(tab_08);
    }

    private void operate_tab_07(PrelimComponents main_components) {
        Tab tab_07 = new Tab(get_tab_layout(
                                 get_icon(0),
                                 get_span("Account")
                             ));
        tab_list.add(tab_07);
    }

    private void operate_tab_06(PrelimComponents main_components) {
        Tab tab_06 = new Tab(get_tab_layout(
                                 get_icon(0),
                                 get_span("WishList")
                             ));
        tab_list.add(tab_06);
    }

    private void operate_tab_05(PrelimComponents main_components) {
        TextField search_input = new TextField();
        search_input.setPlaceholder("Enter Keyword and Search");
        search_input.setWidth("250px");
        search_input.setClearButtonVisible(true);

        Button search_btn = new Button(new Icon(VaadinIcon.SEARCH));
        search_btn.setIconAfterText(true);

        HorizontalLayout layout = new HorizontalLayout(
                                      search_input,search_btn);

        Tab tab_05 = new Tab(layout);
        tab_list.add(tab_05);
    }

    private void operate_tab_04(PrelimComponents main_components) {
        Tab tab_04 = new Tab(get_tab_layout(
                                 get_icon(0),
                                 get_span("Contact")
                             ));
        tab_list.add(tab_04);
    }

    private void operate_tab_03(PrelimComponents main_components) {
        Tab tab_03 = new Tab(get_tab_layout(
                                 get_icon(0),
                                 get_span("About")
                             ));
        tab_list.add(tab_03);
    }

    private void operate_tab_02(PrelimComponents main_components) {
        Tab tab_02 = new Tab(get_tab_layout(
                                 get_icon(0),
                                 get_span("Trending")
                             ));

        tab_list.add(tab_02);
    }

    private void operate_tab_01(PrelimComponents main_components) {
        Tab tab_01 = new Tab(main_components.getDtg()[0]);
        tab_list.add(tab_01);
    }

    private void attach_all_tabs(PrelimComponents main_components) {
        for (Tab tab : tab_list) {
            main_components.getNav_tabs()[0]
                    .add(tab);
        }
        main_components.getNav_tabs()[0].setFlexGrowForEnclosedTabs(1);
    }

    private Image get_icon(int index){
        Image image = new Image(
                      "https://randomuser.me/api/portraits/men/76.jpg",
                      "Peter");
        image.setWidth("24px");
        image.setHeight("24px");
        image.getStyle().set("borderRadius", "50%");

        return  image;
    }

    private Span get_span(String title){
        Span span = new Span(title);
        span.getStyle().set("fontSize", "85%");
        return span;
    }

    private HorizontalLayout get_tab_layout(Image icon,Span title){
        HorizontalLayout layout = new HorizontalLayout(
                                      icon,title);

        layout.getStyle().set("alignItems", "center");
        return layout;
    }

    private void notification_short(String sms){
        Notification notification = new Notification(
                sms,
                600,
                Notification.Position.MIDDLE);
        notification.open();
    }

    private void notification_long(String sms,int duration){
        Notification notification = new Notification(
                sms,
                duration,
                Notification.Position.MIDDLE);
        notification.open();
    }
}
