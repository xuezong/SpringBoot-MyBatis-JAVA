package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Area;

import java.util.List;

/**
 * @ClassName: AreaService
 * @Description:
 * @Author: XWZ
 * @Date: 2018-11-24 20:36
 * @Version 1.0
 */
public interface AreaService {

    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean addArea(Area area);

    boolean modify(Area area);

    boolean deleteArea(int areaId);
}
