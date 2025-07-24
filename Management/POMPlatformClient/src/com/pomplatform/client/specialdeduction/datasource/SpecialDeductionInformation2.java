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
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SpecialDeductionInformation2 extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private int parentId;
	private int specialDeductionTypeId=2;//继续教育
	private int year;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public SpecialDeductionInformation2(){
		HLayout employeeEducationInformations = new HLayout();
		employeeEducationInformations.setWidth100();
		employeeEducationInformations.setHeight100();
		grid.setHeaderHeight(60); 
		grid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("继续教育信息", 
				   new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId",
				   "year","educationType","educationStage","startDate",
				   "endDate","issueDate","credential","credentialNumber"
				   ,"issuingAuthority","amount","fileId","fileUrl"})
	    });
		ListGridField[] fields = new ListGridField[18];
		int idx = 0;
		fields[0] = new ListGridField("specialDeductionDetailId");
		fields[0].setShowGridSummary(false);
		fields[0].setHidden(true);
		idx++;
		fields[1] = new ListGridField("parentId");
		fields[1].setShowGridSummary(false);
		fields[1].setHidden(true);
		idx++;
		fields[2] = new ListGridField("specialDeductionTypeId",shouldNotBeNull+"专项类型");
		fields[2].setShowGridSummary(false);
		fields[2].setCanEdit(false);
		fields[2].setDefaultValue(specialDeductionTypeId); 
		idx++;
		fields[3] = new ListGridField("year",shouldNotBeNull+"扣除年度");
		fields[3].setShowGridSummary(false);
		Date d = new Date();
		fields[3].setDefaultValue(d.getYear()+1900);
		idx++;
		fields[4] = new ListGridField("educationType",shouldNotBeNull+"继续教育类型");
		fields[4].setShowGridSummary(false);
		fields[4].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				// TODO Auto-generated method stub
				ListGridRecord selectedRecord = grid.getSelectedRecord();
//				Integer attributeAsInt = selectedRecord.getAttributeAsInt("amount");
				int intValue = BaseHelpUtils.getIntValue(event.getValue());
				if(intValue==1||intValue==2) {
					selectedRecord.setAttribute("amount", 360);
				}else {
					selectedRecord.setAttribute("amount", 400);
				}
			}
		});
		idx++;
		fields[5] = new ListGridField("educationStage","教育阶段");
		fields[5].setShowGridSummary(false);
		idx++;
		fields[6] = new ListGridField("startDate","当前继续教育起始时间");
		fields[6].setShowGridSummary(false);
		idx++;
		fields[7] = new ListGridField("endDate","当前继续教育结束时间");
		fields[7].setShowGridSummary(false);
		idx++;
		fields[8] = new ListGridField("issueDate","发证日期");
		fields[8].setShowGridSummary(false);
		idx++;
		fields[9] = new ListGridField("credential","证书名字");
		fields[9].setShowGridSummary(false);
		idx++;
		fields[10] = new ListGridField("credentialNumber","证书编号");
		fields[10].setShowGridSummary(false);
		idx++;
		fields[11] = new ListGridField("issuingAuthority","发证机关");
		fields[11].setShowGridSummary(false);
		idx++;
		fields[12] = new ListGridField("amount",shouldNotBeNull+"金额");
		fields[12].setShowGridSummary(false);
		fields[12].setCanEdit(false);
		idx++;
		fields[13] = new ListGridField("fileId");
		fields[13].setHidden(true);
		idx++;
		fields[14] = new ListGridField("fileUrl",shouldNotBeNull+"继续教育入学通知书或相关证书附件");
		fields[14].setShowGridSummary(false);
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
				SC.say("继续教育提示","1、纳税人参加学历继续教育的，为入学当月至教育结束的当月，最长不得超过48个月；接受学历继续教育的，在学历教育期间按每年4,800元（每月400元）定额扣除" + 
						"2、纳税人参加职业资格教育的，为取得相关职业资格证书的当年；接受技能人员、专业技术人员职业资格继续教育的，在取得相关证书的年度， 按照3,600（每月300元）元定额扣除"
						+ "3.填写前请点击申请说明仔细阅读，不符合条件者请勿填写该项，以免影响个人纳税信用甚至违反税收法律");
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
		IButton upButton = new IButton("上传继续教育入学通知书或相关证书");
		upButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(null==grid.getSelectedRecord()) {
					SC.say("提示","请选择一条数据");
				}else {
					new CommonUploadWindow("请上传继续教育入学通知书或相关证书", false, 50, 2, 1, new UploadCallBack() {
						
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
			if(null==r.getAttribute("educationType")) {
				SC.say("提示","继续教育类型不能为空");
				return false;
			}
			Integer educationType = r.getAttributeAsInt("educationType");
			if(educationType!=1&&educationType!=2) {
				if(null==r.getAttributeAsDate("startDate")) {
					SC.say("提示","当前受教育开始时间不能为空");
					return false;
				}
				if(null==r.getAttributeAsDate("endDate")) {
					SC.say("提示","当前受教育结束日期不能为空");
					return false;
				}
				if(r.getAttributeAsDate("startDate").after(r.getAttributeAsDate("endDate"))){
					SC.say("当前受教育开始时间必须小于当前受教育结束日期");
					return false;
				}
				if(null==r.getAttribute("educationStage")) {
					SC.say("提示","教育阶段不能为空");
					return false;
				}
			}else {
				if(null==r.getAttributeAsDate("issueDate")) {
					SC.say("提示","发证日期不能为空");
					return false;
				}
				if(null==r.getAttribute("credential")) {
					SC.say("提示","证书名字不能为空");
					return false;
				}
				if(null==r.getAttribute("credentialNumber")) {
					SC.say("提示","证书编号不能为空");
					return false;
				}
				if(null==r.getAttribute("issuingAuthority")) {
					SC.say("提示","发证机关不能为空");
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
		res.add("SpecialDeductionInformation2");
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
			MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "specialDeductionInformation2");
		}
		return param;
	}

	@Override
	public String getName() {
		return "继续教育信息";
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

