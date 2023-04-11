package tech.pdai.springboot.mysql8.mybatisplus.xml.service;

import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.Role;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.SysBanner;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.query.RoleQueryBean;

import java.util.List;

/**
 * @version 1.0
 * @Author qin
 * @Date 2023/1/11 16:31
 */
public interface IBannerService {
    List<SysBanner> findList();
    void save(SysBanner banner);
    void update(SysBanner banner);
    void updateAll(SysBanner banner);
    void deleteById(Long id);
}
