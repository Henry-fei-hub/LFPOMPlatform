package com.pomplatform.client.budgetmanagementworkflow.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.contractppspcccfscsiiicpor.datasource.DSMcontractppspcccfscsiiicpor;
import com.pomplatform.client.contractppspcccfscsiiicpor.datasource.DSSprojectpcor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;    

public class BudgetOutOrderInfoPanel extends VLayout implements HasHandlers{
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private  int projectId;
	private ListGrid resultGrid;
	private ListGrid resultChildGrid;

	public void  initComponents(){
		VLayout layout = new VLayout();
		layout.setWidth100();
		layout.setHeight100();
		layout.setBackgroundColor("#e2e2e2");

		VLayout resultLayout = new VLayout();
		resultLayout.setWidth100();
		resultLayout.setHeight100();

		HLayout dataLayout = new HLayout();
		dataLayout.setHeight100();
		dataLayout.setWidth100();
		resultLayout.addMember(dataLayout);

		resultGrid = new ListGrid() {    
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsInt("flag") == 2) { 
					return "color: red;";
				}else {  
					return super.getCellCSSText(record, rowNum, colNum);  
				} 
			}

			public DataSource getRelatedDataSource(ListGridRecord record) {    
				return getChildDataSource();    
			}    

			@Override    
			protected Canvas getExpansionComponent(final ListGridRecord record) {    

				final ListGrid grid = this;    

				VLayout layout = new VLayout(5);    
				layout.setPadding(5);    
				resultChildGrid = new ListGrid(){
					@Override
					protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
						int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
						int projectId=BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
						if(projectId==getProjectId()) {
							return "color:#1C86EE"; 
						}
						if (status == ClientStaticUtils.PROJECT_STATUS_11) {  //结项标绿色
							return "color:#00B736;";  
						} else if (status == ClientStaticUtils.PROJECT_STATUS_10) {  //暂停标红色
							return "color:#F01813;";  
						} else {  
							return super.getCellCSSText(record, rowNum, colNum);  
						}  
					}
				};
				resultChildGrid.setHeight(224);    
				resultChildGrid.setCellHeight(22);    
				resultChildGrid.setDataSource(getRelatedDataSource(record));    
				resultChildGrid.fetchRelatedData(record, getDataSource());    

				resultChildGrid.setCanEdit(false);    
				resultChildGrid.setModalEditing(true);    
				resultChildGrid.setEditEvent(ListGridEditEvent.CLICK);    
				resultChildGrid.setListEndEditAction(RowEndEditAction.NEXT);    
				resultChildGrid.setAutoSaveEdits(false);
				resultChildGrid.setCanRemoveRecords(true);
				resultChildGrid.setCanDragSelectText(true);
				//设置子GRID操作属性
				setChildGridOption(resultChildGrid);
				layout.addMember(resultChildGrid);    
				HLayout littleControlLayout = new HLayout(10);//子菜单栏控制面板（点击打开节点后可操作的按钮面板）
				littleControlLayout.setAlign(Alignment.RIGHT);    


				//默认含有关闭面板按钮   方便操作
				IButton closeButton = new IButton("关闭");    
				closeButton.addClickHandler(new ClickHandler() {    
					public void onClick(ClickEvent event) {    
						grid.collapseRecord(record);    
					}    
				});    
				littleControlLayout.addMember(closeButton);    

				layout.addMember(littleControlLayout);    

				return layout;    
			}    
		};    
		resultGrid.setHeight100();
		resultGrid.setWidth100();
		resultGrid.setDataSource(getDataSource());
		resultGrid.setSaveLocally(true);
		resultGrid.setAutoFetchData(false);
		resultGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setShowHeaderContextMenu(false);
		resultGrid.setShowHeaderMenuButton(false);
		resultGrid.setCanEdit(false);
		//		resultGrid.setCanReorderRecords(true);
		resultGrid.setCanAcceptDroppedRecords(true);
		resultGrid.setDrawAheadRatio(4);  
		resultGrid.setCanExpandRecords(true);
		resultGrid.setCanDragSelectText(true);

		dataLayout.addMember(resultGrid);

		layout.addMember(resultLayout);
		addMember(layout);
	}

	public void setChildGridOption(ListGrid resultChildGrid) {
		ListGridField [] fields = new ListGridField[12];
		int index = 0;
		fields[index] = new ListGridField("contractCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("plateId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("projectManageId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("departmentManagerId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("plateManagerId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("totalIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("projectIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("sheetAmount");
		index++;
		fields[index] = new ListGridField("status");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("totalPercentStr");
		fields[index].setShowGridSummary(false);
		resultChildGrid.setShowGridSummary(true);
		resultChildGrid.setFields(fields);
	}

	public DataSource getDataSource() {
		return DSMcontractppspcccfscsiiicpor.getInstance();
	}

	public DataSource getChildDataSource() {
		return DSSprojectpcor.getInstance();
	}

	public int getProjectId() {
		return projectId;
	}


    public void lodaData() {
    	Map<String,Object> map=new HashMap<>();
    	map.put("projectId", projectId);
    	Record record=SyncDataUtil.getValueByTableName("NQ_Mcontractppspcccfscsiiicpor", "find", map);
    	int contractId=BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
    	if(contractId>0) {
    		Map<String,Object> params=new HashMap<>();
    		params.put("contractId", contractId);
    		DBDataSource.callOperation("NQ_Mcontractppspcccfscsiiicpor", "find", params, new DSCallback(){
    			@Override
    			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    				if(dsResponse.getStatus() >= 0) {
    					resultGrid.setData(dsResponse.getData());
    				}
    			}
    		});
    	}else {
    		SC.say("找不到项目关联到的合同编号");
    		return;
    	}
    	
    }
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

}
