package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseTeamMembers;
import pomplatform.contract.bean.ConditionTeamMembers;
import pomplatform.contract.query.QueryTeamMembers;
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

public class TeamMembersHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TeamMembersHandler.class);

	public static BaseCollection<BaseTeamMembers> executeQueryTeamMembers(ConditionTeamMembers c, KeyValuePair[] replacements ) throws Exception {
		QueryTeamMembers dao = new QueryTeamMembers();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTeamMembers> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTeamMembers c = new ConditionTeamMembers();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTeamMembers> result = executeQueryTeamMembers(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTeamMembers> result;
		ConditionTeamMembers c = new ConditionTeamMembers();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTeamMembers dao = new QueryTeamMembers();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTeamMembers.ALL_CAPTIONS);
			for(BaseTeamMembers b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


