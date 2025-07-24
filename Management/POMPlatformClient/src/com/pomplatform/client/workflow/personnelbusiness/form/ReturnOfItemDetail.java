package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.ViewProcessWindow;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSPersonnelBusinessLinkEquipment;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSReturnOfItemsDetails;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class ReturnOfItemDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);

	public ReturnOfItemDetail(){


		HLayout returnOfItem = new HLayout();
		returnOfItem.setWidth100();
		returnOfItem.setHeight100();
		grid.setDataSource(DSReturnOfItemsDetails.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		grid.setCanRemoveRecords(false);
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("type");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("returnAmount");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("remainingReturn");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("currentReturn");
		idx++;
		fields[idx] = new ListGridField("createTime");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("remark");
		grid.setFields(fields);

		grid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent editCompleteEvent) {
				SC.debugger();
				int rowNum = editCompleteEvent.getRowNum();
				ListGridRecord record = grid.getRecord(rowNum);
				Map newValues = editCompleteEvent.getNewValues();
				Record oldValues = editCompleteEvent.getOldValues();
				__logger.info("---------------------- newValues: " + newValues);
				if (newValues.containsKey("currentReturn")) {
					int newCurrentReturn = BaseHelpUtils.getIntValue(newValues.get("currentReturn"));
					int oldCurrentReturn = BaseHelpUtils.getIntValue(oldValues.getAttribute("currentReturn"));
					int changeValue = newCurrentReturn - oldCurrentReturn;
					//获取已经归还的物品的数量
					int returnAmount =BaseHelpUtils.getIntValue(oldValues.getAttribute("returnAmount"));
					//获取剩余的归还的数量
					int remainingReturn =BaseHelpUtils.getIntValue(oldValues.getAttribute("remainingReturn"));
					int temp1 = returnAmount + changeValue;
					int temp2 = remainingReturn - changeValue;
					if (temp2 < 0) {
						record.setAttribute("currentReturn", oldCurrentReturn);
					} else {
						record.setAttribute("returnAmount", temp1);
						record.setAttribute("remainingReturn", temp2);
						record.setAttribute("currentReturn", newCurrentReturn);
					}
					grid.updateData(record);
				}
			}
		});

		returnOfItem.addMember(grid);
		VLayout personnelBusinessLinkEquipmentsControls = new VLayout();
		personnelBusinessLinkEquipmentsControls.setHeight100();
		personnelBusinessLinkEquipmentsControls.setWidth(60);
		personnelBusinessLinkEquipmentsControls.setLayoutTopMargin(30);
		personnelBusinessLinkEquipmentsControls.setLayoutLeftMargin(5);
		personnelBusinessLinkEquipmentsControls.setLayoutRightMargin(5);
		personnelBusinessLinkEquipmentsControls.setMembersMargin(10);
		returnOfItem.addMember(personnelBusinessLinkEquipmentsControls);
		addMember(returnOfItem);
		IButton personnelBusinessLinkEquipmentsNewButton = new IButton("查看关联流程");
		personnelBusinessLinkEquipmentsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord selectedRecord = grid.getSelectedRecord();
				if (BaseHelpUtils.isNullOrEmpty(selectedRecord)) {
					SC.say("提示:", "请选择一条数据");
					return;
				}
				SC.debugger();
				HashMap<String, Integer> params = new HashMap<>();
				params.put("personnelBusinessId", BaseHelpUtils.getIntValue(selectedRecord.getAttribute("parentId")));
				DBDataSource.callOperation("NQ_PersonnelBusinessLinkProcessInstance", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record data = dsResponse.getData()[0];
							ViewProcessWindow Reimbursement = new ViewProcessWindow();
							Reimbursement.setWidth("80%");
							Reimbursement.setHeight("80%");
							Reimbursement.setLayoutMode(0);
							Reimbursement.setInstanceData(data);
							Reimbursement.initComponents();
							Reimbursement.setTitle("物品申请");
							Reimbursement.show();
						}
					}
				});
			}
		});
		personnelBusinessLinkEquipmentsControls.addMember(personnelBusinessLinkEquipmentsNewButton);
	}

	@Override
	public void startEdit() {
		reloadDetailTableData();
	}

	/**
	 * @author liubin
	 * @date 2019/12/20 16:22
	 * @param
	 * @return
	 * @description: 查询申请人关联的所有的未换的物品
	 */
	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("employeeId", ClientUtil.getEmployeeId());
		condition.put("opt_type", "getItemsNeedToReturn");
		DBDataSource.callOperation("EP_ProjectCommonProcess", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] data = dsResponse.getData();
					grid.setData(data);
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("returnOfItemDetail");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		SC.debugger();
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getSelectedRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "returnOfItemDetail");
		param.put("list", "list");
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}


}

