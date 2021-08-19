package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.JhRr;
import com.oracle.s20210704.model.SyMemberVO;



@Repository
public class JhRrDaoImpl implements JhRrDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<JhRr> rrList() {
		List<JhRr> rrList = session.selectList("jhRrList");
		return rrList;
	}

	@Override
	public int total() {
		int tot = 0;
		System.out.println("JhRrDaoImpl Start total...");
		try {
			tot = session.selectOne("jhRrtotal");
			System.out.println("jhRrDaoImpl Start total...");
		} catch(Exception e) {
			System.out.println("jhRrDaoImpl total Exception-> "+e.getMessage());
		}
		return tot;
	}

	@Override
	public List<JhRr> listJhRr(JhRr jhRr) {
		List<JhRr> jhRrList = null;
		System.out.println("JhRrDaoImpl listjhRr Start...");
		try {
			jhRrList = session.selectList("jhRrListAll", jhRr);
		} catch(Exception e) {
			System.out.println("JhRrDaoImpl listjhRr Exception ->" + e.getMessage());
		}
		return jhRrList;
	}
	//삭제가능
	@Override
	public List<JhRr> listJhRr1(JhRr jhRr) {
		List<JhRr> jhRrList1 = null;
		System.out.println("JhRrDaoImpl listjhRr Start...");
		try {
			jhRrList1 = session.selectList("jhRrListAll1", jhRr);
		} catch(Exception e) {
			System.out.println("JhRrDaoImpl listjhRr Exception ->" + e.getMessage());
		}
		return jhRrList1;
	}
	@Override
	public List<JhRr> listJhRr2(JhRr jhRr) {
		List<JhRr> jhRrList2 = null;
		System.out.println("JhRrDaoImpl listjhRr Start...");
		try {
			jhRrList2 = session.selectList("jhRrListAll2", jhRr);
		} catch(Exception e) {
			System.out.println("JhRrDaoImpl listjhRr Exception ->" + e.getMessage());
		}
		return jhRrList2;
	}
	@Override
	public JhRr detail(int rr_num) {
		System.out.println("JhRrDaoImpl detail start...");
		JhRr jhRr = new JhRr();
		try {
			jhRr = session.selectOne("jhRrSelOne", rr_num);		
			System.out.println("JhRrDaoImpl detail getRrcontent->" + jhRr.getRr_content());
		} catch(Exception e) {
			System.out.println("JhRrDaoImpl detail Exception-> "+e.getMessage());
		}
		return jhRr;
	}

	@Override
	public SyMemberVO show(SyMemberVO vo) {
		System.out.println("JhRrDaoImpl SyMemberVO show start...");
		SyMemberVO syMemberVO = null;
		try {
			syMemberVO = session.selectOne("jhshow", vo);
			System.out.println("JhRrDaoImpl vo"+vo);
		} catch (Exception e) {
			System.out.println("JhRrDaoImplyu SyMemeberVO Exception->" + e.getMessage());
		}
		return syMemberVO;
	}

	@Override
	public int insert(JhRr jhRr) {
		int result = 0;
		System.out.println("JhRrDaoImpl insert Start...");
		try {
			result = session.insert("jhInsertJhRr", jhRr);
		} catch (Exception e ) {
			System.out.println("JhRrDaoImpl insert Exception -> "+e.getMessage());
		}
		return result;
	}
	@Override
	public int insert1(JhRr jhRr) {
		int result = 0;
		System.out.println("JhRrDaoImpl insert Start...");
		try {
			result = session.insert("jhInsertJhRr1", jhRr);
		} catch (Exception e ) {
			System.out.println("JhRrDaoImpl insert Exception -> "+e.getMessage());
		}
		return result;
	}
	//삭제가능
	@Override
	public int total0() {
		int tot0 = 0;
		System.out.println("JhRrDaoImpl Start total0...");
		try {
			tot0 = session.selectOne("jhRrtotal0");
			System.out.println("jhRrDaoImpl Start total...");
		} catch(Exception e) {
			System.out.println("jhRrDaoImpl total Exception-> "+e.getMessage());
		}
		return tot0;
	}
	
	//삭제가능
	@Override
	public int total1() {
		int tot1 = 0;
		System.out.println("JhRrDaoImpl Start total1...");
		try {
			tot1 = session.selectOne("jhRrtotal1");
			System.out.println("jhRrDaoImpl Start total...");
		} catch(Exception e) {
			System.out.println("jhRrDaoImpl total Exception-> "+e.getMessage());
		}
		return tot1;
	}
	//삭제가능
	@Override
	public int total2() {
		int tot2 = 0;
		System.out.println("JhRrDaoImpl Start total2...");
		try {
			tot2 = session.selectOne("jhRrtotal2");
			System.out.println("jhRrDaoImpl Start total...");
		} catch(Exception e) {
			System.out.println("jhRrDaoImpl total Exception-> "+e.getMessage());
		}
		return tot2;
	}
	//삭제가능
	@Override
	public int total3() {
		int tot3 = 0;
		System.out.println("JhRrDaoImpl Start total3...");
		try {
			tot3 = session.selectOne("jhRrtotal3");
			System.out.println("jhRrDaoImpl Start total...");
		} catch(Exception e) {
			System.out.println("jhRrDaoImpl total Exception-> "+e.getMessage());
		}
		return tot3;
	}
	//수정
	@Override
	public int update(JhRr jhRr) {
		System.out.println("JhRrDaoImpl update Start...");
		int cu = 0;
		try {
			cu = session.update("jhClubUpdate", jhRr);
		} catch (Exception e) {
			System.out.println("jhRrDaoImpl update Exception -> " +e.getMessage());
		}
		return cu;
	}
	//삭제
	@Override
	public int delete(int rr_num) {
		int result = 0;
		System.out.println("JhRrDaoImpl delete Start...");
		try {
			result = session.delete("jhDelete",rr_num);
			System.out.println("JhRrDaoImpl delete result-> " +result);
		} catch(Exception e) {
			System.out.println("JhRrDaoImpl delete Exception -> " +e.getMessage());
		}
		return result;
	}

	@Override
	public String depNum(int emp_num) {
		String depnum = null;
		System.out.println("JhCalendarDaoImpl depNum Start..");
		try {
			depnum = session.selectOne("deptNum", emp_num);
		} catch(Exception e) {
			System.out.println("JhCalendarDaoImpl depNum Exception -> " + e.getMessage());
		}
		return depnum;
	}

}
