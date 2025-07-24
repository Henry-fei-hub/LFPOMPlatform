package com.pomplatform.client.workflow.reimbursement.panel;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.NewProcessWindow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author guangxun
 */
public class PersonalStuff extends DelicacyPanel {
    
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            PersonalStuff cm = new PersonalStuff();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "PersonalStuff";
        }

    }

    @Override
    public Canvas getViewPanel() {
        VLayout global = new VLayout();
        global.setWidth100();
        global.setHeight100();
        global.setPadding(10);
        
        IButton NewReimbursement = new IButton("差旅报销");
        global.addMember(NewReimbursement);
        NewReimbursement.addClickHandler(new ClickHandler(){
            @Override
            public void onClick(ClickEvent event) {
                NewProcessWindow Reimbursement = new NewProcessWindow();
                Reimbursement.setWidth("80%");
                Reimbursement.setHeight("80%");
                Reimbursement.setProcessId(1);
                Reimbursement.setLayoutMode(0);
                Reimbursement.initComponents();
                Reimbursement.setTitle("差旅报销");
                Reimbursement.show();
            }
            
        });
        
        return global;
    }
    
}
