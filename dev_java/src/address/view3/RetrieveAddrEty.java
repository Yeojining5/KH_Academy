package address.view3;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class RetrieveAddrEty {
	// 이른 인스턴스화 (게으른 인스턴스화)
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs 		= null;
	/***************************************************************************
	 * 회원정보 중 상세보기 구현 - 1건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
        WHERE id = 5
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO retrieve(AddressVO vo) {
		System.out.println("RetrieveAddrEty retrieve(AddressVO vo) 호출 성공");
		AddressVO rVO = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, telephone, gender         ");
	    sql.append("      ,relationship, birthday, comments, registedate"); 
	    sql.append("  FROM mkaddrtb                                     ");
	    sql.append(" WHERE id = ?");
	    // AddressBook에서 선택한 로우의 id값 담기
	    int id = vo.getId();
	    try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//게으른 인스턴스화
				rVO = new AddressVO();
				rVO.setName(rs.getString("name"));
				rVO.setAddress(rs.getString("address"));
				rVO.setTelephone(rs.getString("telephone"));
				rVO.setGender(rs.getString("gender"));
				rVO.setRelationship(rs.getString("relationship"));
				rVO.setBirthday(rs.getString("birthday"));
				rVO.setComments(rs.getString("comments"));
				rVO.setRegistedate(rs.getString("registedate"));
				// 이코드를 쓰지 않는자 와 쓰는자  그 차이 - 한끝차이
				rVO.setId(rs.getInt("id"));
				// 상세보기에서는 id가 필요 없지만 수정처리할 때는 id가 필요하니까 넣어두자
				// UPDATE mkaddrtb set address = "서울시 영등포구" WHERE id = ?
			}
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e) {
			e.printStackTrace();// 에러 스택에 쌓여 있는 로그 정보 출력해줌.라인번호도 같이
		} finally {
			// DB연동에서 사용한 자원 반납하기 - 노출가능, 위변조
			dbMgr.freeConnection(rs, pstmt, con);
		}
		//return null;
		return rVO;
	}
	/***************************************************************************
	 * 회원 목록 보기 구현 - n건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO[] retrieve() {
		System.out.println("RetrieveAddrEty retrieve() 호출 성공");		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, telephone, gender         ");
	    sql.append("      ,relationship, birthday, comments, registedate"); 
	    sql.append("  FROM mkaddrtb                                     ");
	    AddressVO[] vos = null;
	    try {
			con = dbMgr.getConnection();
			// 커넥션이 생성되고 나면 오라클 서버에 DML문을 가져가 요청해주는 PreparedStatement 생성되야함
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Vector<AddressVO> v = new Vector<>();
			AddressVO rVO = null;
			while(rs.next()) {
				rVO = new AddressVO(rs.getString("name")
						           ,rs.getString("address")
						           ,rs.getString("telephone")
						           ,rs.getString("gender")
						           ,rs.getString("relationship")
						           ,rs.getString("birthday")
						           ,rs.getString("comments")
						           ,rs.getString("registedate")
						           ,rs.getInt("id")
						           );
				v.add(rVO);// v.size()-> 배열의 크기 결정해야 함
			}////////end of while
			vos = new AddressVO[v.size()];
			v.copyInto(vos);
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e) {
			e.printStackTrace();// 에러 스택에 쌓여 있는 로그 정보 출력해줌.라인번호도 같이
		} finally {
			// DB연동에서 사용한 자원 반납하기
			dbMgr.freeConnection(rs, pstmt, con);
		}
		return vos;
	}
	// iBatis <-- myBatis, JDO, hibernate,......
	public List<Map<String,Object>> myBatisRetrieve() {
		//MapperConfig.xml에서 오라클 서버 정보 읽어서 커넥션 연결
		//JDBC API를 활용할 때와는 다르게 DBConnectionMgr은 사용하지 않음
		SqlSessionFactory sqlMapper = null;
		//SqlSessionFactory와 의존관계에 있어 반드시 먼저 생성된 후에 야 SqlSession객체 생성가능함
		SqlSession sqlSes = null;
		//호출 유무
		System.out.println("RetrieveAddrEty myBatisRetrieve() 호출 성공");	
		// 물리적으로 떨어져 있는 오라클 서버의 접속을 위한 정보 담음
		// 컴파일을 하지 않아도 된다. 그래서 버전관리 용이 - spring 프레임워크 - xml 모르는 - 어노테이션
		String resource = "address/view3/MapperConfig.xml";
		// IO클래스 통하여 xml스캔한다 - 커넥션, 연결통로
		Reader reader = null;
		List<Map<String,Object>> addressList = null;
		try {
			reader  = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			//I/O, network, JDBC API -  명시적으로 자원 반납할 것을 권장하고 있음 - 자바튜닝팀
			reader.close();
			//mkaddrtb.xml에 등록된 아이디로 쿼리문 호출
			addressList = sqlSes.selectList("retrieveAll");
			System.out.println(addressList);
		} catch (Exception e) {
			e.printStackTrace();// 에러 스택에 쌓여 있는 로그 정보 출력해줌.라인번호도 같이
		}
		return addressList;
	}
	
	public AddressVO myBatisRetrieve(AddressVO vo) {
		System.out.println("RetrieveAddrEty retrieve(AddressVO vo) 호출 성공");
		AddressVO rVO = null;
		
		SqlSessionFactory sqlMapper = null;
		SqlSession sqlSes = null;
		String resource = "address/view3/MapperConfig.xml";
		Reader reader = null;
		
		int id = vo.getId();
//		rVO = sqlSes.selectOne("retrieve", id);
		
	    try {
	    	reader  = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader); // 물리적인 정보 저장
			sqlSes = sqlMapper.openSession();
			rVO = sqlSes.selectOne("retrieve", vo);
			System.out.println("조회 결과 ---->"+rVO);
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();// 에러 스택에 쌓여 있는 로그 정보 출력해줌.라인번호도 같이
		} 
		
		return rVO;
	}
	
	
}

/*
ID,NAME,ADDRESS,TELEPHONE,GENDER,RELATIONSHIP,BIRTHDAY,COMMENTS,REGISTEDATE
3,나초보,서울시 마포구 공덕동,025556968,2,2,19801215,주연테크,REGISTEDATE
1,홍길동,서울시 영등포구 당산동,111,1,동창,19901010,222,20081117
2,이순신,서울시 서초구 양재동,222,2,회사동료,19901110,333,20100113
4,강감찬,경기도 광명시,11,1,동창,19801120,테스트합니다.,2011-03-20
9,나초조,4455,44455,1,44555,19800702,자영업,20110320
7,223,223,223,2,223,223,223,20190609
10,조조,경기도 화성시,44455,1,44555,19800702,자영업,20110320
*/