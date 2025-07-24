package com.pomplatform.client.applyprojectquotetemplate.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.applyprojectquotetemplate.datasource.DSApplyProjectQuoteTemplate;
import com.pomplatform.client.applyprojectquotetemplate.form.ApplyProjectQuoteTemplateSearchForm;
import com.pomplatform.client.preprojects.datasource.DSApplyListOfPreProjectReport;
import com.pomplatform.client.preprojects.form.ApplyListOfPreProjectReportSearchForm;
import com.pomplatform.client.preprojects.panel.ApplyListOfPreProjectReportPanel;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ApplyProjectQuoteTemplatePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ApplyListOfPreProjectReportPanel cm = new ApplyListOfPreProjectReportPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ApplyProjectQuoteTemplate";
		}

	}

	@Override
	public void init(){
		super.init();
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("projectQuoteId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("businessType");
		KeyValueManager.loadValueMap("pre_business_type",fields[index]);
		index++;
		fields[index] = new ListGridField("infoCode");
		index++;
		fields[index] = new ListGridField("projectName");
		index++;
		fields[index] = new ListGridField("basicAmount");
		index++;
		fields[index] = new ListGridField("totalAmount");
		index++;
		fields[index] = new ListGridField("taxAmount");
		index++;
		fields[index] = new ListGridField("otherTaxAmount");
		index++;
		fields[index] = new ListGridField("finalAmount");
		index++;
		fields[index] = new ListGridField("taxFinalAmount");
		index++;
		fields[index] = new ListGridField("quoteStatus");
		KeyValueManager.loadValueMap("system_dictionary_204",fields[index]);
		index++;
		fields[index] = new ListGridField("operateEmployeeId");
		KeyValueManager.loadValueMap("employees",fields[index]);
		index++;
		fields[index] = new ListGridField("createTime");
		index++;
		fields[index] = new ListGridField("remark");
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setFields(fields);
		resultGrid.setDataSource(getDataSource());
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton editButton = new IButton("撤销修改");
		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("please select a record to edit");
							return;
						}
						ListGridRecord selected = resultGrid.getSelectedRecord();
						int status = selected.getAttributeAsInt("processStatus");
						if (status != 0) {
							SC.say("对不起，该申请不能修改！");
							return;
						}
						EditProcessWindow Reimbursement = new EditProcessWindow();
						Reimbursement.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), resultGrid.getSelectedRecord());
								resultGrid.redraw();
							}
						});
						Reimbursement.setLayoutMode(0);
						Reimbursement.setProcessId(selected.getAttributeAsInt("processId"));
						Reimbursement.setInstanceData(selected);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
						if(processType == 42){
							Reimbursement.setWidth("50%");
							Reimbursement.setHeight("90%");
						}
						Reimbursement.centerInPage();
						Reimbursement.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面再操作");
					}
				});
				
			}
		});
		controlLayout.addMember(editButton);
//		commonQuery();
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
				ListGridRecord selected = resultGrid.getSelectedRecord();
                ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
	        	Reimbursement.setWidth("100%");
	            Reimbursement.setHeight("100%");
                Reimbursement.setTitle("项目报价详情");
                Reimbursement.show();
                Reimbursement.centerInPage();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType",processType);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new  ApplyProjectQuoteTemplateSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSApplyProjectQuoteTemplate.getInstance();
	}

	private int processType;
	
	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getSearchFormHeight() {
        return 80;
    }
	
}

