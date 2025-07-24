package pomplatform.ht.handler;

import java.io.StringReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.bean.BaseFormalContract;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.bean.StaticMethod;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.FormalContract;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.OutDesignConsideration;
import com.pomplatform.db.dao.OutQuotation;
import com.pomplatform.db.dao.SubContract;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CustomFormalContractHandler implements GenericProcessor {

	private static final Logger __logger = Logger.getLogger(CustomFormalContractHandler.class);

	/**
	 * 根据主合同创建正式合同
	 */
	private static final String CREATE_FORMAL_CONTRACT = "createFormalContract";

	 

	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case CREATE_FORMAL_CONTRACT:
				return createFormalContract(result);
			}
		}
		return null;
	}
	/**
	 * 根据主合同创建正式合同
	 * 
	 * @param result
	 * @return
	 * @throws Exception 
	 */
	private String createFormalContract(Map<String, Object> result) throws Exception {
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		String projectCode = BaseHelpUtils.getStringValue(result, "projectCode");
		ThreadConnection.beginTransaction();
		Contract c=new Contract();
		c.setConditionProjectCode("=", projectCode);
		BaseContract base=c.executeQueryOneRow(" order by contract_id desc ");
		int res=0;
		String msg="";
		if(BaseHelpUtils.isNullOrEmpty(base)){
			res--;
			msg="主合同未创建";
		}else{
			System.out.println("BaseHelpUtils.getIntValue(base.getSigningCompanyName())="+BaseHelpUtils.getIntValue(base.getSigningCompanyName()));
			
			Map<String, Object> map = StaticMethod.getNumberStr(infoCode, projectCode, BaseHelpUtils.getIntValue(base.getSigningCompanyName()));
			FormalContract dao = new FormalContract();
			BaseFormalContract bean=new BaseFormalContract();
			bean.setContractCode(BaseHelpUtils.getStringValue(map, "contractCode"));// 主订单编号
			bean.setSerialNumber(BaseHelpUtils.getStringValue(map, "serialNumberStr"));
			bean.setOrderNo(BaseHelpUtils.getIntValue(map, "orderNOStr"));
			bean.setCity(infoCode);
			bean.setProjectCode(projectCode);
			bean.setContractName(base.getContractName());//主订单名称
			bean.setCustomerName(base.getCustomerName());//客户名称
			bean.setContractType(base.getContractType());//合同类别
			bean.setProjectLevel(base.getProjectLevel());//项目等级
			bean.setTotalProjectTime(base.getTotalProjectTime());//项目总工期
			bean.setSigningMoneySum(base.getSigningMoneySum());//签约总金额
			bean.setDesignAreas(base.getDesignAreas());//总设计面积
			bean.setContractPrice(base.getContractPrice());//合同价格
			bean.setProjectAddress(base.getProjectAddress());//项目地点
			//bean.setContractFollower(base.getContractFollower());//合同跟进人
			bean.setRemark(base.getRemark());
			bean.setContractDate(base.getContractDate());//合同签署日期
			bean.setSigningCompanyName(base.getSigningCompanyName());//我方签约公司名称
			bean.setBusinessType(base.getBusinessType());//业务类别
			bean.setProjectType(base.getProjectType());//项目类别
			bean.setFlowStatus(base.getFlowStatus());//流转状态，默认为0表示可以提交到运营管理修改承接部门...
			bean.setCoveredArea(base.getCoveredArea());//建筑面积
			bean.setProfessionalCooperation(base.getProfessionalCooperation());//配合专业
			bean.setProvince(base.getProvince());//省份
			bean.setCustomerAddress(base.getCustomerAddress());//客户地址
			bean.setServiceSuggestBook(bean.getServiceSuggestBook());//服务建议书
			bean.setProjectApprovalTime(bean.getProjectApprovalTime());//立单时间 提交了立单时间会将保存下来，只是点击保存不会将当前时间保存下来，单每次都会显示当前的时间，提交了下次显示的就是提交时的立单时间
			bean.setInfoCode(infoCode);
			dao.setDataFromBase(bean);
		 
			
			
			int num = dao.save();
			
			//标记项目信息已经创建过正式合同
			MainProject mp=new MainProject();
			mp.setConditionInfoCode("=", infoCode);
			mp.setConditionProjectCode("=", projectCode);
			BaseMainProject bMp=mp.executeQueryOneRow();
			bMp.setHasFormalContracts(true);
			mp.setDataFromBase(bMp);
			mp.setPrimaryKeyFromBase(bMp);
			int uMp= mp.update();
 
			if(num>0){
				res++;
			}else{
				res--;
				msg="创建正式合同失败";
			}
		}
		
		ThreadConnection.commit();
 		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		return bc.toJSON(res, msg);
	}
}
