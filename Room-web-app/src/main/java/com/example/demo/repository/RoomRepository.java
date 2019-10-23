package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>  {
	@Query(value="SELECT r FROM Room r where r.name=?1 OR r.id=?2")
	List<Room> findRoomInfobyNameorId(String name,Long id);
		
	

}
