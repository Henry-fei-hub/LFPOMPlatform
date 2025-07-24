package com.pomplatform.client.equipment.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateMequipmenttypeedeeeorForm extends GenericWizadWindow
{


	private MequipmenttypeedeeeorUpdateForm mequipmenttypeedeeeorUpdateForm = new MequipmenttypeedeeeorUpdateForm();

	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "EP_UpdateEquipmentProcess";
	}

	@Override
	public boolean checkData(Map data){
		return true;
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
				// Please code the program after save sucessfully.

			}
		});
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(mequipmenttypeedeeeorUpdateForm);
		return res;
	}

	public void setModifyMode(){
		mequipmenttypeedeeeorUpdateForm.setModifyMode();
	}


}

