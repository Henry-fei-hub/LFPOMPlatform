package pomplatform.subjectType.handler;

import org.apache.log4j.Logger;
import pomplatform.subjectType.bean.BaseSubjectTypeLinkDepartment;
import pomplatform.subjectType.bean.ConditionSubjectTypeLinkDepartment;
import pomplatform.subjectType.query.QuerySubjectTypeLinkDepartment;
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

public class SubjectTypeLinkDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SubjectTypeLinkDepartmentHandler.class);

	public static BaseCollection<BaseSubjectTypeLinkDepartment> executeQuerySubjectTypeLinkDepartment(ConditionSubjectTypeLinkDepartment c, KeyValuePair[] replacements ) throws Exception {
		QuerySubjectTypeLinkDepartment dao = new QuerySubjectTypeLinkDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSubjectTypeLinkDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSubjectTypeLinkDepartment c = new ConditionSubjectTypeLinkDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSubjectTypeLinkDepartment> result = executeQuerySubjectTypeLinkDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSubjectTypeLinkDepartment> result;
		ConditionSubjectTypeLinkDepartment c = new ConditionSubjectTypeLinkDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySubjectTypeLinkDepartment dao = new QuerySubjectTypeLinkDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSubjectTypeLinkDepartment.ALL_CAPTIONS);
			for(BaseSubjectTypeLinkDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


