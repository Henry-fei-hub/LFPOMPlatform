package com.pomplatform.client.refuseprojectquotetemplate.panel;

import java.util.ArrayList;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.preprojects.panel.RefuseListOfPreProjectReportPanel;
import com.pomplatform.client.refuseprojectquotetemplate.datasource.DSRefuseProjectQuoteTemplate;
import com.pomplatform.client.refuseprojectquotetemplate.form.RefuseProjectQuoteTemplateSearchForm;
import com.pomplatform.client.refuseprojectquotetemplate.form.RefuseProjectQuoteTemplateViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class RefuseProjectQuoteTemplatePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			RefuseProjectQuoteTemplatePanel cm = new RefuseProjectQuoteTemplatePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RefuseListOfPreProjectReport";
		}

	}

	@Override
	public void init(){
		//		super.init();
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if(BaseHelpUtils.getIntValue(record.getAttribute("processStatus"))==5) {
					return "font-weight:bold; color:#4fabff;";  
				}else {
					return "font-weight:bold; color:#555555;";  
				}
			}
		};
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
		resultGrid.setShowRowNumbers(true);
		__controlPosition = LayoutConstant.RIGHT;
		__layoutMode = LayoutConstant.LEFTRIGHT;
		__detailCanvas = new ArrayList<>();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = true;
		__needControl = true;
		__needViewPage = true;
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
				Reimbursement.centerInPage();
				Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType",processType);
		//		criteria.put("processStatus",processStatus);
		List<Map> keyvalues = new ArrayList<>();	
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "spi.process_status = ?");
		kv.put("value", "spi.process_status = ? and spi.process_status IN ( 3, 5 )");
		keyvalues.add(kv);
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)) {
			criteria.put("keyValues", keyvalues);
		}		
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new RefuseProjectQuoteTemplateSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSRefuseProjectQuoteTemplate.getInstance();
	}

	private int processType;
	private int processStatus;

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

	public int getSearchFormHeight() {
		return 80;
	}

}

