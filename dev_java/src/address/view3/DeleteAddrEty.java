package address.view3;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeleteAddrEty {
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	public AddressVO delete(AddressVO vo) {
		System.out.println("DeleteAddrEty delete 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM mkaddrtb WHERE id=?");
		int id = vo.getId();
		int result =0;
		AddressVO raVO = new AddressVO();
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			raVO.setResult(result);
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(pstmt, con);
		}
		return raVO;
	}
	public AddressVO myBatisDelete(AddressVO vo) {
		System.out.println("DeleteAddrEty delete 호출 성공");
		
		SqlSessionFactory sqlMapper = null;
		String resource = "address/view3/MapperConfig.xml";
		SqlSession sqlSes = null;
		Reader reader = null;
		
		int result = 0;
		int id = vo.getId();
		AddressVO raVO = new AddressVO();
		try {
			reader  = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();	
			result = sqlSes.delete("deleteAddress", vo);
			sqlSes.commit();
			System.out.println("myBatisDelete : "+result);
			raVO.setResult(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return raVO;
	}

}
