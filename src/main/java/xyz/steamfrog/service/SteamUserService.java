package xyz.steamfrog.service;

import xyz.steamfrog.pojo.SteamUserDO;

/**
 * SteamUserService
 *
 * @author Clevo
 * @date 2019/3/25
 */
public interface SteamUserService {

  /**
   * 根据steamId查询steam用户信息
   */
  SteamUserDO findOrCreateBySteamId(Long steamId);

}
