package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomservice;
	
	@GetMapping
	public String getAllRooms(Model model) {
		 model.addAttribute("rooms", roomservice.getAllRooms());
		return "rooms";
		
	}

}
