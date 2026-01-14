package iducs202012068.javaweb.fundmentals.controller;

import iducs202012068.javaweb.fundmentals.model.Blog;
import iducs202012068.javaweb.fundmentals.model.Member;
import iducs202012068.javaweb.fundmentals.repository.BlogDAO;
import iducs202012068.javaweb.fundmentals.repository.BlogDAOImpl;
import iducs202012068.javaweb.fundmentals.repository.MemberDAO;
import iducs202012068.javaweb.fundmentals.repository.MemberDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

@WebServlet(name = "BlogController", urlPatterns = {"/blogs/post-form.do", "/blogs/post.do", "/blogs/detail.do",
        "/blogs/get.do", "/blogs/delete.do", "/blogs/update.do"})
public class BlogController extends HttpServlet {
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(); // session 객체를 가져옴
        String uri = request.getRequestURI(); // URI 정보를 가져옴
        String action = uri.substring(uri.lastIndexOf("/") + 1); // 마지막 슬래시 뒷부분을 서브스트링화
        BlogDAO blogDAOImpl = new BlogDAOImpl();
        MemberDAO memberDAOImpl = new MemberDAOImpl();
        if(action.equals("post-form.do")) {
            Member member = new Member();
            member.setEmail((String) session.getAttribute("logined"));
            member.setName((String) session.getAttribute("name"));

            request.setAttribute("member", member);
            request.getRequestDispatcher("blog-post-form.jsp").forward(request, response);
        }
        else if(action.equals("post.do")) {
            int ret = 0;
            Blog m = new Blog();

            m.setTitle(request.getParameter("title"));
            m.setContent(request.getParameter("content"));
            m.setEmail(request.getParameter("email"));
            m.setAuthor(request.getParameter("author"));

            if((ret = blogDAOImpl.create(m)) > 0){
                request.setAttribute("message", "블로그 등록 성공");
                request.getRequestDispatcher("../status/success.jsp").forward(request, response);
            }
            else{
                request.setAttribute("message", "블로그 등록 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        } else if (action.equals("detail.do") && request.getParameter("id") !=null){
            Blog ret = new Blog();
            Blog blog = new Blog();
            blog.setId(Long.parseLong(request.getParameter("id")));
            // select * from where email = ?;
            if((ret = blogDAOImpl.read(blog)) != null){
                session.setAttribute("blog", ret);
                request.getRequestDispatcher("../blogs/detail-form.jsp").forward(request, response);

            } else {
                request.setAttribute("message", "블로그 조회 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        } else if (action.equals("get.do")){
            List<Blog> blogList = new ArrayList<Blog>();
            if((blogList = blogDAOImpl.readList()) != null){
                request.setAttribute("blogs", blogList);
                request.getRequestDispatcher("../blogs/list-view.jsp").forward(request, response);
            } else{
                request.setAttribute("message", "블로그 목록 조회 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        }
        else if (action.equals("delete.do")) {
            int ret = 0;
            Blog blog = new Blog();
            blog.setId(Long.parseLong(request.getParameter("id")));

            if ((ret = blogDAOImpl.delete(blog)) > 0) {
                session.invalidate();
                request.setAttribute("message", "블로그 삭제 성공");
                request.getRequestDispatcher("../status/success.jsp").forward(request, response);

            } else
            {
                request.setAttribute("message", "블로그 삭제 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        }
        else if (action.equals("update.do")) {
            String email = (String) session.getAttribute("logined");
            Member member = new Member();
            member.setEmail(email);
            Member retMember = null;
            int ret = 0;
            Blog blog = new Blog();
            blog.setTitle(request.getParameter("title"));
            blog.setContent(request.getParameter("content"));
            blog.setEmail(request.getParameter("email"));
            blog.setAuthor(request.getParameter("author"));
            blog.setId(Long.parseLong(request.getParameter("id")));
                if ((ret = blogDAOImpl.update(blog)) > 0) {
                    request.setAttribute("message", "블로그 업데이트 성공");
                    request.getRequestDispatcher("../status/success.jsp").forward(request, response);
            }else{
                request.setAttribute("message", "블로그 업데이트 실패");
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
    }
}
