package pomplatform.company.handler;

import org.apache.log4j.Logger;
import pomplatform.company.bean.BaseSheetTotalByBusinessType;
import pomplatform.company.bean.ConditionSheetTotalByBusinessType;
import pomplatform.company.query.QuerySheetTotalByBusinessType;
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

public class SheetTotalByBusinessTypeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SheetTotalByBusinessTypeHandler.class);

	public static BaseCollection<BaseSheetTotalByBusinessType> executeQuerySheetTotalByBusinessType(ConditionSheetTotalByBusinessType c, KeyValuePair[] replacements ) throws Exception {
		QuerySheetTotalByBusinessType dao = new QuerySheetTotalByBusinessType();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSheetTotalByBusinessType> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSheetTotalByBusinessType c = new ConditionSheetTotalByBusinessType();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSheetTotalByBusinessType> result = executeQuerySheetTotalByBusinessType(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSheetTotalByBusinessType> result;
		ConditionSheetTotalByBusinessType c = new ConditionSheetTotalByBusinessType();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySheetTotalByBusinessType dao = new QuerySheetTotalByBusinessType();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSheetTotalByBusinessType.ALL_CAPTIONS);
			for(BaseSheetTotalByBusinessType b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


