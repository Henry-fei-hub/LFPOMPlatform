package com.pomplatform.client.preprojects.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.preprojects.datasource.CDprojectPreInfomations;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class projectPreInfomationsSearchForm extends SearchForm
{


	private final TextItem projectNameItem;
//	private final SelectItem projectStatusItem;
	private final SelectItem statusItem;
//	private final DateTimeItem startDateItem;
//	private final DateTimeItem endDateItem;
	private final SelectItem processStatusItem;
	private final ComboBoxItem employeeNameItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem customerNameItem;
	private final SelectItem projectStatusItem;
	private final SelectItem projectLevelItem;
	private final TextItem winRateItem;
	private final TextItem infoCodeItem;
	private final TextItem detailAddressItem;
	private final SelectItem projectBaseOnItem;
	private final SelectItem businessTypeItem;
	private final ComboBoxItem projectLeaderItem;
	private final ComboBoxItem projectManagerItem; 
	private final TextItem actualDesignAreasItem;
	private final TextItem decorateMoneyControlItem;
	private final SelectItem contractStatusItem;
	private final TextItem estimateTheDesignAreasItem;
	private final TextItem projectTotalInvestmentItem;  
	private final SelectItem projectOriginationItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem projectMissionerItem;

	public projectPreInfomationsSearchForm() {
		setWidth100();
		setHeight100();
//		setDataSource(CDprojectPreInfomations.getInstance());

		startDateItem=new DateTimeItem("createTimeStart","登记开始时间"); 
		startDateItem.setUseTextField(true);   
		startDateItem.setWidth("*");

		endDateItem=new DateTimeItem("createTimeEnd","登记结束时间");
		endDateItem.setUseTextField(true);   
		endDateItem.setWidth("*");
		
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		
		detailAddressItem = new TextItem("detailAddress", "项目地址");
		detailAddressItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		projectOriginationItem = new SelectItem("projectOrigination", "项目来源渠道");
		projectOriginationItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_156",projectOriginationItem);


		provinceItem = new TextItem("province", "项目地址（省）");
		provinceItem.setHidden(false);
		provinceItem.setWidth("*");

		cityItem = new TextItem("city", "项目地址（市）");
		cityItem.setHidden(false);
		cityItem.setWidth("*");
		
		
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据"); 
		projectBaseOnItem.setWidth("*");
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28")); 
		
		LinkedHashMap<String, String> busLinkMap=new LinkedHashMap<>();
		Map<String,Object> bMap=new HashMap<>();
		bMap.put("addtionalCondition", "parent_id>0");
		Record[] brecord=SyncDataUtil.getValueByTableNames("ST_BusinessCategory", "find", bMap);
		for (Record record : brecord) {
			busLinkMap.put(record.getAttributeAsString("businessCategoryName"), record.getAttributeAsString("businessCategoryName"));
		}
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(busLinkMap);
		//KeyValueManager.loadValueMap("pre_business_type_detail",businessTypeItem);
		
		processStatusItem = new SelectItem("processStatus","报备流程状态");
		processStatusItem.setWidth("*");
		processStatusItem.setValueMap(KeyValueManager.getValueMap("process_status"));

		statusItem = new SelectItem("status", "立项/关闭流程状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_161")); 
		
		estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasItem.setWidth("*");
		
		actualDesignAreasItem = new TextItem("actualDesignAreas", "实际设计面积");
		actualDesignAreasItem.setWidth("*");
		
		
		LinkedHashMap<String, Object> linkMap=new LinkedHashMap<>();
		Record[] records=SyncDataUtil.getValueByTableNames("ST_Employee", "find", new HashMap<>());
		for (Record record : records) {
			linkMap.put(record.getAttribute("employeeName"), record.getAttribute("employeeName"));
		}
		projectLeaderItem = new ComboBoxItem("projectLeader", "项目主管领导");
		projectLeaderItem.setLength(120);
		projectLeaderItem.setWidth("*");
		projectLeaderItem.setValueMap(linkMap);
		
		projectManagerItem = new ComboBoxItem("projectManager", "项目经理");
		projectManagerItem.setWidth("*");
		projectManagerItem.setValueMap(linkMap);

		
//		startDateItem = new DateTimeItem("startDate", "开始修改时间");
//		startDateItem.addChangedHandler(new ChangedHandler() {
//			@Override
//			public void onChanged(ChangedEvent event) {
//				Date val = (Date) event.getValue();
//				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
//			}
//		});
//		startDateItem.setWidth("*");
		
//		endDateItem = new DateTimeItem("endDate", "截止修改时间");
//		endDateItem.addChangedHandler(new ChangedHandler() {
//			@Override
//			public void onChanged(ChangedEvent event) {
//				Date val = (Date) event.getValue();
//				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
//			}
//		});
//		endDateItem.setWidth("*");
		
		customerNameItem = new TextItem("customerName","客户名称");
		customerNameItem.setWidth("*");
		
		projectStatusItem = new SelectItem("projectStatus","项目状态");
		projectStatusItem.setWidth("*");
		projectStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_154"));
		
		employeeNameItem = new ComboBoxItem("employeeName","报备人");
		employeeNameItem.setWidth("*");
	    employeeNameItem.setValueMap(linkMap);
	
		
		decorateMoneyControlItem = new TextItem("decorateMoneyControl", "装修造价控制");
		decorateMoneyControlItem.setWidth("*");
		
		contractStatusItem = new SelectItem("contractStatus", "合同状态");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		contractStatusItem.setWidth("*");
		
		
		projectTotalInvestmentItem = new TextItem("projectTotalInvestment", "项目总投资额");
		projectTotalInvestmentItem.setWidth("*");
		
		projectMissionerItem = new TextItem("projectMissioner", "项目秘书");
		projectMissionerItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId","报备部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		//如果有查看所有数据的权限
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PRE_PROJECT_CHECK_ALL_DATA)){
			departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		//如果是查看自己管理部门的权限
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PRE_PROJECT_CHECK_PLATE_DATA)){
			String departmentIds = ClientUtil.getRoleDepartmentId();
	        String departmentId = ClientUtil.getDepartmentId() + "";
            final String[] ids = departmentIds.split(",");
            boolean status = false;
            if(BaseHelpUtils.isNullOrEmpty(departmentIds)){//说明没有设置管理部门的权限
                departmentIdItem.setDefaultValue(departmentId);
            }else{
                for (String str : ids) {
                    if (str.equals(departmentId)) {
                        status = true;
                    }
                }
                if (status) {
                    departmentIdItem.setDefaultValue(departmentId);
                } else {
                    departmentIdItem.setDefaultValue(ids[0]);
                }
            }
            departmentIdItem.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					if (null != event.getValue()) {
                        String[] arr = event.getValue().toString().split("/");
                        String value = arr[arr.length - 1];
                        boolean status = false;
                        for (String str : ids) {
                            if (str.equals(value)) {
                                status = true;
                            }
                        }
                        if (!status) {
                            SC.say("对不起，您没有查看这个部门数据的权限");
                            event.cancel();
                        }
                    }    					
				}
			});
		}else{
			departmentIdItem.hide();
		}
		
		projectLevelItem = new SelectItem("projectLevel","项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		
		winRateItem = new TextItem("winRate","赢率大于");
		winRateItem.setWidth("*");
		setItems(infoCodeItem,projectNameItem,customerNameItem,processStatusItem,projectStatusItem,statusItem,businessTypeItem ,projectBaseOnItem,projectLeaderItem,projectManagerItem,employeeNameItem,departmentIdItem,projectOriginationItem,provinceItem,cityItem,detailAddressItem,startDateItem,endDateItem,projectMissionerItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
