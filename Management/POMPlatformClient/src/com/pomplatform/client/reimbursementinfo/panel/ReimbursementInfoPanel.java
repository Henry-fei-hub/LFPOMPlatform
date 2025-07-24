package com.pomplatform.client.reimbursementinfo.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.reimbursementinfo.datasource.DSReimbursementInfo;
import com.pomplatform.client.reimbursementinfo.form.ReimbursementInfoSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class ReimbursementInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReimbursementInfoPanel cm = new ReimbursementInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReimbursementInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setSelectionType(SelectionStyle.SINGLE);  
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton completeButton = new IButton("填写收款信息");
		controlLayout.addMember(completeButton);
		completeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				Integer processTypeId = record.getAttributeAsInt("processTypeId");
				Integer businessId = record.getAttributeAsInt("businessId");
				if(null != processTypeId && processTypeId.compareTo(0)>0 && null != businessId && businessId.compareTo(0)>0){
					Map params = new HashMap<>();
					params.put("optType", "needToComplete");
					params.put("processTypeId", processTypeId);
					params.put("businessId", businessId);
					DBDataSource.callOperation("EP_ReimbursementInfo", "loadDetail", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								PopupWindow window = new PopupWindow();
								CompleteProcessBillListPanel panel = new CompleteProcessBillListPanel(null);
								panel.setBusinessId(businessId);
								panel.setProcessType(processTypeId);
								panel.setParent(window);
								panel.init();
								window.addItem(panel);
								window.setWidth100();
								window.setHeight100();
								window.centerInPage();
								window.setTitle("完善收款信息");
								window.show();
							}else{
								SC.say(dsResponse.getErrors().get("errorMsg").toString());
							}
						}
					});
					
				}else{
					SC.say("该记录数据缺失，无法完善收款信息");
				}
			}
		});

		IButton downloadButton = new IButton("导出数据");
		controlLayout.addMember(downloadButton);
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				if(checkSearchCriteria(condition)){
					DBDataSource.downloadFile("DW_ReimbursementInfoDownload", condition);
				}
			}
		});
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("optType", "loadInfo");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReimbursementInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReimbursementInfo.getInstance();
	}


}

