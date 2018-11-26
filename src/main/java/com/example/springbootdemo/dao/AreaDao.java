package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.Area;

import java.util.List;

/**
 * @ClassName: AreaDao
 * @Description:
 * @Author: XWZ
 * @Date: 2018-11-23 23:57
 * @Version 1.0
 */
public interface AreaDao {

    /**
     * 查询该表的所有对象
     * @return List<Area>
     */
    List<Area> queryArea();

    /**
     * 根据id查询对象
     * @param areaId
     * @return Area对象
     */
    Area queryAreaById(int areaId);

    /**
     * 插入数据
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新
     * @param area
     * @return Area
     */
    int updateArea(Area area);
    /**
     * 删除方法
     * @param areaId
     * @return int
     */
    int deleteArea(int areaId);
}
