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

public class SpecialDeductionInformation4 extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private int parentId;
	private int specialDeductionTypeId=4; //住房租金
	private int year;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	public SpecialDeductionInformation4(){
		HLayout employeeEducationInformations = new HLayout();
		employeeEducationInformations.setWidth100();
		employeeEducationInformations.setHeight100();
		grid.setHeaderHeight(60); 
		grid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("住房租金信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year",
				   "province","city","leaseType","name","otherDocumentType","otherIdentificationNumber","leaseAddress",
				   "leaseContractNumber","startDate"
				   ,"endDate","amount","fileId","fileUrl"})
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
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(specialDeductionTypeId);
		idx++;
		fields[idx] = new ListGridField("year",shouldNotBeNull+"年份");
		fields[idx].setShowGridSummary(false);
		Date d = new Date();
		fields[idx].setDefaultValue(d.getYear()+1900);
		idx++;
		fields[idx] = new ListGridField("province",shouldNotBeNull+"省");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("city",shouldNotBeNull+"市");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("leaseType",shouldNotBeNull+"租赁类型）");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("name",shouldNotBeNull+"出租房姓名（组织名称）");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber",shouldNotBeNull+"出租方身份证件号码（统一社会信用代码）");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("leaseAddress",shouldNotBeNull+"住房坐落地址");
		idx++;
		fields[idx] = new ListGridField("leaseContractNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("startDate",shouldNotBeNull+"合同起始时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("endDate",shouldNotBeNull+"合同结束时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount",shouldNotBeNull+"金额");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("fileUrl",shouldNotBeNull+"租房合同附件");
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
				SC.say("住房租金提示","1.本人以及配偶在主要城市无自有住房" + 
						"2.本人以及配偶扣除年度未扣除住房贷款利息支出"
						+ "3.本人以及配偶主要工作城市相同，该扣除年度配偶未享受过住房租金支出扣除"
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
		IButton upButton = new IButton("上传租房合同");
		upButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(null==grid.getSelectedRecord()) {
					SC.say("提示","请选择一条数据");
				}else {
					new CommonUploadWindow("请上传租房合同", false, 50, 2, 1, new UploadCallBack() {
						
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
			if(null==r.getAttribute("province")) {
				SC.say("提示","省份不能为空");
				return false;
			}
			if(null==r.getAttribute("city")) {
				SC.say("提示","城市不能为空");
				return false;
			}
			if(null==r.getAttribute("leaseType")) {
				SC.say("提示","出租类型不能为空");
				return false;
			}else {
				String attribute = r.getAttribute("leaseType");
				if(attribute.equals("0")) {
					if(null==r.getAttribute("otherDocumentType")) {
						SC.say("提示","出租方证件类型不能为空");
						return false;
					}

				}
			}
			if(null==r.getAttribute("otherIdentificationNumber")) {
				SC.say("提示","出租方身份证件号码不能为空");
				return false;
			}
			if(null==r.getAttribute("name")) {
				SC.say("提示","出租方姓名不能为空");
				return false;
			}
		
			if(null==r.getAttribute("leaseAddress")) {
				SC.say("提示","住房坐落地址不能为空");
				return false;
			}
			if(null==r.getAttribute("startDate")) {
				SC.say("提示","合同开始时间不能为空");
				return false;
			}
			if(null==r.getAttribute("endDate")) {
				SC.say("提示","合同结束时间不能为空");
				return false;
			}
			if(r.getAttributeAsDate("startDate").after(r.getAttributeAsDate("endDate"))){
				SC.say("合同开始时间必须小于合同结束时间");
				return false;
			}
			if(null==r.getAttribute("amount")) {
				SC.say("提示","金额不能为空");
				return false;
			}else {
				int amount = BaseHelpUtils.getIntValue(r.getAttribute("amount"));
				if(amount>1500) {
					SC.say("提示","金额不能超过1500");
					return false;
				}
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
		res.add("SpecialDeductionInformation4");
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
			MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "specialDeductionInformation4");
		}
		return param;
	}

	@Override
	public String getName() {
		return "住房租金信息";
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

