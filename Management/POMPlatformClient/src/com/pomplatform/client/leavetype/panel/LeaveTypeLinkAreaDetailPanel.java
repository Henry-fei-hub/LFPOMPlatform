package com.pomplatform.client.leavetype.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.leavetype.datasource.DSLeaveType;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class LeaveTypeLinkAreaDetailPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private HLayout hLayout;
    
    //请假类型grid
    private TreeGrid leaveTypeGrid;
    //请假类型和省份关联信息
    LinkOfLeaveTypeAndAreaPanel areaPanel = new LinkOfLeaveTypeAndAreaPanel();
    
    public LeaveTypeLinkAreaDetailPanel() {
    	
    	hLayout = new HLayout();
    	hLayout.setWidth100();
    	hLayout.setHeight100();
    	hLayout.setBackgroundColor("#e2e2e2");
    	hLayout.setMargin(10);
    	hLayout.setMembersMargin(20);
        
    	//报销科目grid
    	leaveTypeGrid = new TreeGrid();
    	leaveTypeGrid.setWidth("40%");
    	TreeGridField[] fields = new TreeGridField[1];
    	int idx = 0;
		fields[idx] = new TreeGridField("leaveTypeName");
		fields[idx].setCanEdit(false);
		idx ++;
		leaveTypeGrid.setFields(fields);
		leaveTypeGrid.setShowFilterEditor(false);
		leaveTypeGrid.setFilterOnKeypress(false);
    	DSLeaveType leaveTypeDataSource = DSLeaveType.getInstance();
    	leaveTypeGrid.setDataSource(leaveTypeDataSource);
    	
        hLayout.addMember(leaveTypeGrid);
        hLayout.addMember(areaPanel);
    	
    	addMember(hLayout);
    	
    	//左边grid单击事件处理开始**********************************
    	leaveTypeGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				ListGridRecord[] selected = leaveTypeGrid.getSelectedRecords();
				//获取请假类型
				int leaveTypeId = BaseHelpUtils.getIntValue(selected[0].getAttribute("leaveTypeId"));
				areaPanel.setLeaveTypeId(leaveTypeId);
				areaPanel.commonQuery();
			}
		});
    }
    
    @Override
    public void startEdit() {
    	onLoadData();
    }
    
    //搜索方法
    private void onLoadData(){
    	//加载请假类型数据
    	loadLeaveType();
    }
    
    //加载业态表信息
    public void loadLeaveType(){
    	DSLeaveType ds = DSLeaveType.getInstance();
    	String operationName = ds.getActionMode() + ds.getActionName();
    	Map condition = new HashMap<>();
    	DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    fetchDataCallback(dsResponse, data);
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
    }
    
    public void fetchDataCallback(DSResponse response, Object rawData) {
		int len = response.getData().length;
		TreeNode[] nodes = new TreeNode[len];
		for (int i = 0; i < len; i++) {
			nodes[i] = new TreeNode();
			DBDataSource.copyRecord(response.getData()[i], nodes[i]);
		}
		Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setRootValue("0");
		tree.setIdField("leaveTypeId");
		tree.setParentIdField("parentId");
		tree.setData(nodes);
		leaveTypeGrid.setData(tree);
		leaveTypeGrid.selectSingleRecord(0);
		TreeNode selectedNode = leaveTypeGrid.getSelectedRecord();
		if(selectedNode != null){
			leaveTypeGrid.openFolder(selectedNode);
			int leaveTypeId = BaseHelpUtils.getIntValue(selectedNode.getAttribute("leaveTypeId"));
			areaPanel.setLeaveTypeId(leaveTypeId);
			areaPanel.commonQuery();
		}
	}
    
    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSCompanyReportIntegralDataSource.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        return "ST_LeaveType";
    }
    
    public int leaveTypeId;

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
    
}
