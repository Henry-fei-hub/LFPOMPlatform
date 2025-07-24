package pomplatform.project.business;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.SubContract;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.servlet.HttpCookie;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author guanxgun
 */
public class ProjectUpdate123 implements GenericProcessor {

    public static void main(String[] args) {
        try {
            ProjectUpdate123 pu = new ProjectUpdate123();
            pu.execute("{\"projectType\":3,\"oldProjectDiscount\":0,\"commonArea\":\"3000\",\"logisticsArea\":0,\"percentage\":\"0\",\"contractCode\":\"J&A/SJ2016006\",\"projectCode\":\"J&A/SJ2016006-O\",\"projectName\":\"《西安高新NEWorld项目室内设计项目》\",\"projectManageId\":14,\"totalAmount\":20000,\"officeType\":6,\"projectId\":123,\"contractName\":\"《西安高新NEWorld项目室内设计合同》\",\"customerName\":\"西安海科重工 投资有限公司\",\"departmentId\":21,\"status\":0,\"projectIntegral\":\"75000\",\"departmentManagerId\":12,\"plateId\":3,\"totalIntegral\":\"75000\",\"reserveIntegral\":\"0\"}", null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        BaseProject bp = new BaseProject();
        bp.setDataFromJSON(creteria);
        HttpCookie hc = new HttpCookie(request);
        bp.setPlateId(hc.getPlateId());
        Project dao = new Project();
        dao.setPrimaryKeyFromBase(bp);
        if (dao.load()) {
//            String contractCode = dao.getContractCode();//旧的合同编号
//            String projectCode = dao.getProjectCode();//旧的项目编号
            dao.setContractCode(bp.getContractCode());
            dao.setProjectCode(bp.getProjectCode());
            dao.setProjectName(bp.getProjectName());
            dao.update();
//            if (!BaseHelpUtils.isNullOrEmpty(dao.getContractCode()) && !BaseHelpUtils.isNullOrEmpty(contractCode) && !(dao.getContractCode().equals(contractCode))) {
//                String contractName = "";
//                String newContractCode = dao.getContractCode();
//                String newProjectCode = dao.getProjectCode();
//                String[] arr = newContractCode.split("-");
//                int parentId = 0;
//                dao.update();
//                SubContract subDao = new SubContract();
//                Contract contractDao = new Contract();
//                subDao.setConditionSubContractCode("=", contractCode);
//                if (!BaseHelpUtils.isNullOrEmpty(subDao.executeQueryOneRow())) {//子合同存在，则直接修改子合同
//                    subDao.setSubContractCode(newContractCode);
//                    String tempName = completeSubDao(subDao, arr);
//                    String oldName = subDao.getSubContractName();
//                    subDao.setSubContractName(tempName + oldName.substring(oldName.indexOf(")") + 1));
//                    subDao.setUpdateTime(new Date());
//                    subDao.update();
//                    contractDao.setConditionContractCode("=", contractCode.split("-")[0]);
//                    if (!BaseHelpUtils.isNullOrEmpty(contractDao.executeQueryOneRow())) {
//                        contractDao.setContractCode(arr[0]);
//                        contractDao.update();
//                    } else {
//                        System.out.println("********************************************************************************");
//                        System.out.println("***********************什么鬼？存在子合同，但却没有主合同*************************");
//                        System.out.println("********************************************************************************");
//                    }
//                } else {//子合同不存在，则需要修改主合同的合同编号、项目的合同编号和项目编号、创建子合同
//                    contractDao.setConditionContractCode("=", contractCode);
//                    if (!BaseHelpUtils.isNullOrEmpty(contractDao.executeQueryOneRow())) {//旧的主合同存在，且合同编号是旧编号，则改为新的主合同编号
//                        contractDao.setContractCode(arr[0]);
//                        contractDao.update();
//                        contractName = contractDao.getContractName();
//                        parentId = contractDao.getContractId();
//                    } else {
//                        contractDao.clear();
//                        contractDao.setConditionContractCode("=", arr[0]);
//                        if (BaseHelpUtils.isNullOrEmpty(contractDao.executeQueryOneRow())) {//主合同不存在，则用新的主合同编号创建一个主合同
//                            contractDao.setContractCode(arr[0]);
//                            contractDao.save();
//                            parentId = contractDao.getContractId();
//                        } else {
//                            contractName = contractDao.getContractName();
//                            parentId = contractDao.getContractId();
//                        }
//                    }
//                    subDao.clear();
//                    subDao.setSubContractCode(newContractCode);
//                    subDao.setProjectCode(newProjectCode);
//                    subDao.setCreateTime(new Date());
//                    subDao.setUpdateTime(new Date());
//                    subDao.setProjectCode(newProjectCode);
//                    subDao.setParentId(parentId);
//                    String tempName = completeSubDao(subDao, arr);
//                    subDao.setSubContractName(tempName + contractName);
//                    subDao.save();
//                }
//            } else if (!BaseHelpUtils.isNullOrEmpty(dao.getProjectCode()) && !BaseHelpUtils.isNullOrEmpty(projectCode) && !(dao.getProjectCode().equals(projectCode))) {
//                dao.update();
//                String newProjectCode = dao.getProjectCode();
//                SubContract subDao = new SubContract();
//                subDao.setConditionSubContractCode("=", contractCode);
//                subDao.setProjectCode(newProjectCode);
//                subDao.conditionalUpdate();
//            } else {
//                dao.update();
//            }
            ThreadConnection.commit();
        }

        return bp.toOneLineJSON(0, null);
    }

    public String completeSubDao(SubContract subDao, String[] arr) {
        if (arr.length >= 4) {
            StringBuilder tempName = new StringBuilder("(");
            switch (arr[1]) {//业务类别
                case "01":
                    tempName.append("商业");
                    subDao.setBusinessType(1);
                    break;
                case "02":
                    tempName.append("酒店");
                    subDao.setBusinessType(2);
                    break;
                case "03":
                    tempName.append("办公");
                    subDao.setBusinessType(3);
                    break;
                case "04":
                    tempName.append("轨道交通");
                    subDao.setBusinessType(4);
                    break;
                case "05":
                    tempName.append("医养");
                    subDao.setBusinessType(5);
                    break;
                case "06":
                    tempName.append("公共建筑");
                    subDao.setBusinessType(6);
                    break;
                case "07":
                    tempName.append("综合体");
                    subDao.setBusinessType(7);
                    break;
                case "91":
                    tempName.append("采买");
                    subDao.setBusinessType(91);
                    break;
                case "99":
                    tempName.append("其他");
                    subDao.setBusinessType(99);
                    break;
                default:
                    break;
            }
            switch (arr[2]) {//项目类别
                case "01":
                    tempName.append("方案");
                    subDao.setProjectType(1);
                    break;
                case "02":
                    tempName.append("深化");
                    subDao.setProjectType(2);
                    break;
                case "03":
                    tempName.append("方案+深化");
                    subDao.setProjectType(3);
                    break;
                case "04":
                    tempName.append("机电灯光普通配合");
                    subDao.setProjectType(4);
                    break;
                case "05":
                    tempName.append("机电二次设计");
                    subDao.setProjectType(5);
                    break;
                case "06":
                    tempName.append("灯光设计");
                    subDao.setProjectType(6);
                    break;
                case "07":
                    tempName.append("导向标识");
                    subDao.setProjectType(7);
                    break;
                case "08":
                    tempName.append("陈设设计");
                    subDao.setProjectType(8);
                    break;
                case "09":
                    tempName.append("采买");
                    subDao.setProjectType(9);
                    break;
                case "10":
                    tempName.append("外包");
                    subDao.setProjectType(10);
                    break;
                case "11":
                    tempName.append("智能化");
                    subDao.setProjectType(10);
                    break;
                case "12":
                    tempName.append("机电顾问");
                    subDao.setProjectType(10);
                    break;
                default:
                    break;
            }
            tempName.append(")");
            switch (arr[3]) {//承接部门
                case "801":
                    subDao.setDepartmentId(2);
                    break;
                case "802":
                    subDao.setDepartmentId(63);
                    break;
                case "803":
                    subDao.setDepartmentId(64);
                    break;
                case "804":
                    subDao.setDepartmentId(43);
                    break;
                case "805":
                    subDao.setDepartmentId(12);
                    break;
                case "806":
                    subDao.setDepartmentId(50);
                    break;
                case "807":
                    subDao.setDepartmentId(60);
                    break;
                case "808":
                    subDao.setDepartmentId(57);
                    break;
                case "809":
                    subDao.setDepartmentId(48);
                    break;
                case "810":
                    subDao.setDepartmentId(61);
                    break;
                case "811":
                    subDao.setDepartmentId(62);
                    break;
                case "812":
                    subDao.setDepartmentId(59);
                    break;
                default:
                    break;
            }
            return tempName.toString();
        }
        return null;
    }
}
