/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.employee.business;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import pomplatform.domain.bean.BaseSemployeepdror;

/**
 *
 * @author wull
 */
public class CustomDeptIdEmployeeProcessor implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        int deptdepartmentId = BaseHelpUtils.getIntValue(result.get("departmentId"));
        List<BaseEmployee> baseEmployeeList = new ArrayList<>();
        List<BaseSemployeepdror> bs = new ArrayList<>();
        Employee e = new Employee();
        e.unsetSelectFlags();
        e.setSelectEmployeeId(true);
        e.setSelectEmployeeName(true);
        e.setConditionDepartmentId("=", deptdepartmentId);
        baseEmployeeList = e.conditionalLoad(" order by employee_no desc ");
        if(baseEmployeeList.size()>0){
            for (BaseEmployee baseEmployee : baseEmployeeList) {
                BaseSemployeepdror b=new BaseSemployeepdror();
                b.setIdd(baseEmployee.getEmployeeId());
                b.setVal(baseEmployee.getEmployeeName());
                bs.add(b);
            }
        }
        BaseCollection<BaseSemployeepdror> bc = new BaseCollection<>();
        bc.setCollections(bs);
        
        return bc.toJSON();
    }
}
