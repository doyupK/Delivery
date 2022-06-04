package com.sparta.delivery.service;

import com.sparta.delivery.Dto.*;
import com.sparta.delivery.domain.Order;
import com.sparta.delivery.domain.OrderDetail;
import com.sparta.delivery.mapping.MenuMapping;
import com.sparta.delivery.domain.Restaurant;
import com.sparta.delivery.repository.MenuRepository;
import com.sparta.delivery.repository.OrderDetailRepository;
import com.sparta.delivery.repository.OrderRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final OrderDetailRepository orderDetailRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository, MenuRepository menuRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Transactional
    public OrderResponseDto getOrderResponse(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.
                findRestaurantById(orderRequestDto.getRestaurantId());
        int sumFoodsPrice = 0;
        Order order = new Order(restaurant, sumFoodsPrice);

        // 해당 음식점 메뉴 가져옴
        List<MenuMapping> restaurantFoodsList = menuRepository.findMenusByRestaurant(restaurant);

        // Response용 List
        List<OrderFoodsResponseDto> orderFoodsResponseDtoList = new ArrayList<>();

        for(OrderFoodsRequestDto orderFood : orderRequestDto.getFoods()) {
            OrderDetail orderDetail = null;
            OrderFoodsResponseDto orderFoodsResponseDto = null;
            for (MenuMapping restaurantFood : restaurantFoodsList) {
                if (orderFood.getId().equals(restaurantFood.getId())) {
                    orderDetail = new OrderDetail(
                            restaurantFood.getName(),
                            orderFood.getQuantity(),
                            orderFood.getQuantity() * restaurantFood.getPrice(),
                            order
                    );
                    orderFoodsResponseDto = new OrderFoodsResponseDto(
                            restaurantFood.getName(),
                            orderFood.getQuantity(),
                            orderFood.getQuantity() * restaurantFood.getPrice()
                    );

                    sumFoodsPrice += restaurantFood.getPrice() * orderFood.getQuantity();

                    break;
                }
            }
            orderFoodsResponseDtoList.add(orderFoodsResponseDto);
            orderDetailRepository.save(orderDetail);
        }
        order.setTotalPrice(sumFoodsPrice);
        orderRepository.save(order);


        return new OrderResponseDto(
                restaurant.getName(),
                orderFoodsResponseDtoList,
                restaurant.getDeliveryFee(),
                restaurant.getDeliveryFee()+sumFoodsPrice);
//        OrderFoodsResponseDto orderFoodsResponseDto = new OrderFoodsResponseDto();

    }

    public List<OrderResponseDto> getAllOrder() {
        List<OrderResponseDto> orderResponseDtosList = new ArrayList<>();



        List<Order> orderList = orderRepository.findAll();


        for(Order order : orderList){
//            List<OrderDetail> orderDetailList = null;
            List<OrderFoodsResponseDto> orderFoodsResponseDtoList = new ArrayList<>();
            List<OrderDetail> orderDetailList = orderDetailRepository.findAllByOrder(order);
            for(OrderDetail orderDetail : orderDetailList) {
                System.out.println(orderDetail.getFoodName());
                System.out.println(orderDetail.getId());
                OrderFoodsResponseDto orderFoodsResponseDto = new OrderFoodsResponseDto(
                        orderDetail.getFoodName(),
                        orderDetail.getQuantity(),
                        orderDetail.getPrice()
                );
                orderFoodsResponseDtoList.add(orderFoodsResponseDto);
            }
            OrderResponseDto orderResponseDto = new OrderResponseDto(
                    order.getRestaurant().getName(),
                    orderFoodsResponseDtoList,
                    order.getRestaurant().getDeliveryFee(),
                    order.getTotalPrice()
            );
            orderResponseDtosList.add(orderResponseDto);
        }
        return orderResponseDtosList;
    }
}
