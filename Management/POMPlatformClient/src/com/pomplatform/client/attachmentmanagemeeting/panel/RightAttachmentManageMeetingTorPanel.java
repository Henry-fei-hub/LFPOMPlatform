package com.pomplatform.client.attachmentmanagemeeting.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.attachmentmanagemeeting.datasource.DSAttachmentManageMeetingTor;
import com.pomplatform.client.attachmentmanagemeeting.form.AttachmentManageMeetingTorViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;

public class RightAttachmentManageMeetingTorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private Integer attachmentManageId;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			RightAttachmentManageMeetingTorPanel cm = new RightAttachmentManageMeetingTorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AttachmentManageMeetingTor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		
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
				detail.setTitle("AttachmentManageMeetingTor");
				detail.setWidth100();
				detail.setHeight100();
				AttachmentManageMeetingTorViewer detailForm = new AttachmentManageMeetingTorViewer();
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
		criteria.put("addtionalCondition", "order by attachment_manage_meeting_id");
		criteria.put("attachmentManageId", getAttachmentManageId());
		criteria.put("mettingStatus", 3);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSAttachmentManageMeetingTor.getInstance();
	}

	public Integer getAttachmentManageId() {
		return attachmentManageId;
	}

	public void setAttachmentManageId(Integer attachmentManageId) {
		this.attachmentManageId = attachmentManageId;
	}

}
