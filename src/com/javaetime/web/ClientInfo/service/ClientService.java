package com.javaetime.web.ClientInfo.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.ClientEntity;
import com.javaetime.web.ClientInfo.param.ClientParam;
/**
 * @time 20150912
 * @author petter
 * QQ872024775
 */
public interface ClientService {
	
public List<ClientEntity> queryAll(PageBounds pageBounds,ClientParam param);
	
	public boolean addSave(ClientEntity ClientEntity);
	
	public boolean editSave(ClientEntity clientEntity);
	
	public boolean deleteSave(int id);
	
	public ClientEntity findById(int id);

	public List<ClientEntity> queryForPageList();
	
	public ClientEntity detail(int id);
	

	List<ClientEntity> queryForClientEntity(PageBounds pageBounds);
}
