package com.pomplatform.client.employeerescord.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.pomplatform.client.common.SetManageProjectIntegralAssign;
import com.pomplatform.client.common.SetPlateIntegralAssign;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class EmployeePanel extends AbstractSearchPanel {
    private static final Logger __logger = Logger.getLogger("");
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            EmployeePanel cm = new EmployeePanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Employee";
        }
    }
    
    public int flag;

    public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
    public void initComponents() {
        resultGrid.setCanEdit(false);
        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
//        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });
        
        IButton addButton = new IButton("添加");
        controlLayout.addMember(addButton);
        addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addRecord();
			}
		});

        ListGridField[] fields = new ListGridField[5];
        int idx = 0;
        fields[idx] = new ListGridField("employeeId");
        fields[idx].setCanEdit(false);
        fields[idx].setHidden(true);
        PickTreeItem employeeIdPickTree = new PickTreeItem();
        employeeIdPickTree.setCanSelectParentItems(true);
        employeeIdPickTree.setValueField("treeId");
        employeeIdPickTree.setValueTree(KeyValueManager.getTree("employees", ""));
        fields[idx].setEditorProperties(employeeIdPickTree);
        idx++;
        fields[idx] = new ListGridField("employeeNo");
        idx++;
        fields[idx] = new ListGridField("employeeName");
        idx++;
        fields[idx] = new ListGridField("departmentId");
        fields[idx].setHidden(true);
        PickTreeItem departmentIdPickTree = new PickTreeItem();
        departmentIdPickTree.setCanSelectParentItems(true);
        departmentIdPickTree.setValueField("treeId");
        departmentIdPickTree.setValueTree(KeyValueManager.getTree("departments"));
        fields[idx].setEditorProperties(departmentIdPickTree);
        idx++;
        fields[idx] = new ListGridField("plateId");
        idx++;
        resultGrid.setFields(fields);
        resultGrid.setShowFilterEditor(true);
        resultGrid.setFilterOnKeypress(false);
        
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
            	addRecord();
            }
        });
        
        resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                Map params = resultGrid.getRecord(event.getRowNum()).toMap();
                final int rowNumModified = event.getRowNum();
                DBDataSource.callOperation("ST_Employee", "saveOrUpdate", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        } else {
                            DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
                            resultGrid.redraw();
                        }
                    }
                });
            }
        });
        
        commonQuery();
    }
	
	@Override
	public void init() {
		super.init();
		__needViewPage = false;
	}
	
    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSEmployee.getInstance();
    }
    
    //当双击和点击同步图标按钮时触发的公用方法
    public void addRecord(){
    	if (!resultGrid.anySelected()) {
            SC.say("请选择一条数据");
            return;
        }
    	ListGridRecord[] selected = resultGrid.getSelectedRecords();
        //获取到职员id
        int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
        if(employeeId <= 0){
            return;
        }
        if(flag == 1){//表示是管理项目的积分发放的操作
        	//设置发放积分
        	double assignIntegral = 0;
        	//设置已发放积分
        	double assignedIntegral = 0;
        	//获取左边所有的gird数据
        	ListGridRecord[] records = SetManageProjectIntegralAssign.grid.getRecords();
        	//根据当前employeeId检索是否已存在左边的grid，如果存在则不新增，如果不存在则新增
        	if(records.length > 0){
        		for(ListGridRecord record : records){
        			if(ClientUtil.checkAndGetIntValue(record.getAttribute("employeeId")) == employeeId){
        				return;
        			}
        		}
        	}
        	//左边gird新增一条记录
        	Record record  = new Record();
        	record.setAttribute("employeeId", employeeId);
        	record.setAttribute("assignIntegral", assignIntegral);
        	record.setAttribute("assignedIntegral", assignedIntegral);
        	SetManageProjectIntegralAssign.grid.addData(record);
        }else{
        	//设置发放积分
        	double assignIntegral = 0;
        	//获取左边所有的gird数据
        	ListGridRecord[] records = SetPlateIntegralAssign.grid.getRecords();
        	//根据当前employeeId检索是否已存在左边的grid，如果存在则不新增，如果不存在则新增
        	if(records.length > 0){
        		for(ListGridRecord record : records){
        			if(ClientUtil.checkAndGetIntValue(record.getAttribute("employeeId")) == employeeId){
        				return;
        			}
        		}
        	}
        	//左边gird新增一条记录
        	Record record  = new Record();
        	record.setAttribute("employeeId", employeeId);
        	record.setAttribute("assignIntegral", assignIntegral);
        	SetPlateIntegralAssign.grid.addData(record);
        }
    }

}
