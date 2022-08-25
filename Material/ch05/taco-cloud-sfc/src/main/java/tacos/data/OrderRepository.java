package tacos.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tacos.TacoOrder;
import tacos.User;

public interface OrderRepository 
         extends CrudRepository<TacoOrder, Long> {
	List<Order> findByUserOrderByPlacedAtDesc(User user);
}
