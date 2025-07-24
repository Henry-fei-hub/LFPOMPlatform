package com.pomplatform.client.ja.ht.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class BidPaySheetProjectForm extends GenericWizadWindow
{
	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "EP_OnProjectCommonProcess";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkData(Map data){
		data.put("optType","onBidPaySheetProjectSave");
		//获取投标金额
		BigDecimal bigPayAmount = BaseHelpUtils.getBigDecimalValue(data.get("bigPayAmount"));
		Date bidDate = (Date)data.get("bidDate");
		if(BaseHelpUtils.isNullOrEmpty(bidDate)){
			SC.say("提示","投标日期不可为空");
			return false;
		}else if(bigPayAmount.compareTo(BigDecimal.ZERO) <= 0){
			SC.say("提示","投标不能小于或等于0");
			return false;
		}else{
			return true;
		}
	}

	@Override
	public int getPageCount(){
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new BidPaySheetProjectNewForm());
		return res;
	}


}

