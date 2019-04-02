package xyz.steamfrog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.steamfrog.pojo.DotaItemDO;

public interface DotaItemRepository extends JpaRepository<DotaItemDO,Long> {
}
