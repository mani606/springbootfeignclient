package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.OrderClient;
import com.example.demo.entity.Order;

@RestController
	@RequestMapping("/users")
	public class UserController {
		
		@Autowired
		OrderClient orderClient;
		
		@GetMapping("/info")
		public String getInfo() {
			return orderClient.getInfo();
		}
		
		@GetMapping("")
		public List<Order> getUserOrders() {

			return orderClient.getAll();

		}
		
				
		@GetMapping("/{userId}")
		public List<Order> getUserOrdersById(@PathVariable String userId) {
			return orderClient.getAllById(userId);
		}
		
		@GetMapping("/byparam")
		public List<Order> getUserOrdersByReqParam(@RequestParam String userId) {
			return orderClient.getAllByReqParam("112233");
		}
		
		@GetMapping("/postparam")
		public List<Order> testPostWithParam(@RequestParam String userId){
			return orderClient.getAllByPostReqParam(userId);
		}
		
		@GetMapping("/bybody")
		public Order testPostWithBody(){
			Order order = new Order();
			order.setId(1122);
			order.setDes("Feign user");
			return orderClient.getAllByPostReqBody(order);

}
}
