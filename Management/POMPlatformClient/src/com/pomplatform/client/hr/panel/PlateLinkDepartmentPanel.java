package com.pomplatform.client.hr.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.app.datasource.DSDepartment;
import com.delicacy.client.app.datasource.DSFunction;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.hr.datasource.DSPlateRecord;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class PlateLinkDepartmentPanel extends AbstractWizadPage {
	private final Logger logger = Logger.getLogger("");
	private static DelicacyListGrid plateGrid;
	private static TreeGrid depGrid;

	public PlateLinkDepartmentPanel() {
		VLayout mainLayout = new VLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);
		
		HLayout centerLayout = new HLayout();
		centerLayout.setMembersMargin(10);
		centerLayout.setHeight("95%");
		centerLayout.setWidth100();
		mainLayout.addMember(centerLayout);
		
		VLayout leftLayout = new VLayout();
		leftLayout.setHeight100();
		leftLayout.setWidth("50%");
		centerLayout.addMember(leftLayout);
		
		Label plateTitle = new Label("业务板块信息");
		plateTitle.setHeight("5%");
		plateTitle.setAlign(Alignment.CENTER);
		leftLayout.addMember(plateTitle);
		
		plateGrid = new DelicacyListGrid();
		plateGrid.setAutoFitFieldWidths(false);
		plateGrid.setHeight("95%");
		leftLayout.addMember(plateGrid);
		plateGrid.setDataSource(DSPlateRecord.getInstance());
		ListGridField[] fields = new ListGridField[5];
        int idx = 0;
        fields[idx] = new ListGridField("plateId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("plateName");
        idx++;
        fields[idx] = new ListGridField("plateCode");
        idx++;
        fields[idx] = new ListGridField("hrCode");
        idx++;
        fields[idx] = new ListGridField("plateType");
        idx++;
        plateGrid.setFields(fields);
        plateGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record record = plateGrid.getSelectedRecord();
				if(!BaseHelpUtils.isNullOrEmpty(record)){
					//获取业务部门Id
					int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
					//加载当前业务部门绑定的归属部门信息
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("plateId",plateId);
					final LoadingWindow loading = new LoadingWindow();
					DBDataSource.callOperation("ST_PlateDepartment", "find", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] datas = dsResponse.getData();
								if(!BaseHelpUtils.isNullOrEmpty(datas)){
									Map<Integer,Integer> map = new HashMap<>();
									for(Record r : datas){
										int departmentId = BaseHelpUtils.getIntValue(r.getAttribute("departmentId"));
										map.put(departmentId, departmentId);
									}
									depGrid.deselectAllRecords();
									Tree originalList = depGrid.getData();
									TreeNode[] nodes = originalList.getAllNodes();
									for(TreeNode node : nodes){
										//获取部门Id
										int depId = BaseHelpUtils.getIntValue(node.getAttribute("departmentId"));
										if(map.containsKey(depId) && !originalList.isFolder(node)){
											depGrid.selectRecord(node);
										}
									}
									
								}
							}
							loading.destroy();
						}
					});
				}
			}
		});
        
		VLayout rightLayout = new VLayout();
		rightLayout.setHeight100();
		rightLayout.setWidth("50%");
		centerLayout.addMember(rightLayout);
		
		Label departmentTitle = new Label("部门信息");
		departmentTitle.setHeight("5%");
		departmentTitle.setAlign(Alignment.CENTER);
		rightLayout.addMember(departmentTitle);
		
		depGrid = new TreeGrid();
		depGrid.setAutoFitFieldWidths(false);
		depGrid.setHeight("95%");
		depGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		depGrid.setDataSource(DSFunction.getInstance());
		depGrid.setShowOpenIcons(false);
		depGrid.setShowDropIcons(false);
		depGrid.setShowSelectedStyle(true);
		depGrid.setShowPartialSelection(true);
		// 当为true时表示父级选中时子级自动选中，当子级选中时父级自动选中
		depGrid.setCascadeSelection(true);
		rightLayout.addMember(depGrid);
		depGrid.setDataSource(DSDepartment.getInstance());
		
		TreeGridField[] depFields = new TreeGridField[4];
        int depIdx = 0;
        depFields[depIdx] = new TreeGridField("departmentId");
        depFields[depIdx].setHidden(true);
        depIdx++;
        depFields[depIdx] = new TreeGridField("departmentName");
        depIdx++;
        depFields[depIdx] = new TreeGridField("abbreviation");
        depIdx++;
        depFields[depIdx] = new TreeGridField("managerId");
        depIdx++;
        depGrid.setFields(depFields);
        
		HLayout buttonLayout = new HLayout(10);
		buttonLayout.setMembersMargin(10);
		buttonLayout.setHeight("5%");
		buttonLayout.setWidth100();
		buttonLayout.setAlign(Alignment.RIGHT);
		buttonLayout.setLayoutAlign(Alignment.RIGHT);
		mainLayout.addMember(buttonLayout);
		
		IButton sureButton = new IButton("保存");
		buttonLayout.addMember(sureButton);
		sureButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取选择的业务部门
				if(!plateGrid.anySelected()){
					SC.say("提示","请选择一条业务板块");
					return;
				}
				Record plateRecord = plateGrid.getSelectedRecord();
				//获取业务部门Id
				int plateId = BaseHelpUtils.getIntValue(plateRecord.getAttribute("plateId"));
				Record[] depRecords = depGrid.getSelectedRecords();
				String ids = "";
				for(Record r : depRecords){
					int departmentId = BaseHelpUtils.getIntValue(r.getAttribute("departmentId"));
					if(!BaseHelpUtils.isNullOrEmpty(ids)){
						ids += ",";
					}
					ids += departmentId;
				}
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("plateId",plateId);
				params.put("ids",ids);
				params.put("optType","onSavePlateLinkDep");
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("EP_OnHrManageProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						if(dsResponse.getStatus() >= 0){
							SC.say("提示","保存成功");
						}
					}
				});
			}
		});
		
		IButton cancelButton = new IButton("关闭");
		buttonLayout.addMember(cancelButton);
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ParentWindows.destroy();
			}
		});
	}
	
	//数据加载
	public void loadData(){
		//加载业务板块信息
		Map<String, Object> plateParams = new HashMap<String, Object>();
		plateParams.put("parentId", "0");
		DBDataSource.callOperation("ST_PlateRecord", "find", plateParams, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] datas = dsResponse.getData();
					plateGrid.setData(datas);
				}
			}
		});
		//加载部门信息
		Map<String, Object> depParams = new HashMap<String, Object>();
		depParams.put("optType", "onFindDepartmentData");
		DBDataSource.callOperation("EP_OnHrManageProcess", "find", depParams, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					int len = dsResponse.getData().length;
					TreeNode[] nodes = new TreeNode[len];
					for (int i = 0; i < len; i++) {
						nodes[i] = new TreeNode();
						DBDataSource.copyRecord(dsResponse.getData()[i], nodes[i]);
					}
					Tree tree = new Tree();
					tree.setModelType(TreeModelType.PARENT);
					tree.setRootValue("1");
					tree.setIdField("departmentId");
					tree.setParentIdField("parentId");
					tree.setData(nodes);
					tree.openAll();
					depGrid.setData(tree);
				}
				
			}
		});
	}
	
	private static PopupWindow ParentWindows;
	
	

	public static PopupWindow getParentWindows() {
		return ParentWindows;
	}

	public static void setParentWindows(PopupWindow parentWindows) {
		ParentWindows = parentWindows;
	}

	@Override
	public Map getValuesAsMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void startEdit() {
		// TODO Auto-generated method stub

	}
}
