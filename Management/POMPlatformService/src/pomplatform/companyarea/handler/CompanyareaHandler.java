package pomplatform.companyarea.handler;

import org.apache.log4j.Logger;
import pomplatform.companyarea.bean.BaseCompanyarea;
import pomplatform.companyarea.bean.ConditionCompanyarea;
import pomplatform.companyarea.query.QueryCompanyarea;
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

public class CompanyareaHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CompanyareaHandler.class);

	public static BaseCollection<BaseCompanyarea> executeQueryCompanyarea(ConditionCompanyarea c, KeyValuePair[] replacements ) throws Exception {
		QueryCompanyarea dao = new QueryCompanyarea();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCompanyarea> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCompanyarea c = new ConditionCompanyarea();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCompanyarea> result = executeQueryCompanyarea(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCompanyarea> result;
		ConditionCompanyarea c = new ConditionCompanyarea();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCompanyarea dao = new QueryCompanyarea();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCompanyarea.ALL_CAPTIONS);
			for(BaseCompanyarea b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


