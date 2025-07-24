package com.pomplatform.client.mcapitalsubcontractscoor.panel;

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
import com.pomplatform.client.mcapitalsubcontractscoor.datasource.DSMcapitalsubcontractscoor;
import com.pomplatform.client.mcapitalsubcontractscoor.form.McapitalsubcontractscoorSearchForm;
import com.pomplatform.client.mcapitalsubcontractscoor.form.McapitalsubcontractscoorViewer;
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

public class McapitalsubcontractscoorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	private Integer capitalId;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McapitalsubcontractscoorPanel cm = new McapitalsubcontractscoorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcapitalsubcontractscoor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
        __needViewPage = false;
	}

	@Override
	public void initComponents() {
		ListGridField subContractCodeField = new ListGridField("subContractCode");
		subContractCodeField.setShowGridSummary(false);
		ListGridField projectCodeField = new ListGridField("projectCode");
		projectCodeField.setShowGridSummary(false);
		ListGridField subContractNameField = new ListGridField("subContractName");
		subContractNameField.setShowGridSummary(false);
		ListGridField moneyField = new ListGridField("money", 200);
		moneyField.setRequired(true);
		moneyField.setValidators(ValidateUtils.isFloatValidator());
		resultGrid.setFields(subContractCodeField, projectCodeField, subContractNameField, moneyField);
		resultGrid.setCanEdit(true);
		resultGrid.setShowGridSummary(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据进行删除.");
				}
				resultGrid.removeSelectedData();
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Mcapitalsubcontractscoor");
				detail.setWidth100();
				detail.setHeight100();
				McapitalsubcontractscoorViewer detailForm = new McapitalsubcontractscoorViewer();
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

	public Integer getCapitalId() {
		return capitalId;
	}

	public void setCapitalId(Integer capitalId) {
		this.capitalId = capitalId;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by capital_sub_contract_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new McapitalsubcontractscoorSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMcapitalsubcontractscoor.getInstance();
	}

	public DelicacyListGrid getGrid() {
		return resultGrid;
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
}
