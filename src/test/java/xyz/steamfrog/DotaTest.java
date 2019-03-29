package xyz.steamfrog;

import com.ibasco.agql.protocols.valve.dota2.webapi.enums.Dota2IconType;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Econ;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Match;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2EventStats;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2MatchDetails;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2MatchHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.steamfrog.pojo.DotaHero;
import xyz.steamfrog.pojo.DotaItem;
import xyz.steamfrog.repository.DotaHeroRepository;
import xyz.steamfrog.repository.DotaItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@EnableAutoConfiguration
public class DotaTest {

    @Autowired
    private Dota2Econ dota2Econ;

    @Autowired
    private DotaHeroRepository dotaHeroRepository;

    @Autowired
    private DotaItemRepository dotaItemRepository;

    @Test
    public void findHeroList(){
        try {
            dota2Econ.getGameHeroes(false, "zh_CN").get().forEach(dota2Heroes -> {
                System.out.println(dota2Heroes);
                DotaHero dotaHero = new DotaHero();
                dotaHero.init();
                dotaHero.setHeroId(dota2Heroes.getId());
                dotaHero.setName(dota2Heroes.getName());
                dotaHeroRepository.save(dotaHero);
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void findItemList(){
        try {
            dota2Econ.getGameItems("zh_CN").get().forEach(dota2GameItem -> {
                DotaItem dotaItem = new DotaItem();
                dotaItem.init();
                dotaItem.setItemId(dota2GameItem.getId());
                BeanUtils.copyProperties(dota2GameItem,dotaItem);
                dotaItemRepository.save(dotaItem);
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
