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
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.scapitaldistributionor.datasource.DSCapitalDistributionLinkSubContract;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CapitalDistributionDetailCapitalDistributionLinkSubContract extends AbstractWizadPage {

	@SuppressWarnings("unused")
	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;
	
	public boolean isFrance = false;//是财务

	public CapitalDistributionDetailCapitalDistributionLinkSubContract(String processName) {
		if(!processName.contains("回款分配")){
			isFrance = true;
		}
		HLayout capitalDistributionLinkSubContracts = new HLayout();
		capitalDistributionLinkSubContracts.setWidth100();
		capitalDistributionLinkSubContracts.setHeight100();
		grid.setDataSource(DSCapitalDistributionLinkSubContract.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setHeaderHeight(60);
		ListGridField subContractIdField = new ListGridField("subContractId");
		subContractIdField.setShowGridSummary(false);
		if(!isFrance){
			subContractIdField.setCanEdit(false);
			grid.setCanRemoveRecords(false);
		}
		ListGridField moneyField = new ListGridField("money");
		ListGridField codeField = new ListGridField("code", "编号");
		codeField.setCanEdit(false);
//		codeField.setValueMap(KeyValueManager.getValueMap("project_contract_codes"));
		KeyValueManager.loadValueMap("project_contract_codes", codeField);
		
		grid.setFields(subContractIdField, codeField, moneyField);
		grid.setShowGridSummary(true);
		grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("分配给订单", new String[] { "subContractId", "code", "money" }) });
		capitalDistributionLinkSubContracts.addMember(grid);
		VLayout capitalDistributionLinkSubContractsControls = new VLayout();
		capitalDistributionLinkSubContractsControls.setHeight100();
		capitalDistributionLinkSubContractsControls.setWidth(60);
		capitalDistributionLinkSubContractsControls.setLayoutTopMargin(30);
		capitalDistributionLinkSubContractsControls.setLayoutLeftMargin(5);
		capitalDistributionLinkSubContractsControls.setLayoutRightMargin(5);
		capitalDistributionLinkSubContractsControls.setMembersMargin(10);
		capitalDistributionLinkSubContracts.addMember(capitalDistributionLinkSubContractsControls);
		addMember(capitalDistributionLinkSubContracts);
		IButton capitalDistributionLinkSubContractsNewButton = new IButton("新增");
		capitalDistributionLinkSubContractsNewButton.setIcon("[SKIN]/actions/add.png");
		capitalDistributionLinkSubContractsNewButton.addClickHandler(new ClickHandler() {
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
		IButton capitalDistributionLinkSubContractsRemoveButton = new IButton("删除所有");
		capitalDistributionLinkSubContractsRemoveButton.setIcon("[SKIN]/actions/remove.png");
		capitalDistributionLinkSubContractsRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		if(isFrance){
			capitalDistributionLinkSubContractsControls.addMember(capitalDistributionLinkSubContractsNewButton);
			capitalDistributionLinkSubContractsControls.addMember(capitalDistributionLinkSubContractsRemoveButton);
		} else {
			IButton updateBtn = new IButton("修改");
			capitalDistributionLinkSubContractsControls.addMember(updateBtn);
			updateBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if(grid.anySelected()){
						grid.startEditing(grid.getRowNum(grid.getSelectedRecord()));
					} else {
						SC.say("请选择一条需要修改的数据");
					}
					
				}
			});
		}
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
		DBDataSource.callOperation("ST_CapitalDistributionLinkSubContract", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (__startLoadedDetail != null)
						__startLoadedDetail.execute(dsResponse, data, dsRequest);
					Record [] record = dsResponse.getData();
					for (Record record2 : record) {
						record2.setAttribute("code", record2.getAttribute("subContractId"));
					}
					grid.setData(record);
					if (__endLoadedDetail != null)
						__endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		if (getPageMode() == PAGE_MODE_UPDATE) {
			Record[] records = grid.getRecords();
			if (records.length > 0) {
				BigDecimal allMoney = BigDecimal.ZERO;
				boolean flag = false;
				for (int i = 0; i < records.length; i++) {
					if (grid.validateRow(i)) {
						allMoney = allMoney.add(BaseHelpUtils.format(records[i].getAttribute("money"), 2));
					} else {
						flag = true;
						break;
					}
				}
				if (flag) {
					SC.say("请按系统提示补充填写好数据");
					return false;
				}

				FormItem capitalAmountItem = mainInfoPage.findNamedItem("capitalAmount");
				BigDecimal checkMoney = BaseHelpUtils.format(capitalAmountItem.getValue(), 2);

				if (allMoney.compareTo(checkMoney) > 0) {
					SC.say("分配给订单的总金额不能大于回款金额");
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
		res.add("detailCapitalDistributionLinkSubContract");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailCapitalDistributionLinkSubContract");
		return param;
	}

	@Override
	public String getName() {
		return "分配给订单";
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
