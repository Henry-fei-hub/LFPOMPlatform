package com.pomplatform.client.designer.panel;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author guanxgun
 */
public class DesignWorkPanel extends VLayout {

    public DesignWorkPanel() {
        setWidth100();
        setHeight100();
        setMembersMargin(5);

        VLayout myprojectPanel = new VLayout(5);

        Label myprojectTitle = new Label("我的项目");
        myprojectTitle.setHeight(50);
        myprojectTitle.setAlign(Alignment.CENTER);
        myprojectPanel.addMember(myprojectTitle);

        myprojectPanel.addMember(new DesignerProjectPanel());

        VLayout myinvitationPanel = new VLayout(5);

        Label myinvitationTitle = new Label("我收到的邀请");
        myinvitationTitle.setHeight(50);
        myinvitationTitle.setAlign(Alignment.CENTER);
        myinvitationPanel.addMember(myinvitationTitle);

        myinvitationPanel.addMember(new MprojectemployeeporPanel());

        if (Browser.getIsDesktop()) {
            HLayout myworkPanel = new HLayout(10);
            myworkPanel.setWidth100();
            myworkPanel.setHeight100();
            myprojectPanel.setWidth100();
            myprojectPanel.setHeight100();
            myworkPanel.addMember(myprojectPanel);
//            myinvitationPanel.setWidth("50%");
//            myinvitationPanel.setHeight100();
//            myworkPanel.addMember(myinvitationPanel);
            addMember(myworkPanel);
        } else {
            myprojectPanel.setWidth100();
            myprojectPanel.setHeight("100%");
            addMember(myprojectPanel);
//            myinvitationPanel.setWidth100();
//            myinvitationPanel.setHeight("50%");
//            addMember(myinvitationPanel);
        }
    }
}
