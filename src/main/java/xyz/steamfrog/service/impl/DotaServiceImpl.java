package xyz.steamfrog.service.impl;

import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Match;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2MatchDetails;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2MatchHistory;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2MatchHistoryCriteria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.steamfrog.service.DotaService;

@Service
public class DotaServiceImpl implements DotaService {

  @Autowired
  private Dota2Match dota2Match;

  @Override
  public Dota2MatchHistory findLatestDota2Match(Long steamId) {
    Dota2MatchHistoryCriteria dota2MatchHistoryCriteria = new Dota2MatchHistoryCriteria();
    dota2MatchHistoryCriteria.accountId(steamId);
    try {
      return dota2Match.getMatchHistory(dota2MatchHistoryCriteria).get();
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Dota2MatchDetails getMatchDetails(Long matchId) {
    try {
      return dota2Match.getMatchDetails(matchId).get();
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }
}
