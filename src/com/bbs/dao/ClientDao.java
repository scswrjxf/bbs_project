package com.bbs.dao;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bbs.pojo.ClientInvatationAnswer;
import com.bbs.pojo.ClientInvitation;
import com.bbs.pojo.Invitation;
import com.bbs.tools.BaseDao;

public class ClientDao {
	/**
	 * 把帖子保存到数据库中
	 * @param invitation--帖子
	 * @return 1-成功 0-失败
	 */
	public int saveInvitation(Invitation invitation) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = BaseDao.getCon();
			String sql = "insert into bbs_invitation("
				+ "invitationId,invitationTitle,invitationMessage,"
				+ "userId,plateId,invitationCreate,invitationModify) "
				+ "values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			return BaseDao.update(ps,new Object[] {
				invitation.getInvitationId(),invitation.getInvitationTitle(),
				invitation.getInvitationMessage(),invitation.getUserId(),
				invitation.getPlateId(),invitation.getInvitationCreate(),
				invitation.getInvitationModify()
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, null);
		}
		return 0;
	}
	/**
	 * 得到所有符合要求的帖子
	 * @param plateId--版块id
	 * @return 帖子列表
	 */
	public List<ClientInvitation> listInvitations(Integer plateId){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 保存所有帖子的列表
		List<ClientInvitation> invitations = new ArrayList<>();
		try {
			con = BaseDao.getCon();
			// 增加了条件，必须通过审核，才能显示
			String sql = "select invitationId,userAlice,invitationTitle,"
					+ "invitationCreate"
					+ " from bbs_invitation left join bbs_user" 
					+ " on bbs_invitation.userId=bbs_user.userId"
					+ " where bbs_invitation.isPass=1";
			if(plateId != null) {
				sql += " and plateId="+plateId;
			}
			sql += " order by invitationCreate desc";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,null);
			// 格式化日期时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 逐行把信息读取出来，放入列表中
			while(rs.next()) {
				invitations.add(
					new ClientInvitation(
							rs.getString("invitationId"),
							rs.getString("userAlice"),
							URLDecoder.decode(rs.getString("invitationTitle"),"UTF-8"),
							sdf.parse(rs.getString("invitationCreate")))
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, rs);
		}
		return invitations;
	}
	/**
	 * 根据帖子id查询帖子
	 * @param invitationId--帖子id
	 * @return 成功返回找到的帖子对象，失败返回null
	 */
	public ClientInvatationAnswer findInvitationById(String invitationId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ClientInvatationAnswer invitation = null;
		try {
			con = BaseDao.getCon();
			String sql = "select invitationId,invitationTitle,userPhoto,invitationMessage,userAlice"
					+ " from bbs_invitation left join bbs_user "
					+ "on bbs_invitation.userId=bbs_user.userId "
					+ "where invitationId=?";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,new Object[] {invitationId}); 
			// 逐行把信息读取出来，放入列表中
			if(rs.next()) {
				invitation = new ClientInvatationAnswer(
						rs.getString("invitationId"),
						URLDecoder.decode(rs.getString("invitationTitle"),"UTF-8"), 
						rs.getString("userPhoto"),
						URLDecoder.decode(rs.getString("invitationMessage"),"UTF-8"),
						rs.getString("userAlice")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, rs);
		}
		return invitation;
	}
}
