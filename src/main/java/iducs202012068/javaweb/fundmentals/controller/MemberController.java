package iducs202012068.javaweb.fundmentals.controller;

import iducs202012068.javaweb.fundmentals.model.Member;
import iducs202012068.javaweb.fundmentals.repository.MemberDAO;
import iducs202012068.javaweb.fundmentals.repository.MemberDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MemberController", urlPatterns = {"/members/create.do", "/members/list.do","/members/update.do", "/members/delete.do",
"/members/detail.do", "/members/login.do", "/members/logout.do"})
public class MemberController extends HttpServlet {
    MemberDAO memberDAOImpl = new MemberDAOImpl(); //Data Access Object 생성

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String uri = request.getRequestURI(); // URI 정보를 가져옴
        String action = uri.substring(uri.lastIndexOf("/") + 1);
        //uri가 http://localhos:8080/members/list 인 경우
        // list 단어의 시작점 : uri.lastIndexOf('/')+1

        if (action.equals("list.do")) {
            List<Member> memberList = memberDAOImpl.readList(); // JCF : Java Collection Framework, 집합 개체 조작
            if (memberList != null) {
                request.setAttribute("members", memberList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            } else {

            }
        } else if (action.equals("create.do")) {
            request.setCharacterEncoding("UTF-8");
            int ret = 0;
            Member m = new Member();
            m.setEmail(request.getParameter("email"));
            m.setPw(request.getParameter("pw"));
            m.setName(request.getParameter("name"));
            m.setPhone(request.getParameter("phone"));
            m.setAddress(request.getParameter("address"));

            if ((ret = memberDAOImpl.create(m)) > 0) {
                request.setAttribute("message", "회원가입 성공");
                request.getRequestDispatcher("../status/success.jsp").forward(request, response);

            } else {
                request.setAttribute("message", "회원가입 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        } else if (action.equals("update.do")) {
            int ret = 0;
            Member m = new Member();
            m.setEmail(request.getParameter("email"));
            m.setPw(request.getParameter("pw"));
            m.setName(request.getParameter("name"));
            m.setPhone(request.getParameter("phone"));
            m.setAddress(request.getParameter("address"));

            if ((ret = memberDAOImpl.update(m)) > 0) {
                request.setAttribute("message", "정보 업데이트 성공");
                request.getRequestDispatcher("../status/success.jsp").forward(request, response);

            } else{
                request.setAttribute("message", "정보 업데이트 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        } else if (action.equals("detail.do")){
            String email = (String) session.getAttribute("logined");
            Member member = new Member();
            member.setEmail(email);
            Member retMember = null;
            // select * from where email = ?;
            if((retMember = memberDAOImpl.read(member)) != null){
                session.setAttribute("m", retMember);
                request.setAttribute("message", retMember.getName()+"님 환영합니다.");
                request.getRequestDispatcher("../members/detail-form.jsp").forward(request, response);
                System.out.println(retMember.getAddress());

            } else {
                request.setAttribute("message", "회원 조회 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        }
        else if (action.equals("delete.do")) {
            int ret = 0;
            Member m = new Member();
            m.setEmail(request.getParameter("email"));
            m.setPw(request.getParameter("pw"));

            if ((ret = memberDAOImpl.delete(m)) > 0) {
                session.invalidate();
                request.setAttribute("message", "지금까지 이용해주셔서 감사합니다.");
                request.getRequestDispatcher("../status/success.jsp").forward(request, response);

            } else
            {
                request.setAttribute("message", "오류: 회원탈퇴 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        } else if (action.equals("login.do")){
            String email = request.getParameter("email");
            String pw = request.getParameter("pw");
            Member member = new Member();
            member.setEmail(email);
            member.setPw(pw);
            Member retMember = null;
            if((retMember = memberDAOImpl.login(member)) != null){
                //page -> request -> application 객체에 속성을 유지
                session.setAttribute("logined", retMember.getEmail());
                session.setAttribute("name", retMember.getName());
                request.setAttribute("message", retMember.getName() + "님 환엽합니다.");
                request.getRequestDispatcher("../main/index.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "로그인 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        } else if (action.equals("logout.do")){
            session.invalidate();
            request.getRequestDispatcher("../members/login-form.jsp").forward(request, response);

        }
    }

        //doPost


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}
