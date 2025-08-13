package com.deepak.airBnbApp.service;

import com.deepak.airBnbApp.dto.HotelDto;
import com.deepak.airBnbApp.entity.Hotel;
import com.deepak.airBnbApp.exception.ResourceNotFoundException;
import com.deepak.airBnbApp.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new hotel with name: {}",hotelDto.getName());
        Hotel hotel=modelMapper.map(hotelDto,Hotel.class);
        hotel.setActive(false);
       hotel= hotelRepository.save(hotel);
        log.info("Created a new hotel with name: {}",hotelDto.getName());
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting the hotel with ID: {}",id);
       Hotel hotel= hotelRepository
               .findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Hotel not found with ID:"+id));
       return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating the hotel with ID: {}",id);
        Hotel hotel= hotelRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with ID:"+id));

       modelMapper.map(hotelDto,hotel);
       hotel.setId(id);
       hotel= hotelRepository.save(hotel);
       return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public void deleteHotelById(Long id) {
        boolean exists=hotelRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Hotel not found with ID:"+id);

        hotelRepository.deleteById(id);
        //TODO: delete the future inventories for this hotel
    }

    @Override
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel with Id: {}",hotelId);
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));
        hotel.setActive(true);
      //  TODO:Crate inventory for all the room for this hotel

        hotelRepository.save(hotel);
    }

}
