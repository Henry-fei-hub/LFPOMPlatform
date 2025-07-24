package pomplatform.company.handler;

import org.apache.log4j.Logger;
import pomplatform.company.bean.BaseSheetTotalByProjectType;
import pomplatform.company.bean.ConditionSheetTotalByProjectType;
import pomplatform.company.query.QuerySheetTotalByProjectType;
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

public class SheetTotalByProjectTypeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SheetTotalByProjectTypeHandler.class);

	public static BaseCollection<BaseSheetTotalByProjectType> executeQuerySheetTotalByProjectType(ConditionSheetTotalByProjectType c, KeyValuePair[] replacements ) throws Exception {
		QuerySheetTotalByProjectType dao = new QuerySheetTotalByProjectType();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSheetTotalByProjectType> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSheetTotalByProjectType c = new ConditionSheetTotalByProjectType();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSheetTotalByProjectType> result = executeQuerySheetTotalByProjectType(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSheetTotalByProjectType> result;
		ConditionSheetTotalByProjectType c = new ConditionSheetTotalByProjectType();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySheetTotalByProjectType dao = new QuerySheetTotalByProjectType();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSheetTotalByProjectType.ALL_CAPTIONS);
			for(BaseSheetTotalByProjectType b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


