package tech.pdai.springboot.mysql8.mybatisplus.xml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.Role;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.SysBanner;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.query.RoleQueryBean;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.response.ResponseResult;
import tech.pdai.springboot.mysql8.mybatisplus.xml.service.IBannerService;

import java.util.List;

/**
 * @version 1.0
 * @Author qin
 * @Date 2023/1/11 16:27
 */
@RestController
@RequestMapping("/banner")
public class SysBannerController {

    @Autowired
    IBannerService bannerService;
    @GetMapping("list")
    public ResponseResult<List<SysBanner>> list() {
        return ResponseResult.success(bannerService.findList());
    }
    @PostMapping("add")
    public void add(@RequestBody SysBanner banner){
        System.out.println(banner.toString());
        bannerService.save(banner);
    }
    @PostMapping("move")
    public void MoveUp(@RequestBody SysBanner banner){
        System.out.println(banner.toString());
        bannerService.update(banner);
    }

    @PostMapping("Edit")
    public void Edit(@RequestBody SysBanner banner){
        System.out.println(banner.toString());
        bannerService.updateAll(banner);
    }

    @PostMapping("Dell")
    public void Dell(@RequestBody SysBanner banner){
        System.out.println(banner.toString());
        bannerService.deleteById(Long.valueOf(banner.getId()));
    }
}
