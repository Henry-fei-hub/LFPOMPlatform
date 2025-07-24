package delicacy.department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pomplatform.db.bean.BaseSubjectType;
import com.pomplatform.db.dao.SubjectType;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.department.bean.BaseDepartmentWithSd;
import delicacy.department.dao.DepartmentWithSd;
import delicacy.department.handler.DepartmentWithSdHandler;
import delicacy.otheraccount.DepartmentAccountUtils;
import delicacy.system.bean.BaseDepartmentId;
import delicacy.system.bean.BaseSubjectDepartment;
import delicacy.system.dao.Department;
import delicacy.system.dao.DepartmentId;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;

public class CustomDepartmentWithSdHandler extends DepartmentWithSdHandler {

    @Override
    public String save(String json) throws Exception {
        BaseDepartmentWithSd bean = new BaseDepartmentWithSd();
        bean.setDataFromJSON(json);
        getAllSubjects(bean);
        DepartmentWithSd dao = new DepartmentWithSd();
        ThreadConnection.beginTransaction();
        dao.setDataFromBase(bean);
        int num = dao.save();
        int childId = dao.getDepartmentId();
        int parentId = dao.getParentId();
        //往departmentIds表插入数据
        departmentId(parentId, childId);
        dao.setDataToBase(bean);
        //创建第三方应用的部门数据
        DepartmentAccountUtils.createDepartment(bean);
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String saveOrUpdate(String json) throws Exception {
        BaseDepartmentWithSd bean = new BaseDepartmentWithSd();
        bean.setDataFromJSON(json);
        getAllSubjects(bean);
        int num = 0;
        DepartmentWithSd dao = new DepartmentWithSd();
        ThreadConnection.beginTransaction();
        dao.setDataFromBase(bean);
        if (dao.isPrimaryKeyNull()) {
            num = dao.save();
            bean = dao.generateBaseExt();
            //创建第三方应用的部门数据
            DepartmentAccountUtils.createDepartment(bean);
        } else if (dao.load()) {
            bean.setEcmcDepartmentId(dao.getEcmcDepartmentId());
            bean.setEmailDepartmentId(dao.getEmailDepartmentId());
            bean.setWeixinDepartmentId(dao.getWeixinDepartmentId());
            dao.setDataFromBase(bean);
            num = dao.update();
            //更新第三方应用的的部门归属父级
            DepartmentAccountUtils.updateDepartment(bean, 1);
        }
        //往departmentIds表插入数据
        int parentId = dao.getParentId();
        int childId = dao.getDepartmentId();
        departmentId(parentId, childId);
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String update(String json) throws Exception {
        BaseDepartmentWithSd bean = new BaseDepartmentWithSd();
        bean.setDataFromJSON(json);
        DepartmentWithSd dao = new DepartmentWithSd();
        ThreadConnection.beginTransaction();
        dao.setPrimaryKeyFromBase(bean);
        int num = 0;
        if (dao.load()) {
            bean.setEcmcDepartmentId(dao.getEcmcDepartmentId());
            bean.setEmailDepartmentId(dao.getEmailDepartmentId());
            bean.setWeixinDepartmentId(dao.getWeixinDepartmentId());
            dao.setDataFromBase(bean);
            num = dao.update();
            int parentId = dao.getParentId();
            int childId = dao.getDepartmentId();
            //更新departmentId表数据
            departmentId(parentId, childId);
            //更新第三方应用的的部门归属父级
            DepartmentAccountUtils.updateDepartment(bean, 1);
        }
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String delete(String json) throws Exception {
        BaseDepartmentWithSd bean = new BaseDepartmentWithSd();
        bean.setDataFromJSON(json);
        int departmentId = BaseHelpUtils.getIntValue(bean.getDepartmentId());
        //先检索这个部门下是否有成员，如果有成员则不能进行删除，需将人员进行转移方可
        Employee empDao = new Employee();
        empDao.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);//只检索在职的人员
        empDao.setConditionDepartmentId("=", departmentId);
        if (empDao.countRows() > 0) {//说明该部门下还有人员，则不可进行删除
            throw new SQLException("该部门下还有归属员工,不可进行删除,请转移该部门下的人员");
        }
        Department dao = new Department();
        //检索该部门下是否有子级部门，如果有子级部门，尚不可删除
        dao.setConditionParentId("=", departmentId);
        dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
        if (dao.countRows() > 0) {//说明该部门下还有子级部门
            throw new SQLException("该部门下还有子级部门,不可进行删除,请先删除子级部门");
        }
        //删除第三方应用的部门信息
        DepartmentAccountUtils.deleteDepartment(bean.getDepartmentId());
        dao.clear();
        dao.setDepartmentId(departmentId);
        int num = 0;
        if (dao.load()) {
            dao.setDeleteFlag(StaticUtils.HAS_DELETE);
            num = dao.update();
        }
        return bean.toOneLineJSON(num, null);
    }

    private void departmentId(int parentId, int childId) throws Exception {
        DepartmentId ddao = new DepartmentId();
        //找出当前节点的上一级父级节点的所有父级节点
        ddao.setConditionChildId("=", parentId);
        List<BaseDepartmentId> list = ddao.conditionalLoad();
        List<BaseDepartmentId> saveList = new ArrayList<>();
        //所有找出来的父级节点都与当前节点建立联系，插入departmentIds表中
        if (!BaseHelpUtils.isNullOrEmpty(list)) {
            for (BaseDepartmentId obj : list) {
                BaseDepartmentId base = new BaseDepartmentId();
                base.setDepartmentId(obj.getDepartmentId());
                base.setChildId(childId);
                saveList.add(base);
            }
        }
        //将当前部门作为自己部门的父级部门
        BaseDepartmentId base = new BaseDepartmentId();
        base.setDepartmentId(childId);
        base.setChildId(childId);
        saveList.add(base);
        //先清除所有与当前节点有关的departmentIds表中的数据
        ddao.clear();
        ddao.setConditionChildId("=", childId);
        ddao.conditionalDelete();
        ddao.clear();
        ddao.setConditionDepartmentId("=", childId);
        ddao.conditionalDelete();
        ddao.clear();
        //保存数据到departmentIds表中
        ddao.save(saveList);
    }
    
    public void getAllSubjects(BaseDepartmentWithSd bean) throws SQLException{
    	if(null == bean) {
    		return;
    	}
    	if(null != bean.getDetailSubjectDepartment() && !bean.getDetailSubjectDepartment().isEmpty()) {
    		return;
    	}
    	List<BaseSubjectDepartment> sujectDepartmentList = new ArrayList<>();
        SubjectType subjectDao = new SubjectType();
        subjectDao.unsetSelectFlags();
        subjectDao.setSelectSubjectTypeId(true);
        List<BaseSubjectType> subjectList = subjectDao.conditionalLoad();
        subjectList.stream().forEachOrdered(subject -> {
        	BaseSubjectDepartment subjectDepartmentBean = new BaseSubjectDepartment();
        	subjectDepartmentBean.setSubjectTypeId(subject.getSubjectTypeId());
        	sujectDepartmentList.add(subjectDepartmentBean);
        });
        bean.setDetailSubjectDepartment(sujectDepartmentList);
    }
}
