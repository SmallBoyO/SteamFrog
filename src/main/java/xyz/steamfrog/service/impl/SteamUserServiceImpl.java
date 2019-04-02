package xyz.steamfrog.service.impl;

import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUser;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamPlayerProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.steamfrog.pojo.SteamUserDO;
import xyz.steamfrog.pojo.SteamUserFriendDO;
import xyz.steamfrog.repository.SteamUserFriendRepository;
import xyz.steamfrog.repository.SteamUserRepository;
import xyz.steamfrog.service.SteamUserService;

/**
 * SteamUserServiceImpl
 *
 * @author Clevo
 * @date 2019/3/25
 */
@Service
@Slf4j
public class SteamUserServiceImpl implements SteamUserService {

  @Autowired
  SteamUser webApiSteamUser;

  @Autowired
  private SteamUserRepository steamUserRepository;

    @Autowired
    private SteamUserFriendRepository steamUserFriendRepository;

    @Autowired
    private SteamUserService steamUserService;

    @Override
    public SteamUserDO findSteamUserInfoBySteamId(Long steamId, Boolean needQueryFriend) {
        try {
            SteamUserDO steamUserDO = steamUserRepository.findBySteamId(steamId);
            if(steamUserDO==null){
                steamUserDO = new SteamUserDO();
                SteamPlayerProfile steamPlayerProfile = webApiSteamUser.getPlayerProfile(steamId).get();
                BeanUtils.copyProperties(steamPlayerProfile,steamUserDO);
                steamUserDO = steamUserRepository.save(steamUserDO);

                final SteamUserDO user = new SteamUserDO();
                user.setId(steamUserDO.getId());
                //查询了用户信息之后 异步查询用户的好友信息
                if(needQueryFriend) {
                    webApiSteamUser.getFriendList(steamId).thenAccept(steamFriends -> {
                        steamFriends.forEach(steamFriend -> {
                            SteamUserDO friend = steamUserService.findSteamUserInfoBySteamId(steamFriend.getSteamId(),false);
                            if(friend!=null){
                                SteamUserFriendDO steamUserFriend = new SteamUserFriendDO();
                                steamUserFriend.setUser(user);
                                steamUserFriend.setFriend(friend);
                                steamUserFriendRepository.save(steamUserFriend);
                            }
                        });
                    });
                }
            }
            return steamUserDO;
        }catch (Exception e){
            log.error("获取steam用户信息异常.",e);
            return null;
        }
  }
}
