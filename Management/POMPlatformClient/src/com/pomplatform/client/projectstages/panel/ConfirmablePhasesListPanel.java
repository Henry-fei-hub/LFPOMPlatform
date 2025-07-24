package com.pomplatform.client.projectstages.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.projectstages.datasource.DSConfirmablePhasesList;
import com.pomplatform.client.projectstages.form.ConfirmablePhasesListSearchForm;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ConfirmablePhasesListPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ConfirmablePhasesListPanel cm = new ConfirmablePhasesListPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ConfirmablePhasesList";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton operation3Button = PermissionControl.createPermissionButton("阶段分配",ERPPermissionStatic.CONFIRMABLE_PHASES_LIST_ALLOT_BUTTON);
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据修改");
					return;
				}

				Record record = resultGrid.getSelectedRecords()[0];
				int contractId = BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
				if (contractId <= 0) {
					SC.say("请选择一条数据修改");
					return;
				}
				
				BigDecimal percentSum = BaseHelpUtils.getBigDecimalValue(record.getAttribute("percentSum"));
				if (percentSum .compareTo(new BigDecimal(100))>=0) {
					SC.say("该订单已达100%");
					return;
				}
				
				BigDecimal projectAmountSum = BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectAmountSum"));
				if (projectAmountSum .compareTo(BigDecimal.ZERO)<=0) {
					SC.say("该订单产值小于等于0");
					return;
				}
				
				//获取流程process_id
				String processId = "";
				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
				if(!PomPlatformClientUtil.isNullOrEmpty(str)){
					String[] arr = str.split(",");
					for(String tempStr : arr){
						String[] tempArr = tempStr.split(":");
						//获取父级ID
						if(tempArr[0].replaceAll("\"", "").equals("Project_Stages_Process_Application")){
							processId = tempArr[1];
						}
					}
				}
                NewProcessWindow panel = new NewProcessWindow();
				panel.setTitle("可分配确认申请");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
				panel.setLayoutMode(0);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.setData(record);
				panel.initComponents();
				panel.setWidth100();
				panel.setHeight100();
				panel.centerInPage();
				panel.show();
			}
		});
		
		commonQuery();
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONFIRMABLE_PHASES_LIST_ALL_INFO_DATA)) {
			
		}else if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONFIRMABLE_PHASES_LIST_ALL_INFO_DATA)&&ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONFIRMABLE_PHASES_LIST_SELF_INFO_DATA)) {
			criteria.put("employeeId", ClientUtil.getUserId());
		}else {
			SC.say("提示","你没查看数据权限");
			return false;
		}
		
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ConfirmablePhasesListSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSConfirmablePhasesList.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}
	
	
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
        		 if ((BaseHelpUtils.getBigDecimalValue(record.getAttribute("percent")).multiply(hundred)).compareTo(BaseHelpUtils.getBigDecimalValue(record.getAttribute("percentSum")))<0) { 
        			 return "color: red;";
                 }else {  
                     return super.getCellCSSText(record, rowNum, colNum);  
                 }  
            } 
        };
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}

	private BigDecimal hundred = new BigDecimal(100);
}

