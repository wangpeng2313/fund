package com.javaetime.web.ClientInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.ClientEntity;
import com.javaetime.web.ClientInfo.dao.ClientDao;
import com.javaetime.web.ClientInfo.param.ClientParam;
@Component
@Transactional
/**
 * @time 20150912
 * @author petter
 * QQ872024775
 */
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;
	@Override
	public boolean addSave(ClientEntity clientEntity) {
	return clientDao.addSave(clientEntity);
		
	}

	@Override
	public boolean deleteSave(int id) {
		return clientDao.deleteSave(id);
		
	}

	@Override
	public boolean editSave(ClientEntity clientEntity) {
		return clientDao.editSave(clientEntity);
	}

	@Override
	public ClientEntity findById(int id) {
		
		return clientDao.findById(id);
	}

	@Override
	public List<ClientEntity> queryAll(PageBounds pageBounds,ClientParam param) {
		return clientDao.queryAll(pageBounds,param );
	}

	@Override
	public List<ClientEntity> queryForPageList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClientEntity detail(int id) {
		// TODO Auto-generated method stub
		return clientDao.detail(id);
	}

	@Override
	public List<ClientEntity> queryForClientEntity(PageBounds pageBounds) {
		// TODO Auto-generated method stub
		return clientDao.queryForClientEntity(pageBounds);
	}






}
