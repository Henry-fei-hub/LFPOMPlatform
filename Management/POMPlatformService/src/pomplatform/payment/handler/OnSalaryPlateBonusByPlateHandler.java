package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnSalaryPlateBonusByPlate;
import pomplatform.payment.bean.ConditionOnSalaryPlateBonusByPlate;
import pomplatform.payment.query.QueryOnSalaryPlateBonusByPlate;
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

public class OnSalaryPlateBonusByPlateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryPlateBonusByPlateHandler.class);

	public static BaseCollection<BaseOnSalaryPlateBonusByPlate> executeQueryOnSalaryPlateBonusByPlate(ConditionOnSalaryPlateBonusByPlate c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryPlateBonusByPlate dao = new QueryOnSalaryPlateBonusByPlate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryPlateBonusByPlate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryPlateBonusByPlate c = new ConditionOnSalaryPlateBonusByPlate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryPlateBonusByPlate> result = executeQueryOnSalaryPlateBonusByPlate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryPlateBonusByPlate> result;
		ConditionOnSalaryPlateBonusByPlate c = new ConditionOnSalaryPlateBonusByPlate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryPlateBonusByPlate dao = new QueryOnSalaryPlateBonusByPlate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryPlateBonusByPlate.ALL_CAPTIONS);
			for(BaseOnSalaryPlateBonusByPlate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


