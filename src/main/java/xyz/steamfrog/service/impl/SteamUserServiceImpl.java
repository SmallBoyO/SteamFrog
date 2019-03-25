package xyz.steamfrog.service.impl;

import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUser;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamPlayerProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public void find(Long steamId) {
        try {
            SteamPlayerProfile steamPlayerProfile = steamUser.getPlayerProfile(steamId).get();
        }catch (Exception e){
            log.error("获取steam用户信息异常.",e);
        }
    }
}
