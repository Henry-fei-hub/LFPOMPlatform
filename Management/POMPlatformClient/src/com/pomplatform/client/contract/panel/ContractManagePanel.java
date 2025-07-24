package com.pomplatform.client.contract.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.contract.datasource.DSContractManage;
import com.pomplatform.client.contract.form.ContractManageSearchForm;
import com.pomplatform.client.contract.form.ContractManageViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ContractManagePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractManagePanel cm = new ContractManagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractManage";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("financialContractCode");
		idx++;
		fields[idx] = new ListGridField("contractName");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("signingCompanyName");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("signingMoneySum");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("customerId");
		ComboBoxItem customerIdItem = new ComboBoxItem("customerId");
		customerIdItem.setWidth("*");
		customerIdItem.setChangeOnKeypress(false);
		customerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		customerIdItem.setValueMap(KeyValueManager.getValueMap("customers"));
        KeyValueManager.loadValueMap("customers",customerIdItem);
		fields[idx].setEditorProperties(customerIdItem);
		idx++;
		fields[idx] = new ListGridField("customerName");
		fields[idx].setHidden(true);
		resultGrid.setFields(fields);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				int rowNum = resultGrid.getRowNum(resultGrid.getSelectedRecord());
				resultGrid.startEditing(rowNum);
			}
		});
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = resultGrid.getRecord(event.getRowNum());
				if(!BaseHelpUtils.isNullOrEmpty(record)){
					Map<String,Object> params = record.toMap();
					int customerId = ClientUtil.checkAndGetIntValue(params.get("customerId"));
					if(customerId > 0){
						params.put("customerName", KeyValueManager.getValue("customers", customerId + ""));
					}
					DBDataSource.callOperation("ST_Contract","saveOrUpdate", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							}							
						}
					});
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("ContractManage"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractManageViewer detailForm = new ContractManageViewer();
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
		criteria.put("addtionalCondition", "order by contract_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractManageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractManage.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 120;
	}

	@Override
	public void afterDataReceived(Record[] data) {
		for(Record record : data){
			//如果财务合同编号为空，则初始化值为合同编号
			if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("financialContractCode"))){
				record.setAttribute("financialContractCode",record.getAttribute("contractCode"));
			}
		}
	}
}

