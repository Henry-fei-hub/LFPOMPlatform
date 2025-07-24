package com.pomplatform.client.plateIntegralSends.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.BasicPermissionStatic;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.CommonFormat;
import com.pomplatform.client.plateIntegralSends.datasource.DSPlateIntegralSend;
import com.pomplatform.client.plateIntegralSends.datasource.DSPlateIntegralSends;
import com.pomplatform.client.plateIntegralSends.form.PlateIntegralSendsSearchForm;
import com.pomplatform.client.project.panel.SprojectPriceChangedRecordPanel;
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
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.tree.TreeGridField;

public class CustomPlateIntegralSendPanel extends AbstractSearchPanel {

	private static final Logger logger = Logger.getLogger("");

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			CustomPlateIntegralSendPanel cm = new CustomPlateIntegralSendPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateIntegralSend";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		TreeGridField[] fields = new TreeGridField[8];
		int idx = 0;
		fields[idx] = new TreeGridField("plateIntegralSendId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new TreeGridField("plateId");
		idx++;
		fields[idx] = new TreeGridField("sendIntegral");
		fields[idx].setCanFilter(false);
		idx++;
		fields[idx] = new TreeGridField("employeeId");
		fields[idx].setCanEdit(false);
		ComboBoxItem employeeItem = new ComboBoxItem();
		employeeItem.setChangeOnKeypress(false);
//		employeeItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees", employeeItem);
		fields[idx].setEditorProperties(employeeItem);
		fields[idx].setCanFilter(false);
		idx++;
		fields[idx] = new TreeGridField("sendDate");
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(new Date());
		idx++;
		fields[idx] = new TreeGridField("remark");
		fields[idx].setCanFilter(false);
		idx++;
		resultGrid.setFields(fields);
//		resultGrid.setShowFilterEditor(true);
//		resultGrid.setFilterOnKeypress(true);

		resultGrid.addEditorExitHandler(new EditorExitHandler() {

			@Override
			public void onEditorExit(EditorExitEvent event) {
				Object origin = null == event.getRecord() ? null : event.getRecord().getAttribute("sendIntegral");
				Object newValue = event.getNewValue();
				if (event.getColNum() == 1) {
					if (null == origin && null != newValue) {
						achieveIntegral = achieveIntegral.subtract(new BigDecimal(newValue.toString()));
					} else if (null != origin && null != newValue) {
						achieveIntegral = achieveIntegral.add(new BigDecimal(origin.toString()))
								.subtract(new BigDecimal(newValue.toString()));
					}
					updateTitle();
				}
			}
		});

		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
				resultGrid.setCanEdit(true);
				updateTitle();
			}
		});

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				params.put("optType", "saveOrUpdate");
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("EP_PlateIntegralSendProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});
			}
		});

		IButton newButton = PermissionControl.createPermissionButton("新建", ERPPermissionStatic.ADD_COMPANY_ACCOUNT_COMPANY_ADVANCE);
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
                 PopupWindow popupWindow = new PopupWindow("新增公司补贴");
                 popupWindow.setWidth("45%");
                 popupWindow.setHeight("50%");
                 popupWindow.centerInPage();
                 PlateIntegralSendsPanel panel = new PlateIntegralSendsPanel();
                 panel.addDataEditedHandler(new DataEditedHandler() {
             		@Override
             		public void onDataEdited(DataEditEvent event) {
             			 commonQuery();
             		}
             	});
                 panel.initComponents();
                 popupWindow.addItem(panel);
                 panel.setParentWindow(popupWindow);
                 popupWindow.centerInPage();
                 popupWindow.show();
			}
		});
			
	/*	newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("sendDate", new Date());
				DBDataSource.callOperation("ST_PlateIntegralSend", "save", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							resultGrid.addData(dsResponse.getData()[0]);
							resultGrid.startEditing(resultGrid.getRecords().length - 1);
						}
					}
				});
			}
		});*/

		IButton removeButton = PermissionControl.createPermissionButton("删除",
				ERPPermissionStatic.DELETE_COMPANY_ACCOUNT_COMPANY_ADVANCE);
//		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				achieveIntegral = achieveIntegral
						.add(new BigDecimal(ClientUtil.checkAndGetDoubleValue(selected.getAttribute("sendIntegral"))));
				Map params = selected.toMap();
				params.put("optType", "delete");
				DBDataSource.callOperation("EP_PlateIntegralSendProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							int indexNum = resultGrid.getRowNum(selected);
							resultGrid.removeData(selected);
							resultGrid.selectSingleRecord(indexNum);
							updateTitle();
						}
					}
				});
			}
		});
		
		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double sendIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						sendIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("sendIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("sendIntegral", sendIntegral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}
			}
		});

	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new PlateIntegralSendsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPlateIntegralSends.getInstance();
	}

	private BigDecimal achieveIntegral;

	public BigDecimal getAchieveIntegral() {
		return achieveIntegral;
	}

	public void setAchieveIntegral(BigDecimal achieveIntegral) {
		this.achieveIntegral = achieveIntegral;
	}

	public void updateTitle() {
		getParentCanvas().setTitle("公司补贴（公司余额：" + CommonFormat.doubleFormat(achieveIntegral.doubleValue()) + "）");
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}
}
