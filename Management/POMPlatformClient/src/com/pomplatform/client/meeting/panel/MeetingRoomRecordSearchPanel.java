package com.pomplatform.client.meeting.panel;

import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.meeting.datasource.MeetingInfoBase;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * 会议室预约记录的显示
 */
public class MeetingRoomRecordSearchPanel extends AbstractDetailViewer {

    private SearchForm __parentSearchForm;


    public MeetingRoomRecordSearchPanel() {
    }


    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public int getHorizontalPercent() {
        return 0;
    }

    @Override
    public String getName() {
        return "会议预约记录";
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public List<GroupColumn> getGroupColumnNames() {
        List<GroupColumn> gcs = new ArrayList<GroupColumn>();
        return gcs;
    }

    @Override
    public void load() {}


    @Override
    public void viewSelectedData(ListGrid grid){
        super.viewSelectedData(grid);
        setRecord(grid.getSelectedRecord());
        viewDetailData();
    }

    @Override
    public DataSource getMainDataSource() {
        return MeetingInfoBase.getInstance();
    }

    @Override
    public int getDetailCount() {
        return 0;
    }


    @Override
    public List<ListGrid> getDetailListGrids() {
        List<ListGrid> res = new ArrayList<ListGrid>();
        return res;
    }

    @Override
    public List<String> getDetailNames() {
        List<String> res = new ArrayList<String>();
        return res;
    }

    public SearchForm getParentSearchForm() {
        return this.__parentSearchForm;
    }

    public void setParentSearchForm( SearchForm value ) {
        this.__parentSearchForm = value;
    }

}
