package com.blurklet.frontend.accessories;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;

public class PrelimComponents {
   private DrawerToggle []dtg;
   private Tabs []nav_tabs;
   private VerticalLayout []drawer;
   private VerticalLayout []body;

    public PrelimComponents(DrawerToggle[] dtg, Tabs[] nav_tabs,
                            VerticalLayout[] drawer, VerticalLayout[] body) {
       this.dtg = dtg;
       this.nav_tabs = nav_tabs;
       this.drawer = drawer;
       this.body = body;
    }

    public DrawerToggle[] getDtg() {
        return dtg;
    }

    public Tabs[] getNav_tabs() {
        return nav_tabs;
    }

    public VerticalLayout[] getDrawer() {
        return drawer;
    }

    public VerticalLayout[] getBody() {
        return body;
    }
}
