package com.upen.aaida.hotelreservation.web;

import com.upen.aaida.hotelreservation.business.service.ReservationService;
import com.upen.aaida.hotelreservation.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {

    private final ReservationService reservationService;

//    @value("${hotel-reservations.properties.hotel-name}")
//    private String hotelName;

    @Autowired
    public GuestWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model){
        List<Guest> guests = this.reservationService.getHotelGuests();
        model.addAttribute("guests", guests);
//        model.addAttribute("hotelName", hotelName);
        return "guests";
    }
}