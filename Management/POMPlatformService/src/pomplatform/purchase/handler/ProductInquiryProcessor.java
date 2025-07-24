package pomplatform.purchase.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProductInquiryDetail;
import com.pomplatform.db.bean.BaseProductInquirySupplierDetail;
import com.pomplatform.db.dao.ProductInquiryDetail;
import com.pomplatform.db.dao.ProductInquirySupplierDetail;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProductInquiryProcessor implements GenericProcessor{

	//操作类型
    private static final String OPT_TYPE = "optType";
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
        switch (optType) {
        // 设置为最终报价
		case "setFinalQuotation":
			return setFinalQuotation(params);
		case "updateSupplierDetailData":
			return updateSupplierDetailData(creteria);
		default:
			break;
		}
        return null;
    }
    
    /**
     * 修改供应商详情数据
     * @param json
     * @return
     * @throws Exception
     */
    private String updateSupplierDetailData(String json)throws Exception{
    	BaseProductInquirySupplierDetail bean = new BaseProductInquirySupplierDetail();
		bean.setDataFromJSON(json);
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num = 0;
		if(dao.load()){
			dao.setDataFromBase(bean); 
			num = dao.update(); 
			if(dao.getIsSelect()) {
				// 修改主数据
				ProductInquiryDetail pidDao = new ProductInquiryDetail();
				pidDao.setProductInquiryDetailId(dao.getProductInquiryDetailId());
				if(pidDao.load()) {
					pidDao.setSupplierId(dao.getSupplierId());
					pidDao.setTotalPrice(dao.getTotalPrice());
					pidDao.setProductPrice(dao.getProductPrice());
					pidDao.setTaxPoints(dao.getTaxPoints());
					pidDao.update();
				}
			}
		}
		return bean.toOneLineJSON(num, null);
    }
    
    /**
     * 设置为最终报价
     * @param params
     * @return
     * @throws SQLException
     */
    private String setFinalQuotation(Map<String, Object> params) throws SQLException{
    	int status = 1;
    	String errorMsg = null;
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	BaseProductInquirySupplierDetail bean = new BaseProductInquirySupplierDetail();
    	bean.setDataFromMap(params);
    	Integer productInquirySupplierDetailId = bean.getProductInquirySupplierDetailId();
    	if(null != productInquirySupplierDetailId) {
    		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
    		dao.setProductInquirySupplierDetailId(productInquirySupplierDetailId);
    		if(dao.load()) {
    			BaseProductInquirySupplierDetail oriBean = dao.generateBase();
    			int detailId = dao.getProductInquiryDetailId();
    			dao.clear();
    			dao.setConditionProductInquiryDetailId("=", detailId);
    			dao.setIsSelect(false);
    			dao.conditionalUpdate();
    			
    			dao.clear();
    			dao.setConditionProductInquirySupplierDetailId("=", productInquirySupplierDetailId);
    			dao.setIsSelect(true);
    			dao.conditionalUpdate();
    			
    			// 修改主数据关联
    			ProductInquiryDetail pidDao = new ProductInquiryDetail();
    			pidDao.setProductInquiryDetailId(detailId);
    			if(pidDao.load()) {
    				pidDao.setSupplierId(oriBean.getSupplierId());
    				pidDao.setTotalPrice(oriBean.getTotalPrice());
    				pidDao.setProductPrice(oriBean.getProductPrice());
    				pidDao.setTaxPoints(oriBean.getTaxPoints());
    				pidDao.update();
    			}
    		}else {
    			status = -1;
    		}
    	}else {
    		status = -1;
    	}
		return bc.toJSON(status, errorMsg);
    }
    
}
