package com.pomplatform.client.mcapitaldepartmentdccddor.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.mcapitaldepartmentdccddor.datasource.DSMcapitaldepartmentdccddor;
import com.pomplatform.client.mcapitaldepartmentdccddor.form.McapitaldepartmentdccddorViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class McapitaldepartmentdccddorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			McapitaldepartmentdccddorPanel cm = new McapitaldepartmentdccddorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcapitaldepartmentdccddor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	    __needPagenation = false;
        __needControl =  true;
        __needViewPage = false;
	}

	@Override
	public void initComponents() {
		ListGridField departmentNameField = new ListGridField("departmentName");
		departmentNameField.setShowGridSummary(false);
		ListGridField moneyField = new ListGridField("money", 200);
		moneyField.setRequired(true);
		moneyField.setValidators(ValidateUtils.isFloatValidator());
		resultGrid.setFields(departmentNameField, moneyField);
		resultGrid.setCanEdit(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setCanRemoveRecords(true);
		resultGrid.setShowGridSummary(true);
		IButton delButton = new IButton("删除");
		controlLayout.addMember(delButton);
		delButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					resultGrid.removeSelectedData();
				}else{
					SC.say("请选择需要删除的部门数据");
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
				detail.setTitle("Mcapitaldepartmentdccddor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				McapitaldepartmentdccddorViewer detailForm = new McapitaldepartmentdccddorViewer();
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
		criteria.put("addtionalCondition", "order by capital_department_id");
		criteria.put("capitalId", getCapitalId());
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new McapitaldepartmentdccddorSearchForm();
		return null;
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
	public DataSource getDataSource() {
		return DSMcapitaldepartmentdccddor.getInstance();
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

