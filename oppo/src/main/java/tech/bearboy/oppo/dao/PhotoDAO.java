package tech.bearboy.oppo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import tech.bearboy.oppo.client.Photo;
import tech.bearboy.oppo.common.Common;
/**
 * <p>spring--���ݷ��ʶ����ִ࣬�����ݿ���� </p>
 * <p>��Ŀ����: oppo </p> 
 * <p>�ļ�����: PhotoDAO.java </p> 
 * <p>����ʱ��: 2019��3��4�� </p>
 * @author ��ǰǰ
 * @version v1.0
 */
public class PhotoDAO {
	/**
	 * ��������Դ������applicationContext.xml�ڶ����bean
	 */
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * ��ѯʱ��Ϊ���������ͼƬ
	 * @param date ���������
	 * @return �������в�ѯ�����json�ַ���
	 */
	public String todayMsgJson(String date) {
		String s = "https://bearboy.tech/oppo/photos/";
		String jsonData = "";
		List<Photo> photos = new ArrayList<Photo>();
		String sql = "select * from photo where date=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Photo photo = new Photo();
				photo.setImgUrl(s + rs.getString("name") + ".jpg");
				photo.setMsg(rs.getString("msg"));
				photo.setTime(rs.getTime("time").toString());
				photo.setLocation(rs.getString("location"));
				photo.setText(rs.getString("text"));
				photo.setTarget(rs.getString("target"));
				photos.add(photo);
			}
			jsonData = new Common().listToJSON(photos);
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return jsonData;
	}
	/**
	 * ÿ�����ݿ��±���һ��ͼƬ����ÿ����һ��ͼƬ�������������¸�app
	 * @param id �±���ͼƬ��id��primary key
	 * @return �������һ��ͼƬ��json�ַ���
	 */
	public String currentImgJson(int id) {
		String s = "https://bearboy.tech/oppo/photos/";
		String jsonData = "";
		String sql = "select * from photo where id=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Photo photo = new Photo();
			if (rs.next()) {
				photo.setImgUrl(s + rs.getString("name") + ".jpg");
				photo.setMsg(rs.getString("msg"));
				photo.setTime(rs.getTime("time").toString());
				photo.setLocation(rs.getString("location"));
				photo.setText(rs.getString("text"));
				photo.setTarget(rs.getString("target"));
			}
			jsonData = new Common().beanToJSON(photo);
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return jsonData;
	}
	/**
	 * ���浱ǰʶ���ͼƬ�����ݿ�
	 * @param s ͼƬ�����ԣ��������֣�ʱ�䣬�ص㣬ʶ����
	 * @return ���ر�����ͼƬ��id�����ϸ��������������
	 */
	public int insertOneImg(String...s) {
		int id = 0;
		String sql = "insert into photo (name,text,target,msg,time,date,location) values (?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, s[0]);
			ps.setString(2, s[1]);
			ps.setString(3, s[2]);
			ps.setString(4, s[3]);
			ps.setString(5, s[4]);
			ps.setString(6, s[5]);
			ps.setString(7, s[6]);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next())
				id = rs.getInt(1);
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return id;
	}
}
