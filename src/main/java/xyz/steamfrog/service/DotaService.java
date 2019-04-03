package xyz.steamfrog.service;

import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2MatchDetails;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2MatchHistory;
import java.util.List;

public interface DotaService {

  /**
   * 查询用户最近的匹配信息
   */
  Dota2MatchHistory findLatestDota2Match(Long steamId);

  /**
   * 获取匹配详情
   */
  Dota2MatchDetails getMatchDetails(Long matchId);
}
