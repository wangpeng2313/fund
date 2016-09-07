package com.javaetime.web.ClientInfo.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.ClientEntity;
import com.javaetime.web.ClientInfo.param.ClientParam;



/**
 * @time 20150912
 * @author petter
 * QQ872024775
 */
public interface ClientDao {
	
    public List<ClientEntity> queryAll(PageBounds pageBounds,ClientParam param);
	
	public boolean addSave(ClientEntity clientEntity);
	
	public boolean editSave(ClientEntity clientEntity);
	
	public boolean deleteSave(int id);
	
	public ClientEntity findById(int id);
	
	public ClientEntity detail(int id);
	
	public List<ClientEntity> queryForClientEntity(PageBounds pageBounds);



}
