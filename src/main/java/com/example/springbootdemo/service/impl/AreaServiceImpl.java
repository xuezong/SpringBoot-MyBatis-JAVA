package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.AreaDao;
import com.example.springbootdemo.entity.Area;
import com.example.springbootdemo.service.AreaService;
import org.apache.ibatis.executor.ExecutorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.accessibility.AccessibleText;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: AreaServiceImpl
 * @Description:
 * @Author: XWZ
 * @Date: 2018-11-24 20:36
 * @Version 1.0
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaDao.insertArea(area);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("插入区域信息不能为空");
        }
    }

    @Override
    public boolean modify(Area area) {
        // 判断主要时id不能为空
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setCreateTime(new Date());
            try {
                int effectNum = areaDao.updateArea(area);
                if(effectNum > 0) {
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("更新区域信息失败" + e.getMessage());
            }
        }else {
            throw new RuntimeException("更新区域信息主键不为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        // 判断主要时id不能为空
        if (areaId > 0) {
            try {
                int effectNum = areaDao.deleteArea(areaId);
                if(effectNum > 0) {
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("删除区域信息失败" + e.toString());
            }
        }else {
            throw new RuntimeException("删除区域信息主键不为空");
        }
    }
}
