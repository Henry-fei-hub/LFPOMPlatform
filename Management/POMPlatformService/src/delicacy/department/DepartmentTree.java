package delicacy.department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.dao.Department;

import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseDepartmentId;
import delicacy.system.dao.DepartmentId;

/**
 *
 * @author guanxgun
 */
public class DepartmentTree extends BaseDepartment {

    public static DepartmentTree departmentRoot;
	
	public static void main(String[] args){
		try{
			generateDepartmentTree();
			printDepartmentTree(departmentRoot, "");
//			DepartmentTree root = findAreaDepartment(departmentRoot);
			DepartmentId dao = new DepartmentId();
			updateDepartmentId(departmentRoot, dao);
//			updateAreaDepartment(root, dao);
//			Map<Integer, Boolean> dhmap = generateDepartmentHeadcount();
//			Employee e = new Employee();
//			List<BaseEmployee> bes = e.conditionalLoad();
//			for(BaseEmployee be : bes){
//				e.clear();
//				e.setDataFromBase(be);
//				e.clearModifiedFlags();
//				e.setIsHeadcount(dhmap.get(be.getDepartmentId()));
//				e.update();
//			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static Map<Integer, Boolean> generateDepartmentHeadcount() throws SQLException{
		Map<Integer, Boolean> res = new HashMap<>();
		Department dao = new Department();
		dao.unsetSelectFlags();
		dao.setSelectDepartmentId(true);
		dao.setSelectIsHeadcount(true);
		List<BaseDepartment> bds = dao.conditionalLoad();
		for(BaseDepartment bd : bds){
			res.put(bd.getDepartmentId(), bd.getIsHeadcount());
		}
		return res;
	}
	
	public static String updateDepartmentId(DepartmentTree node, DepartmentId dao) throws SQLException{
		StringBuilder sb = new StringBuilder();
		sb.append(node.getDepartmentId());
		if(!BaseHelpUtils.isNullOrEmpty(node.getChildren())){
			for(DepartmentTree c : node.getChildren()){
				sb.append(",");
				sb.append(updateDepartmentId(c, dao));
				
			}
		}
		String[] ids = sb.toString().split(",");
		List<BaseDepartmentId> bdis = new ArrayList<>();
		for(String s : ids){
			BaseDepartmentId bdi = new BaseDepartmentId();
			bdi.setDepartmentId(node.getDepartmentId());
			bdi.setChildId(Integer.parseInt(s));
			bdis.add(bdi);
		}
		for(BaseDepartmentId b : bdis){
			dao.clear();
			dao.setConditionChildId("=", b.getChildId());
			dao.setConditionDepartmentId("=", b.getDepartmentId());
			if(!dao.isExist()){
				dao.clear();
				dao.setDataFromBase(b);
				dao.save();
			}
		}
//		dao.save(bdis);
		return sb.toString();
	}
	
    public static DepartmentTree generateDepartmentTree() {
        try {
            Department dao = new Department();
            dao.setConditionParentId("=", 0);
            BaseDepartment bd = dao.executeQueryOneRow();
            DepartmentTree dt = new DepartmentTree();
            bd.cloneCopy(dt);
            dt.setParentDepartment(null);
            generateDepartmentTree(dt, dao);
            departmentRoot = dt;
            return dt;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void generateDepartmentTree(DepartmentTree department, Department dao) throws Exception {
        dao.clearConditions();
        dao.setConditionParentId("=", department.getDepartmentId());
        List<BaseDepartment> bds = dao.conditionalLoad();
        List<DepartmentTree> dts = new ArrayList<>();
        for (BaseDepartment bd : bds) {
            if((bd.getParentId() != 1) && (bd.getPlateId() == null || bd.getPlateId() == 0)){
                dao.clearCurrentData();
                dao.setDataFromBase(bd);
                dao.clearModifiedFlags();
                dao.setPlateId(department.getPlateId());
                dao.update();
                bd.setPlateId(department.getPlateId());
            }
            DepartmentTree dt = new DepartmentTree();
            bd.cloneCopy(dt);
            dts.add(dt);
            dt.setParentDepartment(department);
            generateDepartmentTree(dt, dao);
        }
        department.setChildren(dts);
    }
	
    public static DepartmentTree findDepartment(int id){
    	if(departmentRoot == null) generateDepartmentTree();
    	return findDepartment(departmentRoot, id);
    }
    
    public static DepartmentTree findDepartment(DepartmentTree dt, int id){
    	if(dt.getDepartmentId() == id) return dt;
    	for(DepartmentTree d : dt.getChildren()){
    		if(d.getDepartmentId() == id) return d;
    		DepartmentTree tt = findDepartment(d, id);
    		if(tt != null) return tt;
    	}
    	return null;
    }
    
	public static DepartmentTree findAreaDepartment(DepartmentTree dt){
		if(dt.getDepartmentName().equals("区域公司")) return dt;
		DepartmentTree d = null;
		for(DepartmentTree tt : dt.getChildren()){
			d = findAreaDepartment(tt);
			if(d != null) return d;
		}
		return null;
	}
	
	public static void updateAreaDepartment(DepartmentTree root, Department dao) throws SQLException{
		dao.setPrimaryKeyFromBase(root);
		dao.load();
		dao.setIsHeadcount(false);
		dao.update();
		for(DepartmentTree tt : root.getChildren()){
			updateAreaDepartment(tt, dao);
		}
	}

    public static int findPlateID(int departmentID) {
        DepartmentTree department = findPlateID(departmentID, departmentRoot);
        if (department == null) {
            return -1;
        }
        while (department.getParentDepartment() != null && department.getParentDepartment().getParentId() != 1) {
            if (department.getParentId() == 1 || department.getDepartmentName().equals("武汉公司")) {
                break;
            }
            department = department.getParentDepartment();
        }
        switch (department.getDepartmentName()) {
            case "商业公司":
                return 1;
            case "酒店部":
                return 2;
            case "办公部":
                return 3;
            case "地铁部":
                return 4;
            case "机电公司":
                return 5;
            case "武汉公司":
                return 6;
            default:
                return 0;
        }
    }

    public static DepartmentTree findPlateID(int departmentID, DepartmentTree dt) {
        if (dt.getDepartmentId() == departmentID) {
            return dt;
        }
        for (DepartmentTree dt1 : dt.getChildren()) {
            if (dt1.getDepartmentId() == departmentID) {
                return dt1;
            }
        }
        for (DepartmentTree dt1 : dt.getChildren()) {
            DepartmentTree res = findPlateID(departmentID, dt1);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    public static void printDepartmentTree(DepartmentTree department, String space) {
        System.out.printf("%s%s\n", space, department.toCSVString());
        space += "\t";
        for (DepartmentTree dt : department.getChildren()) {

            printDepartmentTree(dt, space);
        }
    }

    private List<DepartmentTree> children = new ArrayList<>();
    private DepartmentTree parentDepartment;

    /**
     * @return the parentDepartment
     */
    public DepartmentTree getParentDepartment() {
        return parentDepartment;
    }

    /**
     * @param parentDepartment the parentDepartment to set
     */
    public void setParentDepartment(DepartmentTree parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    /**
     * @return the children
     */
    public List<DepartmentTree> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<DepartmentTree> children) {
        this.children = children;
    }
}
