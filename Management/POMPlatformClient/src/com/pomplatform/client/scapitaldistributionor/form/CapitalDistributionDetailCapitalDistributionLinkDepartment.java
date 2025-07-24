package com.pomplatform.client.scapitaldistributionor.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.scapitaldistributionor.datasource.DSCapitalDistributionLinkDepartment;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CapitalDistributionDetailCapitalDistributionLinkDepartment extends AbstractWizadPage {

	@SuppressWarnings("unused")
	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;

	public CapitalDistributionDetailCapitalDistributionLinkDepartment() {

		HLayout capitalDistributionLinkDepartments = new HLayout();
		capitalDistributionLinkDepartments.setWidth100();
		capitalDistributionLinkDepartments.setHeight100();
		grid.setDataSource(DSCapitalDistributionLinkDepartment.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setHeaderHeight(60);
		grid.setShowGridSummary(true);
		grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("分配给部门", new String[] { "departmentId", "money" }) });
		capitalDistributionLinkDepartments.addMember(grid);
		VLayout capitalDistributionLinkDepartmentsControls = new VLayout();
		capitalDistributionLinkDepartmentsControls.setHeight100();
		capitalDistributionLinkDepartmentsControls.setWidth(60);
		capitalDistributionLinkDepartmentsControls.setLayoutTopMargin(30);
		capitalDistributionLinkDepartmentsControls.setLayoutLeftMargin(5);
		capitalDistributionLinkDepartmentsControls.setLayoutRightMargin(5);
		capitalDistributionLinkDepartmentsControls.setMembersMargin(10);
		capitalDistributionLinkDepartments.addMember(capitalDistributionLinkDepartmentsControls);
		addMember(capitalDistributionLinkDepartments);
		IButton capitalDistributionLinkDepartmentsNewButton = new IButton("新增");
		capitalDistributionLinkDepartmentsNewButton.setIcon("[SKIN]/actions/add.png");
		capitalDistributionLinkDepartmentsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				FormItem capitalAmountItem = mainInfoPage.findNamedItem("capitalAmount");
				if(null == capitalAmountItem.getValue()){
					SC.say("请添加回款金额");
					return;
				}
				grid.startEditingNew();
			}
		});
		IButton capitalDistributionLinkDepartmentsRemoveButton = new IButton("删除所有");
		capitalDistributionLinkDepartmentsRemoveButton.setIcon("[SKIN]/actions/remove.png");
		capitalDistributionLinkDepartmentsRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		capitalDistributionLinkDepartmentsControls.addMember(capitalDistributionLinkDepartmentsNewButton);
		capitalDistributionLinkDepartmentsControls.addMember(capitalDistributionLinkDepartmentsRemoveButton);
	}

	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void reloadDetailTableData() {
		Map condition = new HashMap();
		condition.put("capitalDistributionId", getRecord().getAttribute("capitalDistributionId"));
		DBDataSource.callOperation("ST_CapitalDistributionLinkDepartment", "find", condition, new DSCallback() {
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
		if (getPageMode() == PAGE_MODE_UPDATE) {
			Record [] records = grid.getRecords();
			if(records.length > 0){
				BigDecimal allMoney = BigDecimal.ZERO;
				boolean flag = false;
				for (int i = 0; i < records.length; i++) {
					if(grid.validateRow(i)){
						allMoney = allMoney.add(BaseHelpUtils.format(records[i].getAttribute("money"), 2));
					} else {
						flag = true;
						break;
					}
				}
				if(flag){
					SC.say("请按系统提示补充填写好数据");
					return false;
				}
				FormItem capitalAmountItem = mainInfoPage.findNamedItem("capitalAmount");
				BigDecimal checkMoney = BaseHelpUtils.format(capitalAmountItem.getValue(), 2);
				
				if(allMoney.compareTo(checkMoney) != 0){
					SC.say("分配给部门的总金额与回款金额不相等");
					return false;
				}
			} else {
				SC.say("请添加部门分配数据");
				return false;
			}
			
		} 
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailCapitalDistributionLinkDepartment");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailCapitalDistributionLinkDepartment");
		return param;
	}

	@Override
	public String getName() {
		return "分配给部门";
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

	public AbstractWizadPage getMainInfoPage() {
		return mainInfoPage;
	}

	public void setMainInfoPage(AbstractWizadPage mainInfoPage) {
		this.mainInfoPage = mainInfoPage;
	}

}
