package com.blurklet.frontend.drawer;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.notification.Notification;

import java.util.Set;

public class SectionManager06 {
    public SectionManager06(){

    }

    public void listen_to_section_06_box(Checkbox box,
                                         CheckboxGroup<String> group, Set<String> items) {
      box.addValueChangeListener(event -> {
         if (box.getValue()) {
           group.setValue(items);
         }
         else {
           group.deselectAll();
         }
      });
    }

    public void listen_to_section_06_group(Checkbox box, CheckboxGroup<String> group, Set<String> items) {
      group.addValueChangeListener(event -> {
        if (event.getValue().size() == items.size()) {
          box.setValue(true);
          box.setIndeterminate(false);
          notification_short("All Selected");
        }

        else if (event.getValue().size() == 0) {
          box.setValue(false);
          box.setIndeterminate(false);
          notification_short("Selection is Reset");
        }

        else {
          box.setIndeterminate(true);
          notification_short(group.getSelectedItems().toString());

          if(group.isSelected("Black") &&
                  group.getSelectedItems().size()==1){
            notification_short("Only Black");
          }

          else if(group.isSelected("White") &&
                       group.getSelectedItems().size()==1){
             notification_short("Only White");
          }
        }
      });
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
