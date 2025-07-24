package pomplatform.shift.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import pomplatform.shift.bean.BaseOnGetEmployeeMonthCheck;
import pomplatform.shift.bean.BaseOnGetEmployeeMonthCheckCustom;
import pomplatform.shift.bean.ConditionOnGetEmployeeMonthCheck;
import pomplatform.shift.query.QueryOnGetEmployeeMonthCheck;

public class OnGetEmployeeMonthCheckHandlerCustom extends OnGetEmployeeMonthCheckHandler {

	private static final Logger __logger = Logger.getLogger(OnGetEmployeeMonthCheckHandlerCustom.class);

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnGetEmployeeMonthCheck> result;
		ConditionOnGetEmployeeMonthCheck c = new ConditionOnGetEmployeeMonthCheck();
		c.setDataFromJSON(creteria);
		QueryOnGetEmployeeMonthCheck dao = new QueryOnGetEmployeeMonthCheck();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnGetEmployeeMonthCheckCustom.ALL_CAPTIONS);
			BaseOnGetEmployeeMonthCheckCustom be = null;
			for(BaseOnGetEmployeeMonthCheck b : result.getCollections()){
				be = new BaseOnGetEmployeeMonthCheckCustom();
				be.setDataFromJSON(b.toJSON());
				ps.println(be.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


