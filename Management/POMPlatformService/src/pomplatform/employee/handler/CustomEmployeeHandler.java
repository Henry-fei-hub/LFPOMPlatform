package pomplatform.employee.handler;

import delicacy.common.ColumnChangedData;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.system.handler.EmployeeHandler;
import pomplatform.filemanage.business.FileManageProcessor;

public class CustomEmployeeHandler extends EmployeeHandler {

	@Override
	public String update(String json) throws Exception {
		BaseEmployee bean = new BaseEmployee();
		bean.setDataFromJSON(json);
		Employee dao = new Employee();
		dao.setPrimaryKeyFromBase(bean);
		int num = 0;
		if (dao.load()) {
			dao.setDataFromBase(bean);
			//修改头像的引用次数
			ColumnChangedData photoData = dao.getColumnChangedData(BaseEmployee.CS_PHOTO_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(photoData);
			//修改劳动合同附件的引用次数
			ColumnChangedData laborAttachmentIdData = dao.getColumnChangedData(BaseEmployee.CS_LABOR_ATTACHMENT_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(laborAttachmentIdData);
			//修改身份证附件的引用次数
			ColumnChangedData cardAttachmentIdData = dao.getColumnChangedData(BaseEmployee.CS_CARD_ATTACHMENT_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(cardAttachmentIdData);
			//修改职称证明的引用次数
			ColumnChangedData technicalAttachmentIdData = dao.getColumnChangedData(BaseEmployee.CS_TECHNICAL_ATTACHMENT_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(technicalAttachmentIdData);
			//修改学历证的引用次数
			ColumnChangedData educationProofIdData = dao.getColumnChangedData(BaseEmployee.CS_EDUCATION_PROOF_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(educationProofIdData);
			//修改学位证的引用次数
			ColumnChangedData degreeProofIdData = dao.getColumnChangedData(BaseEmployee.CS_DEGREE_PROOF_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(degreeProofIdData);
			num = dao.update();
		}
		return bean.toOneLineJSON(num, null);
	}
}
