package system.wlims.oa.serviceImpl.course.adjust;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import system.components.SecurityUserHolder;
import system.utils.StringUtils;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.course.adjust.CourseAdjustDAO;
import system.wlims.oa.entity.course.adjust.ApplyItemModel;
import system.wlims.oa.entity.course.adjust.ApplyModel;
import system.wlims.oa.service.course.adjust.CourseAdjustService;

public class CourseAdjustServiceImpl implements CourseAdjustService{
	private CourseAdjustDAO courseAdjustDAO;

	public CourseAdjustDAO getCourseAdjustDAO() {
		return courseAdjustDAO;
	}

	public void setCourseAdjustDAO(CourseAdjustDAO courseAdjustDAO) {
		this.courseAdjustDAO = courseAdjustDAO;
	}

	@Override
	public boolean applyAdd(ApplyModel apply) {
		// TODO Auto-generated method stub
		Date currenDate=new Date();
		apply.setApplyNo(UtilDateTime.toDateString(currenDate, "yyyyMMddHHmmss"));
		apply.setApplyCreationDate(currenDate);
		apply.setApplyStatus(ApplyModel.ApplyStatus.WAITING.getStatus());
		courseAdjustDAO.saveOrUpdate(apply);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyModel> personalApplySearch() {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(ApplyModel.class);
		criteria.add(Restrictions.eq("applyTeacherId", SecurityUserHolder.getCurrentUser().getId()));
		criteria.addOrder(Order.desc("applyNo"));
		List<ApplyModel> result = courseAdjustDAO.getListByCriteria(criteria);
		return result;
	}

	@Override
	public boolean cancleApplyById(String applyId) {
		// TODO Auto-generated method stub
		ApplyModel apply=courseAdjustDAO.get(applyId);
		if(apply.getApplyStatus()!=ApplyModel.ApplyStatus.WAITING.getStatus()){
			return false;
		}else {
			apply.setApplyStatus(ApplyModel.ApplyStatus.CANCLE.getStatus());
			courseAdjustDAO.saveOrUpdate(apply);
			return true;
		}
	
	}

	@Override
	public ApplyModel getApplyById(String applyId) {
		// TODO Auto-generated method stub
		return courseAdjustDAO.get(applyId);
	}

	@Override
	public ApplyModel loadApplyInfo(String applyId) {
		// TODO Auto-generated method stub
		return courseAdjustDAO.get(applyId);
	}
	@Override
	public boolean applyUpdate(ApplyModel apply, Set<ApplyItemModel> applyItems) {
		// TODO Auto-generated method stub
		ApplyModel preApply=courseAdjustDAO.get(apply.getId());
		preApply.getApplyItems().removeAll(preApply.getApplyItems());
		courseAdjustDAO.saveOrUpdate(preApply);	
		apply.setApplyItems(applyItems);
		courseAdjustDAO.merge(apply);
		
		return true;
	}
//	
//	public static void main(String[] args) {
//		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"system/wlims/oa/serviceImpl/course/adjust/*.xml"});	 
//		 CourseAdjustService applyService=(CourseAdjustService)applicationContext.getBean("applyServiceDest");
//		 applyService.applyUpdate(null,null);
//		 
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyModel> getAppliesByCondition(String accountId,
			Integer state, Integer type, String beginDate, String endDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ApplyModel.class);
		if(!StringUtils.isEmpty(accountId)){
			criteria.add(Restrictions.eq("applyTeacherId", accountId));
		}
		if(state!=null){
			criteria.add(Restrictions.eq("applyStatus", state));
		}
		if(type!=null){
			criteria.add(Restrictions.eq("applyType", type));
		}
		if(!StringUtils.isEmpty(beginDate)){
			criteria.add(Restrictions.ge("applyCreationDate", java.sql.Date.valueOf(beginDate+" 00:00:00")));
		}
		if(!StringUtils.isEmpty(endDate)){
			criteria.add(Restrictions.le("applyCreationDate", java.sql.Date.valueOf(endDate+" 23:59:59")));
		}
		
		
		criteria.addOrder(Order.asc("applyNo"));
		List<ApplyModel> result = courseAdjustDAO.getListByCriteria(criteria);
		return result;
	}

	@Override
	public boolean deleteApplyById(String applyId) {
		// TODO Auto-generated method stub
		courseAdjustDAO.remove(courseAdjustDAO.get(applyId));
		return true;
	}

	@Override
	public boolean saveApprove(ApplyModel apply) {
		// TODO Auto-generated method stub
		courseAdjustDAO.saveOrUpdate(apply);
		return true;
	}
	
}
