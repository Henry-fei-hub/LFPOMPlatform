package com.pomplatform.client.cwd.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.cwd.datasource.DSCwdFilingTemplate;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class CwdFilingTemplatePanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private Integer cwdFilingMainTemplateId;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			CwdFilingTemplatePanel cm = new CwdFilingTemplatePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CwdFilingTemplate";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
//		resultGrid.setCanEdit(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		ListGridField[] fields = new ListGridField[6];
		int idx = 0;
//		fields[idx] = new ListGridField("templateName");
//		idx++;
		fields[idx] = new ListGridField("filingType");
		idx++;
		fields[idx] = new ListGridField("operatorId");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("remark");
		idx++;
		fields[idx] = new ListGridField("createTime");
		fields[idx].setCanEdit(false);
		idx++;
		resultGrid.setFields(fields);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				viewDetail();
			}
		});
//		IButton newButton = new IButton("新建");
//		controlLayout.addMember(newButton);
//		newButton.setIcon("[SKIN]/actions/add.png");
//		newButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				Record record = new Record();
//				record.setAttribute("operatorId", ClientUtil.getEmployeeId());
//				resultGrid.startEditingNew(record);
//			}
//		});
//
//		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
//			@Override
//			public void onEditComplete(EditCompleteEvent event) {
//				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
//				final int rowNumModified = event.getRowNum();
//				params.put("optType", "addFilingTemplate");
//				DBDataSource.callOperation("EP_FilingTemplateProcessor", "addFilingTemplate", params, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() < 0) {
//							commonQuery();
//							ClientUtil.displayErrorMessage(dsResponse);
//						} else {
//							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
//							resultGrid.redraw();
//						}
//					}
//				});
//			}
//		});

		
		IButton viewButton = new IButton("查看详情");
		controlLayout.addMember(viewButton);
		viewButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				viewDetail();
			}
		});
		
	}

	private void viewDetail() {
		if(resultGrid.anySelected()) {
			Record selectRecord = resultGrid.getSelectedRecord();
			Integer cwdFilingTemplateId = resultGrid.getSelectedRecord().getAttributeAsInt("cwdFilingTemplateId");
			String filingType = selectRecord.getAttribute("filingType");
			String filingTypeName = KeyValueManager.getValue("system_dictionary_199", filingType);
			PopupWindow pw = new PopupWindow("【" + filingTypeName + "】文件归档模板详情");
			CwdFilingTemplateDetailPanel panel = new CwdFilingTemplateDetailPanel();
			panel.setCwdFilingTemplateId(cwdFilingTemplateId);
			panel.commonQuery();
			pw.addMember(panel);
			pw.setHeight("80%");
			pw.setWidth("80%");
			pw.centerInPage();
			pw.show();
		}else {
			SC.say("请选择一条数据查看");
		}
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("cwdFilingMainTemplateId", getCwdFilingMainTemplateId());
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSCwdFilingTemplate.getInstance();
	}

	public Integer getCwdFilingMainTemplateId() {
		return cwdFilingMainTemplateId;
	}

	public void setCwdFilingMainTemplateId(Integer cwdFilingMainTemplateId) {
		this.cwdFilingMainTemplateId = cwdFilingMainTemplateId;
	}

}
