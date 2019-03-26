package xyz.steamfrog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.steamfrog.pojo.SteamUserInfo;

public interface SteamUserInfoRepository extends JpaRepository<SteamUserInfo,Long> {

    Boolean existsBySteamId(String steamId);

    SteamUserInfo findBySteamId(String steamId);

}
