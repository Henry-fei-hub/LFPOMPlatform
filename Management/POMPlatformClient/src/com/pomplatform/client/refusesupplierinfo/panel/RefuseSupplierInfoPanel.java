package com.pomplatform.client.refusesupplierinfo.panel;

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
import com.smartgwt.client.types.Alignment;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.refusesupplierinfo.datasource.DSRefuseSupplierInfo;
import com.pomplatform.client.refusesupplierinfo.form.RefuseSupplierInfoSearchForm;
import com.pomplatform.client.refusesupplierinfo.form.RefuseSupplierInfoViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class RefuseSupplierInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			RefuseSupplierInfoPanel cm = new RefuseSupplierInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RefuseSupplierInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("supplierId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("supplierName");
		index++;
		fields[index] = new ListGridField("supplierContact");
		index++;
		fields[index] = new ListGridField("supplierPhone");
		index++;
		fields[index] = new ListGridField("supplierEmail");
		index++;
		fields[index] = new ListGridField("teamSize");
		index++;
		fields[index] = new ListGridField("areasExpertise");
		KeyValueManager.loadValueMap("system_dictionary_213", fields[index]);
		index++;
		fields[index] = new ListGridField("fileUrl","附件");
		fields[index].setCanEdit(false);
		fields[index].setLinkText("相关文件下载/预览");
		index++;
		fields[index] = new ListGridField("employeeId");
		KeyValueManager.loadValueMap("employees",fields[index]);
		index++;
		fields[index] = new ListGridField("createTime");
		index++;
		fields[index] = new ListGridField("isUse");
		fields[index].setAlign(Alignment.CENTER);
		LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
		linkMap.put(0, "无效");
		linkMap.put(1, "有效");
		fields[index].setValueMap(linkMap);
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
	        	Reimbursement.setWidth("80%");
	            Reimbursement.setHeight("80%");
                Reimbursement.setTitle("供应商详情");
                Reimbursement.show();
                Reimbursement.centerInPage();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType",processType);
		List<Map> keyvalues = new ArrayList<>();	
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "spi.process_status =?");
		kv.put("value", "spi.process_status =? and spi.process_status IN ( 3, 5 )");
		keyvalues.add(kv);
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)) {
			criteria.put("keyValues", keyvalues);
		}		
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new RefuseSupplierInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSRefuseSupplierInfo.getInstance();
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

