package com.confidant.service.basedata;

import com.confidant.common.BaseService;
import com.confidant.entity.Country;
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
@Service("viewspotService")
public class ViewspotService extends BaseService {

    @PostConstruct
    protected void init() {
        namespace = "viewspot.";
    }

    public List<Viewspot> searchViewspot(Map<String, Object> condition) {
        List<Map> list = baseSqlSession.selectList(namespace + "searchViewspot", condition);
        List<Viewspot> result = new ArrayList<Viewspot>();
        for (Map map : list) {
            Viewspot viewspot = new Viewspot();
            viewspot.setId(Integer.parseInt(map.get("id").toString()));
            viewspot.setName(map.get("name").toString());
            viewspot.setProvince_id(Integer.parseInt(map.get("province_id").toString()));
            viewspot.setType(map.get("type").toString());
            Province province = new Province();
            province.setId(viewspot.getProvince_id());
            province.setName(map.get("province_name").toString());
            viewspot.setProvince(province);
            result.add(viewspot);
        }
        return result;
    }
}
