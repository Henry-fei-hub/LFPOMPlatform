package com.pomplatform.client.purchase.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.purchase.datasource.DSPaymentTemplateDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PaymentTemplateWithPDetailPaymentTemplateDetail extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);

	public PaymentTemplateWithPDetailPaymentTemplateDetail() {

		HLayout paymentTemplateDetails = new HLayout();
		paymentTemplateDetails.setWidth100();
		paymentTemplateDetails.setHeight100();
		grid.setDataSource(DSPaymentTemplateDetail.getInstance());
		grid.setAutoFitFieldWidths(false);
		paymentTemplateDetails.addMember(grid);
		VLayout paymentTemplateDetailsControls = new VLayout();
		paymentTemplateDetailsControls.setHeight100();
		paymentTemplateDetailsControls.setWidth(60);
		paymentTemplateDetailsControls.setLayoutTopMargin(30);
		paymentTemplateDetailsControls.setLayoutLeftMargin(5);
		paymentTemplateDetailsControls.setLayoutRightMargin(5);
		paymentTemplateDetailsControls.setMembersMargin(10);
		paymentTemplateDetails.addMember(paymentTemplateDetailsControls);
		addMember(paymentTemplateDetails);
		IButton paymentTemplateDetailsNewButton = new IButton("新增");
		paymentTemplateDetailsNewButton.setIcon("[SKIN]/actions/add.png");
		paymentTemplateDetailsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		IButton paymentTemplateDetailsRemoveButton = new IButton("删除所有");
		paymentTemplateDetailsRemoveButton.setIcon("[SKIN]/actions/remove.png");
		paymentTemplateDetailsRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		paymentTemplateDetailsControls.addMember(paymentTemplateDetailsNewButton);
		paymentTemplateDetailsControls.addMember(paymentTemplateDetailsRemoveButton);
	}

	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		condition.put("paymentTemplateId", getRecord().getAttribute("paymentTemplateId"));
		condition.put("addtionalCondition", " order by order_num ASC");
		DBDataSource.callOperation("ST_PaymentTemplateDetail", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (__startLoadedDetail != null)
						__startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if (__endLoadedDetail != null)
						__endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		boolean flag = true;
		int length = grid.getRecords().length;
		if(length > 0) {
			for (int i = 0; i < length; i++) {
				flag = grid.validateRow(i);
				if(!flag) {
					SC.say("请补充好数据");
					break;
				}
			}
		} else {
			flag = false;
			SC.say("请添加付款详情数据");
		}
		return flag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailPaymentTemplateDetail");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		int i = 1;
		for (ListGridRecord listGridRecord : rows) {
			listGridRecord.setAttribute("orderNum", i);
			i ++;
		}
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailPaymentTemplateDetail");
		return param;
	}

	@Override
	public String getName() {
		return "付款模板详情表";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail(DSCallback value) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail(DSCallback value) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid(DelicacyListGrid value) {
		this.grid = value;
	}

}
