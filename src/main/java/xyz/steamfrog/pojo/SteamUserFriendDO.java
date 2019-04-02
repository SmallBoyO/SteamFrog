package xyz.steamfrog.pojo;

import lombok.Data;
import xyz.steamfrog.pojo.common.BaseDO;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SteamUserFriendDO
 *
 * @author Clevo
 * @date 2019/3/27
 */
@Entity
@Table(name = "steam_user_friend")
@Data
public class SteamUserFriendDO extends BaseDO {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SteamUserDO user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private SteamUserDO friend;

}
