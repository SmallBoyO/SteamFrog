package xyz.steamfrog.pojo;

import lombok.Data;
import xyz.steamfrog.pojo.common.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dota_item")
@Data
public class DotaItemDO extends BaseDO {

    private Integer itemId;

    private String name;

    private Integer cost;

    private Integer secretShop;

    private Integer sideShop;

    private Integer recipe;

    private String imageUrl;

}
