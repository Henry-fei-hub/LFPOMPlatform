package com.pomplatform.client.revenue.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.revenue.datasource.DSSheetAmountStatisticalOfRevenue;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class SheetAmountStatisticalOfRevenuePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SheetAmountStatisticalOfRevenuePanel cm = new SheetAmountStatisticalOfRevenuePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SheetAmountStatisticalOfRevenue";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("projectId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("revenuePlateId");
		fields[idx].setCanEdit(false);
		ComboBoxItem operateEmployeeIdSelect = new ComboBoxItem();
		operateEmployeeIdSelect.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		idx ++;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("projectName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("designType");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("projectLevel");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("totalAmount");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("sheetAmount");
		idx ++;
		resultGrid.setFields(fields);
		resultGrid.setShowFilterEditor(true);
		resultGrid.setFilterOnKeypress(true);

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				params.put("operateEmployeeId", ClientUtil.getEmployeeId());
				params.put("optType","onUpdateSheetRevenue");
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("EP_OnProjectCommonProcess", "update", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});
			}
		});

		commonQuery();
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("projectFlag",1);//只检索设计项目
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSSheetAmountStatisticalOfRevenue.getInstance();
	}


}

