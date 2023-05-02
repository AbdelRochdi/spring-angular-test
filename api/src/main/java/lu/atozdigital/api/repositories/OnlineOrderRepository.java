package lu.atozdigital.api.repositories;

import lu.atozdigital.api.models.OnlineOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OnlineOrderRepository extends JpaRepository<OnlineOrder, Integer> {
    List<OnlineOrder> findByAccount(Integer accountId);
}
