package xyz.steamfrog.service.impl;

import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUser;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamPlayerProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.steamfrog.pojo.SteamUserInfo;
import xyz.steamfrog.repository.SteamUserInfoRepository;
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
    SteamUser steamUser;

    @Autowired
    private SteamUserInfoRepository steamUserInfoRepository;

    @Autowired
    private SteamUserService steamUserService;

    @Override
    public SteamUserInfo findSteamUserInfoBySteamId(Long steamId,Boolean needQueryFriend) {
        try {
            SteamUserInfo steamUserInfo = steamUserInfoRepository.findBySteamId(steamId.toString());
            if(steamUserInfo==null){
                steamUserInfo = new SteamUserInfo();
                SteamPlayerProfile steamPlayerProfile = steamUser.getPlayerProfile(steamId).get();
                steamUserInfo.init();
                BeanUtils.copyProperties(steamPlayerProfile,steamUserInfo);
                steamUserInfo = steamUserInfoRepository.save(steamUserInfo);

                //查询了用户信息之后 异步查询用户的好友信息
                if(needQueryFriend) {
                    steamUser.getFriendList(steamId).thenAccept(steamFriends -> {
                        steamFriends.forEach(steamFriend -> {
                            steamUserService.findSteamUserInfoBySteamId(steamFriend.getSteamId(),false);
                        });
                    });
                }
            }
            return steamUserInfo;
        }catch (Exception e){
            log.error("获取steam用户信息异常.",e);
            return null;
        }
    }

}
