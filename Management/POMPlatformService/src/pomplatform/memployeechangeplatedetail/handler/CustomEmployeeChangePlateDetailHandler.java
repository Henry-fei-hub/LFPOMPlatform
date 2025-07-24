package pomplatform.memployeechangeplatedetail.handler;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pomplatform.db.bean.BaseEmployeeChangePlateDetail;
import com.pomplatform.db.bean.BaseEmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeChangePlateDetail;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;
import com.pomplatform.db.handler.EmployeeChangePlateDetailHandler;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.system.dao.Employee;

public class CustomEmployeeChangePlateDetailHandler extends EmployeeChangePlateDetailHandler {

    @Override
    public String save(String json) throws Exception {
        BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
        bean.setDataFromJSON(json);
        Integer employeeId = bean.getEmployeeId();
        if (!BaseHelpUtils.isNullOrEmpty(employeeId) && !BaseHelpUtils.isNullOrEmpty(bean.getYear()) && !BaseHelpUtils.isNullOrEmpty(bean.getMonth()) && !BaseHelpUtils.isNullOrEmpty(bean.getInPlateId()) && !BaseHelpUtils.isNullOrEmpty(bean.getRemark())) {
            EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
            dao.setDataFromBase(bean);
            Calendar calendar = Calendar.getInstance();
            calendar.set(bean.getYear(), bean.getMonth() - 1, 1);
            Date changePlateDate = calendar.getTime();//本次转岗日期
            dao.setChangePlateDate(changePlateDate);
            ThreadConnection.beginTransaction();
            int num = dao.save();
            dao.setDataToBase(bean);
            saveOrUpdateCommon(employeeId, changePlateDate, bean);
            ThreadConnection.commit();
            return bean.toOneLineJSON(num, null);
        }
        return null;
    }

    @Override
    public String update(String json) throws Exception {
        BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
        bean.setDataFromJSON(json);
        if (!BaseHelpUtils.isNullOrEmpty(bean.getEmployeeId()) && !BaseHelpUtils.isNullOrEmpty(bean.getYear()) && !BaseHelpUtils.isNullOrEmpty(bean.getMonth()) && !BaseHelpUtils.isNullOrEmpty(bean.getInPlateId()) && !BaseHelpUtils.isNullOrEmpty(bean.getRemark())) {
            EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
            dao.setPrimaryKeyFromBase(bean);
            int num = 0;
            if (dao.load()) {
                ThreadConnection.beginTransaction();
                Calendar calendar = Calendar.getInstance();
                calendar.set(bean.getYear(), bean.getMonth() - 1, 1);
                Date changePlateDate = calendar.getTime();//本次转岗日期
                dao.setDataFromBase(bean);
                dao.setChangePlateDate(changePlateDate);
                num = dao.update();
                saveOrUpdateCommon(bean.getEmployeeId(), changePlateDate, bean);
                ThreadConnection.commit();
            }
            return bean.toOneLineJSON(num, null);
        }
        return null;
    }

