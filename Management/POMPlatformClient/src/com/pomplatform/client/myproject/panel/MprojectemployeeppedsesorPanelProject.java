package com.pomplatform.client.myproject.panel;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractTimelinePanel;
import com.pomplatform.client.myproject.datasource.DSMprojectemployeeppedsesor;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.Lane;
import com.smartgwt.client.widgets.calendar.events.CalendarEventClick;
import com.smartgwt.client.widgets.calendar.events.EventClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class MprojectemployeeppedsesorPanelProject extends AbstractTimelinePanel {

    private final Logger __logger = Logger.getLogger("");

    public MprojectemployeeppedsesorPanelProject() {
        super();
    }

    @Override
    public String getLaneName() {
        return "employeeId";
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
                String lname = String.valueOf(ClientUtil.checkAndGetIntValue(r.getAttribute("employeeId")));
                String employeeName = KeyValueManager.getValueMap("employees").get(lname);
                ces[idx] = new CalendarEvent(ClientUtil.checkAndGetIntValue(r.getAttribute("employeeId")), employeeName, employeeName,
                        r.getAttributeAsDate("startDate") == null ? r.getAttributeAsDate("planStartDate") : r.getAttributeAsDate("startDate"),
                        r.getAttributeAsDate("endDate") == null ? r.getAttributeAsDate("planEndDate") : r.getAttributeAsDate("endDate"), lname);
                DBDataSource.copyRecord(r, ces[idx]);
                lanes[idx] = new Lane(lname, employeeName);
                lanes[idx].setAttribute(getLaneName(), employeeName);
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
        return DSMprojectemployeeppedsesor.getInstance();
    }

    @Override
    public void initComponents() {
        resultGrid.addEventClickHandler(new EventClickHandler() {
            @Override
            public void onEventClick(CalendarEventClick event) {
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
    public boolean showPagination() {
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
