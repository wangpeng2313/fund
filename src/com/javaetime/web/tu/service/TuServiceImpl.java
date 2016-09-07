package com.javaetime.web.tu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaetime.web.tu.dao.TuDaoImpl;


public class TuServiceImpl implements TuService {

	private TuDaoImpl tuDao=new TuDaoImpl();

	@Override
	public Map<String, Object> queryBing() throws ClassNotFoundException,
			SQLException {
		int map_xiaoxue=tuDao.executeQueryForInt("SELECT COUNT(*) FROM `dictionary` d,`staff_info` s WHERE d.`DICTIONARY_KEY`=s.`EDUCATION` AND d.`DICTIONARY_VALUE`='小学'");
		int map_zhongxue=tuDao.executeQueryForInt("SELECT COUNT(*) FROM `dictionary` d,`staff_info` s WHERE d.`DICTIONARY_KEY`=s.`EDUCATION` AND d.`DICTIONARY_VALUE`='中学'");
		int map_gaozhong=tuDao.executeQueryForInt("SELECT COUNT(*) FROM `dictionary` d,`staff_info` s WHERE d.`DICTIONARY_KEY`=s.`EDUCATION` AND d.`DICTIONARY_VALUE`='高中'");
		int map_zhuanke=tuDao.executeQueryForInt("SELECT COUNT(*) FROM `dictionary` d,`staff_info` s WHERE d.`DICTIONARY_KEY`=s.`EDUCATION` AND d.`DICTIONARY_VALUE`='大学专科'");
		int map_benke=tuDao.executeQueryForInt("SELECT COUNT(*) FROM `dictionary` d,`staff_info` s WHERE d.`DICTIONARY_KEY`=s.`EDUCATION` AND d.`DICTIONARY_VALUE`='大学本科'");
		int map_boshi=tuDao.executeQueryForInt("SELECT COUNT(*) FROM `dictionary` d,`staff_info` s WHERE d.`DICTIONARY_KEY`=s.`EDUCATION` AND d.`DICTIONARY_VALUE`='博士'");
		int map_shuoshi=tuDao.executeQueryForInt("SELECT COUNT(*) FROM `dictionary` d,`staff_info` s WHERE d.`DICTIONARY_KEY`=s.`EDUCATION` AND d.`DICTIONARY_VALUE`='硕士/研究生'");
		int map_boshihou=tuDao.executeQueryForInt("SELECT COUNT(*) FROM `dictionary` d,`staff_info` s WHERE d.`DICTIONARY_KEY`=s.`EDUCATION` AND d.`DICTIONARY_VALUE`='博士后'");
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("map_xiaoxue", map_xiaoxue);
		map.put("map_zhongxue", map_zhongxue);
		map.put("map_gaozhong", map_gaozhong);
		map.put("map_zhuanke", map_zhuanke);
		map.put("map_benke", map_benke);
		map.put("map_shuoshi", map_shuoshi);
		map.put("map_boshi", map_boshi);
		map.put("map_boshihou", map_boshihou);
		return map;
	}

	@Override
	public List<String[]> queryzhu() throws ClassNotFoundException,
			SQLException {
		List<String[]> list=new ArrayList<String[]>();
		Map<String,Object> map_shouRu;
		Map<String,Object> map_zhiChu;
		Map<String,Object> map_yuSuan;
		
		String[] jinEr_shouRu=new String[12];
		String[] jinEr_zhiChu=new String[12];
		String[] jinEr_yuSuan=new String[12];
		for(int i=0;i<12;i++){
			if(i<10){
				map_shouRu=tuDao.executeQueryForMap("select * from shouru where riqi='2013-0"+(i+1)+"-01'");
				map_zhiChu=tuDao.executeQueryForMap("select * from zhichu where riqi='2013-0"+(i+1)+"-01'");
				map_yuSuan=tuDao.executeQueryForMap("select * from yusuan where riqi='2013-0"+(i+1)+"-01'");
				
			}else{
				map_shouRu=tuDao.executeQueryForMap("select * from shouru where riqi='2013-"+(i+1)+"-01'");
				map_zhiChu=tuDao.executeQueryForMap("select * from zhichu where riqi='2013-"+(i+1)+"-01'");
				map_yuSuan=tuDao.executeQueryForMap("select * from yusuan where riqi='2013-"+(i+1)+"-01'");
			}
			jinEr_shouRu[i]=map_shouRu.get("shouRuJinEr")+"";
			jinEr_zhiChu[i]=map_zhiChu.get("zhiChuJinEr")+"";
			jinEr_yuSuan[i]=map_yuSuan.get("yuSuanJinEr")+"";
		}
			list.add(0,jinEr_shouRu);
			list.add(1, jinEr_zhiChu);
			list.add(2, jinEr_yuSuan);
		return list;
	}
	

}
