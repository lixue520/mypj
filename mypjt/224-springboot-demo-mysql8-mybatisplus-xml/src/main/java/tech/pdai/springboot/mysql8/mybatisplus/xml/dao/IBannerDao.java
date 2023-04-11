package tech.pdai.springboot.mysql8.mybatisplus.xml.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.SysBanner;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.query.UserQueryBean;

import java.util.List;

/**
 * @version 1.0
 * @Author qin
 * @Date 2023/1/11 16:29
 */
@Mapper
public interface IBannerDao {
    List<SysBanner> findList();
    void deleteById(Long id);
    void update(SysBanner banner);
    void updateAll(SysBanner banner);
    void save(SysBanner banner);
}
