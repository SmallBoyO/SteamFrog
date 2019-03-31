package xyz.steamfrog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.steamfrog.pojo.SteamUserInfoDO;

public interface SteamUserInfoRepository extends JpaRepository<SteamUserInfoDO,Long> {

    Boolean existsBySteamId(String steamId);

    SteamUserInfoDO findBySteamId(String steamId);

}
