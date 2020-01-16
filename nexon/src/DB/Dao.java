package DB;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Dto;
import paging.Paging;

public class Dao {
	SqlSessionFactory sqlSessionfactory;
	public Dao(SqlSessionFactory factory) {
		this.sqlSessionfactory=factory;
	}
	public List<Dto> view(Paging page) {
		List<Dto> list=new ArrayList<>();
		SqlSession sqlSession=sqlSessionfactory.openSession();
		list=sqlSession.selectList("memo.board", page);
		sqlSession.close();
		return list;
		
	}
	public List<Dto> view2(Paging page) {
		List<Dto> list=new ArrayList<>();
		SqlSession sqlSession=sqlSessionfactory.openSession();
		list=sqlSession.selectList("memo.board2",page);
		sqlSession.close();
		return list;
		
	}
	public Dto detailView(int no) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		Dto dto=sqlSession.selectOne("memo.detail",no);
		sqlSession.close();
		return dto;
	}
	public void delete(int no) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		sqlSession.delete("memo.delete",no);
		sqlSession.commit();
		sqlSession.close();
	}
	public void write(Dto dto) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		sqlSession.insert("memo.insert", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	public void edit(Dto dto) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		sqlSession.update("memo.update", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	public List<Dto> search(String search) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		List<Dto> list=sqlSession.selectList("memo.search", search);
		System.out.println(search);
		sqlSession.close();
		return list;
	}
	public List<Dto> gamesearch(String search) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		List<Dto> list=sqlSession.selectList("memo.gamesearch", search);
		System.out.println(search);
		sqlSession.close();
		return list;
}
	public void register(Dto dto) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		sqlSession.insert("member.register", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	public String regfound(String id) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		String dbid=sqlSession.selectOne("member.selectReg",id);
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
	public int idcheck(String id) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		int n=sqlSession.selectOne("member.idcheck",id);
		sqlSession.close();
		return n;
	}
	public Dto logincheck(Dto dto) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		Dto list=sqlSession.selectOne("member.logincheck", dto);
		sqlSession.close();
		return list;
	}
	public List<Dto> userview(Paging page) {
		List<Dto> list=new ArrayList<>();
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
	public List<Dto> usersearch(String search) {
		SqlSession sqlSession=sqlSessionfactory.openSession();
		List<Dto> list=sqlSession.selectList("member.usersearch", search);
		System.out.println(search);
		sqlSession.close();
		return list;
	}
	public List<Dto> mobilesearch(String search) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		List<Dto> list=sqlsession.selectList("memo.mobilesearch",search);
		sqlsession.close();
		return list;
	}
	public List<Dto> Kindsearch(String search) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		List<Dto> list=sqlsession.selectList("memo.kindsearch",search);
		sqlsession.close();
		return list;
	}
	public void reply(Dto dto) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		sqlsession.insert("memo.replywrite",dto);
		sqlsession.commit();
		sqlsession.close();
	}
	public List<Dto> detailreply(int no) {
		SqlSession sqlsession=sqlSessionfactory.openSession();
		List<Dto> list=sqlsession.selectList("memo.replyview",no);
		sqlsession.close();
		return list;
	}
	public void replydelete(Dto dto) {
		SqlSession sqlsession=sqlSessionfactory.openSession();		
		sqlsession.delete("memo.replydelete",dto);
		sqlsession.commit();
		sqlsession.close();
	}
	public void changeinfo(Dto dto) {
		SqlSession sqlsession=sqlSessionfactory.openSession();		
		sqlsession.update("member.infoview",dto);
		sqlsession.commit();
		sqlsession.close();
	}
	public int pwcheck(Dto dto) {
		SqlSession sqlsession=sqlSessionfactory.openSession();		
		int n=sqlsession.selectOne("member.pwcheck",dto);
		sqlsession.close();
		return n;
	}
	}
