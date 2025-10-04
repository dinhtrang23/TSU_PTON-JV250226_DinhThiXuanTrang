package ra.edu.final_exam_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.final_exam_javaweb.dto.request.FlightRequestCreateDTO;
import ra.edu.final_exam_javaweb.model.Flight;
import ra.edu.final_exam_javaweb.service.FlightService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/flightController")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @GetMapping("findAll")
    public String findAllFlight(Model model) {
        List<Flight> listFlights = flightService.findAll();
        model.addAttribute("listFlights", listFlights);
        return "flights";
    }

    @GetMapping("/initCreate")
    public String initCreateFlight(Model model) {
        FlightRequestCreateDTO flightDto = new FlightRequestCreateDTO();
        model.addAttribute("flightDto",flightDto);
        return "newFlight";
    }

    @PostMapping("/create")
    public String createFlight(@Valid @ModelAttribute(name = "flightDto") FlightRequestCreateDTO flightDto, BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
          return "newFlight";
      }
      boolean result = flightService.create(flightDto);
      if (result) {
          return "redirect:findAll";
      }
      return "error";
    }

    @GetMapping("/initUpdate")
    public String initUpdateFlight(Model model, String flightId) {
        Flight flight = flightService.findById(1);
        model.addAttribute("flight", flight);
        return "updateFlight";
    }

    @PostMapping("/update")
    public String updateFlight(Flight flight){
        boolean result = flightService.update(flight);
        if (result) {
            return "redirect:findAll";
        }else{
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteFlight(Flight flightId) {
        boolean result = flightService.delete(flightId);
        if (result) {
        return "redirect:findAll";
        }else {
            return "error";
        }
    }

}
