package com.restapi.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.plaf.metal.MetalBorders.OptionDialogBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.dto.OrderDto;
import com.restapi.entities.Item;
import com.restapi.entities.Order;
import com.restapi.repository.ItemRepository;
import com.restapi.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class RestApiRestController {

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private ItemRepository itemRepo;
	
	@PostMapping("/create")
	public void saveOrder(@RequestBody OrderDto order) {
		List<Item> item = order.getItem();
		for (Item item2 : item) {
			item2.setItemId(order.getOrderId());
			itemRepo.save(item2);
		}
		Order ord = new Order();
		ord.setOrderDate(order.getOrderDate());
		ord.setOrderStatus("New");
		orderRepo.save(ord);
	}
	
	@GetMapping("/{id}")
	public OrderDto getOrderById(@PathVariable("id") int id) {
		Optional<Order> opt = orderRepo.findById(id);
		Order order = opt.get();
		List<Item> items = itemRepo.findAllById(order.getOrderId());
		OrderDto orders = new OrderDto();
		orders.setOrderDate(order.getOrderDate());
		orders.setOrderId(order.getOrderId());
		orders.setOrderStatus(order.getOrderStatus());
		orders.setItem(items);
		return orders;
	}
	@GetMapping("/getAll")
	public List<OrderDto> getAllOrders() {
		List<Order> orders = orderRepo.findAll();
		List<OrderDto> list = new ArrayList<OrderDto>();
		for (Order order : orders) {
			OrderDto od = new OrderDto();
			List<Item> items = itemRepo.findAllById(order.getOrderId());
			od.setItem(items);
			od.setOrderDate(order.getOrderDate());
			od.setOrderId(order.getOrderId());
			od.setOrderStatus(order.getOrderStatus());
			list.add(od);
		}
		return list;
	}
}
