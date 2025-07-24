package pomplatform.cwd.business;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCwdFilingMainTemplate;
import com.pomplatform.db.bean.BaseCwdFilingTemplate;
import com.pomplatform.db.dao.CwdFilingMainTemplate;
import com.pomplatform.db.dao.CwdFilingTemplate;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FilingTemplateProcessor  implements GenericProcessor {
    // 操作类型
    private static final String OPT_TYPE = "optType";
    
    // 添加文件归档模板
    private static final String ADD_FILING_TEMPLATE = "addFilingTemplate";
    
    // 添加文件归档模板主数据
    private static final String ADD_MAIN_FILING_TEMPLATE = "addMainFilingTemplate";
    
    // 删除文件归档模板主数据
    private static final String DELETE_MAIN_FILING_TEMPLATE = "deleteMainFilingTemplate";
   
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
        
        switch (optType) {
		case ADD_FILING_TEMPLATE:
			return addFilingTemplate(creteria);
		case ADD_MAIN_FILING_TEMPLATE:
			return addMainFilingTemplate(creteria);
		case DELETE_MAIN_FILING_TEMPLATE:
			return deleteMainFilingTemplate(creteria);
		default:
			break;
		}
        return null;
    }
    
    private String addMainFilingTemplate(String creteria) throws Exception {
    	BaseCwdFilingMainTemplate bean = new BaseCwdFilingMainTemplate();
		bean.setDataFromJSON(creteria);
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		// 插入子表数据
		List<BaseCwdFilingTemplate> list = new ArrayList<>();
		Date currentDate = new Date();
		for (int i = 1; i <= 5; i++) {
			// 排除提资区和出版区
			if(i != 2 && i != 4) {
				BaseCwdFilingTemplate tmpBean = new BaseCwdFilingTemplate();
				tmpBean.setCwdFilingMainTemplateId(dao.getCwdFilingMainTemplateId());
				tmpBean.setFilingType(i);
				tmpBean.setOperatorId(dao.getOperatorId());
				tmpBean.setCreateTime(currentDate);
				list.add(tmpBean);
			}
		}
		if(list.size() > 0) {
			CwdFilingTemplate ctDao = new CwdFilingTemplate();
			ctDao.save(list);
		}
		return bean.toOneLineJSON(num, null);
    }
    
    private String deleteMainFilingTemplate(String creteria) throws Exception{
    	BaseCwdFilingMainTemplate bean = new BaseCwdFilingMainTemplate();
		bean.setDataFromJSON(creteria);
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		// 删除子表数据
		CwdFilingTemplate cftDao = new CwdFilingTemplate();
		cftDao.setConditionCwdFilingMainTemplateId("=", bean.getCwdFilingMainTemplateId());
		cftDao.conditionalDelete();
		
		return bean.toOneLineJSON(num, null);
    }
    
    public static int setDeleteConditions(BaseCwdFilingMainTemplate bean, CwdFilingMainTemplate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFilingMainTemplateId() != null) {
			dao.setConditionCwdFilingMainTemplateId("=", bean.getCwdFilingMainTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTemplateName() != null) {
				dao.setConditionTemplateName("=", bean.getTemplateName());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}
    
    /**
     * 添加文件归档模板
     * @param json
     * @return
     * @throws Exception
     */
    private String addFilingTemplate(String json) throws Exception {
    	BaseCwdFilingTemplate bean = new BaseCwdFilingTemplate();
		bean.setDataFromJSON(json);
		// 检测数据是否完整
		if(!BaseHelpUtils.isNullOrEmpty(bean.getTemplateName()) && !BaseHelpUtils.isNullOrEmpty(bean.getFilingType())) {
			CwdFilingTemplate dao = new CwdFilingTemplate();
			dao.setPrimaryKeyFromBase(bean);
			int ret = 0;
			if(dao.isPrimaryKeyNull()) { 
				// 检测如果有存在同类型的模板 则不进行添加
				dao.setConditionFilingType("=", bean.getFilingType());
				if(dao.countRows() > 0) {
					return bean.toOneLineJSON(-1, "已存在该归档类型的模板,请勿重复添加");
				}else {
					dao.setDataFromBase(bean); 
					ret = dao.save(); 
					bean = dao.generateBase(); 
				}
			} else if(dao.load()) { 
				if(Objects.equals(dao.getFilingType(), bean.getFilingType())) {
					dao.setDataFromBase(bean); 
					ret = dao.update(); 
					bean = dao.generateBase(); 
				} else {
					dao.clear();
					dao.setConditionFilingType("=", bean.getFilingType());
					if(dao.countRows() > 0) {
						return bean.toOneLineJSON(-1, "已存在该归档类型的模板,请修改归档类型");
					}else {
						dao.setPrimaryKeyFromBase(bean);
						dao.load();
						dao.setDataFromBase(bean);
						dao.update();
					}
				}
			}
			return bean.toOneLineJSON(ret, null);
		}else {
			return bean.toOneLineJSON(-1, "请填写完整数据");
		}
		
    }
    
}
