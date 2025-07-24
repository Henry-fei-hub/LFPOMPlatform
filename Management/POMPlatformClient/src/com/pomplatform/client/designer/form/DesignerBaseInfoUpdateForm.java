package com.pomplatform.client.designer.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;

import java.math.BigDecimal;
import java.util.*;

import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.pomplatform.client.employeenew.form.SemployeeUploadImgForm;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.logging.Logger;

public class DesignerBaseInfoUpdateForm extends AbstractWizadPage {

    private final Logger __logger = Logger.getLogger("");
    private final TextItem employeeNoItem;
    private final TextItem employeeNameItem;
    private final TextItem mobileItem;
    private final TextItem phoneItem;
    private final TextItem qqItem;
    private final TextItem emailItem;
    private final CheckboxItem usableStatusItem;
    private final Img designerPhoto;
//    private final TextItem autographItem;
    private final DateItem birthItem;
    private final TextItem cardItem;
    private final TextItem addressItem;
    private final IButton saveButton;
    private final IButton uploadImgButton;
    private final IntegerItem runProjectNum;
    private final IntegerItem finishProjectNum;
    private final IntegerItem planIntegral;
    private final IntegerItem realIntegral;
    private final TextItem companyEmailItem;
    private final SelectItem isBusyItem;
    private final TextItem leftIntegralItem;
    private final TextItem englishNameItem;

    public DesignerBaseInfoUpdateForm() {
        __form.setGroupTitle("我的资料");
        __form.setIsGroup(true);
        __projectForm = new DynamicForm();
        __projectForm.setGroupTitle("我的项目");
        __projectForm.setIsGroup(true);
        DSSemployeeNew ds = DSSemployeeNew.getInstance();
        __form.setWidth100();
        __form.setHeight("65%");
        __projectForm.setWidth100();
        __projectForm.setHeight("35%");
        
        employeeNoItem = new TextItem("employeeNo", "账号");
        employeeNoItem.setDisabled(true);
        employeeNoItem.setWidth("*");
        employeeNoItem.setRequired(true);
        employeeNoItem.setCanEdit(false);
        IsStringValidator employeeNoValidator = new IsStringValidator();
        LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
        employeeNoLengthValidator.setMax(64);
        employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
		__formItems.add(employeeNoItem);
		
        employeeNameItem = new TextItem("employeeName", "名字");
        employeeNameItem.setDisabled(true);
        employeeNameItem.setWidth("*");
        employeeNameItem.setRequired(true);
        IsStringValidator employeeNameValidator = new IsStringValidator();
        LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
        employeeNameLengthValidator.setMax(64);
        employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
        __formItems.add(employeeNameItem);
		
        mobileItem = new TextItem("mobile", "手机(手机号修改请联系人资专员)");
        mobileItem.setDisabled(true);
        mobileItem.setWidth("*");
		__formItems.add(mobileItem);
		
		englishNameItem = new TextItem("employeeNameEn","英文名称(该信息修改后会同步至企业微信)");
		englishNameItem.setWidth("*");
		__formItems.add(englishNameItem);
		
        phoneItem = new TextItem("phone", "座机(该信息修改后会同步至企业邮箱与企业微信),请填写真实的公司座机号");
        phoneItem.setWidth("*");
        __formItems.add(phoneItem);
		
		qqItem = new TextItem("qq", "QQ");
        qqItem.setWidth("*");
        __formItems.add(qqItem);
		
		emailItem = new TextItem("email", "私人邮箱");
        emailItem.setWidth("*");
        __formItems.add(emailItem);
		
		usableStatusItem = new CheckboxItem("usableStatus", "工作是否饱和");
		usableStatusItem.setDisabled(true);
        __formItems.add(usableStatusItem);
		
		designerPhoto = new Img();
        designerPhoto.setHeight(150);
        designerPhoto.setWidth(150);
//        autographItem = new TextItem("autograph", "我的签名");
//        autographItem.setWidth("*");
//		__formItems.add(autographItem);
		
        birthItem = new DateItem("birth", "出生日期");
        birthItem.setUseTextField(true);
        birthItem.setUseMask(true);
        birthItem.setDisabled(true);
        birthItem.setWidth("*");
        __formItems.add(birthItem);
		
		cardItem = new TextItem("card", "身份证号");
		cardItem.setDisabled(true);
        cardItem.setWidth("*");
        __formItems.add(cardItem);
		
		addressItem = new TextItem("address", "家庭地址");
        addressItem.setWidth("*");
		__formItems.add(addressItem);
		
		companyEmailItem = new TextItem("companyEmail", "企业邮箱");
		companyEmailItem.setWidth("*");
		companyEmailItem.setDisabled(true);
		__formItems.add(companyEmailItem);
		
        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        if(Browser.getIsDesktop()) {
            __form.setNumCols(4);
            __form.setHeight("65%");
            __projectForm.setHeight("35%");
        }
        
        setPageMode(PAGE_MODE_UPDATE);

        hLayout = new HLayout(10);
        hLayout.setHeight("10%");
        //saveButton = PermissionControl.createPermissionButton("保存修改", ERPPermissionStatic.MY_INFO_UPDATE_MANAGEMENT);
        saveButton = new IButton("保存修改");
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map value = getValuesAsMap();
                if(null == value.get("phone")){
                	value.put("phone", " ");
                }
                if(null == value.get("employeeNameEn")){
                	value.put("employeeNameEn", " ");
                }
                value.put("isbusy", isBusyItem.getValue());
                DBDataSource.callOperation(getActionName(), "update", value, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            SC.say("update success！");
                            value.put("opt_type", "updateEemployeeTel");
                            DBDataSource.callOperation("EP_CustomSemployeeProcess", value, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									// TODO Auto-generated method stub
									
								}
							});
                        }
                    }
                });
            }
        });
        hLayout.addMember(saveButton);
