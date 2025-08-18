package com.deepak.airBnbApp.service;

import com.deepak.airBnbApp.dto.BookingDto;
import com.deepak.airBnbApp.dto.BookingRequest;
import com.deepak.airBnbApp.dto.GuestDto;

import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
