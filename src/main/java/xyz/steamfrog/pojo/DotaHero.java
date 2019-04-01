package xyz.steamfrog.pojo;

import lombok.Data;
import xyz.steamfrog.pojo.common.BasePojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dota_hero")
@Data
public class DotaHero extends BasePojo {

    private Integer heroId;

    private String name;

    private String sbImageUrl;

    private String lgImageUrl;

    private String fullImageUrl;

}
