package iducs202012068.javaweb.fundmentals.repository;

import iducs202012068.javaweb.fundmentals.model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl extends OracleDAO implements MemberDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public int create(Member m) {
        int ret = 0;
        String sql = "insert into member values(seq_member.nextval,?,?,?,?,?)";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getEmail());
            pstmt.setString(2, m.getPw());
            pstmt.setString(3, m.getName());
            pstmt.setString(4, m.getPhone());
            pstmt.setString(5, m.getAddress());
            ret = pstmt.executeUpdate();
            if(ret <=0)
                throw new SQLException("등록 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return ret;
        }
    }

    @Override
    public Member read(Member m) {
        Member retMember = null;
        String sql = "select * from member where email = ?";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getEmail());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retMember = new Member();
                retMember.setEmail(rs.getString("email")); // DBMS records == resultSet 필드 이름
                retMember.setName(rs.getString("name"));
                retMember.setPw(rs.getString("pw"));
                retMember.setPhone(rs.getString("phone"));
                retMember.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return retMember;
        }
    }
    @Override
    public List<Member> readList() {
        List<Member> memberList = null;
        Member retMember = null;
        String sql = "select * from member";
        try{
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            memberList = new ArrayList<Member>();
            while (rs.next()){
                retMember = new Member();
                retMember.setEmail(rs.getString("email")); // DBMS records == resultSet 필드 이름
                retMember.setName(rs.getString("name"));
                retMember.setPw(rs.getString("pw"));
                retMember.setPhone(rs.getString("phone"));
                retMember.setAddress(rs.getString("address"));
                memberList.add(retMember);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return memberList;
        }
    }

    @Override
    public int update(Member m) {
        int ret = 0;
        String sql = "update member set name=?, phone=?, address=? where email=?"; // ?: placeholder
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getName());
            pstmt.setString(2, m.getPhone());
            pstmt.setString(3, m.getAddress());
            pstmt.setString(4, m.getEmail());
            ret = pstmt.executeUpdate(); // SQL 실행 후 결과를 rs에 반환,
            if(ret <=0)
                throw new SQLException("수정 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return ret;
        }
    }

    @Override
    public int delete(Member m) {

        int ret = 0;
        String sql = "delete from member where email=? and pw=?"; // ?: placeholder
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getEmail());
            pstmt.setString(2, m.getPw());
            ret = pstmt.executeUpdate(); // SQL 실행 후 결과를 rs에 반환,
            if(ret <=0)
                throw new SQLException("삭제 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return ret;
        }
    }

    @Override
    public Member login(Member m) {
        Member retMember = null;
        String sql = "select * from member where email=? and pw=?";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getEmail());
            pstmt.setString(2, m.getPw());
            rs = pstmt.executeQuery();
            if(rs.next()){
                retMember = new Member();
                retMember.setEmail(rs.getString("email"));
                retMember.setPw(rs.getString("pw"));
                retMember.setName(rs.getString("name"));
                retMember.setPhone(rs.getString("phone"));
                retMember.setAddress(rs.getString("address"));

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return retMember;
        }
    }
}
