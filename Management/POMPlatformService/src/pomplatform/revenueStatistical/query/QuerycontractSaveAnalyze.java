package pomplatform.revenueStatistical.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.revenueStatistical.bean.BasecontractSaveAnalyze;
import pomplatform.revenueStatistical.bean.ConditioncontractSaveAnalyze;

public class QuerycontractSaveAnalyze extends AbstractQuery<BasecontractSaveAnalyze, ConditioncontractSaveAnalyze>
{

	private static final Logger __logger = Logger.getLogger(QuerycontractSaveAnalyze.class);

	public QuerycontractSaveAnalyze() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("B.*");
	}

	@Override
	public BaseCollection<BasecontractSaveAnalyze> executeQuery( KeyValuePair[] replacements, ConditioncontractSaveAnalyze condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getYear()
			);
	}

	@Override
	public BasecontractSaveAnalyze generateBase(Object[] __data) throws java.sql.SQLException {
		BasecontractSaveAnalyze __base = new BasecontractSaveAnalyze();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setJanuaryContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruaryContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarchContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAprilContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMayContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuneContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJulyContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugustContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptemberContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctoberContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovemberContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecemberContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotal(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "select B.*, (B.january_contract_save + february_contract_save+ march_contract_save+ april_contract_save+may_contract_save+june_contract_save+july_contract_save+ august_contract_save+september_contract_save+october_contract_save+november_contract_save+december_contract_save)AS total from (select A.plate_id, 0 as year, sum( CASE WHEN A.month=1 THEN A.sheet_save ELSE 0 END )AS january_contract_save, sum( CASE WHEN A.month=2 THEN A.sheet_save ELSE 0 END )AS february_contract_save, sum( CASE WHEN A.month=3 THEN A.sheet_save ELSE 0 END )AS march_contract_save, sum( CASE WHEN A.month=4 THEN A.sheet_save ELSE 0 END )AS april_contract_save, sum( CASE WHEN A.month=5 THEN A.sheet_save ELSE 0 END )AS may_contract_save, sum( CASE WHEN A.month=6 THEN A.sheet_save ELSE 0 END )AS june_contract_save, sum( CASE WHEN A.month=7 THEN A.sheet_save ELSE 0 END )AS july_contract_save, sum( CASE WHEN A.month=8 THEN A.sheet_save ELSE 0 END )AS august_contract_save, sum( CASE WHEN A.month=9 THEN A.sheet_save ELSE 0 END )AS september_contract_save, sum( CASE WHEN A.month=10 THEN A.sheet_save ELSE 0 END )AS october_contract_save, sum( CASE WHEN A.month=11 THEN A.sheet_save ELSE 0 END )AS november_contract_save, sum( CASE WHEN A.month=12 THEN A.sheet_save ELSE 0 END )AS december_contract_save from ( select rsr.year, rsr.month, ps.revenue_plate_id AS plate_id, CASE WHEN rsr.is_locked =true THEN (rsr.sheet_amount-(rsr.sheet_amount*rsr.total_percent))/1.06 ELSE (ps.sheet_amount-(ps.sheet_amount*rsr.total_percent))/1.06 END AS sheet_save from projects ps left join revenue_statistical_records rsr on rsr.project_id = ps.project_id LEFT JOIN plate_rate_records prr ON ps.revenue_plate_id = prr.plate_id where ps.project_flag = 1 AND ps.project_id =? AND ps.revenue_plate_id =? AND rsr.YEAR =? order by rsr.year,rsr.month,ps.revenue_plate_id desc ) as A group by A.plate_id ) B" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,january_contract_save,february_contract_save,march_contract_save,april_contract_save,may_contract_save,june_contract_save,july_contract_save,august_contract_save,september_contract_save,october_contract_save,november_contract_save,december_contract_save,total";
	private final static String[] fieldNames = { "project_id", "plate_id", "year"};
}
