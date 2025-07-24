package com.pomplatform.client.receivables.panel;

import com.delicacy.client.BasicPermissionStatic;
import com.delicacy.client.MapUtils;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.delicacy.client.app.datasource.DSMemployee;
import com.delicacy.client.app.form.MemployeeSearchForm;
import com.delicacy.client.app.form.MemployeeViewer;
import com.delicacy.client.app.form.NewMemployeeForm;
import com.delicacy.client.app.form.UpdateMemployeeForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.LinkedHashMap;
import java.util.Map;

public class CapitalEmployeePanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            CapitalEmployeePanel cm = new CapitalEmployeePanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Memployee";
        }

    }
    
    

    @Override
	public void init() {
    	super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
        __needViewPage = false;
	}

	@Override
    public void initComponents() {
		resultGrid.hideField("photo");
		resultGrid.hideField("employeeRoleNames");
//		resultGrid.hideField("plateId");
		resultGrid.hideField("gradeId");
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        /*resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });*/
        IButton addButton = new IButton("添加");
        controlLayout.addMember(addButton);
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord [] selectRecords =  resultGrid.getSelectedRecords();
            	ListGridRecord [] existRecords = employeeGrid.getRecords();
            	for (ListGridRecord __selectRecord : selectRecords) {
            		boolean flag = true;
            		int employeeId = __selectRecord.getAttributeAsInt("employeeId");
            		for (ListGridRecord __existRecord : existRecords) {
            			int __employeeId = __existRecord.getAttributeAsInt("employeeId");
            			if(employeeId == __employeeId){
            				flag = false;
            				break;
            			}
    				}
            		if(flag){
            			employeeGrid.addData(__selectRecord);
            		}
				}
            }
        });
        commonQuery();
    }

    public void showDetail() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                SC.say("failure to download code");
            }

            @Override
            public void onSuccess() {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("职员信息");
                detail.setWidth100();
                detail.setHeight100();
                MemployeeViewer detailForm = new MemployeeViewer();
                detailForm.setParentSearchForm(searchForm);
                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                detailForm.initComponents();
                detailForm.viewSelectedData(resultGrid);
                detail.setContent(detailForm);
                detail.centerInPage();
                detail.show();
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        ClientUtil.departmentParameterProcess(criteria);
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
    	MemployeeSearchForm form = new MemployeeSearchForm();
    	form.hideItem("plateId");
    	form.hideItem("roleId");
    	form.hideItem("gradeId");
    	form.hideItem("status");
    	form.hideItem("gender");
        return form;
    }

    @Override
    public DataSource getDataSource() {
        return DSMemployee.getInstance();
    }
    
    @Override
    public int getSearchFormHeight() {
        return 60;
    }
    
    public DelicacyListGrid employeeGrid;
    
}
