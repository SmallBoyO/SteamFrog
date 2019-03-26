package xyz.steamfrog.service;

import xyz.steamfrog.pojo.SteamUserInfo;

/**
 * SteamUserService
 *
 * @author Clevo
 * @date 2019/3/25
 */
public interface SteamUserService {

    /**
     * 根据steamId查询steam用户信息
     * @param steamId
     * @return
     */
    SteamUserInfo findSteamUserInfoBySteamId(Long steamId);

}
