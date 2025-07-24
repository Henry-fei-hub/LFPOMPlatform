package com.pomplatform.client.attachment.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.attachment.datasource.DSMcontractAttachmentCapitalCount;
import com.pomplatform.client.attachment.datasource.DSSattachmentmanageCapital;
import com.pomplatform.client.attachment.form.McontractAttachmentCapitalCountSearchForm;
import com.pomplatform.client.attachment.form.McontractAttachmentCapitalCountViewer;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;

public class McontractAttachmentCapitalCountPanel extends AbstractExpansionRelatedPage {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McontractAttachmentCapitalCountPanel cm = new McontractAttachmentCapitalCountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "McontractAttachmentCapitalCount";
		}

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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
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
				detail.setTitle("McontractAttachmentCapitalCount");
				detail.setWidth100();
				detail.setHeight100();
				McontractAttachmentCapitalCountViewer detailForm = new McontractAttachmentCapitalCountViewer();
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
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACC_VIEW_ALL_DATA)){
			int employeeId = ClientUtil.getEmployeeId();
			int checkType = 3;
			if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACC_VIEW_MAJORDOMO_DATA)){//总监查看权限
				checkType = 1;
			}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACC_VIEW_MAJORDOMO_DATA)){//大项目负责人权限
				checkType = 2;
			}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACC_VIEW_MANAGE_DATA)){//项目负责人查看
				checkType = 3;
			}else{//最低权限  作为项目负责人查看
				checkType = 3;
			}
			criteria.put("checkType", checkType);
			criteria.put("checkEmployeeId", employeeId);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McontractAttachmentCapitalCountSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcontractAttachmentCapitalCount.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSSattachmentmanageCapital.getInstance();
	}

	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		super.setChildGridOption(resultChildGrid);
		Criteria ct = resultChildGrid.getCriteria();
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACC_VIEW_ALL_DATA)){
			int employeeId = ClientUtil.getEmployeeId();
			int checkType = 3;
			if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACC_VIEW_MAJORDOMO_DATA)){//总监查看权限
				checkType = 1;
			}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACC_VIEW_MAJORDOMO_DATA)){//大项目负责人权限
				checkType = 2;
			}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACC_VIEW_MANAGE_DATA)){//项目负责人查看
				checkType = 3;
			}else{//最低权限  作为项目负责人查看
				checkType = 3;
			}
			ct.addCriteria("checkType", checkType);
			ct.addCriteria("checkEmployeeId", employeeId);
			if(checkType == 3){
				ct.addCriteria("projectManageId", employeeId);
			}
		}
		resultChildGrid.setCriteria(ct);
	}
	
	

}
