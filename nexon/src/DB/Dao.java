package DB;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.BoardDto;
import model.GameDto;
import model.MemberDto;
import paging.Paging;

public class Dao {
	SqlSessionFactory sqlSessionfactory;
	public Dao(SqlSessionFactory factory) {
		this.sqlSessionfactory=factory;
	}
	public List<BoardDto> view(Paging page) {
		List<BoardDto> list=new ArrayList<>();
		SqlSession sqlSession=sqlSessionfactory.openSession();
		list=sqlSession.selectList("memo.board", page);
		sqlSession.close();
		return list;
		
	}
	public List<BoardDto> view2(Paging page) {
		List<BoardDto> list=new ArrayList<>();
		SqlSession sqlSession=sqlSessionfactory.openSession();
		list=sqlSession.selectList("memo.board2",page);
		sqlSession.close();
		return list;
		
	}
	public BoardDto detailView(int no) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		BoardDto dto=sqlSession.selectOne("memo.detail",no);
		sqlSession.close();
		return dto;
	}
	public void delete(int no) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		sqlSession.delete("memo.delete",no);
		sqlSession.commit();
		sqlSession.close();
	}
	public void write(BoardDto dto) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		sqlSession.insert("memo.insert", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	public void edit(BoardDto dto) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		sqlSession.update("memo.update", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	public List<BoardDto> search(String search) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		List<BoardDto> list=sqlSession.selectList("memo.search", search);
		System.out.println(search);
		sqlSession.close();
		return list;
	}
	public List<BoardDto> gamesearch(String search) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		List<BoardDto> list=sqlSession.selectList("game.gamesearch", search);
		System.out.println(search);
		sqlSession.close();
		return list;
}
	public void register(MemberDto dto) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		sqlSession.insert("member.user", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	public String regfound(String email) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		String dbid=sqlSession.selectOne("member.selectReg",email);
		sqlSession.close();
		return dbid;
	}
	public int count() {
		int tot=0;
		SqlSession sqlSession=sqlSessionfactory.openSession();
		tot=sqlSession.selectOne("memo.count");
		sqlSession.close();
		return tot;
	}
	public int idcheck(String email) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		int n=sqlSession.selectOne("member.idcheck",email);
		sqlSession.close();
		return n;
	}
	public MemberDto logincheck(MemberDto dto) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		MemberDto list=sqlSession.selectOne("member.logincheck", dto);
		sqlSession.close();
		return list;
	}
	public List<MemberDto> userview(Paging page) {
		List<MemberDto> list=new ArrayList<>();
		SqlSession sqlSession=sqlSessionfactory.openSession();
		list=sqlSession.selectList("member.user", page);
		sqlSession.close();
		return list;
	}
	public void deleteuser(int no) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		sqlsession.delete("member.userdelete",no);
		sqlsession.commit();
		sqlsession.close();
	}
	public List<MemberDto> usersearch(String search) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		List<MemberDto> list=sqlSession.selectList("member.usersearch", search);
		System.out.println(search);
		sqlSession.close();
		return list;
	}
	public List<GameDto> mobilesearch(String search) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		List<GameDto> list=sqlsession.selectList("game.mobilesearch",search);
		sqlsession.close();
		return list;
	}
	public List<GameDto> Kindsearch(String search) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		List<GameDto> list=sqlsession.selectList("game.kindsearch",search);
		sqlsession.close();
		return list;
	}
	public void reply(BoardDto dto) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		sqlsession.insert("memo.replywrite",dto);
		sqlsession.commit();
		sqlsession.close();
	}
	public List<BoardDto> detailreply(int no) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		List<BoardDto> list=sqlsession.selectList("memo.replyview",no);
		sqlsession.close();
		return list;
	}
	public void replydelete(BoardDto dto) {
		SqlSession sqlsession=sqlSessionfactory.openSession();		
		sqlsession.delete("memo.replydelete",dto);
		sqlsession.commit();
		sqlsession.close();
	}
	public void changeinfo(MemberDto dto) {
		SqlSession sqlsession=sqlSessionfactory.openSession();		
		sqlsession.update("member.infoview",dto);
		sqlsession.commit();
		sqlsession.close();
	}
	public int pwcheck(MemberDto dto) {
		SqlSession sqlsession=sqlSessionfactory.openSession();		
		int n=sqlsession.selectOne("member.pwcheck",dto);
		sqlsession.close();
		return n;
	}
	}
