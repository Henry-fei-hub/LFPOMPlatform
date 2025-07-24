package com.pomplatform.client.specialdeduction.datasource;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.specialdeduction.panel.SspecialdeductiontypessorPanel;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeEducationInformation;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SpecialDeductionInformation3 extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private int parentId;
	private int specialDeductionTypeId=3; //住房贷款利息
	private int year;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public SpecialDeductionInformation3(){
		HLayout employeeEducationInformations = new HLayout();
		employeeEducationInformations.setWidth100();
		employeeEducationInformations.setHeight100();
		grid.setHeaderHeight(60); 
		grid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("住房贷款信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year",
				   "houseBorrower","houseType","houseNumber",
				   "houseFirst","loanType","creditorBank","creditorContractNumber"
				   ,"repaymentFirstDate","repayment","amount","fileId","fileUrl"})
	    });
		ListGridField[] fields = new ListGridField[18];
		int idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId",shouldNotBeNull+"专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setDefaultValue(specialDeductionTypeId);
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("year",shouldNotBeNull+"扣除年度");
		fields[idx].setShowGridSummary(false);
		Date d = new Date();
		fields[3].setDefaultValue(d.getYear()+1900);
		idx++;
		fields[idx] = new ListGridField("houseBorrower",shouldNotBeNull+"是否借款人");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("houseType",shouldNotBeNull+"房屋证书类型");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("houseNumber",shouldNotBeNull+"房屋证书号码");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("houseFirst");
		idx++;
		fields[idx] = new ListGridField("loanType",shouldNotBeNull+"贷款类型");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("creditorBank","贷款银行");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("creditorContractNumber",shouldNotBeNull+"贷款合同编号");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("repaymentFirstDate",shouldNotBeNull+"首次还款日期");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("repayment",shouldNotBeNull+"贷款期限");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount",shouldNotBeNull+"每月抵扣金额金额");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(1000);
		idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("fileUrl",shouldNotBeNull+"购房合同及银行贷款合同附件");
		fields[idx].setShowGridSummary(false);
		grid.setFields(fields);
		grid.setDataSource(DSSspecialdeductiondetailor.getInstance());
		grid.setAutoFitFieldWidths(true);
		employeeEducationInformations.addMember(grid);
		VLayout employeeEducationInformationsControls = new VLayout();
		employeeEducationInformationsControls.setHeight100();
		employeeEducationInformationsControls.setWidth(60);
		employeeEducationInformationsControls.setLayoutTopMargin(30);
		employeeEducationInformationsControls.setLayoutLeftMargin(5);
		employeeEducationInformationsControls.setLayoutRightMargin(5);
		employeeEducationInformationsControls.setMembersMargin(10);
		employeeEducationInformations.addMember(employeeEducationInformationsControls);
		addMember(employeeEducationInformations);
		IButton refearshButton = new IButton("刷新");
		refearshButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.redraw();
			}
		});
		IButton employeeEducationInformationsNewButton = new IButton("新增");
		employeeEducationInformationsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				SC.say("住房贷款提示","1.偿还贷款期间，按每年12,000元（每月1,000元）标准定额扣除" + 
						"2.单独或共同使用商业银行或住房公积金贷款购买住房发生的首套住房贷款利息支出的个人或配偶"
						+ "3.住房租赁合房屋贷款未同时扣除"
						+ "4.填写前请点击申请说明仔细阅读，不符合条件者请勿填写该项，以免影响个人纳税信用甚至违反税收法律");
				grid.startEditingNew();
			}
		});
		IButton employeeEducationInformationsRemoveButton = new IButton("删除所有");
		employeeEducationInformationsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		IButton upButton = new IButton("上传购房合同及银行贷款合同");
		upButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(null==grid.getSelectedRecord()) {
					SC.say("提示","请选择一条数据");
				}else {
					new CommonUploadWindow("请上传购房合同及银行贷款合同", false, 50, 2, 1, new UploadCallBack() {
						
						@Override
						public void execute(Map<String, Record> data) {
							// 上传附件文件成功
							for(String key : data.keySet()) {
								String fileId = data.get(key).getAttribute("fileId");
								String fileUrl = data.get(key).getAttribute("fileUrl");
								ListGridRecord selectedRecord = grid.getSelectedRecord();
								selectedRecord.setAttribute("fileId", fileId);
								selectedRecord.setAttribute("fileUrl", fileUrl);
								grid.redraw();
							}
						}
					});
				}
			}
		});
		employeeEducationInformationsControls.addMember(refearshButton);
		employeeEducationInformationsControls.addMember(employeeEducationInformationsNewButton);
		employeeEducationInformationsControls.addMember(employeeEducationInformationsRemoveButton);
		employeeEducationInformationsControls.addMember(upButton);
		IButton remarkButton = new IButton("申请说明");
		remarkButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				
				GenericViewWindow detail = new GenericViewWindow();
				detail.setWidth(700); 
				detail.setHeight(500); 
				SspecialdeductiontypessorPanel panel =new SspecialdeductiontypessorPanel();
				panel.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				panel.setSpecialDeductionTypeId(specialDeductionTypeId);
				panel.commonQuery();
				detail.setContent(panel);
				detail.centerInPage();
				detail.show();
			}
		});
		employeeEducationInformationsControls.addMember(remarkButton);
	}
	

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) {
			return;
		}else{
			reloadDetailTableData();
		}
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("parentId", parentId);
		condition.put("specialDeductionTypeId", specialDeductionTypeId);
		condition.put("year", year);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		for(ListGridRecord r : grid.getRecords()) {
			if(null==r.getAttribute("specialDeductionTypeId")) {
				SC.say("提示","子项类型不能为空");
				return false;
			}
			if(null==r.getAttribute("year")) {
				SC.say("提示","扣除年度不能为空");
				return false;
			}
			if(null==r.getAttribute("houseBorrower")) {
				SC.say("提示","是否借款人不能为空");
				return false;
			}
			if(null==r.getAttribute("houseType")) {
				SC.say("提示","房屋证书类型不能为空");
				return false;
			}
			if(null==r.getAttribute("houseNumber")) {
				SC.say("提示","房屋证书号码不能为空");
				return false;
			}
			if(null==r.getAttribute("loanType")) {
				SC.say("提示","贷款类型不能为空");
				return false;
			}
			/*if(null==r.getAttribute("creditorBank")) {
				SC.say("提示","贷款银行不能为空");
				return false;
			}*/
			if(null==r.getAttribute("creditorContractNumber")) {
				SC.say("提示","贷款合同编号不能为空");
				return false;
			}
			if(null==r.getAttribute("repaymentFirstDate")) {
				SC.say("提示","首次还款日期不能为空");
				return false;
			}
			if(null==r.getAttribute("repayment")) {
				SC.say("提示","贷款期限不能为空");
				return false;
			}
			if(r.getAttributeAsInt("repayment")>240) {
				SC.say("提示","贷款期限不能大于240个月");
				return false;
			}
			if(r.getAttributeAsInt("repayment")<=0) {
				SC.say("提示","贷款期限不能小于或等于0个月");
				return false;
			}
			if(null==r.getAttribute("amount")) {
				SC.say("提示","每月抵扣金额金额不能为空");
				return false;
			}
			if(null==r.getAttribute("fileUrl")||null==r.getAttribute("fileId")) {
				SC.say("提示","请上传附件");
				return false;
			}
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("SpecialDeductionInformation1");
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
		if(!BaseHelpUtils.isNullOrEmpty(rows) && rows.length > 0) {
			MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "specialDeductionInformation3");
		}
		return param;
	}

	@Override
	public String getName() {
		return "住房贷款信息";
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public int getSpecialDeductionTypeId() {
		return specialDeductionTypeId;
	}


	public void setSpecialDeductionTypeId(int specialDeductionTypeId) {
		this.specialDeductionTypeId = specialDeductionTypeId;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	

}

