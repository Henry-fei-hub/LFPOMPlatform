package delicacy.oa;

/**
 *
 * @author guanxgun
 */
public class OAEmployeeSync {

//    public static void main(String[] args) {
//        syncUpdateEmployeeFromOA();
//    }
//
//    public static Map<Integer, Integer> plateMap = null;
//    public static Map<Integer, Integer> departMap = null;
//    public static Map<Integer, Integer> dutyMap = null;
//
//    public static BaseEmployee syncEmployeeFromOA(int employeeId) {
//        try {
//            BEmployee oaDao = new BEmployee();
//            oaDao.setConnection("oabase");
////            oaDao.setConditionEmploystateid("=", 1);
//            //只检索在职和离职的人员
//            oaDao.addCondition(BaseBEmployee.CS_EMPLOYSTATEID,"in",1,2);
//            oaDao.setConditionId("=", Long.valueOf(employeeId));
//            BaseBEmployee oaBeans = oaDao.executeQueryOneRow();
//            if (oaBeans == null) {
//                return null;
//            }
//            if (plateMap == null) {
//                plateMap = new HashMap<>();
//                departMap = generateDepartmentMap(plateMap);
//                dutyMap = generateDutyMap();
//            }
//            BaseEmployee be = new BaseEmployee();
//            setEmployeeFromOA(be, oaBeans, departMap, dutyMap, plateMap);
//            Employee dao = new Employee();
//            dao.setDataFromBase(be);
//            dao.save();
//            return dao.generateBase();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void SyncupDepartmentFromOA(){
//        try{
//            BDepartment bddao = new BDepartment();
//            bddao.setConditionCanceled("=", 0);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//    public static void syncUpdateEmployeeFromOA() {
//        try {
//            //获取所有的OA职员数据
//            BEmployee oaDao = new BEmployee();
//            oaDao.setConnection("oabase");
//            //只检索在职和离职的人员
//            oaDao.addCondition(BaseBEmployee.CS_EMPLOYSTATEID,"in",1,2);
////            oaDao.setConditionEmploystateid("=", 1);
//            List<BaseBEmployee> oaBeans = oaDao.conditionalLoad();
//
//            //获取所有职员数据
//            Employee dao = new Employee();
//            List<BaseEmployee> beans = dao.conditionalLoad();
//            EmployeeRole employeeRoleDao = new EmployeeRole();
//
//            // 需要增加的员工列表
//            List<BaseBEmployee> needToAdd = new ArrayList<>();
//            // 需要删除的员工列表
//            List<BaseEmployee> needToDelete = new ArrayList<>();
//
//            if (plateMap == null) {
//                plateMap = new HashMap<>();
//                departMap = generateDepartmentMap(plateMap);
//                dutyMap = generateDutyMap();
//            }
//
//            for (BaseBEmployee bbe : oaBeans) {
//                boolean found = false;
//                for (BaseEmployee be : beans) {
//                	int oaiderp = BaseHelpUtils.getIntValue(be.getOaId());
//                	int oaid = BaseHelpUtils.getIntValue(bbe.getId());
//                    if (oaiderp == oaid && oaiderp != 0 && oaid != 0) {
//                        dao.clear();
//                        dao.setDataFromBase(be);
//                        dao.clearModifiedFlags();
//                        setEmployeeFromOA(be, bbe, departMap, dutyMap, plateMap);
//                        dao.setDataFromBase(be);
//                        dao.update();
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    needToAdd.add(bbe);
//                }
//            }
//            for (BaseEmployee be : beans) {
//                boolean found = false;
//                for (BaseBEmployee bbe : oaBeans) {
//                	int oaiderp = BaseHelpUtils.getIntValue(be.getOaId());
//                	int oaid = BaseHelpUtils.getIntValue(bbe.getId());
//                    if ((oaiderp == oaid && oaiderp != 0 && oaid != 0) || be.getEmployeeNo().equals("admin")) {
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    needToDelete.add(be);
//                }
//            }
//            // 处理已经离职的员工
//            for (BaseEmployee be : needToDelete) {
//                dao.clear();
//                dao.setPrimaryKeyFromBase(be);
//                dao.setStatus(1);
//                dao.update();
//            }
//            // 处理刚入职的员工
//            EmployeeChangePlateRecord employeeChangePlateRecordDao = new EmployeeChangePlateRecord();
//            Date date = new Date();
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(date);
//            calendar.set(Calendar.DATE, 1);
//            date = calendar.getTime();
//            int year = calendar.get(Calendar.YEAR);
//            int month = calendar.get(Calendar.MONTH)+1;
//            for (BaseBEmployee bbe : needToAdd) {
//                dao.clear();
//                BaseEmployee be = new BaseEmployee();
//                setEmployeeFromOA(be, bbe, departMap, dutyMap, plateMap);
//                if(null == be.getDepartmentId()){
//                	be.setDepartmentId(1);//没有部门信息，则默认深圳杰恩设计公司
//                }
//                dao.setDataFromBase(be);
//                dao.save();
//                //给新增的职员设置一个默认的角色，即普通职员
//                employeeRoleDao.clear();
//                employeeRoleDao.setEmployeeId(dao.getEmployeeId());
//                employeeRoleDao.setRoleId(15);
//                employeeRoleDao.setDepartmentId(1);
//                employeeRoleDao.setIsDefault(true);
//                employeeRoleDao.save();
//                //往员工每月归属哪个部门的表中插入一条记录
//                employeeChangePlateRecordDao.clear();
//                employeeChangePlateRecordDao.setEmployeeId(dao.getEmployeeId());
//                employeeChangePlateRecordDao.setPlateId(dao.getPlateId());
//                employeeChangePlateRecordDao.setDepartmentId(dao.getDepartmentId());
//                employeeChangePlateRecordDao.setYear(year);
//                employeeChangePlateRecordDao.setMonth(month);
//                employeeChangePlateRecordDao.setChangePlateDate(date);
//                employeeChangePlateRecordDao.setCreateTime(date);
//                employeeChangePlateRecordDao.setUpdateTime(date);
//                employeeChangePlateRecordDao.save();
//            }
//            DepartmentTree.generateDepartmentTree();
//            DepartmentTree.updateDepartmentId(DepartmentTree.departmentRoot, new DepartmentId());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static void setEmployeeFromOA(BaseEmployee be, BaseBEmployee bbe, Map<Integer, Integer> dpm, Map<Integer, Integer> dum, Map<Integer, Integer> pm) {
//        // 姓名
//        be.setEmployeeName(bbe.getEmpname());
//        // 部门
////        be.setDepartmentId(dpm.get(bbe.getDepartmentid().intValue()));
//        // 生日
//        be.setBirth(bbe.getBirthday());
//        // 性别
//        be.setGender(bbe.getGender() == 1 ? 1 : 2);
//        //离职状态(OA:2:表示离职1;1:表示在职;ERP:1:表示离职;0:表示在职)
//        be.setStatus(bbe.getEmploystateid() == 2 ? 1 : 0);
//        // 入职时间
//        be.setOnboardDate(bbe.getDutydate());
//        // 手机
//        be.setMobile(bbe.getTelmobile());
//        // 电话
//        be.setPhone(bbe.getTeloffice());
//        // 邮箱
//        be.setEmail(bbe.getEmail());
//        // 地址
//        be.setAddress(bbe.getHomeaddress());
//        // 员工号
//        be.setEmployeeNo(bbe.getEmpnum());
//        // 如果员工密码为空，则为其初始化
//        if (BaseHelpUtils.isNullOrEmpty(be.getEmployeePassword())) {
//            be.setEmployeePassword(DES.string2MD5(bbe.getEmpnum()));
//        }
//        // 职务
//        be.setDutyId(dum.get(BaseHelpUtils.getIntValue(bbe.getDutyid())));
//        // OA的员工ID
//        be.setOaId(bbe.getId().intValue());
//        // OA的部门编码
//        be.setOaDepart(bbe.getDepartmentid().intValue());
//        // 离职时间
//        be.setResignationDate(bbe.getDimissiondate());
//        // 学位
//        be.setDegree(bbe.getDegree());
//        // 学历
//        be.setEducation(bbe.getEducation());
//        // 身份证
//        be.setCard(bbe.getIdentitynum());
//        // 婚姻状况
//        be.setMarriedStatus(bbe.getMarriedstateid());
//        // 设置板块
//        if (be.getPlateId() == null || be.getPlateId() == 0) {
//            be.setPlateId(pm.get(be.getDepartmentId()));
//        }
//    }
//
//    public static Map<Integer, Integer> generateEmployeeMap() throws SQLException {
//        Employee ddao = new Employee();
//        ddao.unsetSelectFlags();
//        ddao.setSelectEmployeeId(true);
//        ddao.setSelectOaId(true);
//        List<BaseEmployee> bds = ddao.conditionalLoad();
//        Map<Integer, Integer> departmentIDMap = new HashMap<>();
//        bds.stream().forEach((bd) -> {
//            departmentIDMap.put(bd.getOaId(), bd.getEmployeeId());
//        });
//        return departmentIDMap;
//    }
//
//    public static Map<Integer, Integer> generateDepartmentMap(Map<Integer, Integer> plateMap) throws SQLException {
//        Department ddao = new Department();
//        ddao.unsetSelectFlags();
//        ddao.setSelectDepartmentId(true);
//        ddao.setSelectOriginalId(true);
//        ddao.setSelectPlateId(true);
//        List<BaseDepartment> bds = ddao.conditionalLoad();
//        Map<Integer, Integer> departmentIDMap = new HashMap<>();
//        bds.stream().forEach((bd) -> {
//            departmentIDMap.put(bd.getOriginalId(), bd.getDepartmentId());
//            plateMap.put(bd.getDepartmentId(), bd.getPlateId());
//        });
//        return departmentIDMap;
//    }
//
//    public static Map<Integer, Integer> generateDutyMap() throws SQLException {
//        Duty ddao = new Duty();
//        ddao.unsetSelectFlags();
//        ddao.setSelectDutyId(true);
//        ddao.setSelectOriginalId(true);
//        List<BaseDuty> bds = ddao.conditionalLoad();
//        Map<Integer, Integer> departmentIDMap = new HashMap<>();
//        bds.stream().forEach((bd) -> {
//            departmentIDMap.put(bd.getOriginalId(), bd.getDutyId());
//        });
//        return departmentIDMap;
//    }

}
