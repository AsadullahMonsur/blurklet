package com.blurklet.frontend.drawer;

import com.blurklet.frontend.accessories.PrelimComponents;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;

import java.util.*;

public class DrawerOperator {
    private ArrayList<HorizontalLayout> component_list;

    public DrawerOperator(PrelimComponents main_components) {
        component_list = new ArrayList<HorizontalLayout>();
        main_components.getDrawer()[0]
                       .getStyle()
                       .set("alignItems", "center");

        operate_section_01(main_components);
        operate_section_02(main_components);
        operate_section_03(main_components);
        operate_section_04(main_components);
        operate_section_05(main_components);
        operate_section_06(main_components);

        attach_all_section(main_components);
    }

    private void attach_all_section(PrelimComponents main_components) {

      for (HorizontalLayout layout: component_list){
          main_components.getDrawer()[0].add(layout);
      }
    }

    private void operate_section_06(PrelimComponents main_components) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.getStyle().set("alignItems", "center");

        VerticalLayout v = new VerticalLayout();
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(get_span("Cloth Color"));

        HorizontalLayout h2 = new HorizontalLayout();
        List<String> list = Arrays.asList(
                                  "Black","White",
                                  "Yellow","Red","Pink","Orange",
                                  "Violate/Purple","Blue", "Green");

        Set<String> items = new LinkedHashSet<>(list);


        formulate_multi_choice_schema(h2,items,"Black",6);

        v.add(h1,h2);
        layout.add(v);
        component_list.add(layout);
    }

    private void operate_section_05(PrelimComponents main_components) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.getStyle().set("alignItems", "center");

        VerticalLayout v = new VerticalLayout();
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(get_span("Cloth Size"));

        HorizontalLayout h2 = new HorizontalLayout();
        List<String> list = Arrays.asList(
                                  "Small","Medium",
                                  "Large","Extra-Large","Inhuman");

        Set<String> items = new LinkedHashSet<>(list);


        formulate_multi_choice_schema(h2,items,"Large",5);

        v.add(h1,h2);
        layout.add(v);
        component_list.add(layout);
    }

    private void operate_section_04(PrelimComponents main_components) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.getStyle().set("alignItems", "center");

        VerticalLayout v = new VerticalLayout();
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(get_span("Cloth Brand"));

        HorizontalLayout h2 = new HorizontalLayout();
        List<String> list = Arrays.asList(
                                  "Bomba","Gotuli",
                                  "Lotol","Others");

        Set<String> items = new LinkedHashSet<>(list);


        formulate_multi_choice_schema(h2,items,"Lotol",4);

        v.add(h1,h2);
        layout.add(v);
        component_list.add(layout);
    }

    private void operate_section_03(PrelimComponents main_components) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.getStyle().set("alignItems", "center");

        VerticalLayout v = new VerticalLayout();
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(get_span("Cloth Type"));

        HorizontalLayout h2 = new HorizontalLayout();
        List<String> list = Arrays.asList(
                            "T-Shirt","Half-Shirt","Full-Shirt",
                            "Pan`-ja-bi","Half-Pant","Full-Pant",
                            "Handkerchief","Muffler","Hat/Cap",
                            "Mask","Others");

        Set<String> items = new LinkedHashSet<>(list);


        formulate_multi_choice_schema(h2,items,"Half-Shirt",3);

        v.add(h1,h2);
        layout.add(v);
        component_list.add(layout);
    }

    private void operate_section_02(PrelimComponents main_components) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.getStyle().set("alignItems", "center");

        VerticalLayout v = new VerticalLayout();

        NumberField price_from = new NumberField("Select Price From");
        price_from.setValue(1d);
        price_from.setHasControls(true);
        price_from.setStep(10);
        price_from.setMin(1);
        price_from.setMax(101);
        price_from.setWidthFull();

        NumberField price_to = new NumberField("Select Price Up-to");
        price_to.setValue(101d);
        price_to.setHasControls(true);
        price_to.setStep(10);
        price_to.setMin(1);
        price_to.setMax(101);
        price_to.setWidthFull();

        formulate_price_ranger_schema(price_from,price_to);

        v.add(price_from,price_to);
        layout.add(v);
        component_list.add(layout);
    }

    private void operate_section_01(PrelimComponents main_components) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.getStyle().set("alignItems", "center");

        VerticalLayout v = new VerticalLayout();
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(get_span("Customer Type"));

        HorizontalLayout h2 = new HorizontalLayout();
        Set<String> items = new LinkedHashSet<>(
                                Arrays.asList("Male",
                                              "Female",
                                              "Children"));

        formulate_multi_choice_schema(h2,items,"Male",1);

        v.add(h1,h2);
        layout.add(v);
        component_list.add(layout);
    }

    public ArrayList<HorizontalLayout> getComponent_list() {
        return component_list;
    }

    private void formulate_price_ranger_schema(NumberField price_from,
                                               NumberField price_to) {
        SectionManager02 manager = new SectionManager02();
        manager.listen_to_section_02_price_from(price_from,price_to);
        manager.listen_to_section_to_price_to(price_from,price_to);
    }

    private void formulate_multi_choice_schema(HorizontalLayout h,
                                               Set<String> items,
                                               String choice, int type){

        Checkbox box = new Checkbox("Select all");
        CheckboxGroup<String> group = new CheckboxGroup<>();

        group.setItems(items);
        group.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        group.setValue(Collections.singleton(choice));
        h.add(box,group);

        if(type==1){
            SectionManager01 manager = new SectionManager01();
            manager.listen_to_section_01_box(box,group,items);
            manager.listen_to_section_01_group(box,group,items);
        }
        else if (type==3){
            SectionManager03 manager = new SectionManager03();
            manager.listen_to_section_03_box(box,group,items);
            manager.listen_to_section_03_group(box,group,items);
        }
        else if(type==4){
            SectionManager04 manager = new SectionManager04();
            manager.listen_to_section_04_box(box,group,items);
            manager.listen_to_section_04_group(box,group,items);
        }
        else if(type==5){
            SectionManager05 manager = new SectionManager05();
            manager.listen_to_section_05_box(box,group,items);
            manager.listen_to_section_05_group(box,group,items);
        }
        else if(type==6){
            SectionManager06 manager = new SectionManager06();
            manager.listen_to_section_06_box(box,group,items);
            manager.listen_to_section_06_group(box,group,items);
        }
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
