package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseDepartmentIncomeDetailReport;
import pomplatform.report.bean.ConditionDepartmentIncomeDetailReport;

public class QueryDepartmentIncomeDetailReport extends AbstractQuery<BaseDepartmentIncomeDetailReport, ConditionDepartmentIncomeDetailReport>
{

	private static final Logger __logger = Logger.getLogger(QueryDepartmentIncomeDetailReport.class);

	public QueryDepartmentIncomeDetailReport() throws java.sql.SQLException 
	{
		setParameterNumber(216);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("one.details");
	}

	@Override
	public BaseCollection<BaseDepartmentIncomeDetailReport> executeQuery( KeyValuePair[] replacements, ConditionDepartmentIncomeDetailReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseDepartmentIncomeDetailReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDepartmentIncomeDetailReport __base = new BaseDepartmentIncomeDetailReport();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDetails(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setJanuary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarch(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApril(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJune(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuly(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugust(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctober(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecember(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
		if(args[23] != null) __statement.setInt(count++, GenericBase.__getInt(args[23]));
		if(args[24] != null) __statement.setInt(count++, GenericBase.__getInt(args[24]));
		if(args[25] != null) __statement.setInt(count++, GenericBase.__getInt(args[25]));
		if(args[26] != null) __statement.setInt(count++, GenericBase.__getInt(args[26]));
		if(args[27] != null) __statement.setInt(count++, GenericBase.__getInt(args[27]));
		if(args[28] != null) __statement.setInt(count++, GenericBase.__getInt(args[28]));
		if(args[29] != null) __statement.setInt(count++, GenericBase.__getInt(args[29]));
		if(args[30] != null) __statement.setInt(count++, GenericBase.__getInt(args[30]));
		if(args[31] != null) __statement.setInt(count++, GenericBase.__getInt(args[31]));
		if(args[32] != null) __statement.setInt(count++, GenericBase.__getInt(args[32]));
		if(args[33] != null) __statement.setInt(count++, GenericBase.__getInt(args[33]));
		if(args[34] != null) __statement.setInt(count++, GenericBase.__getInt(args[34]));
		if(args[35] != null) __statement.setInt(count++, GenericBase.__getInt(args[35]));
		if(args[36] != null) __statement.setInt(count++, GenericBase.__getInt(args[36]));
		if(args[37] != null) __statement.setInt(count++, GenericBase.__getInt(args[37]));
		if(args[38] != null) __statement.setInt(count++, GenericBase.__getInt(args[38]));
		if(args[39] != null) __statement.setInt(count++, GenericBase.__getInt(args[39]));
		if(args[40] != null) __statement.setInt(count++, GenericBase.__getInt(args[40]));
		if(args[41] != null) __statement.setInt(count++, GenericBase.__getInt(args[41]));
		if(args[42] != null) __statement.setInt(count++, GenericBase.__getInt(args[42]));
		if(args[43] != null) __statement.setInt(count++, GenericBase.__getInt(args[43]));
		if(args[44] != null) __statement.setInt(count++, GenericBase.__getInt(args[44]));
		if(args[45] != null) __statement.setInt(count++, GenericBase.__getInt(args[45]));
		if(args[46] != null) __statement.setInt(count++, GenericBase.__getInt(args[46]));
		if(args[47] != null) __statement.setInt(count++, GenericBase.__getInt(args[47]));
		if(args[48] != null) __statement.setInt(count++, GenericBase.__getInt(args[48]));
		if(args[49] != null) __statement.setInt(count++, GenericBase.__getInt(args[49]));
		if(args[50] != null) __statement.setInt(count++, GenericBase.__getInt(args[50]));
		if(args[51] != null) __statement.setInt(count++, GenericBase.__getInt(args[51]));
		if(args[52] != null) __statement.setInt(count++, GenericBase.__getInt(args[52]));
		if(args[53] != null) __statement.setInt(count++, GenericBase.__getInt(args[53]));
		if(args[54] != null) __statement.setInt(count++, GenericBase.__getInt(args[54]));
		if(args[55] != null) __statement.setInt(count++, GenericBase.__getInt(args[55]));
		if(args[56] != null) __statement.setInt(count++, GenericBase.__getInt(args[56]));
		if(args[57] != null) __statement.setInt(count++, GenericBase.__getInt(args[57]));
		if(args[58] != null) __statement.setInt(count++, GenericBase.__getInt(args[58]));
		if(args[59] != null) __statement.setInt(count++, GenericBase.__getInt(args[59]));
		if(args[60] != null) __statement.setInt(count++, GenericBase.__getInt(args[60]));
		if(args[61] != null) __statement.setInt(count++, GenericBase.__getInt(args[61]));
		if(args[62] != null) __statement.setInt(count++, GenericBase.__getInt(args[62]));
		if(args[63] != null) __statement.setInt(count++, GenericBase.__getInt(args[63]));
		if(args[64] != null) __statement.setInt(count++, GenericBase.__getInt(args[64]));
		if(args[65] != null) __statement.setInt(count++, GenericBase.__getInt(args[65]));
		if(args[66] != null) __statement.setInt(count++, GenericBase.__getInt(args[66]));
		if(args[67] != null) __statement.setInt(count++, GenericBase.__getInt(args[67]));
		if(args[68] != null) __statement.setInt(count++, GenericBase.__getInt(args[68]));
		if(args[69] != null) __statement.setInt(count++, GenericBase.__getInt(args[69]));
		if(args[70] != null) __statement.setInt(count++, GenericBase.__getInt(args[70]));
		if(args[71] != null) __statement.setInt(count++, GenericBase.__getInt(args[71]));
		if(args[72] != null) __statement.setInt(count++, GenericBase.__getInt(args[72]));
		if(args[73] != null) __statement.setInt(count++, GenericBase.__getInt(args[73]));
		if(args[74] != null) __statement.setInt(count++, GenericBase.__getInt(args[74]));
		if(args[75] != null) __statement.setInt(count++, GenericBase.__getInt(args[75]));
		if(args[76] != null) __statement.setInt(count++, GenericBase.__getInt(args[76]));
		if(args[77] != null) __statement.setInt(count++, GenericBase.__getInt(args[77]));
		if(args[78] != null) __statement.setInt(count++, GenericBase.__getInt(args[78]));
		if(args[79] != null) __statement.setInt(count++, GenericBase.__getInt(args[79]));
		if(args[80] != null) __statement.setInt(count++, GenericBase.__getInt(args[80]));
		if(args[81] != null) __statement.setInt(count++, GenericBase.__getInt(args[81]));
		if(args[82] != null) __statement.setInt(count++, GenericBase.__getInt(args[82]));
		if(args[83] != null) __statement.setInt(count++, GenericBase.__getInt(args[83]));
		if(args[84] != null) __statement.setInt(count++, GenericBase.__getInt(args[84]));
		if(args[85] != null) __statement.setInt(count++, GenericBase.__getInt(args[85]));
		if(args[86] != null) __statement.setInt(count++, GenericBase.__getInt(args[86]));
		if(args[87] != null) __statement.setInt(count++, GenericBase.__getInt(args[87]));
		if(args[88] != null) __statement.setInt(count++, GenericBase.__getInt(args[88]));
		if(args[89] != null) __statement.setInt(count++, GenericBase.__getInt(args[89]));
		if(args[90] != null) __statement.setInt(count++, GenericBase.__getInt(args[90]));
		if(args[91] != null) __statement.setInt(count++, GenericBase.__getInt(args[91]));
		if(args[92] != null) __statement.setInt(count++, GenericBase.__getInt(args[92]));
		if(args[93] != null) __statement.setInt(count++, GenericBase.__getInt(args[93]));
		if(args[94] != null) __statement.setInt(count++, GenericBase.__getInt(args[94]));
		if(args[95] != null) __statement.setInt(count++, GenericBase.__getInt(args[95]));
		if(args[96] != null) __statement.setInt(count++, GenericBase.__getInt(args[96]));
		if(args[97] != null) __statement.setInt(count++, GenericBase.__getInt(args[97]));
		if(args[98] != null) __statement.setInt(count++, GenericBase.__getInt(args[98]));
		if(args[99] != null) __statement.setInt(count++, GenericBase.__getInt(args[99]));
		if(args[100] != null) __statement.setInt(count++, GenericBase.__getInt(args[100]));
		if(args[101] != null) __statement.setInt(count++, GenericBase.__getInt(args[101]));
		if(args[102] != null) __statement.setInt(count++, GenericBase.__getInt(args[102]));
		if(args[103] != null) __statement.setInt(count++, GenericBase.__getInt(args[103]));
		if(args[104] != null) __statement.setInt(count++, GenericBase.__getInt(args[104]));
		if(args[105] != null) __statement.setInt(count++, GenericBase.__getInt(args[105]));
		if(args[106] != null) __statement.setInt(count++, GenericBase.__getInt(args[106]));
		if(args[107] != null) __statement.setInt(count++, GenericBase.__getInt(args[107]));
		if(args[108] != null) __statement.setInt(count++, GenericBase.__getInt(args[108]));
		if(args[109] != null) __statement.setInt(count++, GenericBase.__getInt(args[109]));
		if(args[110] != null) __statement.setInt(count++, GenericBase.__getInt(args[110]));
		if(args[111] != null) __statement.setInt(count++, GenericBase.__getInt(args[111]));
		if(args[112] != null) __statement.setInt(count++, GenericBase.__getInt(args[112]));
		if(args[113] != null) __statement.setInt(count++, GenericBase.__getInt(args[113]));
		if(args[114] != null) __statement.setInt(count++, GenericBase.__getInt(args[114]));
		if(args[115] != null) __statement.setInt(count++, GenericBase.__getInt(args[115]));
		if(args[116] != null) __statement.setInt(count++, GenericBase.__getInt(args[116]));
		if(args[117] != null) __statement.setInt(count++, GenericBase.__getInt(args[117]));
		if(args[118] != null) __statement.setInt(count++, GenericBase.__getInt(args[118]));
		if(args[119] != null) __statement.setInt(count++, GenericBase.__getInt(args[119]));
		if(args[120] != null) __statement.setInt(count++, GenericBase.__getInt(args[120]));
		if(args[121] != null) __statement.setInt(count++, GenericBase.__getInt(args[121]));
		if(args[122] != null) __statement.setInt(count++, GenericBase.__getInt(args[122]));
		if(args[123] != null) __statement.setInt(count++, GenericBase.__getInt(args[123]));
		if(args[124] != null) __statement.setInt(count++, GenericBase.__getInt(args[124]));
		if(args[125] != null) __statement.setInt(count++, GenericBase.__getInt(args[125]));
		if(args[126] != null) __statement.setInt(count++, GenericBase.__getInt(args[126]));
		if(args[127] != null) __statement.setInt(count++, GenericBase.__getInt(args[127]));
		if(args[128] != null) __statement.setInt(count++, GenericBase.__getInt(args[128]));
		if(args[129] != null) __statement.setInt(count++, GenericBase.__getInt(args[129]));
		if(args[130] != null) __statement.setInt(count++, GenericBase.__getInt(args[130]));
		if(args[131] != null) __statement.setInt(count++, GenericBase.__getInt(args[131]));
		if(args[132] != null) __statement.setInt(count++, GenericBase.__getInt(args[132]));
		if(args[133] != null) __statement.setInt(count++, GenericBase.__getInt(args[133]));
		if(args[134] != null) __statement.setInt(count++, GenericBase.__getInt(args[134]));
		if(args[135] != null) __statement.setInt(count++, GenericBase.__getInt(args[135]));
		if(args[136] != null) __statement.setInt(count++, GenericBase.__getInt(args[136]));
		if(args[137] != null) __statement.setInt(count++, GenericBase.__getInt(args[137]));
		if(args[138] != null) __statement.setInt(count++, GenericBase.__getInt(args[138]));
		if(args[139] != null) __statement.setInt(count++, GenericBase.__getInt(args[139]));
		if(args[140] != null) __statement.setInt(count++, GenericBase.__getInt(args[140]));
		if(args[141] != null) __statement.setInt(count++, GenericBase.__getInt(args[141]));
		if(args[142] != null) __statement.setInt(count++, GenericBase.__getInt(args[142]));
		if(args[143] != null) __statement.setInt(count++, GenericBase.__getInt(args[143]));
		if(args[144] != null) __statement.setInt(count++, GenericBase.__getInt(args[144]));
		if(args[145] != null) __statement.setInt(count++, GenericBase.__getInt(args[145]));
		if(args[146] != null) __statement.setInt(count++, GenericBase.__getInt(args[146]));
		if(args[147] != null) __statement.setInt(count++, GenericBase.__getInt(args[147]));
		if(args[148] != null) __statement.setInt(count++, GenericBase.__getInt(args[148]));
		if(args[149] != null) __statement.setInt(count++, GenericBase.__getInt(args[149]));
		if(args[150] != null) __statement.setInt(count++, GenericBase.__getInt(args[150]));
		if(args[151] != null) __statement.setInt(count++, GenericBase.__getInt(args[151]));
		if(args[152] != null) __statement.setInt(count++, GenericBase.__getInt(args[152]));
		if(args[153] != null) __statement.setInt(count++, GenericBase.__getInt(args[153]));
		if(args[154] != null) __statement.setInt(count++, GenericBase.__getInt(args[154]));
		if(args[155] != null) __statement.setInt(count++, GenericBase.__getInt(args[155]));
		if(args[156] != null) __statement.setInt(count++, GenericBase.__getInt(args[156]));
		if(args[157] != null) __statement.setInt(count++, GenericBase.__getInt(args[157]));
		if(args[158] != null) __statement.setInt(count++, GenericBase.__getInt(args[158]));
		if(args[159] != null) __statement.setInt(count++, GenericBase.__getInt(args[159]));
		if(args[160] != null) __statement.setInt(count++, GenericBase.__getInt(args[160]));
		if(args[161] != null) __statement.setInt(count++, GenericBase.__getInt(args[161]));
		if(args[162] != null) __statement.setInt(count++, GenericBase.__getInt(args[162]));
		if(args[163] != null) __statement.setInt(count++, GenericBase.__getInt(args[163]));
		if(args[164] != null) __statement.setInt(count++, GenericBase.__getInt(args[164]));
		if(args[165] != null) __statement.setInt(count++, GenericBase.__getInt(args[165]));
		if(args[166] != null) __statement.setInt(count++, GenericBase.__getInt(args[166]));
		if(args[167] != null) __statement.setInt(count++, GenericBase.__getInt(args[167]));
		if(args[168] != null) __statement.setInt(count++, GenericBase.__getInt(args[168]));
		if(args[169] != null) __statement.setInt(count++, GenericBase.__getInt(args[169]));
		if(args[170] != null) __statement.setInt(count++, GenericBase.__getInt(args[170]));
		if(args[171] != null) __statement.setInt(count++, GenericBase.__getInt(args[171]));
		if(args[172] != null) __statement.setInt(count++, GenericBase.__getInt(args[172]));
		if(args[173] != null) __statement.setInt(count++, GenericBase.__getInt(args[173]));
		if(args[174] != null) __statement.setInt(count++, GenericBase.__getInt(args[174]));
		if(args[175] != null) __statement.setInt(count++, GenericBase.__getInt(args[175]));
		if(args[176] != null) __statement.setInt(count++, GenericBase.__getInt(args[176]));
		if(args[177] != null) __statement.setInt(count++, GenericBase.__getInt(args[177]));
		if(args[178] != null) __statement.setInt(count++, GenericBase.__getInt(args[178]));
		if(args[179] != null) __statement.setInt(count++, GenericBase.__getInt(args[179]));
		if(args[180] != null) __statement.setInt(count++, GenericBase.__getInt(args[180]));
		if(args[181] != null) __statement.setInt(count++, GenericBase.__getInt(args[181]));
		if(args[182] != null) __statement.setInt(count++, GenericBase.__getInt(args[182]));
		if(args[183] != null) __statement.setInt(count++, GenericBase.__getInt(args[183]));
		if(args[184] != null) __statement.setInt(count++, GenericBase.__getInt(args[184]));
		if(args[185] != null) __statement.setInt(count++, GenericBase.__getInt(args[185]));
		if(args[186] != null) __statement.setInt(count++, GenericBase.__getInt(args[186]));
		if(args[187] != null) __statement.setInt(count++, GenericBase.__getInt(args[187]));
		if(args[188] != null) __statement.setInt(count++, GenericBase.__getInt(args[188]));
		if(args[189] != null) __statement.setInt(count++, GenericBase.__getInt(args[189]));
		if(args[190] != null) __statement.setInt(count++, GenericBase.__getInt(args[190]));
		if(args[191] != null) __statement.setInt(count++, GenericBase.__getInt(args[191]));
		if(args[192] != null) __statement.setInt(count++, GenericBase.__getInt(args[192]));
		if(args[193] != null) __statement.setInt(count++, GenericBase.__getInt(args[193]));
		if(args[194] != null) __statement.setInt(count++, GenericBase.__getInt(args[194]));
		if(args[195] != null) __statement.setInt(count++, GenericBase.__getInt(args[195]));
		if(args[196] != null) __statement.setInt(count++, GenericBase.__getInt(args[196]));
		if(args[197] != null) __statement.setInt(count++, GenericBase.__getInt(args[197]));
		if(args[198] != null) __statement.setInt(count++, GenericBase.__getInt(args[198]));
		if(args[199] != null) __statement.setInt(count++, GenericBase.__getInt(args[199]));
		if(args[200] != null) __statement.setInt(count++, GenericBase.__getInt(args[200]));
		if(args[201] != null) __statement.setInt(count++, GenericBase.__getInt(args[201]));
		if(args[202] != null) __statement.setInt(count++, GenericBase.__getInt(args[202]));
		if(args[203] != null) __statement.setInt(count++, GenericBase.__getInt(args[203]));
		if(args[204] != null) __statement.setInt(count++, GenericBase.__getInt(args[204]));
		if(args[205] != null) __statement.setInt(count++, GenericBase.__getInt(args[205]));
		if(args[206] != null) __statement.setInt(count++, GenericBase.__getInt(args[206]));
		if(args[207] != null) __statement.setInt(count++, GenericBase.__getInt(args[207]));
		if(args[208] != null) __statement.setInt(count++, GenericBase.__getInt(args[208]));
		if(args[209] != null) __statement.setInt(count++, GenericBase.__getInt(args[209]));
		if(args[210] != null) __statement.setInt(count++, GenericBase.__getInt(args[210]));
		if(args[211] != null) __statement.setInt(count++, GenericBase.__getInt(args[211]));
		if(args[212] != null) __statement.setInt(count++, GenericBase.__getInt(args[212]));
		if(args[213] != null) __statement.setInt(count++, GenericBase.__getInt(args[213]));
		if(args[214] != null) __statement.setInt(count++, GenericBase.__getInt(args[214]));
		if(args[215] != null) __statement.setInt(count++, GenericBase.__getInt(args[215]));
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

	private final static String __SQLText = "select one.details, one.plate_id, one.results as January, two.results as February, three.results as March, four.results as April, five.results as May, six.results as June, seven.results as July, eight.results as August, nine.results as September, ten.results as October, eleven.results as November, twelve.results as December from ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 1 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS one LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 2 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS two on one.plate_id = two.plate_id and one.details = two.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 3 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS three on one.plate_id = three.plate_id and one.details = three.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 4 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS four on one.plate_id = four.plate_id and one.details = four.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 5 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS five on one.plate_id = five.plate_id and one.details = five.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 6 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS six on one.plate_id = six.plate_id and one.details = six.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 7 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS seven on one.plate_id = seven.plate_id and one.details = seven.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 8 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS eight on one.plate_id = eight.plate_id and one.details = eight.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 9 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS nine on one.plate_id = nine.plate_id and one.details = nine.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 10 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS ten on one.plate_id = ten.plate_id and one.details = ten.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost AS results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 11 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS eleven on one.plate_id = eleven.plate_id and eleven.details = nine.details LEFT JOIN ( (SELECT '合同存量' as details, plate_id, contract_stock AS results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '本月营收' as details, plate_id, revenue AS results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门确认积分' as details, plate_id, department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目确认积分' as details, plate_id, employee_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '确认积分合计' as details, plate_id, employee_confirmation_points + department_confirmation_points AS results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '人工成本' as details, plate_id, employee_cost AS results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '项目成本' as details, plate_id, project_cost AS results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '部门成本' as details, plate_id, plate_cost As results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) UNION ALL ( SELECT '成本合计' as details, plate_id, plate_cost + project_cost + employee_cost As results FROM plate_income_and_expenditures where year =? and month = 12 and plate_id =? GROUP BY year, month, plate_id, contract_stock, revenue, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_cost ) )AS twelve on one.plate_id = twelve.plate_id and one.details = twelve.details order by one.plate_id, two.plate_id, three.plate_id, four.plate_id, five.plate_id, six.plate_id, seven.plate_id, eight.plate_id, nine.plate_id, ten.plate_id, eleven.plate_id, twelve.plate_id" ;
	private final static String RESULTSETFIELDLIST = "details,plate_id,january,february,march,april,may,june,july,august,september,october,november,december";
	private final static String[] fieldNames = { "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id"};
}
