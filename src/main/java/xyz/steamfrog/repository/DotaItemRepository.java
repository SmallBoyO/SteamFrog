package xyz.steamfrog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.steamfrog.pojo.DotaItem;

public interface DotaItemRepository extends JpaRepository<DotaItem,Long> {
}
