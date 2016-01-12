package com.confidant.service.basedata;

import com.confidant.common.BaseService;
import com.confidant.entity.Country;
import com.confidant.entity.Member;
import com.confidant.entity.Province;
import com.confidant.entity.Viewspot;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/27.
 */
@Service("basedataService")
public class BasedataService extends BaseService {

    @PostConstruct
    protected void init() {
        namespace = "basedata.";
    }

    public List<Province> getAllProvinces() {
        List<Map> list = baseSqlSession.selectList(namespace + "getAllProvinces");
        List<Province> result = new ArrayList<Province>();
        for (Map map : list) {
            Province province = new Province();
            if (map.containsKey("p_id")) {
                province.setId(Integer.parseInt(map.get("p_id").toString()));
                province.setName(map.get("p_name").toString());
            }
            int country_id = Integer.parseInt(map.get("c_id").toString());
            Country country = new Country();
            country.setId(country_id);
            country.setName(map.get("c_name").toString());
            province.setCountry_id(country_id);
            province.setCountry(country);
            result.add(province);
        }
        return result;
    }
}
