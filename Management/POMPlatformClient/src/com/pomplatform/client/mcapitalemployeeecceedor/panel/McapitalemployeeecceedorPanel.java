package com.pomplatform.client.mcapitalemployeeecceedor.panel;

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
import com.smartgwt.client.types.SelectionAppearance;
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
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.mcapitalemployeeecceedor.datasource.DSMcapitalemployeeecceedor;
import com.pomplatform.client.mcapitalemployeeecceedor.form.McapitalemployeeecceedorSearchForm;
import com.pomplatform.client.mcapitalemployeeecceedor.form.McapitalemployeeecceedorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class McapitalemployeeecceedorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			McapitalemployeeecceedorPanel cm = new McapitalemployeeecceedorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcapitalemployeeecceedor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
        __needControl = true;
        __needViewPage = false;
	}

	@Override
	public void initComponents() {
		ListGridField employeeNameField = new ListGridField("employeeName");
		employeeNameField.setShowGridSummary(false);
		ListGridField employeeNoField = new ListGridField("employeeNo");
		employeeNoField.setShowGridSummary(false);
		ListGridField departmentIdField = new ListGridField("departmentId");
		departmentIdField.setShowGridSummary(false);
		ListGridField moneyField = new ListGridField("money", 200);
		moneyField.setRequired(true);
		moneyField.setValidators(ValidateUtils.isFloatValidator());
		resultGrid.setFields(employeeNameField, employeeNoField, departmentIdField, moneyField);
		resultGrid.setCanEdit(true);
		resultGrid.setCanRemoveRecords(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setShowGridSummary(true);
		IButton delButton = new IButton("删除");
		controlLayout.addMember(delButton);
		delButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					resultGrid.removeSelectedData();
				}else{
					SC.say("请选择需要删除的员工数据");
				}
				
			}
		});
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
				detail.setTitle("Mcapitalemployeeecceedor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				McapitalemployeeecceedorViewer detailForm = new McapitalemployeeecceedorViewer();
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
	
	public boolean checkData() {
		boolean flag = true;
		ListGridRecord [] records = resultGrid.getRecords();
		for (ListGridRecord listGridRecord : records) {
			int __row = resultGrid.getRowNum(listGridRecord);
			if(!resultGrid.validateRow(__row)){
				flag = false;
				break;
			}
		}
		return flag;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by capital_employee_id");
		criteria.put("capitalId", getCapitalId());
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new McapitalemployeeecceedorSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMcapitalemployeeecceedor.getInstance();
	}

	public DelicacyListGrid getGrid(){
		return resultGrid;
	}
	
	private Integer capitalId;

	public Integer getCapitalId() {
		return capitalId;
	}

	public void setCapitalId(Integer capitalId) {
		this.capitalId = capitalId;
	}
}

