package com.upen.aaida.hotelreservation.data.repository;

import com.upen.aaida.hotelreservation.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
