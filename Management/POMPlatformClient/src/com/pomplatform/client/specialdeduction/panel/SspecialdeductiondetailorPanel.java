package com.pomplatform.client.specialdeduction.panel;

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
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductiondetailor;
import com.pomplatform.client.specialdeduction.form.SspecialdeductiondetailorSearchForm;
import com.pomplatform.client.specialdeduction.form.SspecialdeductiondetailorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SspecialdeductiondetailorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SspecialdeductiondetailorPanel cm = new SspecialdeductiondetailorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sspecialdeductiondetailor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
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
		commonQuery();
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("parentId", specialDeductionRecordId);
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	@Override
	public SearchForm generateSearchForm() {
		return new SspecialdeductiondetailorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSspecialdeductiondetailor.getInstance();
	}
 	
	private Integer specialDeductionRecordId;


	public Integer getSpecialDeductionRecordId() {
		return specialDeductionRecordId;
	}

	public void setSpecialDeductionRecordId(Integer specialDeductionRecordId) {
		this.specialDeductionRecordId = specialDeductionRecordId;
	}
	


}

