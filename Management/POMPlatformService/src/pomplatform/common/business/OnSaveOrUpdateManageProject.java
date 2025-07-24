package pomplatform.common.business;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseManageProject;
import com.pomplatform.db.bean.BasePlateReportRecord;
import com.pomplatform.db.dao.ManageProject;
import com.pomplatform.db.dao.PlateReportRecord;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;

public class OnSaveOrUpdateManageProject implements GenericProcessor {
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		BaseManageProject bean = new BaseManageProject();
		bean.setDataFromJSON(creteria);
		ManageProject dao = new ManageProject();
		dao.setDataFromBase(bean);
		BigDecimal changeIntegral = new BigDecimal(0);
		if(dao.isPrimaryKeyNull()){
			dao.save();
		}else{
			//取出原先的管理项目的总积分
			ManageProject tempDao = new ManageProject();
			tempDao.setConditionManageProjectId("=",dao.getManageProjectId());
			tempDao.unsetSelectFlags();
			tempDao.setSelectTotalIntegral(true);
			tempDao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(tempDao.getTotalIntegral())){
				//减去原有的管理项目总积分
				changeIntegral = changeIntegral.subtract(tempDao.getTotalIntegral());
			}
			dao.update();
		}
		dao.setConditionManageProjectId("=", dao.getManageProjectId());
		Date date = dao.executeQueryOneRow().getProjectDate();
		date = DateUtil.getFirstDay(date);
		//得到本次保存或更新的变动的项目积分总额
		changeIntegral = changeIntegral.add(dao.getTotalIntegral());
		PlateReportRecord plateReportDao = new PlateReportRecord();
		plateReportDao.setConditionPlateId("=", dao.getPlateId());
		plateReportDao.setConditionRecordDate("=", date);
		plateReportDao.unsetSelectFlags();
		plateReportDao.setSelectPlateReportRecordId(true);
		plateReportDao.setSelectManagerProjectIntegral(true);
		plateReportDao.setSelectAchieveIntegral(true);
		BasePlateReportRecord plateReportBean = plateReportDao.executeQueryOneRow();
		plateReportDao.clear();
		//如果部门积分汇总有数据，则更新该记录的奖金补贴总额
		if(!BaseHelpUtils.isNullOrEmpty(plateReportBean)){
			if(!BaseHelpUtils.isNullOrEmpty(plateReportBean.getManagerProjectIntegral())){
				//加上原有的部门积分汇总里面的奖金补贴的金额，得到目前该月份该部门的奖金补贴总额
				plateReportDao.setManagerProjectIntegral(plateReportBean.getManagerProjectIntegral().add(changeIntegral));
			}else{
				plateReportDao.setManagerProjectIntegral(changeIntegral);
			}
			if(!BaseHelpUtils.isNullOrEmpty(plateReportBean.getAchieveIntegral())){
				//如果有记录中的价值积分不为空，则价值积分要减去此次变动的奖金补贴金额
				plateReportDao.setAchieveIntegral(plateReportBean.getAchieveIntegral().subtract(changeIntegral));
			}else{
				//如果有记录中的价值积分为空，则价值积分应该为此次变动的奖金补贴金额的相反数
				plateReportDao.setAchieveIntegral((new BigDecimal(0)).subtract(changeIntegral));//
			}
			plateReportDao.setConditionPlateReportRecordId("=", plateReportBean.getPlateReportRecordId());
			plateReportDao.conditionalUpdate();
		}else{//如果部门积分汇总没数据，则新增一条记录
			plateReportDao.setPlateId(dao.getPlateId());
			plateReportDao.setRecordDate(date);
			plateReportDao.setManagerProjectIntegral(changeIntegral);
			plateReportDao.setAchieveIntegral((new BigDecimal(0)).subtract(changeIntegral));
			plateReportDao.save();
		}
		ThreadConnection.commit();
		return dao.generateBase().toOneLineJSON(0, null);
	}
	
}
