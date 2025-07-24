package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnSalaryAnnualBonusByPlate;
import pomplatform.payment.bean.ConditionOnSalaryAnnualBonusByPlate;
import pomplatform.payment.query.QueryOnSalaryAnnualBonusByPlate;
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

public class OnSalaryAnnualBonusByPlateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryAnnualBonusByPlateHandler.class);

	public static BaseCollection<BaseOnSalaryAnnualBonusByPlate> executeQueryOnSalaryAnnualBonusByPlate(ConditionOnSalaryAnnualBonusByPlate c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryAnnualBonusByPlate dao = new QueryOnSalaryAnnualBonusByPlate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryAnnualBonusByPlate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryAnnualBonusByPlate c = new ConditionOnSalaryAnnualBonusByPlate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryAnnualBonusByPlate> result = executeQueryOnSalaryAnnualBonusByPlate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryAnnualBonusByPlate> result;
		ConditionOnSalaryAnnualBonusByPlate c = new ConditionOnSalaryAnnualBonusByPlate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryAnnualBonusByPlate dao = new QueryOnSalaryAnnualBonusByPlate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryAnnualBonusByPlate.ALL_CAPTIONS);
			for(BaseOnSalaryAnnualBonusByPlate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


