package pomplatform.PreProjectReimbursementNumber.handler;

import java.util.*;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkMainProject;
import com.pomplatform.db.dao.NormalReimbursementLinkMainProject;
import com.pomplatform.db.dao.TravelReimbursementLinkMainProject;

import delicacy.common.BaseHelpUtils;

public class CodingIsused {

	public static boolean getPreProjectCode(Integer mainProject) throws Exception{
		boolean flag=Boolean.FALSE;
		if(!BaseHelpUtils.isNullOrEmpty(mainProject)){
			NormalReimbursementLinkMainProject normalReimbursementLinkMainProject=new NormalReimbursementLinkMainProject();
			normalReimbursementLinkMainProject.setConditionMainProjectId("=", mainProject);
			List<BaseNormalReimbursementLinkMainProject> normalList=normalReimbursementLinkMainProject.conditionalLoad();
			if(normalList.size()>0){
				flag=Boolean.TRUE;
				return flag;
			}
			TravelReimbursementLinkMainProject travelReimbursementLinkMainProject=new TravelReimbursementLinkMainProject();
			travelReimbursementLinkMainProject.setConditionMainProjectId("=", mainProject);
			List<BaseTravelReimbursementLinkMainProject> travelList=travelReimbursementLinkMainProject.conditionalLoad();
			if(travelList.size()>0){
				flag=Boolean.TRUE;
				return flag;
			}
		}else{
			throw new Exception("没有传入前期项目编号");
		}
		return flag;
	}
}