    private void saveOrUpdateCommon(int employeeId, Date changePlateDate, BaseEmployeeChangePlateDetail bean) throws Exception {
        EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
        dao.unsetSelectFlags();
        dao.setSelectEmployeeChangePlateDetailId(true);
        dao.setSelectChangePlateDate(true);
        dao.setSelectInPlateId(true);
        dao.setConditionEmployeeId("=", employeeId);
        //获取该用户的所有转岗记录
        List<BaseEmployeeChangePlateDetail> list = dao.conditionalLoad("order by " + BaseEmployeeChangePlateDetail.CS_CHANGE_PLATE_DATE + " desc");
        Date date = new Date();
        Date endDate = null;//用来存放在本次转岗记录之后最近的一条转岗记录的日期
        Integer beanId = bean.getEmployeeChangePlateDetailId();
        if (!BaseHelpUtils.isNullOrEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                BaseEmployeeChangePlateDetail base = list.get(i);
                if(i+1<size){//该记录有前续记录
                    System.out.println("有前续记录："+base.toJSONString());
                        BaseEmployeeChangePlateDetail beforeObj = list.get(i+1);
                    System.out.println("他的前续记录是："+beforeObj.toJSONString());
                        dao.clear();
                        dao.setConditionEmployeeChangePlateDetailId("=", base.getEmployeeChangePlateDetailId());
                        dao.setOutPlateId(beforeObj.getInPlateId());
                        dao.conditionalUpdate();
                    }else{//该记录无前续记录
                        System.out.println("没有前续记录："+base.toJSONString());
                        EmployeeChangePlateRecord recordDao = new EmployeeChangePlateRecord();
                        recordDao.setConditionChangePlateDate("<", base.getChangePlateDate());
                        recordDao.setConditionEmployeeId("=", employeeId);
                        recordDao.unsetSelectFlags();
                        recordDao.setSelectPlateId(true);
                        recordDao.executeQueryOneRow();
                        dao.clear();
                        dao.setConditionEmployeeChangePlateDetailId("=", base.getEmployeeChangePlateDetailId());
                        dao.setOutPlateId(BaseHelpUtils.getIntValue(recordDao.getPlateId()));
                        dao.conditionalUpdate();
                    }
                if (base.getEmployeeChangePlateDetailId().equals(beanId)) {
                    if (i == 0) {//该记录无后续记录
                        endDate = new Date();
                    } else {//该记录有后续记录
                        endDate = list.get(i-1).getChangePlateDate();
                    }
                    
                }
            }
            EmployeeChangePlateRecord changePlateRecordDao = new EmployeeChangePlateRecord();
            changePlateRecordDao.setConditionChangePlateDate(">=", changePlateDate);
            changePlateRecordDao.setConditionEmployeeId("=", employeeId);
            List<BaseEmployeeChangePlateRecord> recordList = changePlateRecordDao.conditionalLoad(BaseEmployeeChangePlateRecord.CS_CHANGE_PLATE_DATE + " < '" + endDate + "'");
            //将两个转岗日期之间的所有记录的业务部门设置为本次转岗记录的业务部门
            if (!BaseHelpUtils.isNullOrEmpty(recordList)) {
                for (BaseEmployeeChangePlateRecord obj : recordList) {
                    obj.setPlateId(bean.getInPlateId());
                    obj.setUpdateTime(date);
                    changePlateRecordDao.clear();
                    changePlateRecordDao.setDataFromBase(obj);
                    changePlateRecordDao.update();
                }
            }
            Employee employeeDao = new Employee();
            employeeDao.setConditionEmployeeId("=", employeeId);
            employeeDao.setPlateId(list.get(0).getInPlateId());
            employeeDao.conditionalUpdate();
        }
    }

    @Override
    public String delete(String json) throws Exception {
        BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
        bean.setDataFromJSON(json);
        EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
        dao.setPrimaryKeyFromBase(bean);
        Integer employeeId = bean.getEmployeeId();
        ThreadConnection.beginTransaction();
        if (dao.load()) {
            bean = dao.generateBase();
            EmployeeChangePlateDetail listDao = new EmployeeChangePlateDetail();
            listDao.setConditionEmployeeId("=", employeeId);
            //获取该用户的所有转岗记录
            List<BaseEmployeeChangePlateDetail> list = listDao.conditionalLoad("order by " + BaseEmployeeChangePlateDetail.CS_CHANGE_PLATE_DATE + " desc");
            Integer daoId = dao.getEmployeeChangePlateDetailId();
            int size = list.size();
            Date startDate = null;
            Date endDate = null;
            Integer plateId = null;
            for (int i = 0; i < size; i++) {
                BaseEmployeeChangePlateDetail obj = list.get(i);
                if (obj.getEmployeeChangePlateDetailId().equals(daoId)) {
                    if (i + 1 < size) {
                        BaseEmployeeChangePlateDetail beforeObj = list.get(i+1);//所删除记录的前一条记录
                        startDate = beforeObj.getChangePlateDate();
                        plateId = beforeObj.getInPlateId();
                    } else {
                        plateId = dao.getOutPlateId();
                    }
                    if (i - 1 >= 0) {
                        BaseEmployeeChangePlateDetail afterObj = list.get(i-1);//所删除记录的后一条记录
                        endDate = afterObj.getChangePlateDate();
                        EmployeeChangePlateDetail afterDao = new EmployeeChangePlateDetail();
                        afterDao.setPrimaryKeyFromBase(afterObj);
                        afterDao.setOutPlateId(obj.getOutPlateId());
                        afterDao.update();
                    }
                    break;
                }
            }
            EmployeeChangePlateRecord changePlateRecordDao = new EmployeeChangePlateRecord();
            if (null != startDate) {
                changePlateRecordDao.setConditionChangePlateDate(">=", startDate);
            }
            changePlateRecordDao.setConditionEmployeeId("=", employeeId);
            StringBuilder sql = new StringBuilder();
            if (null != endDate) {
                sql.append(BaseEmployeeChangePlateRecord.CS_CHANGE_PLATE_DATE)
                        .append(" < '").append(endDate).append("'");

            }
            List<BaseEmployeeChangePlateRecord> recordList = changePlateRecordDao.conditionalLoad(sql.toString());
            Date date = new Date();
            //将两个转岗日期之间的所有记录的业务部门设置为本次转岗记录的业务部门
            if (!BaseHelpUtils.isNullOrEmpty(recordList)) {
                for (BaseEmployeeChangePlateRecord obj : recordList) {
                    obj.setPlateId(plateId);
                    obj.setUpdateTime(date);
                    changePlateRecordDao.clear();
                    changePlateRecordDao.setDataFromBase(obj);
                    changePlateRecordDao.update();
                }
            }
            if(null == endDate){
                Employee eDao = new Employee();
                eDao.setConditionEmployeeId("=", employeeId);
                eDao.setPlateId(dao.getOutPlateId());
                eDao.conditionalUpdate();
            }
            int num = dao.delete();//删除选中的数据
            ThreadConnection.commit();
            return bean.toOneLineJSON(num, null);
        }
        return null;
    }
}
