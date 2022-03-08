package com.blurklet.frontend.drawer;

import com.vaadin.flow.component.textfield.NumberField;

public class SectionManager02 {
    public SectionManager02() {
    }

    public void listen_to_section_02_price_from(NumberField price_from,
                                                NumberField price_to) {
      price_from.addValueChangeListener(event -> {
         price_to.setMin(price_from.getValue());
         if(price_to.getValue()<price_from.getValue()) {
             price_to.setValue(price_from.getValue());
         }
      });
    }

    public void listen_to_section_to_price_to(NumberField price_from,
                                              NumberField price_to) {

    }
}
