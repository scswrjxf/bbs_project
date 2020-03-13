package com.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bbs.pojo.Plate;
import com.bbs.tools.BaseDao;

public class ManageDao {
	/**
	 * 添加新的板块
	 * @param plate
	 * @return @return 成功返回新添加的Plate对象 失败返回null
	 */
	public Plate addPlate(Plate plate) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = BaseDao.getCon();
			String sql = "insert into bbs_plate(plateTitle,plateMessage) values(?,?)";
			ps = con.prepareStatement(sql);
			BaseDao.update(ps,new Object[] {
				plate.getPlateTitle(),plate.getPlateMessage()
			});
			// 返回最后插入的那个自增的值
			sql = "select last_insert_id()";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,null);
			if(rs.next())
				plate.setPlateId(rs.getInt(1));
			// 把屏蔽信息设置为不屏蔽
			plate.setIsEnable(0);
			return plate;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, null);
		}
		return null;
	}
}
