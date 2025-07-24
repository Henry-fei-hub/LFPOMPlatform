package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseOnLoadEmployeeShiftDetailOfShift;
import pomplatform.shift.bean.ConditionOnLoadEmployeeShiftDetailOfShift;
import pomplatform.shift.query.QueryOnLoadEmployeeShiftDetailOfShift;
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

public class OnLoadEmployeeShiftDetailOfShiftHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadEmployeeShiftDetailOfShiftHandler.class);

	public static BaseCollection<BaseOnLoadEmployeeShiftDetailOfShift> executeQueryOnLoadEmployeeShiftDetailOfShift(ConditionOnLoadEmployeeShiftDetailOfShift c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadEmployeeShiftDetailOfShift dao = new QueryOnLoadEmployeeShiftDetailOfShift();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadEmployeeShiftDetailOfShift> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadEmployeeShiftDetailOfShift c = new ConditionOnLoadEmployeeShiftDetailOfShift();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadEmployeeShiftDetailOfShift> result = executeQueryOnLoadEmployeeShiftDetailOfShift(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadEmployeeShiftDetailOfShift> result;
		ConditionOnLoadEmployeeShiftDetailOfShift c = new ConditionOnLoadEmployeeShiftDetailOfShift();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadEmployeeShiftDetailOfShift dao = new QueryOnLoadEmployeeShiftDetailOfShift();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadEmployeeShiftDetailOfShift.ALL_CAPTIONS);
			for(BaseOnLoadEmployeeShiftDetailOfShift b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


