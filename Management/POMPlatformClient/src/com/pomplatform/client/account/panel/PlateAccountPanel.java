package com.pomplatform.client.account.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;  
  
public class PlateAccountPanel extends VLayout {
	public PlateAccountPanel() {
        setWidth100();
        setHeight100();
        PlateAccountAllPanel panel1 = new PlateAccountAllPanel();
        PlateAccountDesignPanel panel2 = new PlateAccountDesignPanel();
        // 如果拥有查看所有部门数据，则加载所有数据
 		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)) {
 			addMember(panel1);
 		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)){
 			String plateIds = PomPlatformClientUtil.getRolePlateId();
 			if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
 				//检索该人员管理的部门是否有包含一级部门的数据集
 				Map<Object, Object> paramChild = new HashMap<>();
 				paramChild.put("optType", "onCheckIsHasParent");
 				paramChild.put("plateIds", plateIds);
 				DBDataSource.callOperation("EP_AccountManageProcess", paramChild, new DSCallback() {
 					@Override
 					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
 						if (dsResponse.getStatus() == 1) {//说明管理的部门当中有包含一级部门
 							addMember(panel1);
 						}else if(dsResponse.getStatus() == 0){
 							String[] plateIdArr = plateIds.split(",");
 							panel2.setPlateId(BaseHelpUtils.getIntValue(plateIdArr[0]));
 							panel2.initComponents();
 							addMember(panel2);
 						}else{
 							SC.say("提示","数据加载异常");
 						}
 					}
 				});
 			}
 		}else{
			SC.say("提示","您没有查看部门账户的任何权限");
		}
    }
	
	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			PlateAccountPanel cm = new PlateAccountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateAccountPanel";
		}

	}

}