package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;

@Service
public class RoomService {
	
	/* one-1 private static List<Room> rooms = new ArrayList<Room>();
	static {
		for(int i=0;i<10;i++) {
			rooms.add(new Room(i, "Room"+i, "Rn"+i, "Q"));
		}
	}*/
	
	private RoomRepository  roomrepository;
	
	@Autowired
	public RoomService(RoomRepository roomrepository) {
		super();
		this.roomrepository = roomrepository;
	}

	public List<Room> getAllRooms(){
		List<Room> rooms = new ArrayList<>();
		this.roomrepository.findAll().forEach(rooms::add);
		return rooms;
		
	}
	
	public Room createRooms(Room room) {
		return roomrepository.save(room);
		
	}
	public Optional<Room> getRoomById(Long roomid){
		return roomrepository.findById(roomid);
		
	}
	public void deleteBookedRoom(Long roomid) {
		roomrepository.deleteById(roomid);
	}
	public Room updateRoom(Long roomid,String name) {
		Room room=roomrepository.findById(roomid).orElse(new Room());
		room.setName(name);
		return roomrepository.save(room);
		
	}
	public List<Room> findRoomInfobyNameorId(String name, Long id) {
		return roomrepository.findRoomInfobyNameorId(name, id);
		
	}
	

}
