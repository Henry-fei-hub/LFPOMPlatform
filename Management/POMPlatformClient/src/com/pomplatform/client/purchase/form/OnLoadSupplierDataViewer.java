package com.pomplatform.client.purchase.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.purchase.datasource.DSOnLoadSupplierData;
import com.pomplatform.client.purchase.panel.SupplierAppraiseDetialViewPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class OnLoadSupplierDataViewer extends AbstractDetailViewer{
	//联系人信息gird
	private final DelicacyListGrid contactGrid = new DelicacyListGrid();
	//信息变动grid
	private final DelicacyListGrid changeInfoGrid = new DelicacyListGrid();
	//供应商评价记录gird
	private final DelicacyListGrid appraiseGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;


	public OnLoadSupplierDataViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		contactGrid.setAutoFitFieldWidths(false);
        ListGridField[] fields = new ListGridField[9];
        int fieldIdx = 0;
		fields[fieldIdx] = new ListGridField("supplierContactId");
		fields[fieldIdx].setHidden(true);
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactType","联系人类型");
		fields[fieldIdx].setValueMap(KeyValueManager.getValueMap("system_dictionary_146"));
		fields[fieldIdx].setWidth("*");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactName","姓名");
		fields[fieldIdx].setWidth("*");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactPosition","职位");
		fields[fieldIdx].setWidth("*");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactPhone","联系电话");
		fields[fieldIdx].setWidth("*");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactEmail","邮箱地址");
		fields[fieldIdx].setWidth("*");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactFax","传真");
		fields[fieldIdx].setWidth("*");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactGender","性别");
		fields[fieldIdx].setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		fields[fieldIdx].setWidth("*");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("remark","备注");
		fields[fieldIdx].setWidth("*");
		contactGrid.setFields(fields);
		
		changeInfoGrid.setAutoFitFieldWidths(false);
        ListGridField[] ciFields = new ListGridField[3];
        int ciIdx = 0;
        ciFields[ciIdx] = new ListGridField("changeEmployeeId","变更人员");
        ciFields[ciIdx].setValueMap(KeyValueManager.getValueMap("employees"));
        ciFields[ciIdx].setWidth("*");
        ciIdx++;
		ciFields[ciIdx] = new ListGridField("changeDate","变更日期");
		ciFields[ciIdx].setWidth("*");
		ciIdx++;
		ciFields[ciIdx] = new ListGridField("changeContent","变更内容");
		ciFields[ciIdx].setWidth("*");
		ciIdx++;
		ciFields[ciIdx] = new ListGridField("remark","备注");
		ciFields[ciIdx].setWidth("*");
		changeInfoGrid.setFields(ciFields);
		
		
		appraiseGrid.setAutoFitFieldWidths(false);
        ListGridField[] aFields = new ListGridField[8];
        int aIdx = 0;
        aFields[aIdx] = new ListGridField("supplierAppraiseId","id");
        aFields[aIdx].setHidden(true);
        aIdx++;
        aFields[aIdx] = new ListGridField("createEmployeeId","发起人");
        aFields[aIdx].setValueMap(KeyValueManager.getValueMap("employees"));
        aFields[aIdx].setWidth("*");
        aIdx++;
		aFields[aIdx] = new ListGridField("title","主题");
		aFields[aIdx].setWidth("*");
        aIdx++;
        aFields[aIdx] = new ListGridField("provideProduct","提供产品");
        aFields[aIdx].setWidth("*");
        aIdx++;
		aFields[aIdx] = new ListGridField("score","评价合计得分");
		aFields[aIdx].setWidth("*");
		aIdx++;
		aFields[aIdx] = new ListGridField("createTime","发起时间");
		aFields[aIdx].setWidth("*");
		aIdx++;
		aFields[aIdx] = new ListGridField("reason","事由");
		aFields[aIdx].setWidth("*");
		aIdx++;
		aFields[aIdx] = new ListGridField("remark","备注");
		aFields[aIdx].setWidth("*");
		appraiseGrid.setFields(aFields);
		appraiseGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(!appraiseGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = appraiseGrid.getSelectedRecord();
				//获取供应商评价id
				int supplierAppraiseId = BaseHelpUtils.getIntValue(record.getAttribute("supplierAppraiseId"));
				//获取供应商名称
				String title = BaseHelpUtils.getString(record.getAttribute("title"));						
				final PopupWindow popupWindow = new PopupWindow(title + "-评价明细");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("50%");
				popupWindow.centerInPage();
				SupplierAppraiseDetialViewPanel panel = new SupplierAppraiseDetialViewPanel();
				panel.initComponents();
				panel.load(supplierAppraiseId);
				popupWindow.addItem(panel);
				panel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "供应商";
	}

	@Override
	public int getGroupCount() {
		return 2;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		GroupColumn gc;
        gc = new GroupColumn();
        gc.setGroupName("baseInfo");
        gc.setGroupCaption("主要信息");
        gc.getColumnNames().add("supplierName");
		gc.getColumnNames().add("abbreviatedName");
		gc.getColumnNames().add("supplierType");
		gc.getColumnNames().add("supplierLevel");
		gc.getColumnNames().add("contactPhone");
		gc.getColumnNames().add("email");
		gc.getColumnNames().add("fax");
		gc.getColumnNames().add("postCode");
        gc.getColumnNames().add("bankName");
        gc.getColumnNames().add("payName");
        gc.getColumnNames().add("payCode");
        gc.getColumnNames().add("taxCode");
        gc.getColumnNames().add("country");
        gc.getColumnNames().add("province");
        gc.getColumnNames().add("city");
        gc.getColumnNames().add("address");
        gcs.add(gc);
        gc = new GroupColumn();
        gc.setGroupName("otherInfo");
        gc.setGroupCaption("其他信息");
        gc.getColumnNames().add("parentId");
		gc.getColumnNames().add("startOrderCount");
		gc.getColumnNames().add("productionCycle");
		gc.getColumnNames().add("logisticsCycle");
		gc.getColumnNames().add("logisticsType");
		gc.getColumnNames().add("warrantyPeriod");
		gc.getColumnNames().add("startCoworkDate");
		gc.getColumnNames().add("accountPeriod");
		gc.getColumnNames().add("registeredDate");
		gc.getColumnNames().add("registeredCapital");
		gc.getColumnNames().add("registeredAddress");
		gc.getColumnNames().add("productionAddress");
		gc.getColumnNames().add("majorBusiness");
		gc.getColumnNames().add("isIncludeInstall");
		gc.getColumnNames().add("remark");
		gcs.add(gc);
		return gcs;
	}

	@Override
	public void load() {
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){
		Record record = getRecord();
		if(!BaseHelpUtils.isNullOrEmpty(record)) {
			int supplierId = BaseHelpUtils.getIntValue(record.getAttribute("supplierId"));
			Map<String,Object> params = new HashMap<>();
			//加载联系人信息
			params.put("supplierId",supplierId);
			params.put("addtionalCondition","order by contact_type asc");
			DBDataSource.callOperation("ST_SupplierContact", "find", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] datas = dsResponse.getData();
						contactGrid.setData(datas);
					}
				}
			});
			
			//加载变更记录信息
			params.put("supplierId",supplierId);
			params.put("addtionalCondition","order by change_time desc");
			DBDataSource.callOperation("ST_SupplierInfoChangeRecord", "find", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] datas = dsResponse.getData();
						changeInfoGrid.setData(datas);
					}
				}
			});
			
			//加载评价记录信息
			params.put("supplierId",supplierId);
			params.put("addtionalCondition","order by create_time desc");
			DBDataSource.callOperation("ST_SupplierApprais", "find", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] datas = dsResponse.getData();
						appraiseGrid.setData(datas);
					}
				}
			});
			
		}
	}

	@Override
	public DataSource getMainDataSource() {
		return DSOnLoadSupplierData.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 3;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(contactGrid);
		res.add(changeInfoGrid);
		res.add(appraiseGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("联系人信息");
		res.add("变更记录信息");
		res.add("评价记录信息");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

