package pomplatform.capital.handler;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CapitalDistribution;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.handler.CapitalHandler;

import delicacy.common.GenericDao;
import delicacy.date.util.DateUtil;
import delicacy.system.dao.Employee;
import message.common.ERPWeixinUtils;
import pomplatform.capitaldistribution.business.CapitalDistributionMsg;
import pomplatform.common.utils.StaticUtils;
/**
 * 录入回款时，这笔款的指定了合同，
 * 1：会将这笔金额回款到发票上去，成功的会上去了，改一下这笔款是否绑定发票的状态
 * 2：有合同阶段回款到合同阶段上去，成功的会上去了，改一下这笔款是否绑定合同阶段的状态
 * @author wull
 *
 */
public class CustomCapitalHandler extends CapitalHandler implements GenericDao {
	
	private int moneyAttribute_1 = 1;//收款/合同款
	
	private static final Logger __logger = Logger.getLogger(CustomCapitalHandler.class);
	@Override
	public String save(String json) throws Exception{
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setDataFromBase(bean);
		int num = dao.save();
		if(dao.getMoneyAttribute() == moneyAttribute_1){
			sendWeixinMsg(dao);
		}
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}
	
	@Override
	public String saveOrUpdate(String json) throws Exception {
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { 
			dao.setDataFromBase(bean); 
			ret = dao.save(); 
			if(dao.getMoneyAttribute() == moneyAttribute_1){
				sendWeixinMsg(dao);
			}
			bean = dao.generateBase(); 
		}else if(dao.load()) { 
			dao.setDataFromBase(bean); 
			ret = dao.update(); 
			if(dao.getMoneyAttribute() == moneyAttribute_1){
				CapitalDistribution distribution = new CapitalDistribution();
				distribution.setConditionCapitalId("=", dao.getCapitalId());
				distribution.setTotalAmount(dao.getBorrowMoney());
				distribution.conditionalUpdate();
			}
			bean = dao.generateBase(); 
		}
		return bean.toOneLineJSON(ret, null);
	}

	/**
	 * 合同回款登记的时候，发消息给陈浩、陈亚辉、贾小娟
	 * @param dao
	 * @throws SQLException
	 * @throws Exception
	 */
	public void sendWeixinMsg(Capital dao) throws SQLException, Exception {
		StringBuilder sb1 = new StringBuilder();
		sb1.append("【回款登记】");
		if(null != dao.getOperator()){
			DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
			sb1.append("\r\n  操作人：");
			Employee employee = new Employee();
			employee.setEmployeeId(dao.getOperator());
			employee.unsetSelectFlags();
			employee.setSelectEmployeeName(true);
			employee.load();
			sb1.append(employee.getEmployeeName());
			sb1.append("\r\n  操作时间：").append(DateUtil.formatDateString(new Date()));
			sb1.append("\r\n  回款日期：").append(DateUtil.formatDateString(dao.getHappenDate()));
			sb1.append("\r\n  回款金额：").append(df.format(dao.getBorrowMoney()));
			sb1.append("\r\n  回款备注：").append(dao.getRemark());
			ERPWeixinUtils.sendTextMsgToUser(StaticUtils.BINDING_CONTRACT_TO_NOTIFY_EMPLOYEES, sb1.toString());
			if(null != dao.getContractId()){
				Contract c = new Contract();
				c.setContractId(dao.getContractId());
				c.unsetSelectFlags();
				c.setSelectContractName(true);
				c.setSelectContractCode(true);
				c.load();
				StringBuilder sb2 = new StringBuilder();
				sb2.append(employee.getEmployeeName()).append("于").append(DateUtil.formatDateTimeString(new Date())).append("将").append(df.format(dao.getBorrowMoney())).append("的回款")
				.append("绑定到合同：").append(c.getContractName()).append("(").append(c.getContractCode()).append(")上，请相关负责人及时进行回款分配");
				CapitalDistributionMsg msgUtil = new CapitalDistributionMsg();
				msgUtil.sendToAllProjectManager(dao.getContractId(), sb2.toString());
				//应陈浩要求，绑定合同和重新绑定的时候，发消息给陈浩、陈亚辉、贾小娟
				ERPWeixinUtils.sendTextMsgToUser(StaticUtils.BINDING_CONTRACT_TO_NOTIFY_EMPLOYEES, sb2.toString());
			}
		}
	}
	
	@Override
	public String update(String json) throws Exception {
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){
			dao.setDataFromBase(bean); 
			num = dao.update(); 
			if(dao.getMoneyAttribute() == moneyAttribute_1){
				CapitalDistribution distribution = new CapitalDistribution();
				distribution.setConditionCapitalId("=", dao.getCapitalId());
				distribution.setTotalAmount(dao.getBorrowMoney());
				distribution.conditionalUpdate();
			}
		}
		return bean.toOneLineJSON(num, null);
	}
}


