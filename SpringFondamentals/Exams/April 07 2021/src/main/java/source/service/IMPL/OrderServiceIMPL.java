package source.service.IMPL;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import source.model.dto.AddOrderDTO;
import source.model.dto.OrderViewDTO;
import source.model.entity.Order;
import source.repository.CategoryRepository;
import source.repository.OrderRepository;
import source.repository.UserRepository;
import source.service.OrderService;
import source.session.CurrentSession;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceIMPL implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentSession currentSession;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public OrderServiceIMPL(OrderRepository orderRepository, ModelMapper modelMapper, CurrentSession currentSession, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentSession = currentSession;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void add(AddOrderDTO addOrderDTO) {
        addOrderDTO.setUser(userRepository.findUserByUsername(currentSession.getUsername()));
        addOrderDTO.setCategory(categoryRepository.findByName(addOrderDTO.getCategory().getName()));
        orderRepository.save(modelMapper.map(addOrderDTO, Order.class));
    }

    @Override
    public List<OrderViewDTO> getOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order,OrderViewDTO.class))
                .peek(order->{
                    order.setUrl(String.format("/images/%s.png",order.getCategoryName()));
                })
                .sorted((order1,order2)->Integer.compare(order2.getPrice().intValue(),order1.getPrice().intValue()))
                .collect(Collectors.toList());
    }

    @Override
    public int totalTimeToPrepare() {
        return this.getOrders().stream()
                .mapToInt(OrderViewDTO::getCategoryNeededTime)
                .sum();
    }

    @Override
    public void delete(long id) {
        Order order = orderRepository.findById(id).get();
        orderRepository.delete(order);
    }
}
