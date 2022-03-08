package com.blurklet.frontend.lobby;

import com.blurklet.frontend.accessories.PrelimComponents;
import com.blurklet.frontend.drawer.DrawerOperator;
import com.blurklet.frontend.navigation.NavOperator;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("")
public class PrelimView extends AppLayout {
    private PrelimComponents main_components;

    public PrelimView(){
      try {
          DrawerToggle[] dtg = new DrawerToggle[]{
                  new DrawerToggle()};

          Tabs[] nav_tabs = new Tabs[]{
                  new Tabs()};

          VerticalLayout[] drawer = new VerticalLayout[]{
                  new VerticalLayout()};

          VerticalLayout []body = new VerticalLayout[]{
                  new VerticalLayout()};

          main_components = new PrelimComponents(dtg, nav_tabs, drawer,body);

          operate_drawer();
          operate_navigation();
          operate_body();
      }
      catch (Exception e){
          e.printStackTrace();
      }
    }

    private void operate_body() {
       setContent(main_components.getBody()[0]);
       PivotOperator pot = new PivotOperator(main_components);
    }

    private void operate_drawer() {
        addToDrawer(main_components.getDrawer()[0]);
        DrawerOperator dr_operator = new DrawerOperator(main_components);
    }

    private void operate_navigation() {
        final boolean touchOptimized = true;
        addToNavbar(touchOptimized,main_components.getNav_tabs()[0]);
        NavOperator nav_operator = new NavOperator(main_components);
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
