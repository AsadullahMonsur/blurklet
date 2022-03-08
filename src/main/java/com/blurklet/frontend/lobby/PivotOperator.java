package com.blurklet.frontend.lobby;

import com.blurklet.frontend.accessories.PrelimComponents;
import com.blurklet.frontend.kernel.Trending;

public class PivotOperator {
    private Trending trend_page;

    public PivotOperator(PrelimComponents main_components) {
       trend_page = new Trending();
       trend_page.setWidthFull();
       trend_page.getStyle().set("alignItems", "center");

       main_components.getBody()[0].setWidthFull();
       main_components.getBody()[0].setHeightFull();

       main_components.getBody()[0].add(trend_page);
    }
}
