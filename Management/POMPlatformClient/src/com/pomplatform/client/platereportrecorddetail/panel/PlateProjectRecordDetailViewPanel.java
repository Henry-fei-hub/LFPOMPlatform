package com.pomplatform.client.platereportrecorddetail.panel;

import java.util.Date;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.platereportrecorddetail.form.PlateReportRecordDetailViewer;
import com.pomplatform.client.projectreportrecorddetail.panel.ProjectReportRecordDetailPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PlateProjectRecordDetailViewPanel extends VLayout {
	private static final Logger logger = Logger.getLogger("");
    public static PlateReportRecordDetailViewer plateReportRecordDetailView;
    public static ProjectReportRecordDetailPanel projectReportRecordDetailView;
    public static Label plateReportRecordDetailViewTitle;
    public static Label projectReportRecordDetailViewTitle;
    
	public PlateProjectRecordDetailViewPanel(int plateId,Date startDate,Date endDate,DelicacyListGrid resultGrid) {
		plateReportRecordDetailViewTitle = new Label("部门汇总");
		plateReportRecordDetailViewTitle.addStyleName("colorLabel");
		projectReportRecordDetailViewTitle = new Label("项目明细");
		projectReportRecordDetailViewTitle.addStyleName("colorLabel");
		plateReportRecordDetailView = new PlateReportRecordDetailViewer();
		plateReportRecordDetailView.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
		plateReportRecordDetailView.initComponents();
		plateReportRecordDetailView.viewSelectedData(resultGrid);
		
		projectReportRecordDetailView = new ProjectReportRecordDetailPanel();
		projectReportRecordDetailView.commonQuery();
        setHeight100();
        setMembersMargin(5);

        //部门汇总item
        VLayout plateIntegralAccountLayout = new VLayout(5);
        plateReportRecordDetailViewTitle.setHeight(50);
        plateReportRecordDetailViewTitle.setAlign(Alignment.CENTER);
        plateIntegralAccountLayout.addMember(plateReportRecordDetailViewTitle);
        plateIntegralAccountLayout.addMember(plateReportRecordDetailView);

        //项目积分汇总item
        VLayout achieveIntegralComeLayout = new VLayout(5);
        projectReportRecordDetailViewTitle.setHeight(50);
        projectReportRecordDetailViewTitle.setAlign(Alignment.CENTER);
        achieveIntegralComeLayout.addMember(projectReportRecordDetailViewTitle);
        achieveIntegralComeLayout.addMember(projectReportRecordDetailView);
        
        
        if (Browser.getIsDesktop()) {//pc端展示
        	//定义整个面板
            HLayout plateIntegralAccountRecordLayout = new HLayout(10);
            plateIntegralAccountRecordLayout.setWidth100();
            plateIntegralAccountRecordLayout.setHeight100();
            
            //定义左边的部门积分汇总的展示item，并设置其占整个面板的15%宽度，100%高度
            plateIntegralAccountLayout.setWidth("15%");
            plateIntegralAccountLayout.setHeight100();
            plateIntegralAccountRecordLayout.addMember(plateIntegralAccountLayout);
            
            //定义右边的项目积分汇总item，并设置宽度100%，高度100%
            achieveIntegralComeLayout.setWidth100();
            achieveIntegralComeLayout.setHeight100();
            plateIntegralAccountRecordLayout.addMember(achieveIntegralComeLayout);
            
            addMember(plateIntegralAccountRecordLayout);
        } else {//移动端展示
        	plateIntegralAccountLayout.setWidth100();
        	plateIntegralAccountLayout.setHeight("50%");
            addMember(plateIntegralAccountLayout);
            
            achieveIntegralComeLayout.setWidth100();
            achieveIntegralComeLayout.setHeight("50%");
            addMember(achieveIntegralComeLayout);
            
        }
    }

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
        	PlateProjectRecordDetailViewPanel cm = new PlateProjectRecordDetailViewPanel(0,null,null,null);
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "PlateReportRecordDoubleClick";
        }

    }
}
