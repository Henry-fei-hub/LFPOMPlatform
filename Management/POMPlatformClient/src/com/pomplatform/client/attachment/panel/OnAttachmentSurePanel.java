package com.pomplatform.client.attachment.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.attachment.datasource.DSOnAttachmentSure;
import com.pomplatform.client.attachment.form.OnAttachmentSureSearchForm;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class OnAttachmentSurePanel extends AbstractSearchPanel {
	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnAttachmentSurePanel cm = new OnAttachmentSurePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnAttachmentSure";
		}

	}

	@Override
	public void init() {
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		ListGridField[] fields = new ListGridField[10];
		int idx = 0;
		fields[idx] = new ListGridField("projectLinkAttachmentRecordId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("contractName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("sheetCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("sheetName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("attachmentCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("attachmentName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("attachmentAddress");
		fields[idx].setCanEdit(false);
		fields[idx].setLinkText("确认函下载/预览");
		idx ++;
		fields[idx] = new ListGridField("operateEmployeeId");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("operateTime");
		fields[idx].setCanEdit(false);
		idx ++;
		resultGrid.setFields(fields);
		
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
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		OnAttachmentSureSearchForm form = new OnAttachmentSureSearchForm();
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnAttachmentSure.getInstance();
	}

}
