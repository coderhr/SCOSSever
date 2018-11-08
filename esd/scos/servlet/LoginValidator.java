package esd.scos.servlet;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;



public class LoginValidator extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("发送get请求");
        doPost(req, res);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/json");
        String acceptjson = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream(), "utf-8"));
            StringBuffer stringBuffer = new StringBuffer("");
            String temp;
            while((temp = bufferedReader.readLine()) != null){
                stringBuffer.append(temp);
            }
            bufferedReader.close();
            acceptjson = stringBuffer.toString();
            System.out.println("json is"+acceptjson);
            if(acceptjson.equals("{\"nameStr\":\"huang\",\"passwordStr\":\"123456\"}")){
                System.out.println("get the json successfully");
                String jsonStr ="{\"RESULTCODE\":\"1\"}";
                PrintWriter out = res.getWriter();
                out.write(jsonStr);
                out.close();
            }
            else{
                System.out.println("get the json failed");
                String jsonStr ="{\"RESULTCODE\":\"0\"}";
                PrintWriter out = res.getWriter();
                out.write(jsonStr);
                out.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void init() throws ServletException{
        // Put your code here
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }
}

/*import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginValidator extends HttpServlet {

    public boolean isRight (String account, String password){
        boolean flag = false;

        if(account.equals("huang")&&password.equals("123456")) {
            flag = true;
        }
        return flag;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        System.out.println("发送get请求");
        doPost(req, res);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        System.out.println(account);
        System.out.println(password);
        System.out.println("get the json successfully");

        boolean flag1 = isRight(account, password);

        if(flag1 == true) {

            System.out.println("get the json successfully");
            String Str ="{\"RESULTCODE\":\"1\"}";
            PrintWriter out = res.getWriter();
            out.write(Str);
            out.close();
        }else {
            System.out.println("get the json failed");
            String Str ="{\"RESULTCODE\":\"0\"}";
            PrintWriter out = res.getWriter();
            out.write(Str);
            out.close();
        }

        res.setContentType("text/JSON;charset=UTF-8");
        System.out.println("发送post方法");
    }

}*/