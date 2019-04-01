package xyz.steamfrog.service.impl;

import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUser;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamPlayerProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.steamfrog.pojo.SteamUserDO;
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

  @Override
  public SteamUserDO findOrCreateBySteamId(Long steamId) {
    //TODO 区分数据查询问题还是web api问题. 抛出不同的异常
    try {
      SteamUserDO steamUser = steamUserRepository.findBySteamId(steamId);
      if (steamUser == null) {
        steamUser = new SteamUserDO();
        SteamPlayerProfile steamPlayerProfile = webApiSteamUser.getPlayerProfile(steamId).get();
        BeanUtils.copyProperties(steamPlayerProfile, steamUser);
        steamUser = steamUserRepository.save(steamUser);
      }
      return steamUser;
    } catch (Exception e) {
      log.error("获取steam用户信息异常.", e);
      return null;
    }
  }
}
