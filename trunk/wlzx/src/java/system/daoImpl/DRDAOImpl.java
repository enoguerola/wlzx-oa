package system.daoImpl;




import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.dao.DRDAO;
import system.entity.DRModel;
import system.utils.StringUtils;

public class DRDAOImpl extends BaseDAOImpl<DRModel> implements DRDAO{

	@SuppressWarnings("unchecked")
	public DRModel getBasicDR(){
			DetachedCriteria criteria = DetachedCriteria.forClass(DRModel.class);
			criteria.add(Restrictions.eq("basicFlag", true));
			List<DRModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		
	}
	@SuppressWarnings("unchecked")
	public DRModel getDRByDepartmentIdAndRoleId(String departmentId,String roleId){
			if(StringUtils.isNotEmpty(departmentId)&&StringUtils.isNotEmpty(roleId)){
				DetachedCriteria criteria = DetachedCriteria.forClass(DRModel.class);
				criteria.add(Restrictions.eq("departmentId", departmentId));
				criteria.add(Restrictions.eq("roleId", roleId));
				List<DRModel> result = this.getListByCriteria(criteria);
				return result != null && result.size() > 0 ? result.get(0) : null;
			}else return null;
		
	}
	@SuppressWarnings("unchecked")
	public List<DRModel> getAllDRs(boolean filterBasicFlag) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DRModel.class);
		if(filterBasicFlag==true)
		//过滤基础部门岗位
		criteria.add(Restrictions.ne("basicFlag", true));
		List<DRModel> result = this.getListByCriteria(criteria);
		return result;
	}

}
