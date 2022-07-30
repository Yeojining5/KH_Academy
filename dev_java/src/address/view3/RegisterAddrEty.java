package address.view3;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class RegisterAddrEty {
	DBConnectionMgr 	dbMgr	= new DBConnectionMgr();
	Connection 			con		= null;
	PreparedStatement 	ps 		= null;
    /****************************************************************************
     * 회원등록 구현
	   INSERT INTO mkaddrtb(id, name, address, telephone
                          , gender, relationship, birthday
                          , comments, registedate)
                     values(11,'나신입','서울시 강남구 대치동','0105557777'
                           ,1, '회사동료', '1999-10-27'
                           ,'Front-End개발자', '2022-04-16')
     * @param vo - 사용자가 입력한 값 담기
     * @return - 등록 성공 여부 담기
     ***************************************************************************/
	public AddressVO register(AddressVO vo) {
		System.out.println("RegisterAddrEty register 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO mkaddrtb ");
		sql.append(" (name, address, telephone, gender, relationship, ");
		sql.append("  birthday, comments, registedate, id) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, to_char(sysdate,'YYYY-MM-DD'), seq_mkaddrtb_id.nextval)");
		try {
			int i=0;
			con = dbMgr.getConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setString(++i, vo.getName());
			ps.setString(++i, vo.getAddress());
			ps.setString(++i, vo.getTelephone());
			ps.setString(++i, vo.getGender());
			ps.setString(++i, vo.getRelationship());
			ps.setString(++i, vo.getBirthday());
			ps.setString(++i, vo.getComments());
			if(ps.executeUpdate() < 1) {
				String msg = "데이터 입력에 실패했습니다.";
				System.out.println(msg);
			} else {
				System.out.println("데이터 입력에 성공했습니다.");
				vo.setResult(1);
			}
		} catch(SQLException e) {
			String msg = "데이터 입력에 실패했습니다.";
			System.out.println(msg + "\r\n" + e);
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}		
		return vo;
	}////////////////////// end of register
	public AddressVO myBatisRegister(AddressVO vo) {// 조인시에는 어떤 타입을 선택?
		System.out.println("RegisterAddrEty register 호출 성공");
		//물리적으로 떨어져 있는 오라클 서버에 커넥션을 연결할때
		SqlSessionFactory sqlMapper = null;
		String resource = "address/view3/MapperConfig.xml";
		//쿼리문을 가지고 오라클서버에 요청하기
		//select(조회,조건검색,전체조회), insert(수강신청,필라테스신청,회원가입,주문등록, 예매등록), update, delete
		// sqlSes.selectOne():1건 , sqlSes.selectList():n건
		// sqlSes.insert("id",VO)
		SqlSession sqlSes = null;
		int result = 0;
		Reader reader = null;
		try {
			reader  = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();	
			System.out.println("address: "+vo.getAddress());
			System.out.println("name: "+vo.getName());
			System.out.println("gender: "+vo.getGender());
			System.out.println("telephone: "+vo.getTelephone());
			System.out.println("relationship: "+vo.getRelationship());
			System.out.println("birthday: "+vo.getBirthday());
			System.out.println("comments: "+vo.getComments());
			// 등록인데 delete메소드를 사용한 이유는 insert메소드의 리턴타입이 selectkey에 대한 
			// 반환값이므로 Object이기 때문에 사용하였다 - int 원함
			// update 메소드를 주더라도 같은 논리로 처리가 됨(id로 iml을 호출하니까...)
			result = sqlSes.update("insertAddress", vo);
			//result = sqlSes.delete("insertAddress", vo);
			sqlSes.commit();
			if(result < 1) {
				String msg = "데이터 입력에 실패했습니다.";
				System.out.println(msg);
			} else if(result==1) {
				System.out.println("데이터 입력에 성공했습니다.");
				vo.setResult(result);
			}
		} catch(Exception e) {
			String msg = "데이터 입력에 실패했습니다.";
			System.out.println(msg + "\r\n" + e);
		} 		
		return vo;
	}////////////////////// end of register

}////////////////////////// end of RegisterAddrEty


/*
INSERT INTO mkaddrtb(name, address, telephone, gender, relationship
,birthday, comments, registedate, id)
VALUES ('나신입', '서울시 영등포구 당산동', '010-555-7777'
, '1', 'JAVA과정동기', '19900712', '백엔드개발자', '20220325', seq_mkaddrtb_id.nextval)

SELECT * 
FROM mkaddrtb
WHERE id=13  

delete from mkaddrtb
where id=11 

commit        



CREATE SEQUENCE HR.SEQ_MKADDRTB_ID
START WITH 11
MAXVALUE 99999
MINVALUE 10
NOCYCLE
NOCACHE
NOORDER;

*/