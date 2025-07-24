package pomplatform.PreProjectReimbursementNumber.handler;

import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BasePreProjectReimbursementNumber;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.PreProjectReimbursementNumber;

import delicacy.common.BaseHelpUtils;

public class NewPreProjectCode {

	public static String getPreProjectCode(Map<String, Object> map) throws Exception{
		StringBuilder code=new StringBuilder();
		if(!BaseHelpUtils.isNullOrEmpty(map)){
			int mainProjectId=BaseHelpUtils.getIntValue(map,"mainProjectId");
			if(BaseHelpUtils.getIntValue(map,"mainProjectId")>0){
				PreProject mp=new PreProject();
				mp.unsetSelectFlags();
				mp.setSelectInfoCode(true);
				mp.setPreProjectId(mainProjectId);
				if(mp.load()){
					code.append(mp.getInfoCode());
					code.append("-");
				}
			}else{
				throw new Exception("请选择项目");
			}
			String businessTypeTmp="";
			if(BaseHelpUtils.getIntValue(map, "preBusinessType")>0){
				businessTypeTmp= String.format("%02d", BaseHelpUtils.getIntValue(map, "preBusinessType"));
			}else if(BaseHelpUtils.getIntValue(map, "preBusinessType")>0){
				businessTypeTmp = String.format("%02d", BaseHelpUtils.getIntValue(map, "preBusinessType"));
			}else{
				throw new Exception("请选择业务类型");
			}
			code.append(businessTypeTmp);
			code.append("-");
			
			if(BaseHelpUtils.getIntValue(map, "preProjectType")>0){
				String projectTypeTmp = String.format("%02d", BaseHelpUtils.getIntValue(map, "preProjectType"));
				code.append(projectTypeTmp);
				code.append("-");
			}else{
				throw new Exception("请选择项目类型");
			}
			if(BaseHelpUtils.getIntValue(map, "plateId")>0){
				PlateRecord dao = new PlateRecord();
				dao.unsetSelectFlags();
				dao.setSelectPlateCode(true);
				dao.setConditionPlateId("=", BaseHelpUtils.getIntValue(map, "plateId"));
				code.append(dao.executeQueryOneRow().getPlateCode());
			}else{
				throw new Exception("请选择业务部门");
			}
			
		}else{
			throw new Exception("填写信息");
		}
		
		//判断前期项目编号是不是已经存在
		PreProjectReimbursementNumber pp=new PreProjectReimbursementNumber();
		pp.unsetSelectFlags();
		pp.setSelectCustomNumber(true);
		pp.setConditionCustomNumber("=", code.toString());
		List<BasePreProjectReimbursementNumber> l= pp.conditionalLoad();
		if(l.size()>1){
			throw new Exception("已经创建了这个编号的前期项目");
		}
		return code.toString();
	}
}
