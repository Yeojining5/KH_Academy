package address.view3;

import java.util.List;
import java.util.Map;

public class AddressCtrl {

	private AddressVO returnVO = new AddressVO();
	private AddressVO inVO = new AddressVO();

	private static String _DEL = "delete";
	private static String _INS = "insert";
	private static String _MOD = "update";
	private static String _SEL = "select";
	private static String _ALL = "selectall";

	public AddressCtrl() {
	}

	public AddressVO send(AddressVO vo) {
		String command = vo.getCommand();

		if (command.equals(_DEL)) {
			DeleteAddrEty delEty = new DeleteAddrEty();
			returnVO = delEty.myBatisDelete(vo);
		} else if (command.equals(_INS)) {
			RegisterAddrEty insEty = new RegisterAddrEty();
//			returnVO = insEty.register(vo);
			returnVO = insEty.myBatisRegister(vo);
		} else if (command.equals(_MOD)) {
			ModifyAddrEty modEty = new ModifyAddrEty();
//			returnVO = modEty.modify(vo);
			returnVO = modEty.myBatisModify(vo);
		} else if (command.equals(_SEL)) {
			System.out.println("컨트롤 계층 - 상세보기 호출성공");
			RetrieveAddrEty selEty = new RetrieveAddrEty();
//			returnVO = selEty.retrieve(vo);
			returnVO = selEty.myBatisRetrieve(vo);
		}

		return returnVO;
	}

	public AddressVO[] send() {
		System.out.println("AddressCtrl send 호출 성공");
		AddressVO[] returnVOs = null;
		RetrieveAddrEty retEty = new RetrieveAddrEty();
		returnVOs = retEty.retrieve();			
		return returnVOs;
	}
	public List<Map<String,Object>> myBatisSend() {
		System.out.println("AddressCtrl myBatisSend 호출 성공");
		List<Map<String,Object>> addressList = null;
		RetrieveAddrEty retEty = new RetrieveAddrEty();
		addressList = retEty.myBatisRetrieve();			
		return addressList;
	}

//	public AddressVO myBatisRetrive(int id) {
//		AddressVO vo  = null;
//		RetrieveAddrEty retEty = new RetrieveAddrEty();
//		vo = retEty.myBatisRetrieve(id);
//		return vo;
//	}
	
}
	
