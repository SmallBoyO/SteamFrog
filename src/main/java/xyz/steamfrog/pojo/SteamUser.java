package xyz.steamfrog.pojo;

import lombok.Data;
import xyz.steamfrog.pojo.common.BasePojo;

/**
 * Steam用户pojo
 *
 * @author Clevo
 * @date 2019/3/25
 */
@Data
public class SteamUser extends BasePojo {

    private String steamId;

    private Integer communityVisibilityState;

    private Integer profileState;

    private String name;

    private Long lastLogOff;

    private String profileUrl;

    private String avatarUrl;

    private String avatarMediumUrl;

    private String avatarFullUrl;

    private Integer personaState;

    private Long primaryGroupId;

    private Long timeCreated;

    private Integer personaStateFlags;
}
