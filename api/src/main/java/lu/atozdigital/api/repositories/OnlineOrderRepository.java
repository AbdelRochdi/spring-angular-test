package lu.atozdigital.api.repositories;

import lu.atozdigital.api.models.OnlineOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineOrderRepository extends JpaRepository<OnlineOrder, Integer> {
}
