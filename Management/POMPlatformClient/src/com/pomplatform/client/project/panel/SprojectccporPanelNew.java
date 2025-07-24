package com.pomplatform.client.project.panel;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractTimelinePanel;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.myproject.panel.MprojectemployeeppedsesorPanelProject;
import com.pomplatform.client.project.datasource.DSSprojectccpor;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.Lane;
import com.smartgwt.client.widgets.calendar.events.CalendarEventClick;
import com.smartgwt.client.widgets.calendar.events.EventClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;

public class SprojectccporPanelNew extends AbstractTimelinePanel {

    public SprojectccporPanelNew(){
        super();
    }
    
    @Override
    public String getLaneName() {
        return "projectName";
    }

    @Override
    public int getLaneLength() {
        return 160;
    }

    @Override
    public void generateLaneData(Record[] data) {
        if (data == null) {
            return;
        }
        CalendarEvent[] ces = new CalendarEvent[data.length];
        Lane[] lanes = new Lane[data.length];
        int idx = 0;
        if (data.length > 0) {
            for (Record r : data) {
                String lname = String.valueOf(ClientUtil.checkAndGetIntValue(r.getAttribute("projectId")));
                ces[idx] = new CalendarEvent(ClientUtil.checkAndGetIntValue(r.getAttribute("projectId")), r.getAttribute(getLaneName()), r.getAttribute(getLaneName()),
                        r.getAttributeAsDate("startDate") == null ? r.getAttributeAsDate("planStartDate") : r.getAttributeAsDate("startDate"),
                        r.getAttributeAsDate("endDate") == null ? r.getAttributeAsDate("planEndDate") : r.getAttributeAsDate("endDate"), lname);
                DBDataSource.copyRecord(r, ces[idx]);
                lanes[idx] = new Lane(lname, r.getAttribute(getLaneName()));
                lanes[idx].setAttribute(getLaneName(), r.getAttribute(getLaneName()));
                idx++;
            }
        }
        resultGrid.setLanes(lanes);
        resultGrid.setData(ces);
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSSprojectccpor.getInstance();
    }

    @Override
    public void initComponents() {
        resultGrid.addEventClickHandler(new EventClickHandler() {
            @Override
            public void onEventClick(CalendarEventClick event) {
                event.cancel();
                CalendarEvent ce = event.getEvent();
                String projectId = ce.getAttribute("projectId");
                PopupWindow pw = new PopupWindow();
                MprojectemployeeppedsesorPanelProject myselfProject = new MprojectemployeeppedsesorPanelProject();
                myselfProject.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                pw.addItem(myselfProject.getViewPanel());
                pw.setTitle("项目成员时间表");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                myselfProject.commonQuery();
            }
        });
    }
    
    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("projectId", projectId);
        return true;
    }
    
    @Override
    public boolean showControlPanel() {
        return false;
    }
    
    @Override
    public boolean showPagination(){
        return false;
    }
    
    private int projectId = 0;

    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    

}
