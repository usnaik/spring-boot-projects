package com.upen.aaida.hotelreservation.data.repository;

import java.sql.Date;

import com.upen.aaida.hotelreservation.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
