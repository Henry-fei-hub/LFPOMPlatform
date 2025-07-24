package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.datasource.DSOrderPlacement;

public class OrderPlacementNewForm extends AbstractWizadPage
{


	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem customerNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem statusItem;
	private final TextItem projectCodeItem;
	private final TextItem contractTypeItem;
	private final TextItem projectLevelItem;
	private final TextItem contractPriceItem;
	private final TextItem projectAddressItem;
	private final TextItem contractFollowerItem;
	private final TextItem remarkItem;
	private final DateItem contractDateItem;
	private final TextItem signingCompanyNameItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem updateTimeItem;
	private final TextItem businessTypeItem;
	private final TextItem flowStatusItem;
	private final TextItem serialNumberItem;
	private final TextItem projectTypeItem;
	private final TextItem coveredAreaItem;
	private final TextItem professionalCooperationItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem detailAddressItem;
	private final TextItem customerAddressItem;
	private final TextItem serviceSuggestBookItem;
	private final DateItem projectApprovalTimeItem;
	private final TextItem orderNoItem;
	private final TextItem infoCodeItem;
	private final TextItem contractStatusItem;
	private final TextItem clientContractIdItem;
	private final CheckboxItem isFinishItem;
	private final CheckboxItem isSystemAddItem;
	private final CheckboxItem hasOutQuotationsItem;
	private final TextItem fileIdItem;
	private final TextItem fileUrlItem;
	private final TextItem totalProjectTimeItem;
	private final TextItem designAreasItem;
	private final TextItem signingMoneySumItem;
	private final CheckboxItem hasSplitPriceItem;

	public OrderPlacementNewForm() {
		DSOrderPlacement ds = DSOrderPlacement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractIdItem = new TextItem("contractId", "主订单编码");
		__formItems.add(contractIdItem);
		contractCodeItem = new TextItem("contractCode", "主订单编号");
		__formItems.add(contractCodeItem);
		contractNameItem = new TextItem("contractName", "主订单名称");
		__formItems.add(contractNameItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		__formItems.add(customerNameItem);
		startDateItem = new DateItem("startDate", "开始日期");
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "结束日期");
		__formItems.add(endDateItem);
		statusItem = new TextItem("status", "结算状态");
		__formItems.add(statusItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		contractTypeItem = new TextItem("contractType", "合同类别");
		__formItems.add(contractTypeItem);
		projectLevelItem = new TextItem("projectLevel", "项目等级");
		__formItems.add(projectLevelItem);
		contractPriceItem = new TextItem("contractPrice", "合同单价");
		__formItems.add(contractPriceItem);
		projectAddressItem = new TextItem("projectAddress", "项目地点");
		__formItems.add(projectAddressItem);
		contractFollowerItem = new TextItem("contractFollower", "合同跟进人");
		__formItems.add(contractFollowerItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);
		contractDateItem = new DateItem("contractDate", "合同签订日期");
		__formItems.add(contractDateItem);
		signingCompanyNameItem = new TextItem("signingCompanyName", "我方签约公司名称");
		__formItems.add(signingCompanyNameItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		__formItems.add(updateTimeItem);
		businessTypeItem = new TextItem("businessType", "业务类别");
		__formItems.add(businessTypeItem);
		flowStatusItem = new TextItem("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		__formItems.add(flowStatusItem);
		serialNumberItem = new TextItem("serialNumber", "流水号");
		__formItems.add(serialNumberItem);
		projectTypeItem = new TextItem("projectType", "项目类别");
		__formItems.add(projectTypeItem);
		coveredAreaItem = new TextItem("coveredArea", "建筑面积");
		__formItems.add(coveredAreaItem);
		professionalCooperationItem = new TextItem("professionalCooperation", "配合专业");
		__formItems.add(professionalCooperationItem);
		provinceItem = new TextItem("province", "省份");
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "城市");
		__formItems.add(cityItem);
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		__formItems.add(detailAddressItem);
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		__formItems.add(customerAddressItem);
		serviceSuggestBookItem = new TextItem("serviceSuggestBook", "服务建议书");
		__formItems.add(serviceSuggestBookItem);
		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立单时间 提交了立单时间会将保存下来，只是点击保存不会将当前时间保存下来，单每次都会显示当前的时间，提交了下次显示的就是提交时的立单时间");
		__formItems.add(projectApprovalTimeItem);
		orderNoItem = new TextItem("orderNo", "标记补充协议字段；除0之外，其他都表示第n个补充协议");
		__formItems.add(orderNoItem);
		infoCodeItem = new TextItem("infoCode", "信息编号");
		__formItems.add(infoCodeItem);
		contractStatusItem = new TextItem("contractStatus", "合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除");
		__formItems.add(contractStatusItem);
		clientContractIdItem = new TextItem("clientContractId", "客户合同编号");
		__formItems.add(clientContractIdItem);
		isFinishItem = new CheckboxItem("isFinish", "合同是否完成");
		__formItems.add(isFinishItem);
		isSystemAddItem = new CheckboxItem("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		__formItems.add(isSystemAddItem);
		hasOutQuotationsItem = new CheckboxItem("hasOutQuotations", "是否有报价单");
		__formItems.add(hasOutQuotationsItem);
		fileIdItem = new TextItem("fileId", "附件id");
		__formItems.add(fileIdItem);
		fileUrlItem = new TextItem("fileUrl", "附件url");
		__formItems.add(fileUrlItem);
		totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
		__formItems.add(totalProjectTimeItem);
		designAreasItem = new TextItem("designAreas", "总设计面积");
		__formItems.add(designAreasItem);
		signingMoneySumItem = new TextItem("signingMoneySum", "签约总金额");
		__formItems.add(signingMoneySumItem);
		hasSplitPriceItem = new CheckboxItem("hasSplitPrice", "是否有拆分价 true 有，反之");
		__formItems.add(hasSplitPriceItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOrderPlacement.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
