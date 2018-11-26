package com.example.springbootdemo.web;

import com.example.springbootdemo.entity.Area;
import com.example.springbootdemo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * @ClassName: AreaController
 * @Description:
 * @Author: XWZ
 * @Date: 2018-11-24 21:13
 * @Version 1.0
 */
@RestController
@RequestMapping("/supperadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    public Map<String, Object> listArea(){
        Map<String, Object> modelMap = new HashMap<>(16);
        List<Area> areaList = areaService.getAreaList();
        modelMap.put("areaList", areaList);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    public Map<String, Object> getAreaById(Integer areaId){
        Map<String, Object> modelMap = new HashMap<>(16);
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    public Map<String, Object> addArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>(16);
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    public Map<String, Object> modifyArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>(16);
        modelMap.put("success", areaService.modify(area));
        return modelMap;
    }

    @RequestMapping(value = "/deletearea", method = RequestMethod.GET)
    public Map<String, Object> deleteArea(Integer areaId){
        Map<String, Object> modelMap = new HashMap<>(16);
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }
}
