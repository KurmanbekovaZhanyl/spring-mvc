package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/page")
public class Cars {
    static List<Car> cars = List.of(
            new Car("grey","Toyota",5000),
            new Car("black","Honda",12000),
            new Car("red","Volvo",10000),
            new Car("yellow","BMW",20000),
            new Car("white","Tiko",3000));

    @GetMapping
    public String helloPage(@RequestParam(value = "name", required = false) String name, Model model){
     model.addAttribute("cars",cars);
     return "cars";
    }

    @GetMapping("/")
    public String getCars(@RequestParam(value = "count", required = false) int count, Model model) {
        List<Car> carList =new ArrayList<>();
        if (count > 5) {
            model.addAttribute("cars",cars);
        }else {
            for (int i = 0; i < count ; i++) {
             carList.add(cars.get(i));
            }
           model.addAttribute("cars",carList);
        }
        return "cars";
    }

}
