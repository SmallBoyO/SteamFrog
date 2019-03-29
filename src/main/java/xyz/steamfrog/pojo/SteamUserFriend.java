package xyz.steamfrog.pojo;

import lombok.Data;
import xyz.steamfrog.pojo.common.BasePojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SteamUserFriend
 *
 * @author Clevo
 * @date 2019/3/27
 */
@Entity
@Table(name = "steam_user_friend")
@Data
public class SteamUserFriend extends BasePojo {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SteamUserInfo user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private SteamUserInfo friend;

}
