package com.bbs.service;

import com.bbs.dao.ManageDao;
import com.bbs.pojo.Plate;

public class ManageService {
	// 创建一个ManageDao 对象
	private ManageDao manageDao = new ManageDao();
	/**
	 * 添加新的板块
	 * @param plate
	 * @return 成功返回新添加的Plate对象 失败返回null
	 */
	public Plate addPlate(Plate plate) {
		return manageDao.addPlate(plate);
	}
}
