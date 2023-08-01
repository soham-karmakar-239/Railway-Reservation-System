package com.rrs.controllers;

import java.security.Principal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rrs.dto.BookingDto;
import com.rrs.dto.TrainDto;
import com.rrs.dto.TrainSearchDto;
import com.rrs.service.BookingService;
import com.rrs.service.HelpService;
import com.rrs.service.TrainService;

/** The Controller class for User */

@Controller
@RequestMapping("/user")
public class UserController {

	/** the BookingService object */
	@Autowired
	private BookingService bookingService;

	/** the TrainService object */
	@Autowired
	private TrainService trainService;

	/** the HelpService object */
	@Autowired
	private HelpService helpService;

	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex, Model model) {
	    String name = ex.getParameterName();
	    model.addAttribute("parameterName", name);
	    return "UserErrorPage";
	}
	
	/**
	 * Handles request to get User Home page
	 *
	 * @return the user home page
	 */
	@GetMapping("/")
	public String userHomePage() {
		return "PlanJourney";
	}

	/**
	 * Handles request to search a train
	 *
	 * @param model          the Model object
	 * @param trainSearchDto the search parameters from user
	 * @return the Train List page with search results
	 */
	@PostMapping("/search")
	public String searchTrains(Model model, @ModelAttribute TrainSearchDto trainSearchDto) {
		List<TrainDto> searchTrains = trainService.searchTrains(trainSearchDto);
		model.addAttribute("trains", searchTrains);
		model.addAttribute("departureDate", trainSearchDto.getDepartureDate());
		return "TrainList";
	}

	/**
	 * Handles request to get Book Train page
	 *
	 * @param model         The Model object
	 * @param departureDate the departure date
	 * @return the Book Train page
	 */
	@GetMapping("/booktrain")
	public String trainBookingPage(Model model, @RequestParam long trainNo, @RequestParam Date departureDate) {
		model.addAttribute("trainDetails", trainService.getTrainDto(trainNo));
		model.addAttribute("departureDate", departureDate);
		return "BookTrain";
	}

	/**
	 * Handles request to get Payment page
	 *
	 * @param model         the Model object
	 * @param trainNo       the Train number
	 * @param seatClass     the seat class
	 * @param departureDate the departure date
	 * @return the payment page
	 */
	@GetMapping("/payment")
	public String getPaymentPage(Model model, @RequestParam long trainNo, @RequestParam String seatClass,
			@RequestParam Date departureDate) {
		model.addAttribute("trainNo", trainNo);
		model.addAttribute("seatClass", seatClass);
		model.addAttribute("price", trainService.getPrice(trainNo, seatClass));
		model.addAttribute("departureDate", departureDate);
		return "PaymentPage";
	}

	/**
	 * Handles request to create new booking
	 *
	 * @param model      the Model object
	 * @param bookingDto details of the booking
	 * @param principal  the Principal object
	 * @return My Bookings page
	 */
	@PostMapping("/confirmbooking")
	public String confirmBooking(Model model, @ModelAttribute BookingDto bookingDto, Principal principal) {
		bookingService.createNewBooking(bookingDto, principal.getName());
		return "redirect:/user/bookings";
	}

	/**
	 * Handles request to get My Bookings page
	 *
	 * @param model     the Model object
	 * @param principal the Principal object
	 * @return My Bookings page
	 */
	@GetMapping("/bookings")
	public String getBookingsPage(Model model, Principal principal) {
		model.addAttribute("bookings", bookingService.getBookings(principal.getName()));
		return "MyBookings";
	}

	/**
	 * Handles request to cancel a ticket
	 *
	 * @param model     the Model object
	 * @param principal the Principal object
	 * @param pnr       the pnr number of the booking
	 * @return the My Refunds page after cancellation of the booking
	 */
	@GetMapping("/cancel")
	public String cancelBooking(Model model, Principal principal, @RequestParam long pnr) {
		bookingService.cancelBooking(pnr);
		model.addAttribute("bookings", bookingService.getBookings(principal.getName()));
		return "redirect:/user/refunds";
	}

	/**
	 * Handles request to get My Refunds page
	 *
	 * @param model     the Model object
	 * @param principal the Principal object
	 * @return the My Refunds page
	 */
	@GetMapping("/refunds")
	public String getRefundsPage(Model model, Principal principal) {
		model.addAttribute("refunds", bookingService.getRefundsList(principal.getName()));
		return "MyRefunds";
	}

	/**
	 * Handles request to get tickets raised by an user
	 *
	 * @param model     the Model object
	 * @param principal the Principal object
	 * @return the Help page
	 */
	@GetMapping("/help")
	public String getHelpPage(Model model, Principal principal) {
		model.addAttribute("tickets", helpService.getTicketsByUsername(principal.getName()));
		return "userHelp";
	}

	/**
	 * Handles request to get Raise new ticket page
	 *
	 * @return Raise New Ticket Page
	 */
	@GetMapping("/newticket")
	public String getNewTicketPage() {
		return "newUserTicket";
	}

	/**
	 * Handles request to create a new ticket
	 *
	 * @param issue       the issue
	 * @param description the description
	 * @param principal   the Principal object
	 * @return the Help page after creating the ticket
	 */
	@PostMapping("/createticket")
	public String createTicket(@RequestParam String issue, @RequestParam String description, Principal principal) {
		helpService.createTicket(issue, description, principal.getName());
		return "redirect:/user/help";
	}

}