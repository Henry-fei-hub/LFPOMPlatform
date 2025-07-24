package com.pomplatform.client.supplierworkflow.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateSupplierComeInForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_ReceiveUnitManageWithSs";
	}

	@Override
	public boolean checkData(Map data){
		return true;
	}

	@Override
	public int getPageCount(){
		return 3;
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
		res.add(new SupplierComeInUpdateForm());
		SupplierComeInDetailSupplierDetail supplierdetail = new SupplierComeInDetailSupplierDetail();
		supplierdetail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(supplierdetail);
		SupplierComeInDetailSupplierCooperation suppliercooperation = new SupplierComeInDetailSupplierCooperation();
		suppliercooperation.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(suppliercooperation);
		return res;
	}


}

