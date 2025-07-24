package com.pomplatform.client.plateproductionvaluecoefficientstype.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.plateproductionvaluecoefficients.form.ProductionValueCoefficientTypeDetailProductionValueCoefficient;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 产值系数的更新界面
 *
 * @author xiaolong
 */
public class UpdateProductionValueCoefficientTypeForm extends GenericWizadWindow {


    @Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_ProductionValueCoefficientTypeWithP";
    }

    @Override
    public boolean checkData(Map data) {
        return true;
    }

    @Override
    public int getPageCount() {
        return 1;
    }

    @Override
    public List<AbstractWizadPage> getPages() {
        setCallback(new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                // Please code the program after save sucessfully.
            }
        });
        setSubaction("update");
        List<AbstractWizadPage> res = new ArrayList<>();
        res.add(new ProductionValueCoefficientTypeDetailProductionValueCoefficient());
        return res;
    }


}

