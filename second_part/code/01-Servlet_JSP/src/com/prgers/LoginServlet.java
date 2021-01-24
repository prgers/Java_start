package com.prgers;

import com.prgers.bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * 当客户端发送的是GET请求，就会调用doGet方法
     * @param request   用来接收客户端发送的数据
     * @param response  用来给客户端发送数据(响应)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     *当客户端发送的是POST请求，就会调用doPost方法
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        doPlain(request, response);

//        doHTML(request, response);
        doFor(request, response);
    }

    private void doFor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //0.当从客户端请求过来的值是中文时， 要设置请求数据的编码
        request.setCharacterEncoding("UTF-8");

        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "_" + password);

        //3.响应客户端时， 要设置响应的内容类型
        response.setContentType("text/html;charset=UTF-8");

        /**
         * 拿到的这个输出流，不用程序员来close，系统自己管理
         */
        //4.拿到输出流
        PrintWriter out = response.getWriter();

        //5.判断
        if ("123".equals(username) && "123".equals(password)) {
            success(out);
        }else {
            failed(out);
        }
    }

    private List<Customer> getCustomers() {
        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Customer("张三", "1234565", "1"));
        }
        return list;
    }

    private void success(PrintWriter out) {
        out.write("<html>");
        out.write("<head>");
        out.write("</head>");
        out.write("<body>");
        out.write("<h1 style=\"color: blue; border: 1px solid black;\">登录成功</h1>");
        out.write("<table>");
        out.write("<thead>");
        out.write("<tr>");
        out.write("<th>姓名</th>");
        out.write("<th>电话</th>");
        out.write("<th>性别</th>");
        out.write("</tr>");
        out.write("</thead>");
        out.write("<tbody>");

        List<Customer> customers = getCustomers();
        for (Customer customer : customers) {
            out.write("<tr>");
            out.write("<td>" + customer.getName() + "</td>");
            out.write("<td>" + customer.getPhone() + "</td>");
            out.write("<td>" + customer.getSex() + "</td>");
            out.write("</tr>");
        }

        out.write("</tbody>");
        out.write("</table>");
        out.write("</body>");
        out.write("</html>");
    }

    private void failed(PrintWriter out) {
        out.write("<h1 style=\"color: red; border: 1px solid black;\">登录失败</h1>");
        out.write("<ul>");
        out.write("<li>重新登录</li>");
        out.write("</ul>");
    }


    private void doHTML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //0.当从客户端请求过来的值是中文时， 要设置请求数据的编码
        request.setCharacterEncoding("UTF-8");

        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "_" + password);

        //3.响应客户端时， 要设置响应的内容类型
        response.setContentType("text/html;charset=UTF-8");

        /**
         * 拿到的这个输出流，不用程序员来close，系统自己管理
         */
        //4.拿到输出流
        PrintWriter out = response.getWriter();

        //5.判断
        if ("123".equals(username) && "123".equals(password)) {
            out.write("<html>");
            out.write("<head>");
            out.write("<link rel=\"stylesheet\" href=\"http://localhost:8080/crm/login.css\">");
            out.write("</head>");
            out.write("<body>");
            out.write("<h1 style=\"color: blue; border: 1px solid black;\">登录成功</h1>");
            out.write("<ul>");
            out.write("<li>个人信息</li>");
            out.write("<li>修改密码</li>");
            out.write("<li>退出登录</li>");
            out.write("</ul>");
            out.write("</body>");
            out.write("</html>");
        }else {
            out.write("<h1 style=\"color: red; border: 1px solid black;\">登录失败</h1>");
            out.write("<ul>");
            out.write("<li>重新登录</li>");
            out.write("</ul>");
        }
    }

    private void doPlain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //0.当从客户端请求过来的值是中文时， 要设置请求数据的编码
        request.setCharacterEncoding("UTF-8");

        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "_" + password);

        //3.响应客户端时， 要设置响应的内容类型
        response.setContentType("text/plain;charset=UTF-8");

        /**
         * 拿到的这个输出流，不用程序员来close，系统自己管理
         */
        //4.拿到输出流
        PrintWriter out = response.getWriter();

        //5.判断
        if ("123".equals(username) && "123".equals(password)) {
            out.write("登录成功");
        }else {
            out.write("登录失败");
        }
    }
}
