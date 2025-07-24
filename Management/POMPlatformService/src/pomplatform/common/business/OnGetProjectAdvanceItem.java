package pomplatform.common.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAdvanceRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.domain.bean.BaseSemployeepdror;

public class OnGetProjectAdvanceItem implements GenericProcessor {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        int employeeId = BaseHelpUtils.getIntValue(result.get("employeeId"));
        //加载专业负责人自己管理的项目
        Project projectDao = new Project();
        projectDao.setConditionProjectManageId("=",employeeId);
        List<BaseProject> projectList = projectDao.conditionalLoad();
        int len = projectList.size();
        Object[] projectIds = new Object[len];
        if(len > 0){
        	int i = 0;
        	for(BaseProject e : projectList){
        		projectIds[i] = BaseHelpUtils.getIntValue(e.getProjectId());
        		i++;
        	}
        }
        List<BaseSemployeepdror> bs = new ArrayList<>();
        //检索业务部门下的拥有补贴的项目
        ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
        dao.setConditionLeftIntegral(">",BigDecimal.ZERO);
        if(!BaseHelpUtils.isNullOrEmpty(projectIds) && projectIds.length > 0){
        	dao.addCondition(BaseProjectAdvanceRecord.CS_PROJECT_ID,"in", projectIds);
        }else{
        	dao.addCondition(BaseProjectAdvanceRecord.CS_PROJECT_ID,"in", 0);
        }
        List<BaseProjectAdvanceRecord> list = dao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(list) && !list.isEmpty()){
        	BaseSemployeepdror b;
            for (BaseProjectAdvanceRecord e : list) {
                b=new BaseSemployeepdror();
                //获取项目id
                int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
                //获取项目名称
                projectDao.clear();
                projectDao.setProjectId(projectId);
                projectDao.load();
                String projectName = BaseHelpUtils.getString(projectDao.getProjectName());
                b.setIdd(projectId);
                b.setVal(projectName);
                bs.add(b);
            }
        }
        BaseCollection<BaseSemployeepdror> bc = new BaseCollection<>();
        bc.setCollections(bs);
        return bc.toJSON();
    }
}