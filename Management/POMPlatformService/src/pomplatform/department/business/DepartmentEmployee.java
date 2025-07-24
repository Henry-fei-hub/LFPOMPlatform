/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.department.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.dao.Department;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/**
 *
 * @author Administrator
 */
public class DepartmentEmployee implements GenericProcessor {

    private final static String IS_DESIGN_DEPARTMENT = "isDesignDepartment";

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {

        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        // 获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch (optType) {
            case IS_DESIGN_DEPARTMENT:
                return isDesignDepartment(params);
            default:
                return departmentEmployee(params);
        }
    }

    private String departmentEmployee(Map<String, Object> params) throws Exception {
        Department dao = new Department();
        dao.setConditionEnabled("=", Boolean.TRUE);//启用
        List<BaseDepartment> ds = dao.conditionalLoad();

        Employee edao = new Employee();
        edao.setConditionStatus("=", 0);//在职
        int idx = 10000;
        edao.unsetSelectFlags();
        edao.setSelectEmployeeName(true);//姓名
        edao.setSelectEmployeeNo(true);//工号
        edao.setSelectDepartmentId(true);//部门ID
        List<BaseEmployee> bes = edao.conditionalLoad();

        List<BaseDepartment> nds = new ArrayList<>();
        for (BaseDepartment bd : ds) {
            for (BaseEmployee be : bes) {
                if (Objects.equals(bd.getDepartmentId(), be.getDepartmentId())) {
                    BaseDepartment d = new BaseDepartment();
                    d.setDepartmentName(be.getEmployeeNo() + " - " + be.getEmployeeName());
                    d.setParentId(bd.getDepartmentId());
                    d.setDepartmentId(idx++);
                    nds.add(d);
                }

            }
        }

        ds.addAll(nds);
        BaseCollection<BaseDepartment> bc = new BaseCollection<>();
        bc.setCollections(ds);
        return bc.toJSON();
    }

    private String isDesignDepartment(Map<String, Object> params) {
        BaseCollection<BaseDepartment> bd = new BaseCollection<>();
        int departmentId = BaseHelpUtils.getIntValue(params.get("departmentId"));
        try {
            // 部门信息
            Department dao = new Department();
            for (;departmentId > 1;){
                dao.clear();
                dao.setDepartmentId( departmentId);
                if(dao.load()){
                    departmentId = dao.getParentId();
                    if(departmentId == 7){ //设计部门
                        return bd.toJSON();
                    }
                }else{
                    return bd.toJSON(-1,null);
                }
            }
            return bd.toJSON(-1,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bd.toJSON(-1,null);
    }

}
