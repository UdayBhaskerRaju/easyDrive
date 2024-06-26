package com.companyname.easyDrive.service;

import com.companyname.easyDrive.Dtos.Request.BookingRequest;
import com.companyname.easyDrive.Dtos.Response.BookingResponse;
import com.companyname.easyDrive.Dtos.Response.CabResponse;
import com.companyname.easyDrive.converters.BookingTransformer;
import com.companyname.easyDrive.exception.CabNotFoundException;
import com.companyname.easyDrive.exception.CustomerNotFoundException;
import com.companyname.easyDrive.model.Booking;
import com.companyname.easyDrive.model.Cab;
import com.companyname.easyDrive.model.Customer;
import com.companyname.easyDrive.model.Driver;
import com.companyname.easyDrive.repository.BookingRepository;
import com.companyname.easyDrive.repository.CabRepository;
import com.companyname.easyDrive.repository.CustomerRepository;
import com.companyname.easyDrive.repository.DriverRepository;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.Optional;

@Service
@RequiredArgsConstructor // This annotation will create constructor for final variables
public class BookingService {

    //Injecting Beans in this way is god practice Instead of using @autowired
    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    JavaMailSender javaMailSender;
    public BookingResponse bookCab(BookingRequest bookingRequest) throws MessagingException {
      //step 1 : check if the customer is exist or not
       Customer customer = customerRepository.findByEmailId(bookingRequest.getEmailId());
       if(ObjectUtils.isEmpty(customer)){
           throw new CustomerNotFoundException("Invalid Id");
       }
       //step 2: check if the cab is available or not to book
        Optional<Cab> optionalCab = cabRepository.getRandomAvailableCab();
       if(optionalCab .isEmpty()){
           throw new CabNotFoundException("seems like all drivers are busy");
       }

       Cab cab = optionalCab.get();
       Driver driver = cab.getDriver();
       cab.setBooked(true);

       //booking entity
        Booking booking = BookingTransformer.BookingRequestToBooking(bookingRequest,cab);
        booking.setDriver(driver);
        booking.setCustomer(customer);
        Booking savedBooking = bookingRepository.save(booking);

        customer.getBookings().add(savedBooking);
        driver.getBookings().add(savedBooking);

        customerRepository.save(customer); // saves customer + bookings
        driverRepository.save(driver); // saves driver + bookings

        sendEmail(savedBooking);
        //booking response
        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }

    public String sendEmail(Booking booking) throws MessagingException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("easydrive0987@gmail.com");
        simpleMailMessage.setTo(booking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Booking Confirmed");
        simpleMailMessage.setText("Congrats!! "+booking.getCustomer().getName()+" your booking Id is :"+booking.getBookingId()+" driver Name is :"
                +booking.getDriver().getName()+" Driver Mobile Number is :"+booking.getDriver().getMobileNumber());

        //add attachment
        MimeMessage message = javaMailSender.createMimeMessage();

        // Use MimeMessageHelper to add multiple support
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(booking.getCustomer().getEmailId());
        helper.setSubject("subject");
        helper.setText("welcome document file attached");

        //add attachment
        FileSystemResource file = new FileSystemResource(new File(booking.getMailAttachment()));
        if(file.exists()){
            helper.addAttachment(file.getFilename(),file);
        }
        else{
            throw new MessagingException("File not found :"+booking.getMailAttachment());
        }
        javaMailSender.send(message);
        javaMailSender.send(simpleMailMessage);
        return "Email Sent successfully";
    }


}
