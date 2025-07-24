package pomplatform.projectAttachmentManage.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.projectAttachmentManage.bean.BaseProjectAttachmentManage;
import pomplatform.projectAttachmentManage.bean.ConditionProjectAttachmentManage;

public class QueryProjectAttachmentManage extends AbstractQuery<BaseProjectAttachmentManage, ConditionProjectAttachmentManage>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectAttachmentManage.class);

	public QueryProjectAttachmentManage() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("substr(b.contract_code");
	}

	@Override
	public BaseCollection<BaseProjectAttachmentManage> executeQuery( KeyValuePair[] replacements, ConditionProjectAttachmentManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getProjectName(), 
				condition.getIsQualified(),
				condition.getPlateId()
			);
	}

	@Override
	public BaseProjectAttachmentManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectAttachmentManage __base = new BaseProjectAttachmentManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAttachmentFile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsHandle(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSameContract(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSameStage(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsHasSign(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsHasSeal(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSure(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsQualified(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsEmailSure(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsOtherSure(GenericBase.__getBoolean(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "select b.plate_id,substr(b.contract_code,1,strpos(b.contract_code,'-')-4) as contract_code ,b.contract_code as sheet_code,b.project_name,a.* from project_attachments a left join projects b on a.project_id = b.project_id where contract_code like ? and b.project_name like ? and is_qualified = ? and b.plate_id = ? ORDER BY contract_code,a.project_id,a.upload_time desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,contract_code,sheet_code,project_name,project_attachment_id,project_id,stage_id,upload_time,attachment_file,remark,is_handle,is_same_contract,is_same_stage,is_has_sign,is_has_seal,is_sure,is_qualified,operate_employee_id,operate_time,is_email_sure,is_other_sure";
	private final static String[] fieldNames = { "contract_code", "project_name", "is_qualified","plate_id"};
}
