package com.pomplatform.client.supplierworkflow.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateSupplierComeInWorkflow extends AbstractProcessPanel
{
	private static final Logger __logger = Logger.getLogger("");

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("supplierId", getBusinessId());
		DBDataSource.callOperation("NQ_SupplierComeIn", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setData(dsResponse.getData()[0]);
					if(__pages == null) __pages = getPages();
					for(AbstractWizadPage wp : __pages) { wp.setRecord(getData()); wp.startEdit(); }
				}
			}
		});
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
		__pageMode = PAGE_DISPLAY_NAV;
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// Please code the program after save sucessfully.
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		SupplierComeInDetailSupplierDetail supplierdetail = new SupplierComeInDetailSupplierDetail();
		SupplierComeInDetailSupplierCooperation suppliercooperation = new SupplierComeInDetailSupplierCooperation();
		res.add(supplierdetail);
		res.add(suppliercooperation);
		return res;
	}


	@Override
	public Map getValues() {
		Map<String, Object> values = new HashMap<>();
		for (AbstractWizadPage p : __pages) {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = p.getValuesAsMap();
			Set<String> set = p.getItemNames();
			if (!BaseHelpUtils.isNullOrEmpty(map) && map.size() > 0) {
				if (!BaseHelpUtils.isNullOrEmpty(set) && set.size() > 0) {
					for (String key : map.keySet()) {
						if (set.contains(key)) {
							values.put(key, map.get(key));
						}
					}
				}
			}
			Object detailSupplierDetail = map.get("detailSupplierDetail");
			Object detailSupplierCooperation = map.get("detailSupplierCooperation");
			Object receiveInfo = map.get("receiveInfo");
			Object supplierId = map.get("supplierId");
			Object fileId = map.get("fileId");
			if(!BaseHelpUtils.isNullOrEmpty(detailSupplierDetail)){
				values.put("detailSupplierDetail", detailSupplierDetail);
			}
			if(!BaseHelpUtils.isNullOrEmpty(detailSupplierCooperation)){
				values.put("detailSupplierCooperation", detailSupplierCooperation);
			}
			if(!BaseHelpUtils.isNullOrEmpty(receiveInfo)){
				values.put("receiveInfo", receiveInfo);
			}
			if(!BaseHelpUtils.isNullOrEmpty(supplierId)){
				values.put("supplierId", supplierId);
			}
			if(!BaseHelpUtils.isNullOrEmpty(fileId)){
				values.put("fileId", fileId);
			}
			values.put("operateEmployeeId", ClientUtil.getEmployeeId());
		}
		return values;
	}

}

