package com.pomplatform.client.workflow.personnel.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyMainProjectValue;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liubin
 * @description //TODO 我的工时详情页面
 * @date 12:48 2020/2/24
 **/
public class WorkHourdetailForm extends AbstractWizadPage {

    private DelicacyListGrid grid = new DelicacyListGrid();
    private Record record;

    private IButton newButton;
    private IButton delOneButton;
    private IButton delAllButton;

    @Override
    public Record getRecord() {
        return record;
    }

    @Override
    public void setRecord(Record record) {
        this.record = record;
    }

    ListGridField[] fields = new ListGridField[3];

    public WorkHourdetailForm(Boolean canEidtor) {
        //左边的主界面
        HLayout mainLayout = new HLayout();
        addMember(mainLayout);
        //右边的控制界面
        VLayout controller = new VLayout();
        controller.setHeight100();
        controller.setWidth(60);
        controller.setLayoutTopMargin(30);
        controller.setLayoutLeftMargin(5);
        controller.setLayoutRightMargin(5);
        controller.setMembersMargin(10);
        addMember(controller);

        int index = 0;
        fields[index] = new ListGridField("projectCode", "项目编号");
        fields[index].setHidden(false);
        KeyValueManager.loadValueMap("main_projects_code", fields[index]);
        fields[index].setWidth("30%");
        fields[index].setCanEdit(false);
        index++;

        ComboBoxItem contractIdItem = new ComboBoxItem("projectId", "项目名称");
        contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        fields[index] = new ListGridField("projectId", "项目名称");

        fields[index].setHidden(false);
        fields[index].setCanEdit(true);
        fields[index].setWidth("50%");
        fields[index].setEditorProperties(contractIdItem);
        KeyValueManager.loadValueMap("main_projects_name", fields[index]);
        KeyValueManager.loadValueMap("main_projects_name", contractIdItem);
        fields[index].addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent changedEvent) {
                int projectId = BaseHelpUtils.getIntValue(changedEvent.getValue());
                DynamicForm form = changedEvent.getForm();
                form.getField("projectCode").setValue(projectId);
            }
        });
        index++;

        fields[index] = new ListGridField("workHour", "工时(小时)");
        fields[index].setHidden(false);
        fields[index].setCanEdit(true);
        fields[index].setWidth("20%");
        fields[index].setType(ListGridFieldType.FLOAT);
        fields[index].setFormat("#,###,###,###,###,##0.00");

        grid.setFields(fields);
        grid.setAutoFitFieldWidths(false);
        mainLayout.addMember(grid);

        newButton = new IButton("新增");
        newButton.addClickHandler( new ClickHandler(){
            @Override
            public void onClick(ClickEvent event) {
                grid.startEditingNew();
            }
        });
        controller.addMember(newButton);

        delOneButton = new IButton("删除");
        controller.addMember(delOneButton);
        delOneButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (!grid.anySelected()) {
                    SC.say("提示", "请至少选择一条数据删除");
                    return;
                } else {
                    ListGridRecord[] selectedRecords = grid.getSelectedRecords();
                    for (ListGridRecord selectedRecord : selectedRecords) {
                        grid.removeData(selectedRecord);
                    }
                }
            }
        });


        delAllButton = new IButton("删除所有");
        delAllButton.addClickHandler( new ClickHandler(){
            @Override
            public void onClick(ClickEvent event) {
                grid.setData(new RecordList());
            }
        });
        controller.addMember(delAllButton);

        camEditor(canEidtor);
    }

    private void camEditor(Boolean canEidtor) {
        if (canEidtor) {
            grid.setCanEdit(true);
            delAllButton.show();
            delOneButton.show();
            newButton.show();
        } else {
            grid.setCanEdit(false);
            delAllButton.hide();
            delOneButton.hide();
            newButton.hide();
        }
    }

    @Override
    public Map getValuesAsMap() {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        ListGridRecord[] records = grid.getRecords();
        for (ListGridRecord listGridRecord : records) {
            list.add(listGridRecord.toMap());
        }
        map.put("workHoursDetails", list);
        return map;
    }

    @Override
    public boolean checkData() {
        ListGridRecord[] records = grid.getRecords();
        if (BaseHelpUtils.isNullOrEmpty(records) || records.length == 0) {
            SC.say("提示", "请填写项目信息");
            return false;
        } else {
            for (ListGridRecord listGridRecord : records) {
                String projectId = listGridRecord.getAttribute("projectId");
                String workHour = listGridRecord.getAttribute("workHour");
                String projectCode = listGridRecord.getAttribute("projectCode");
                if (BaseHelpUtils.isNullOrEmpty(projectId)) {
                    SC.say("提示", "请选择项目");
                    return false;
                }
                if (BaseHelpUtils.isNullOrEmpty(workHour)) {
                    SC.say("提示", "请填写工时");
                    return false;
                }
                if (BaseHelpUtils.isNullOrEmpty(projectCode)) {
                    SC.say("提示", "请填写项目编号");
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public void startEdit() {
        Record record = getRecord();
        if (null != record) {
            //获取流程业务表的主键
            int personnelBusinessId = BaseHelpUtils.getIntValue(record.getAttribute("personnelBusinessId"));
            Map<String, Object> map = new HashMap<>();
            map.put("personnelBusinessId", personnelBusinessId);
            DBDataSource.callOperation("ST_WorkingHourLinkPersonnelBusines", "find", map, new DSCallback() {
                @Override
                public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                    if (dsResponse.getStatus() >= 0) {
                        Record[] data = dsResponse.getData();
                        if (null != data && data.length != 0) {
                            for (Record datum : data) {
                                datum.setAttribute("projectCode", datum.getAttribute("projectId"));
                            }
                        }
                        grid.setData(data);
                    } else {
                        SC.say("没有查询到流程数据");
                    }
                }
            });
        }
    }
}
