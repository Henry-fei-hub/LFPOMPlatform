package pomplatform.PlateProjectAccountRecordByMonth.handler;

import org.apache.log4j.Logger;
import pomplatform.PlateProjectAccountRecordByMonth.bean.BasePlateProjectAccountRecordByMonth;
import pomplatform.PlateProjectAccountRecordByMonth.bean.ConditionPlateProjectAccountRecordByMonth;
import pomplatform.PlateProjectAccountRecordByMonth.query.QueryPlateProjectAccountRecordByMonth;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class PlateProjectAccountRecordByMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PlateProjectAccountRecordByMonthHandler.class);

	public static BaseCollection<BasePlateProjectAccountRecordByMonth> executeQueryPlateProjectAccountRecordByMonth(ConditionPlateProjectAccountRecordByMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryPlateProjectAccountRecordByMonth dao = new QueryPlateProjectAccountRecordByMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePlateProjectAccountRecordByMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPlateProjectAccountRecordByMonth c = new ConditionPlateProjectAccountRecordByMonth();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePlateProjectAccountRecordByMonth> result = executeQueryPlateProjectAccountRecordByMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePlateProjectAccountRecordByMonth> result;
		ConditionPlateProjectAccountRecordByMonth c = new ConditionPlateProjectAccountRecordByMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPlateProjectAccountRecordByMonth dao = new QueryPlateProjectAccountRecordByMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePlateProjectAccountRecordByMonth.ALL_CAPTIONS);
			for(BasePlateProjectAccountRecordByMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


