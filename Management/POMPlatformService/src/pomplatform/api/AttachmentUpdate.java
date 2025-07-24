package pomplatform.api;

import java.util.Date;
import java.util.List;

import com.file.db.bean.BaseFileManage;
import com.file.db.dao.FileManage;
import com.file.utils.CommonUtils;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BasePayMoneyManage;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BasePreProjectRecord;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PreProjectRecord;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.TravelReimbursement;

import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

public class AttachmentUpdate {

    public static void main(String[] args) {
//		确认函申请();
        职员信息();
//		合同();
//		日常报销();
//		前期跟踪();
//		差旅报销();
//		预付款申请();
//		请假申请();
//		薪资发放申请();
        System.out.println("完成");
    }

    public static void 薪资发放申请() {
        try {
            PersonnelBusines dao = new PersonnelBusines();
            dao.setConditionProcessType("=", 37);
            dao.setConditionDeleteFlag("=", 0);
            List<BasePersonnelBusines> list = dao.conditionalLoad();
            for (BasePersonnelBusines obj : list) {
                Integer id1 = save附件并返回ID(obj.getAttachment(), null);
                Integer id2 = save附件并返回ID(obj.getReason(), null);
                Integer id3 = save附件并返回ID(obj.getAddress(), null);
                Integer id4 = save附件并返回ID(obj.getPlan(), null);
                Integer id5 = save附件并返回ID(obj.getTransportation(), null);
                if (null != id1 || null != id2 || null != id3 || null != id4 || null != id5) {
                    dao.clear();
                    dao.setConditionPersonnelBusinessId("=", obj.getPersonnelBusinessId());
                    if (null != id1) {
                        dao.setAttachmentId(id1);
                    }
                    if (null != id2) {
                        dao.setProjectType(id2);
                    }
                    if (null != id3) {
                        dao.setDutyId(id3);
                    }
                    if (null != id4) {
                        dao.setStartDateDetail(id4);
                    }
                    if (null != id5) {
                        dao.setEndDateDetail(id5);
                    }
                    dao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 请假申请() {
        try {
            PersonnelBusines dao = new PersonnelBusines();
            Object[] arr = {13, 22, 23};
            dao.addCondition(BasePersonnelBusines.CS_PROCESS_TYPE, "in", arr);
            dao.setConditionDeleteFlag("=", 0);
            List<BasePersonnelBusines> list = dao.conditionalLoad("attachment is not null");
            for (BasePersonnelBusines obj : list) {
                Integer id = save附件并返回ID(obj.getAttachment(), null);
                if (null != id) {
                    dao.clear();
                    dao.setConditionPersonnelBusinessId("=", obj.getPersonnelBusinessId());
                    dao.setAttachmentId(id);
                    dao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 预付款申请() {
        try {
            PayMoneyManage dao = new PayMoneyManage();
            List<BasePayMoneyManage> list = dao.conditionalLoad("attachment_file is not null");
            for (BasePayMoneyManage bean : list) {
                Integer id = save附件并返回ID(bean.getAttachmentFile(), null);
                if (null != id) {
                    dao.clear();
                    dao.setConditionPayMoneyManageId("=", bean.getPayMoneyManageId());
                    dao.setAttachmentId(id);
                    dao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 差旅报销() {
        try {
            TravelReimbursement dao = new TravelReimbursement();
            List<BaseTravelReimbursement> list = dao.conditionalLoad("attachment is not null");
            for (BaseTravelReimbursement bean : list) {
                Integer id = save附件并返回ID(bean.getAttachment(), null);
                if (null != id) {
                    dao.clear();
                    dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
                    dao.setAttachmentId(id);
                    dao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 前期跟踪() {
        try {
            PreProjectRecord pDao = new PreProjectRecord();
            List<BasePreProjectRecord> list = pDao.conditionalLoad("attachment_name is not null");
            for (BasePreProjectRecord obj : list) {
                Integer id = save附件并返回ID(obj.getAttachmentName(), obj.getFileName());
                if (null != id) {
                    pDao.clear();
                    pDao.setConditionPreProjectRecordId("=", obj.getPreProjectRecordId());
                    pDao.setAttachmentId(id);
                    pDao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 日常报销() {
        try {
            ProjectNormalReimbursement pDao = new ProjectNormalReimbursement();
            List<BaseProjectNormalReimbursement> list = pDao.conditionalLoad("attachment is not null");
            for (BaseProjectNormalReimbursement obj : list) {
                Integer id = save附件并返回ID(obj.getAttachment(), null);
                if (null != id) {
                    pDao.clear();
                    pDao.setConditionProjectNormalReimbursementId("=", obj.getProjectNormalReimbursementId());
                    pDao.setAttachmentId(id);
                    pDao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 合同() {
        try {
            Contract cDao = new Contract();
            List<BaseContract> list = cDao.conditionalLoad("service_suggest_book is not null");
            for (BaseContract obj : list) {
                Integer fileId = save附件并返回ID(obj.getServiceSuggestBook(), null);
                if (null != fileId) {
                    cDao.clear();
                    cDao.setConditionContractId("=", obj.getContractId());
                    cDao.setServiceSuggestBookId(fileId);
                    cDao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 职员信息() {
        try {
            Employee eDao = new Employee();
            //eDao.setConditionEmployeeNo("=", "JA888005");
            List<BaseEmployee> list = eDao.conditionalLoad();
            for (BaseEmployee obj : list) {
                System.out.println(obj.toJSON());
                Integer fileId1 = save附件并返回ID(obj.getPhoto(), null);
                Integer fileId2 = save附件并返回ID(obj.getLaborAttachments(), null);
                Integer fileId3 = save附件并返回ID(obj.getCardAttachment(), null);
                Integer fileId4 = save附件并返回ID(obj.getTechnicalAttachment(), null);
                Integer fileId5 = save附件并返回ID(obj.getEducationProof(), null);
                Integer fileId6 = save附件并返回ID(obj.getDegreeProof(), null);
                if (null != fileId1 || null != fileId2 || null != fileId3 || null != fileId4 || null != fileId5 || null != fileId6) {
                    eDao.clear();
                    eDao.setConditionEmployeeId("=", obj.getEmployeeId());
                    if (null != fileId1) {
                        eDao.setPhotoId(fileId1);
                    }
                    if (null != fileId2) {
                        eDao.setLaborAttachmentId(fileId2);
                    }
                    if (null != fileId3) {
                        eDao.setCardAttachmentId(fileId3);
                    }
                    if (null != fileId4) {
                        eDao.setTechnicalAttachmentId(fileId4);
                    }
                    if (null != fileId5) {
                        eDao.setEducationProofId(fileId5);
                    }
                    if (null != fileId6) {
                        eDao.setDegreeProofId(fileId6);
                    }
                    eDao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 确认函申请() {
        try {
            PersonnelBusines pdao = new PersonnelBusines();
            pdao.setConditionProcessType("=", 27);
            pdao.setConditionDeleteFlag("=", 0);
            List<BasePersonnelBusines> list = pdao.conditionalLoad();
            for (BasePersonnelBusines obj : list) {
                Integer fileId = save附件并返回ID(obj.getAttachment(), obj.getReason());
                if (null != fileId) {
                    pdao.clear();
                    pdao.setConditionPersonnelBusinessId("=", obj.getPersonnelBusinessId());
                    pdao.setNumberOfBaby(fileId);
                    pdao.conditionalUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer save附件并返回ID(String fileUrl, String fileName) throws Exception {
        if (null == fileUrl) {
            return null;
        }
        FileManage dao = new FileManage();
        dao.setConditionFileUrl("=", fileUrl);
        BaseFileManage bean = dao.executeQueryOneRow();
        if (null != bean) {
            dao.setDataFromBase(bean);
            dao.clearModifiedFlags();
            dao.setCitationTimes(BaseHelpUtils.getIntValue(dao.getCitationTimes()) + 1);
            dao.update();
            return dao.getFileId();
        } else {
            dao.clear();
            dao.setFileUrl(fileUrl);
            int idx = fileUrl.lastIndexOf(".");
            if (idx == -1) {
                return null;
            }
            String fileExt = fileUrl.substring(idx + 1).toLowerCase();
            dao.setFileExtension(fileExt);
            dao.setFileType(CommonUtils.getFileType(fileExt));
            dao.setFileName(fileName);
            dao.setCitationTimes(1);
            dao.setCreateTime(new Date());
            dao.save();
            return dao.getFileId();
        }
    }
}
