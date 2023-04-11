package tech.pdai.springboot.mysql8.mybatisplus.xml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.mysql8.mybatisplus.xml.dao.IBannerDao;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.SysBanner;
import tech.pdai.springboot.mysql8.mybatisplus.xml.service.IBannerService;

import java.util.List;

/**
 * @version 1.0
 * @Author qin
 * @Date 2023/1/11 16:33
 */
@Service
public class IBannerDoServiceImpl implements IBannerService {
    @Autowired
    IBannerDao iBannerDao;
    @Override
    public List<SysBanner> findList() {
        return iBannerDao.findList();
    }

    @Override
    public void save(SysBanner banner) {
         iBannerDao.save(banner);
    }

    @Override
    public void update(SysBanner banner) {
        iBannerDao.update(banner);
    }

    @Override
    public void updateAll(SysBanner banner) {
        iBannerDao.updateAll(banner);
    }

    @Override
    public void deleteById(Long id) {
        iBannerDao.deleteById(id);
    }
}
