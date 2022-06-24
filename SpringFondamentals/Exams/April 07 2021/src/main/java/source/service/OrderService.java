package source.service;

import source.model.dto.AddOrderDTO;
import source.model.dto.OrderViewDTO;

import java.util.List;

public interface OrderService {
    void add(AddOrderDTO addOrderDTO);
    List<OrderViewDTO>getOrders();
    int totalTimeToPrepare();
    void delete(long id);
}
