package esd.scos.servlet;

import json.JSONArray;

import json.JSONException;
import json.JSONObject;
import org.jetbrains.annotations.Contract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FoodUpdateService extends HttpServlet {
    DataList data = new DataList();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("success");
        doGet(req, res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/json");
        String acceptjson = "";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream(), "utf-8"));
        StringBuffer stringBuffer = new StringBuffer("");
        String temp;
        while((temp = bufferedReader.readLine()) != null){
            stringBuffer.append(temp);
        }
        bufferedReader.close();
        acceptjson = stringBuffer.toString();
        System.out.println("json is"+acceptjson);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(acceptjson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String type = null;
        int update = 0;// = "Yes";
        try {
            type = jsonObject.getString("FoodType");
            update = jsonObject.getInt("newFood");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(acceptjson != "" && type!= ""){
            List<Data> coldFood = new ArrayList<>();
            coldFood.addAll(data.getData(type));
            String jsonStr = FoodIn2Json(coldFood);
            PrintWriter out = res.getWriter();
            out.write(jsonStr);
            out.close();
            System.out.println("菜单列表长度" + coldFood.size());
        }
    }

    public void init() throws ServletException {
    }

    @Contract("null -> !null")
    private String FoodIn2Json(List<Data> items){
        if (items == null) return "";
        JSONArray array = new JSONArray();
        JSONObject jsonObject = null;
        Data info = null;
        for (int i = 0; i < items.size(); i++) {
            info = items.get(i);
            jsonObject = new JSONObject();
            try {
                jsonObject.put("foodName", info.getName());
                jsonObject.put("foodPrice", info.getPrice());
                jsonObject.put("foodStoreNum", info.getNum());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            array.put(jsonObject);
        }
        return array.toString();
    }
}