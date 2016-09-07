package com.javaetime.web.StaffInfo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.Staff;
import com.javaetime.entity.StaffEntity;
import com.javaetime.entity.User;
import com.javaetime.web.StaffInfo.dao.StaffDao;
import com.javaetime.web.StaffInfo.param.StaffParam;
import com.javaetime.web.account.dao.UserMapper;

/**
 * StaffServiceImpl
 * @author 范兴贵
 * @time 2015.09.12 16:45
 */
@Component("staffService")
@Transactional
public class StaffServiceImpl implements StaffService {

	public static final String HASH_ALGORITHM = "SHA-1";
	
	public static final int HASH_INTERATIONS = 1024;
	
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean addSave(StaffEntity staffEntity) {
		System.out.println("进入StaffServiceImpl的addSave()方法");
		staffDao.queryTelNum(staffEntity);
			setDateNull(staffEntity);
			User user = addUser(staffEntity);
			staffEntity.setStaffId(user.getId());
			return staffDao.addSave(staffEntity);
	}

	/**
	 * @param staffEntity
	 */
	private User addUser(StaffEntity staffEntity) {
		User user=new User();
		user.setLoginName(staffEntity.getTel());
		user.setName(staffEntity.getStaffName());
		user.setPassword(staffEntity.getTel());
		userMapper.insert(user);
		return user;
	}

	private void setDateNull(StaffEntity staffEntity) {
		//毕业时间为空,则改为null
		if("".equals(staffEntity.getGraduationDate())){
			staffEntity.setGraduationDate(null);
		}
	}

	@Override
	public boolean delete(Long id) {
		System.out.println("进入StaffServiceImpl的delete(long id)方法");
		
		return staffDao.delete(id);
	}

	@Override
	public boolean editSave(StaffEntity staffEntity) {
		System.out.println("进入StaffServiceImpl的editSave()方法");
		//客户的电话号码不允许修改为已经存在的客户电话号码
		int telNum = staffDao.queryTelNum(staffEntity);
		if(telNum==1){
			return false;
		}
		//处理日期数据
		setDateNull(staffEntity);
		staffDao.editSave(staffEntity);
		return true;
	}

	@Override
	public void insert(Staff staff) {
		System.out.println("进入StaffServiceImpl的insert()方法");
		staff.setRegisterDate(new Date());
		staff.setRoles("admin");
		int id=userMapper.insert(staff);
		staff.setCounselorId(id);
		staffDao.insert(staff);
	}

	@Override
	public List<Staff> queryAll() {
		System.out.println("进入StaffServiceImpl的queryAll()方法");
		return staffDao.queryAll();
	}

	@Override
	public StaffEntity queryById(long id) {
		System.out.println("进入StaffServiceImpl的queryById(long id)方法");
		return staffDao.queryById(id);
	}

	@Override
	public List<StaffEntity> queryForPageList(StaffParam param,
			PageBounds pageBounds) {
		System.out.println("进入StaffServiceImpl的queryForPageList()方法");
		return staffDao.queryForPageList(param, pageBounds);
	}

}
