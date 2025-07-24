package com.pomplatform.client.areas.panel;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.areas.datasource.DSSareaaaor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.Map;

/**
 * @param null
 * @author liubin
 * @return
 * @creed: write code
 * @date 2020-04-16 16:31
 * @describe: 新增区域界面
 */
public class AddArealPanel extends VLayout {

    private DelicacyListGrid grid = new DelicacyListGrid();
    private DynamicForm form;

    private TextItem areaNameItem;
    private TextItem areaNameEnItem;
    private TextItem allNameItem;
    private TextItem areaLevelItem;

    public PopupWindow parentWindow;

    public PopupWindow getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(PopupWindow parentWindow) {
        this.parentWindow = parentWindow;
    }

    public void initComponents() {

        setWidth("98%");
        setHeight100();
        setPadding(10);
        setMembersMargin(5);

        VLayout formLayout = new VLayout();
        formLayout.setHeight("20%");
        formLayout.setMembersMargin(5);
        formLayout.setWidth100();
        formLayout.setAlign(Alignment.CENTER);
        addMember(formLayout);

        VLayout childLayout = new VLayout();
        childLayout.setWidth100();
        childLayout.setHeight("80%");
        childLayout.setAlign(Alignment.CENTER);
        addMember(childLayout);

        form = new DynamicForm();
        form.setNumCols(6);
        form.setAlign(Alignment.CENTER);
        form.setWidth("95%");
        form.setHeight100();

        areaNameItem = new TextItem("areaName", "区域简称");
        areaNameItem.setWidth("*");
        areaNameItem.setCanEdit(true);

        areaNameEnItem = new TextItem("areaNameEn", "区域英文名称");
        areaNameEnItem.setWidth("*");
        areaNameEnItem.setCanEdit(true);

        allNameItem = new TextItem("allName", "区域全名");
        allNameItem.setWidth("*");
        allNameItem.setCanEdit(true);

        areaLevelItem = new TextItem("areaLevel", "等级");
        areaLevelItem.setWidth("*");
        areaLevelItem.hide();
        areaLevelItem.setCanEdit(true);

        form.setItems(areaNameItem, areaNameEnItem, allNameItem, areaLevelItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        formLayout.addMember(form);

        grid.setDataSource(DSSareaaaor.getInstance());
        grid.setAutoFitFieldWidths(false);
        grid.setCanEdit(true);
        childLayout.addMember(grid);

        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight("5%");
        btnLayout.setMembersMargin(5);
        btnLayout.setLayoutTopMargin(10);
        btnLayout.setAlign(Alignment.RIGHT);
        childLayout.addMember(btnLayout);

        IButton addSecondArealButton = new IButton("新增二级区域");
        btnLayout.addMember(addSecondArealButton);
        addSecondArealButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                grid.addData(new Record());
            }
        });

        IButton deleteSecondArealButton = new IButton("删除二级区域");
        btnLayout.addMember(deleteSecondArealButton);
        deleteSecondArealButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (!grid.anySelected()) {
                    SC.say("提示", "请选择需要删除的数据");
                    return;
                }
                ListGridRecord[] selectedRecords = grid.getSelectedRecords();
                for (ListGridRecord selectedRecord : selectedRecords) {
                    grid.removeData(selectedRecord);
                }
            }
        });

        IButton saveButton = new IButton("保存数据");
        btnLayout.addMember(saveButton);
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (checkData()) {
                    Map params = getValueMap();
                    params.put("optType", "saveAreal");
                    DBDataSource.callOperation("EP_ArealProcess", params, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                            if (dsResponse.getStatus() >= 0) {
                                SC.say("保存成功");
                                getParentWindow().destroy();
                            } else {
                                SC.say("保存失败");
                            }
                        }
                    });
                }
            }
        });
    }

    /**
     * @param null
     * @return 封装数据
     * @author liubin
     * @creed: write code
     * @date 2020-04-16 17:50
     * @describe:
     */
    private Map getValueMap() {
        Map param = form.getValues();
        ListGridRecord[] rows = grid.getRecords();
        MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "lists");
        return param;
    }

    /**
     * @param null
     * @return
     * @author liubin
     * @creed: write code
     * @date 2020-04-16 17:20
     * @describe: 保存数据
     */
    private boolean checkData() {
        Boolean flag = true;
        if (null == areaNameItem.getValue()) {
            SC.say("请输入区域简称");
            flag = false;
        }
        if (null == allNameItem.getValue()) {
            SC.say("请输入区域全称");
            flag = false;
        }
        if (null == grid.getRecords() || grid.getRecords().length == 0) {
            SC.say("请添加子区域");
            flag = false;
        }
        return flag;
    }
}
