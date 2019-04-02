package xyz.steamfrog.pojo;

import lombok.Data;
import xyz.steamfrog.pojo.common.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dota_hero")
@Data
public class DotaHeroDO extends BaseDO {

    private Integer heroId;

    private String name;

    private String sbImageUrl;

    private String lgImageUrl;

    private String fullImageUrl;

}
