package pomplatform.company.handler;

import org.apache.log4j.Logger;
import pomplatform.company.bean.BaseCompanyAccountGetSheetTotal;
import pomplatform.company.bean.ConditionCompanyAccountGetSheetTotal;
import pomplatform.company.query.QueryCompanyAccountGetSheetTotal;
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

public class CompanyAccountGetSheetTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CompanyAccountGetSheetTotalHandler.class);

	public static BaseCollection<BaseCompanyAccountGetSheetTotal> executeQueryCompanyAccountGetSheetTotal(ConditionCompanyAccountGetSheetTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryCompanyAccountGetSheetTotal dao = new QueryCompanyAccountGetSheetTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCompanyAccountGetSheetTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCompanyAccountGetSheetTotal c = new ConditionCompanyAccountGetSheetTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCompanyAccountGetSheetTotal> result = executeQueryCompanyAccountGetSheetTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCompanyAccountGetSheetTotal> result;
		ConditionCompanyAccountGetSheetTotal c = new ConditionCompanyAccountGetSheetTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCompanyAccountGetSheetTotal dao = new QueryCompanyAccountGetSheetTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCompanyAccountGetSheetTotal.ALL_CAPTIONS);
			for(BaseCompanyAccountGetSheetTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


