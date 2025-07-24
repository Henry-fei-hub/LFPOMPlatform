package pomplatform.capitalDsitributionemployee.handler;

import org.apache.log4j.Logger;
import pomplatform.capitalDsitributionemployee.bean.BaseCapitalDsitributionemployee;
import pomplatform.capitalDsitributionemployee.bean.ConditionCapitalDsitributionemployee;
import pomplatform.capitalDsitributionemployee.query.QueryCapitalDsitributionemployee;
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

public class CapitalDsitributionemployeeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalDsitributionemployeeHandler.class);

	public static BaseCollection<BaseCapitalDsitributionemployee> executeQueryCapitalDsitributionemployee(ConditionCapitalDsitributionemployee c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalDsitributionemployee dao = new QueryCapitalDsitributionemployee();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalDsitributionemployee> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalDsitributionemployee c = new ConditionCapitalDsitributionemployee();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalDsitributionemployee> result = executeQueryCapitalDsitributionemployee(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalDsitributionemployee> result;
		ConditionCapitalDsitributionemployee c = new ConditionCapitalDsitributionemployee();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalDsitributionemployee dao = new QueryCapitalDsitributionemployee();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalDsitributionemployee.ALL_CAPTIONS);
			for(BaseCapitalDsitributionemployee b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


