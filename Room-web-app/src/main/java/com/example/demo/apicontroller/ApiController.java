package com.example.demo.apicontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="Room-api",value="Challenge apis by Venkata")
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private RoomService roomservice;
	
	
	@ApiOperation(value="endpoit to get the room details")
	@ApiResponses(value=
	{@ApiResponse(code=200, message="Successfully displayed the current time", response = String.class),
	@ApiResponse(code=400, message="Bad request"),
	@ApiResponse(code=500, message="Internal server error")
	}
	)
	
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms(){
		return roomservice.getAllRooms();
		
	}
	@PostMapping("/createrooms")
	public Room createRooms(@RequestBody Room room) {
		return roomservice.createRooms(room);
		
	}
	@GetMapping("/rooms/{roomid}")
  public Optional<Room> getRoomById(@PathVariable("roomid") Long roomid ){
	return roomservice.getRoomById(roomid);
		
		
	}
	@DeleteMapping("room/{roomid}")
	public void deleteBookedRoom(@PathVariable("roomid") Long roomid) {
		roomservice.deleteBookedRoom(roomid);
	}
	
	@PutMapping("room/{roomid}/{name}")
	public Room updateRooms(@PathVariable("roomid") Long roomid,@PathVariable("name") String name)
	{
		return roomservice.updateRoom(roomid, name);
		}
	
	@GetMapping("room/{name}/{id}")
	public List<Room> getRoomInfobyNameorId(@PathVariable("name") String name,@PathVariable("id") Long id){
		return roomservice.findRoomInfobyNameorId(name, id);
		
	}
}
		

