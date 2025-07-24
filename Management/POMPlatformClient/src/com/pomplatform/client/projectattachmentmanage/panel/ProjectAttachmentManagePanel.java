package com.pomplatform.client.projectattachmentmanage.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.minvocieapplydedaocor.panel.AddOrUpdateContactsPanel;
import com.pomplatform.client.operation.form.NewProjectManagerForm;
import com.pomplatform.client.projectattachmentmanage.datasource.DSProjectAttachmentManage;
import com.pomplatform.client.projectattachmentmanage.form.ProjectAttachmentManageSearchForm;
import com.pomplatform.client.projectattachmentmanage.form.ProjectAttachmentManageViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class ProjectAttachmentManagePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectAttachmentManagePanel cm = new ProjectAttachmentManagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectAttachmentManage";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowFilterEditor(false);
		
		ListGridField[] fields = new ListGridField[17];
		int idx = 0;
		fields[idx] = new ListGridField("projectAttachmentId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("projectId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("sheetCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("projectName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("stageId");
		fields[idx].setCanEdit(false);
		ComboBoxItem stageIdSelect = new ComboBoxItem();
		stageIdSelect.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
		fields[idx].setEditorProperties(stageIdSelect);
		idx ++;
		fields[idx] = new ListGridField("isSameContract");
		idx ++;
		fields[idx] = new ListGridField("isSameStage");
		idx ++;
		fields[idx] = new ListGridField("isHasSign");
		idx ++;
		fields[idx] = new ListGridField("isHasSeal");
		idx ++;
		fields[idx] = new ListGridField("isSure");
		idx ++;
		fields[idx] = new ListGridField("isEmailSure");
		idx ++;
		fields[idx] = new ListGridField("isOtherSure");
		idx ++;
		fields[idx] = new ListGridField("isQualified");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("uploadTime");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("attachmentFile");
		fields[idx].setCanEdit(false);
		fields[idx].setLinkText("附件下载/预览");
		idx ++;
		fields[idx] = new ListGridField("operateEmployeeId");
		fields[idx].setCanEdit(false);
		ComboBoxItem operateEmployeeIdSelect = new ComboBoxItem();
		operateEmployeeIdSelect.setValueMap(KeyValueManager.getValueMap("employees"));
		fields[idx].setEditorProperties(operateEmployeeIdSelect);
		idx ++;
		fields[idx] = new ListGridField("operateTime");
		fields[idx].setCanEdit(false);
		idx ++;
		resultGrid.setFields(fields);
		resultGrid.setFilterOnKeypress(true);

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_ProjectAttachment", "saveOrUpdate", params, new DSCallback() {
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
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton qualifiedButton = new IButton("合格");
		controlLayout.addMember(qualifiedButton);
		qualifiedButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条记录");
					return;
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				//获取是否合格
				Boolean isQualified = selected.getAttributeAsBoolean("isQualified");
				if(isQualified){
					return;
				}
				selected.setAttribute("isQualified", Boolean.TRUE);
				selected.setAttribute("operateEmployeeId", ClientUtil.getEmployeeId());
				selected.setAttribute("operateTime", new Date());
				Map params = selected.toMap();
				DBDataSource.callOperation("ST_ProjectAttachment", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							resultGrid.updateData(selected);
						}
					}
				});
			}
		});
		
		IButton noQualifiedButton = new IButton("不合格");
		controlLayout.addMember(noQualifiedButton);
		noQualifiedButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						PopupWindow pw = new PopupWindow();
						NonconformityDetailPanel panel = new NonconformityDetailPanel();
						panel.setRecord(resultGrid.getSelectedRecord());
						panel.startEdit();
						panel.reloadSource(resultGrid.getSelectedRecord().getAttributeAsInt("projectId"));
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								panel.destroy();
								commonQuery();
							}
						});
						panel.setParentCanvas(pw);
						panel.setFatherWindow(pw);
						pw.addItem(panel);
						pw.setTitle("不合格详情");
						pw.setWidth("40%");
						pw.setHeight("90%");
						pw.centerInPage();
						pw.show();
					}
				});
			}
		});
/*		noQualifiedButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条记录");
					return;
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				//获取是否合格
				Boolean isQualified = selected.getAttributeAsBoolean("isQualified");
				if(!isQualified){
					return;
				}
				selected.setAttribute("isQualified", Boolean.FALSE);
				selected.setAttribute("operateEmployeeId", ClientUtil.getEmployeeId());
				selected.setAttribute("operateTime", new Date());
				Map params = selected.toMap();
				DBDataSource.callOperation("ST_ProjectAttachment", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							resultGrid.updateData(selected);
						}
					}
				});
			}
		});*/
		
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
				detail.setTitle("确认函管理"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ProjectAttachmentManageViewer detailForm = new ProjectAttachmentManageViewer();
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
		criteria.put("addtionalCondition", "order by project_attachment_id");
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ProjectAttachmentManageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectAttachmentManage.getInstance();
	}


}

