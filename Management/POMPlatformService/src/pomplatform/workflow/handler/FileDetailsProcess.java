package pomplatform.workflow.handler;

import com.pomplatform.db.bean.BaseEmployee;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.Employee;
import com.pomplatform.db.dao.EmployeeEducationInformation;
import com.pomplatform.db.dao.SystemDictionary;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileDetailsProcess implements GenericProcessor {
    @Override
    public String execute(String s, HttpServletRequest httpServletRequest) throws Exception {
        JSON parser = new JSON(new StringReader(s));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        // 获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch (optType) {
            case "FileDetails":
                return find(params);
            case "getSealNames":
                return getSealNames(params);
        }
        return null;
    }

    private String getSealNames(Map<String, Object> params) throws Exception{
        BaseCollection<BaseSystemDictionary> bc = new BaseCollection<>();
        int companyId =  BaseHelpUtils.getIntValue(params, "companyId");
        SystemDictionary dictionary = new SystemDictionary();
        dictionary.setConditionParentId("=",companyId);
        dictionary.setConditionDicTypeId("=",107);
        List<BaseSystemDictionary> list = dictionary.conditionalLoad();
        bc.setCollections(list);
        return bc.toJSON();
    }

    private String find(Map<String, Object> params) throws Exception {
        String employeeId =  BaseHelpUtils.getStringValue(params, "employeeId");
        if(null!=employeeId) {
            String[] employeeIds = employeeId.replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "").split(",");
            int length = employeeIds.length;

            int[] ids = new int[length];

            for (int i = 0; i < length; i++) {
                ids[i] = BaseHelpUtils.getIntValue(employeeIds[i]);
            }
            BaseCollection<BaseEmployee> bc = new BaseCollection<>();
            List<BaseEmployee> list = new ArrayList<>();
            Employee employee = new Employee();
            for (int i = 0 ; i < length; i++){
                employee.clear();
                employee.setEmployeeId(ids[i]);
                if(employee.load()){
                    BaseEmployee dao=employee.generateBase();
                    list.add(dao);
                }
            }

            bc.setCollections(list);
            return bc.toJSON();
        }
        return "";
    }


}
