/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.common.expand;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.dao.EmployeeRole;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author wull
 */
public class DefaultSetEmpRole implements GenericProcessor {

    private static final Logger __logger = Logger.getLogger("DefaultSetEmpRole");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }

        System.out.println("params start========");
        System.out.println("employeeId= " + result.get("employeeId"));
        System.out.println("deptId= " + result.get("deptId"));
        System.out.println("roleId= " + result.get("roleId"));
        System.out.println("params end========");

        int employeeId = BaseHelpUtils.getIntValue(result.get("employeeId"));
        int deptId = BaseHelpUtils.getIntValue(result.get("deptId"));
        int roleId = BaseHelpUtils.getIntValue(result.get("roleId"));

        if (employeeId > 0 && deptId > 0 && roleId > 0) {
            EmployeeRole erole = new EmployeeRole();
            erole.setConditionEmployeeId("=", employeeId);
            erole.setConditionRoleId("=", roleId);
            erole.setConditionDepartmentId("=", deptId);

            BaseEmployeeRole baseEmployeeRole = erole.executeQueryOneRow();
            //不存在就新增
            if (BaseHelpUtils.isNullOrEmpty(baseEmployeeRole)) {
                BaseEmployeeRole b = new BaseEmployeeRole();
                b.setEmployeeId(employeeId);
                b.setDepartmentId(deptId);
                b.setRoleId(roleId);
                b.setIsDefault(Boolean.FALSE);
                erole.setDataFromBase(b);
                erole.save();
                return erole.generateBase().toOneLineJSON(0, null);
            } else {
                EmployeeRole eb = new EmployeeRole();
                eb.setConditionEmployeeId("=", employeeId);
                eb.setConditionDepartmentId("=", deptId);
                eb.setConditionRoleId("=", roleId);
                eb.conditionalDelete();
                return eb.generateBase().toOneLineJSON(0, null);
            }

        }
        return "";
    }
}
