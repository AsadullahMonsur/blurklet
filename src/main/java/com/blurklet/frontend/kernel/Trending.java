package com.blurklet.frontend.kernel;

import com.blurklet.frontend.accessories.ProductCard;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import java.util.ArrayList;

public class Trending extends HorizontalLayout {
    private VerticalLayout bench_stack;
    private HorizontalLayout []layers;

    public Trending() {
        bench_stack = new VerticalLayout();
        bench_stack.setHeightFull();
        bench_stack.setWidthFull();
        bench_stack.getStyle().set("alignItems","center");

        layers = new HorizontalLayout[]{
                           new HorizontalLayout(),
                           new HorizontalLayout(),
                           new HorizontalLayout(),
                           new HorizontalLayout(),
                           new HorizontalLayout(),
                           new HorizontalLayout()};

        operate_layers_horizontal();
        operate_layers_vertical();

        bench_stack.add(layers[0],layers[1],layers[2],
                        layers[3],layers[4],layers[5]);
        add(bench_stack);

    }

    private void operate_layers_vertical() {
        layers[4].setWidthFull();
        layers[5].setWidthFull();

        layers[4].setHeight("16px");
        layers[5].setHeight("512px");

        layers[4].getStyle().set("justify-content", "center");
        layers[5].getStyle().set("justify-content", "center");

        layers[4].add(new Button("Special Offers"));

        Tabs tt = new Tabs();
        tt.setWidthFull();
        tt.setHeightFull();
        tt.setFlexGrowForEnclosedTabs(1);
        tt.setOrientation(Tabs.Orientation.HORIZONTAL);
        tt.getStyle().set("justify-content", "center");

        Tab man_section = new Tab("Man Clothes");
        man_section.setFlexGrow(1);
        man_section.add(get_grid(1));
        Tab woman_section = new Tab("Woman Clothes");
        woman_section.setFlexGrow(1);
        woman_section.add(get_grid(1));
        tt.add(man_section,woman_section);

        layers[5].add(tt);
    }

    private void operate_layers_horizontal() {
        layers[0].setWidthFull();
        layers[1].setWidthFull();
        layers[2].setWidthFull();
        layers[3].setWidthFull();

        layers[0].setHeight("16px");
        layers[1].setHeight("384px");
        layers[2].setHeight("16px");
        layers[3].setHeight("384px");

        layers[0].getStyle().set("justify-content", "left");
        layers[1].getStyle().set("alignItems", "center");
        layers[2].getStyle().set("justify-content", "left");
        layers[3].getStyle().set("alignItems", "center");

        layers[0].add(new Button("New Collections"));
        layers[2].add(new Button("Most Popular"));

        layers[1].add(get_grid(0));
        layers[3].add(get_grid(0));

    }

    private Tabs get_grid(int direction) {
        // direction 0 for horizontal, 1 for vertical
        Tabs grid = new Tabs();
        grid.setWidthFull();
        grid.setHeight("384px");

        grid.setFlexGrowForEnclosedTabs(1);
        grid.getStyle().set("alignItems", "center");

        if(direction==0){
            grid.setOrientation(Tabs.Orientation.HORIZONTAL);

        }
        else if (direction==1){
            grid.setOrientation(Tabs.Orientation.VERTICAL);
        }

        load_card_to_grid(grid);

        return grid;
    }

    private void load_card_to_grid(Tabs grid) {
        ArrayList<ProductCard> card_list;
        card_list = new ArrayList<ProductCard>();

        for (int i =0; i<5;i++){
            grid.add(new Tab(get_card(""+i)));
        }
    }

    private ProductCard get_card(String counter){
        ProductCard card = new ProductCard();
        card.attach_image("fo");
        card.setWidth("312px");
        card.setHeightFull();
        card.getNumber().removeAll();
        card.setIdentity(new Span(counter));
        card.getIdentity().getStyle().set("fontSize", "95%");
        card.getNumber().add(card.getIdentity());
        card.getNumber().getStyle().set("alignItems", "center");
        card.getStyle().set("alignItems", "center");
        return card;
    }
}
