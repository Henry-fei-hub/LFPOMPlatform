package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseOnLoadEmployeeShiftOfShift;
import pomplatform.shift.bean.ConditionOnLoadEmployeeShiftOfShift;
import pomplatform.shift.query.QueryOnLoadEmployeeShiftOfShift;
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

public class OnLoadEmployeeShiftOfShiftHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadEmployeeShiftOfShiftHandler.class);

	public static BaseCollection<BaseOnLoadEmployeeShiftOfShift> executeQueryOnLoadEmployeeShiftOfShift(ConditionOnLoadEmployeeShiftOfShift c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadEmployeeShiftOfShift dao = new QueryOnLoadEmployeeShiftOfShift();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadEmployeeShiftOfShift> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadEmployeeShiftOfShift c = new ConditionOnLoadEmployeeShiftOfShift();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadEmployeeShiftOfShift> result = executeQueryOnLoadEmployeeShiftOfShift(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadEmployeeShiftOfShift> result;
		ConditionOnLoadEmployeeShiftOfShift c = new ConditionOnLoadEmployeeShiftOfShift();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadEmployeeShiftOfShift dao = new QueryOnLoadEmployeeShiftOfShift();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadEmployeeShiftOfShift.ALL_CAPTIONS);
			for(BaseOnLoadEmployeeShiftOfShift b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


