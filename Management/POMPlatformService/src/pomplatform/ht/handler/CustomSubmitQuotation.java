package pomplatform.ht.handler;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.bean.BaseDesignConsiderationHistory;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.DesignConsiderationHistory;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CustomSubmitQuotation implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		/**
		 * 1.先将原来的提交的报价单history_status字段设置为0
		 * 2.再将报价单的数据保存到提交报价单中去
		 */
		ThreadConnection.beginTransaction();
		int res=0,submitVersion=0;
		DesignConsideration designConsideration=new DesignConsideration();
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String infoCode = BaseHelpUtils.getString(param.get("infoCode"));
		designConsideration.setConditionInfoCode("=", infoCode);
		List<BaseDesignConsideration> l=designConsideration.conditionalLoad();
		
		List<BaseDesignConsiderationHistory> moveList=new ArrayList<>();
		
		DesignConsiderationHistory dch=new DesignConsiderationHistory();
		dch.setConditionInfoCode("=", infoCode);
		List<BaseDesignConsiderationHistory> baseList=dch.conditionalLoad();
		
		if(baseList.size()>0){
			for (BaseDesignConsiderationHistory baseDesHistory : baseList) {
				DesignConsiderationHistory d=new DesignConsiderationHistory();
				d.setDesignConsiderationHistoryId(baseDesHistory.getDesignConsiderationHistoryId());
				if(d.load()){
					d.setHistoryStatus(0);
					d.update();	
				    int tempSubmitVersion=BaseHelpUtils.getIntValue(baseDesHistory.getHistoryVersion());
					if(submitVersion<tempSubmitVersion){
						submitVersion=tempSubmitVersion;//记录下当前的提交版本号
					}
				}
			}
			
		}
		if(l.size()>0){
			//清除上面的缓存moveList
			moveList.removeAll(moveList);
			int tempv=submitVersion+1;
			for (BaseDesignConsideration baseDes : l) {
				BaseDesignConsiderationHistory base=new BaseDesignConsiderationHistory();
				base.setInfoCode(baseDes.getInfoCode());//信息编号 
				base.setHistoryVersion(tempv);//最新提交的版本号
				base.setProjectCode(baseDes.getProjectCode());//项目编号
				base.setBusinessType(baseDes.getBusinessType());//业务类型
				base.setProjectType(baseDes.getProjectType());//项目类型
				base.setMainDesignAreaName(baseDes.getMainDesignAreaName());//区域 设计范围
				base.setDecorationStatus(baseDes.getDecorationStatus());//精简装状态   0精装    1简装
				base.setDesignArea(baseDes.getDesignArea());//设计面积
				base.setDesignUnitPrice(baseDes.getDesignUnitPrice());//设计单价
				base.setMoneySum(baseDes.getMoneySum());//小计 设计面积总金额
				base.setJobMix(baseDes.getJobMix());//现场配合
				base.setServiceArea(baseDes.getServiceArea());//服务面积
				base.setOnSiteTime(baseDes.getOnSiteTime());//驻场时间(月)
				base.setWithTheAmount(baseDes.getWithTheAmount());//配合金额
				base.setOnSitePrice(baseDes.getOnSitePrice());//驻场价格 (元/月)
				base.setOnSiteTotalMoney(baseDes.getOnSiteTotalMoney());//驻场总金额 (元)
				base.setCreateTime(baseDes.getCreateTime());//创建时间
				moveList.add(base);
			}
			res=1;
			dch.save(moveList);
		}
		ThreadConnection.commit();
		BaseCollection bc = new BaseCollection();
		return bc.toJSON(res, null);
	}

}
