package com.confidant.controllers.basedata;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.confidant.common.BaseController;
import com.confidant.common.Constants;
import com.confidant.entity.Member;
import com.confidant.entity.Province;
import com.confidant.entity.Viewspot;
import com.confidant.service.basedata.BasedataService;
import com.confidant.service.basedata.ViewspotService;
import com.confidant.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Administrator on 2015/1/29.
 */
@Controller("basedataController")
@RequestMapping("/basedata")
public class BaseDataController extends BaseController {

    private static String BATH_PATH = "basedata/";

    @Autowired
    private BasedataService basedataService;

    @Autowired
    private ViewspotService viewspotService;

    @RequestMapping({"", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("tree_data", getProvinceTree());
        return BATH_PATH + "index";
    }

    public JSONArray getProvinceTree() {
        List<Province> list = basedataService.getAllProvinces();
        Map<Integer, JSONObject> country_map = new HashMap<Integer, JSONObject>();
        JSONArray array = new JSONArray();
        for (Province province : list) {
            int country_id = province.getCountry_id();
            //新国家、分类
            if (!country_map.containsKey(country_id)) {
                JSONObject country = new JSONObject();
                country.put("id", country_id);
                country.put("name", province.getCountry().getName());
                if (country_id == 1)
                    country.put("open", true);
                array.add(country);
                country_map.put(country_id, country);
            }
            if (province.getName() != null) {
                JSONObject country = country_map.get(country_id);
                JSONArray children;
                if (country.containsKey("children"))
                    children = country.getJSONArray("children");
                else {
                    children = new JSONArray();
                    country.put("children", children);
                }
                JSONObject json = new JSONObject();
                json.put("id", province.getId());
                json.put("name", province.getName());
                children.add(json);
            }
        }
        return array;
    }

    @RequestMapping("/getAllProvinces")
    public void getAllProvinces(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = successJson();
        result.put("data", getProvinceTree());
        renderJson(response, result);
    }

    @RequestMapping("/searchViewspot")
    public void searchViewspot(HttpServletRequest request, HttpServletResponse response) {
        String country_id = request.getParameter("country_id");
        String province_id = request.getParameter("province_id");
        int page = 1, page_size = 30;
        if (Validator.emptyString(country_id) && Validator.emptyString(province_id))
            fail(response, Constants.ErrorMsg.Common.IllegalArgument);
        else {
            JSONObject result = successJson();
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
            }
            Map<String, Object> condition = new HashMap<String, Object>();
            if (!Validator.emptyString(province_id))
                condition.put("province_id", province_id);
            if (!Validator.emptyString(country_id))
                condition.put("country_id", country_id);
            condition.put("page_start", (page - 1) * page_size);
            condition.put("page_size", page_size);
            try {
                result.put("data", viewspotService.searchViewspot(condition));
            } catch (Exception e) {
                e.printStackTrace();
            }
            renderJson(response, result);
        }
    }

    @RequestMapping("/saveViewspot")
    public void saveViewspot(HttpServletRequest request, HttpServletResponse response) {
//        province_id : province_id, view_name : view_name, view_comment
        String province_id = request.getParameter("province_id");
        String view_name = request.getParameter("view_name");
        String view_comment = request.getParameter("view_comment");
        if (Validator.emptyString(province_id) || Validator.notInt(province_id)
                || Validator.emptyString(view_name))
            fail(response, Constants.ErrorMsg.Common.IllegalArgument);
        else {
            JSONObject result = successJson();
            Viewspot viewspot = new Viewspot();
            viewspot.setName(view_name);
            viewspot.setProvince_id(Integer.parseInt(province_id));
            viewspot.setComments(view_comment);
            try {
                viewspotService.insert(viewspot);
            } catch (Exception e) {
                e.printStackTrace();
                result = failJson();
            }
            renderJson(response, result);
        }
    }

    @RequestMapping("/deleteViewspot")
    public void deleteViewspot(HttpServletRequest request, HttpServletResponse response) {
//        province_id : province_id, view_name : view_name, view_comment
        String id = request.getParameter("id");
        if (Validator.emptyString(id) || Validator.notInt(id))
            fail(response, Constants.ErrorMsg.Common.IllegalArgument);
        else {
            JSONObject result = successJson();
            try {
                viewspotService.deleteById(Long.parseLong(id));
            } catch (Exception e) {
                e.printStackTrace();
                result = failJson();
            }
            renderJson(response, result);
        }
    }
}
