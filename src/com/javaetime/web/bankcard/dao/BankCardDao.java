package com.javaetime.web.bankcard.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.BankCardEntity;
import com.javaetime.web.bankcard.param.BankCardParam;

public interface BankCardDao {
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<BankCardEntity> queryForPageList(BankCardParam param,PageBounds pageBounds);
	/**
	 * 添加银行卡
	 * @param bankCardEntity
	 */
	public void addSave(BankCardEntity bankCardEntity);
	/**
	 * 挂失银行卡
	 * @param bankCardEntity
	 * @return
	 */
	public boolean editSave(BankCardEntity bankCardEntity);
	/**
	 * 银行卡销户
	 * @param bankCardEntity
	 * @return
	 */
	public boolean deleteSave(BankCardEntity bankCardEntity);
	/**
	 * 根据ID删除一条记录
	 * @param id
	 * @return
	 */
	public boolean deleteById(long id);
	/**
	 * 根据账户和密码查询
	 * @param id
	 * @return
	 */
	public int queryById(BankCardEntity bankCardEntity);
	public List<BankCardEntity> queryByIdList(BankCardEntity bankCardEntity);
}
