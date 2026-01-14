package iducs202012068.javaweb.fundmentals;

import java.io.*;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {// 서블릿 객체를 생성할 때
    private String message;

    public void init() {
        message = "Hello World!";
        System.out.println("init()");
    }

    //객체로부터 생성된 스레드가 요청을 처리할 때
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException, ServletException {
        response.setContentType("text/html");
        System.out.println(request.getParameter("fullname"));
        System.out.println(request.getParameter("email"));

        request.getRequestDispatcher("/member/about.jsp").forward(request, response);
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}