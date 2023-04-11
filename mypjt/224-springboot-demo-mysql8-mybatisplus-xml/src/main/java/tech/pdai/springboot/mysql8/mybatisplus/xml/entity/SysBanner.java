package tech.pdai.springboot.mysql8.mybatisplus.xml.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysBanner)实体类
 *
 * @author makejava
 * @since 2023-01-11 16:27:17
 */
public class SysBanner implements Serializable {
    private static final long serialVersionUID = 515052040645024155L;
    
    private Integer id;
    
    private Integer type;
    
    private String name;

    @Override
    public String toString() {
        return "SysBanner{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", link='" + link + '\'' +
                ", img='" + img + '\'' +
                ", remark='" + remark + '\'' +
                ", delFlag=" + delFlag +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", releaseAt=" + releaseAt +
                '}';
    }

    /**
     * 排列顺序0-10
     */
    private Integer sort;
    /**
     * 广告链接
     */
    private String link;
    /**
     * 广告图片地址
     */
    private String img;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除标记
     */
    private Integer delFlag;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;
    /**
     * 发布时间
     */
    private Date releaseAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getReleaseAt() {
        return releaseAt;
    }

    public void setReleaseAt(Date releaseAt) {
        this.releaseAt = releaseAt;
    }

}