//        PermissionControl.createPermissionButton("上传头像", ERPPermissionStatic.MY_INFO_UPLOAD_HEADIMG_MANAGEMENT);
        uploadImgButton = new IButton("上传头像");
        uploadImgButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
            	Map value = getValuesAsMap();
            	final String employeeId = value.get("employeeId").toString();
				new CommonUploadWindow("上传头像", false, 10, 1, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						// 上传附件文件成功
						for(String key : data.keySet()) {
							final String fileId = data.get(key).getAttribute("fileId");
							final String fileUrl = data.get(key).getAttribute("fileUrl");
							final Map<String, String> params = new HashMap<>();
							params.put("employeeId", employeeId);
							params.put("photo", fileUrl);
							params.put("photoId", fileId);
							DBDataSource.callOperation("ST_CustomEmployee", "update", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0) {
										designerPhoto.setSrc(fileUrl);
									}else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							} );
						}
					}
				});
            }
        });
        hLayout.addMember(uploadImgButton);

        runProjectNum = new IntegerItem("runProjectNum", "运行项目数");
        runProjectNum.setDisabled(true);
        finishProjectNum = new IntegerItem("finishProjectNum", "完成项目数");
        finishProjectNum.setDisabled(true);
        planIntegral = new IntegerItem("planIntegral", "计划获得积分");
        planIntegral.setDisabled(true);
        realIntegral = new IntegerItem("realIntegral", "实际获得积分");
        realIntegral.setDisabled(true);
        isBusyItem = new SelectItem("isBusy","状态");
        isBusyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_140"));
        leftIntegralItem = new TextItem("leftIntegral","剩余积分");
        leftIntegralItem.setDisabled(true);
        __projectForm.setItems(runProjectNum, finishProjectNum, planIntegral, realIntegral,isBusyItem,leftIntegralItem);
        __projectForm.setNumCols(4);
        
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        ClientUtil.DynamicFormProcessAccordingToDevice(__projectForm);
        
        vLayout = new VLayout(10);
        vLayout.setOverflow(Overflow.AUTO);
        vLayout.setMargin(20);
        vLayout.addMember(designerPhoto);
        vLayout.addMember(__form);
        vLayout.addMember(__projectForm);
        vLayout.addMember(hLayout);
        addMember(vLayout);
    }

    @Override
    public void startEdit() {
        SC.debugger();
        if (getRecord() != null) {
            __form.editRecord(getRecord());
            String photoUrl = getRecord().getAttribute("photo");
            if (photoUrl == null || photoUrl.length() == 0) {
                designerPhoto.setSrc("/images/photo_view.png");
            } else {
                designerPhoto.setSrc(photoUrl);
            }
            getProjectNumAndIntegral();
        }
    }

    //获取设计师的已完成项目数和正在进行项目数，预分配积分和实际获得积分
    public void getProjectNumAndIntegral() {
    	Map<String,Object> param = new HashMap<>();
    	//获取当前登录人ID
    	int employeeId = ClientUtil.getEmployeeId();
    	param.put("employeeId", employeeId);
        DBDataSource.callOperation("EP_DesignerGetMsg", "update",param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	if(!BaseHelpUtils.isNullOrEmpty(dsResponse.getAttribute("userData")) && dsResponse.getAttribute("userData").length() > 0){
						Map<String,Object> map = dsResponse.getAttributeAsMap("userData");
						//执行成功后重新执行查询，刷新表格数据
						runProjectNum.setDefaultValue(map.get("planWorkHours"));
						finishProjectNum.setDefaultValue(map.get("realWorkHours"));
						planIntegral.setDefaultValue(map.get("planIntegral"));
						realIntegral.setDefaultValue(map.get("realIntegral"));
						isBusyItem.setValue(map .get("isBusy"));
						BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(map.get("leftIntegral"));
						leftIntegralItem.setValue(leftIntegral);
					}
                } else {
                    Map errors = dsResponse.getErrors();
                    SC.say("get failure" + errors);
                }
            }
        });
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSemployeeNew.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        String photoValue = values.get("photo").toString();
        if (photoValue != null && photoValue.length() > 0) {
            String photo = photoValue.substring(photoValue.lastIndexOf("/") + 1);
            values.put("photo", photo);
        }
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_Employee";
    }

    private final DynamicForm __projectForm;
    private final HLayout hLayout;
    private final VLayout vLayout;

}
