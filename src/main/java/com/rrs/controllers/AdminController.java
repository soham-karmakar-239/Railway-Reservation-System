package com.rrs.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rrs.dto.TrainDto;
import com.rrs.service.HelpService;
import com.rrs.service.TrainService;

/** The Controller class for Admin*/

@Controller
@RequestMapping("/admin")
public class AdminController {

	/** the Train Service */
	@Autowired
	private TrainService trainService;

	/** the Help Service */
	@Autowired
	private HelpService helpService;

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex, Model model) {
	    String name = ex.getParameterName();
	    model.addAttribute("parameterName", name);
	    return "AdminErrorPage";
	}
	
	
	/**
	 * Handles get request to Admin Home Page
	 *
	 * @return the Admin Home page
	 */
	@GetMapping("/")
	public String adminHomePage() {
		return "adminhome";
	}

	/**
	 * Handles Post request to search train by train number
	 * 
	 * @param trainNo the train number
	 * @return the All Trains page
	 */
	@PostMapping("/searchtrain")
	public String searchTrain(Model model, @RequestParam long trainNo) {
		model.addAttribute("trains", trainService.searchTrainById(trainNo));
		return "alltrains";
	}

	/**
	 * Handles request to get all trains
	 * 
	 * @param modelMap the ModelMap object
	 * @return the All Trains page
	 */
	@GetMapping("/trains")
	public String viewAllTrains(ModelMap modelMap) {
		modelMap.put("trains", trainService.getAllTrains());
		return "alltrains";
	}

	/**
	 * Handles request to get the form to add new train
	 * 
	 * @return the New Train page
	 */
	@GetMapping("/newtrain")
	public String newTrainPage() {
		return "newtrain";
	}

	/**
	 * Handles request to add a new train
	 * 
	 * @param model             the Model object,
	 * @param trainDto          the Train details,
	 * @param departureTimeUtil the departure time,
	 * @param arrivalTimeUtil   the arrival time
	 * @return forwards to All Trains page with appropriate message
	 */
	@PostMapping("/newtrain")
	public String addTrain(Model model, @ModelAttribute TrainDto trainDto,
			@RequestParam @DateTimeFormat(pattern = "HH:mm") Date departureTimeUtil,
			@RequestParam @DateTimeFormat(pattern = "HH:mm") Date arrivalTimeUtil) {

		boolean verified = trainService.verifyUniqueTrainNo(trainDto.getTrainNo());

		if (verified) {
			trainService.addTrain(trainDto, departureTimeUtil, arrivalTimeUtil);
			return "redirect:/admin/trains?added";
		}
		return "forward:/admin/newtrain?error";

	}

	/**
	 * Handles request to get the form to reschedule a train
	 * 
	 * @param trainNo the train number,
	 * @param model   the Model object
	 * @return the Schedule train page
	 */
	@GetMapping("/scheduletrain")
	public String getScheduleTrainPage(@RequestParam long trainNo, Model model) {
		TrainDto trainDto = trainService.getTrainDto(trainNo);
		model.addAttribute("train", trainDto);
		return "scheduletrain";
	}

	/**
	 * Handles request to reschedule a train
	 * 
	 * @param trainNo           the train number,
	 * @param departureTimeUtil the departure time,
	 * @param arrivalTimeUtil   the arrival time
	 * @return the All trains page with appropriate message
	 */
	@PostMapping("/scheduletrain")
	public String scheduleTrain(@RequestParam long trainNo,
			@RequestParam @DateTimeFormat(pattern = "HH:mm") Date departureTimeUtil,
			@RequestParam @DateTimeFormat(pattern = "HH:mm") Date arrivalTimeUtil) {
		TrainDto trainDto = trainService.getTrainDto(trainNo);
		trainService.addTrain(trainDto, departureTimeUtil, arrivalTimeUtil);
		return "redirect:/admin/trains?rescheduled";
	}

	/**
	 * Handles request to get all unresolved requests
	 * 
	 * @param model the Model object
	 * @return the Unresolved tickets page
	 */
	@GetMapping("/tickets")
	public String getUnresolvedTicketsPage(Model model) {
		model.addAttribute("tickets", helpService.getUnresolvesTickets());
		return "unresolvedTickets";
	}

	/**
	 * Handles request to get the form to resolve a request
	 *
	 * @param model    the Model object,
	 * @param ticketId the Id number of raised ticket
	 * @return the resolve ticket page
	 */
	@GetMapping("/resolve")
	public String resolveTicket(Model model, @RequestParam long ticketId) {
		model.addAttribute("ticket", helpService.getTicketById(ticketId));
		model.addAttribute("username", helpService.getUsername(ticketId));
		return "resolveTicket";
	}

	/**
	 * Handles request to post a resolution to a ticket
	 *
	 * @param ticketId   the Id number of raised ticket,
	 * @param resolution the resolution provided by the admin
	 * @return the unresolved tickets page
	 */
	@PostMapping("/resolve")
	public String addResolution(@RequestParam long ticketId, @RequestParam String resolution) {
		helpService.addResolution(ticketId, resolution);
		return "redirect:/admin/tickets";
	}

}
