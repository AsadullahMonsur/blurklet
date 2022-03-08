package com.blurklet.frontend.accessories;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ProductCard extends VerticalLayout {
    private HorizontalLayout number;
    private HorizontalLayout image_viewer;
    private HorizontalLayout content_option;
    private HorizontalLayout order_option;

    private Span identity;

    public ProductCard() {
        number = new HorizontalLayout();
        image_viewer = new HorizontalLayout();
        content_option = new HorizontalLayout();
        order_option = new HorizontalLayout();

        number.setWidthFull();
        image_viewer.setWidthFull();
        content_option.setWidthFull();
        order_option.setWidthFull();

        //number.setHeight("16px");
        image_viewer.setHeight("224px");
        content_option.setHeight("32px");
        order_option.setHeight("32px");

        this.add(number,
                 image_viewer,
                 content_option,
                 order_option);

        form_number();
        form_discount_option();
        form_details_option();
        form_order_option();
    }

    private void form_order_option() {
        Button order = new Button("Add to WishList");
        order.setWidthFull();
        order.getStyle().set("alignItems", "center");
        order_option.add(order);
    }

    private void form_details_option() {
        Button details = new Button("Details");
        details.setWidth("50%");
        details.getStyle().set("alignItems", "center");
        content_option.add(details);
    }

    private void form_discount_option() {
        Button discount = new Button("Discount");
        discount.setWidth("50%");
        discount.getStyle().set("alignItems", "center");
        content_option.add(discount);
    }


    private void form_number() {
        identity = new Span("Default");
        identity.getStyle().set("fontSize", "95%");

        number.getStyle().set("alignItems", "center");
        number.add(identity);
    }

    private HorizontalLayout form_gap(){
        HorizontalLayout gap = new HorizontalLayout();
        gap.setWidthFull();
        gap.setHeight("16px");

        return gap;
    }

    public void attach_image(String path){
        Image image = new Image("https://www.minnesotawildflowers.info/udata/r9ndp23q/yellow/common-buttercup_0620_115201.jpg","dummy");
        image.setHeightFull();
        image.setWidthFull();;
        image_viewer.add(image);
    }

    public HorizontalLayout getImage_viewer() {
        return image_viewer;
    }

    public void setImage_viewer(HorizontalLayout image_viewer) {
        this.image_viewer = image_viewer;
    }

    public HorizontalLayout getContent_option() {
        return content_option;
    }

    public void setContent_option(HorizontalLayout content_option) {
        this.content_option = content_option;
    }

    public HorizontalLayout getOrder_option() {
        return order_option;
    }

    public void setOrder_option(HorizontalLayout order_option) {
        this.order_option = order_option;
    }

    public HorizontalLayout getNumber() {
        return number;
    }

    public void setNumber(HorizontalLayout number) {
        this.number = number;
    }

    public Span getIdentity() {
        return identity;
    }

    public void setIdentity(Span identity) {
        this.identity = identity;
    }
}
