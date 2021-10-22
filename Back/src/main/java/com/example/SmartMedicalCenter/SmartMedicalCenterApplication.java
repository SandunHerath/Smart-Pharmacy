package com.example.SmartMedicalCenter;

import com.example.SmartMedicalCenter.model.Medicine;
import com.example.SmartMedicalCenter.model.User;
import com.example.SmartMedicalCenter.service.MedicineService;
import com.example.SmartMedicalCenter.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SmartMedicalCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartMedicalCenterApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService, MedicineService medicineService){
		return args->{

			userService.saveUser(new User(null,"Sandun","sandunherath124@gmail.com","1234"));
			userService.saveUser(new User(null,"Bandara","sandunzz","1234"));

			medicineService.SaveMedicine(new Medicine(null,"Tomato","https://image.shutterstock.com/z/stock-photo-woman-hand-planting-spinach-seeds-farming-gardening-organic-food-concept-1362887180.jpg","Seeds",40.00,"20 seeds in a pack"));
			medicineService.SaveMedicine(new Medicine(null,"Chilli","https://m.media-amazon.com/images/I/71rGnq5Z65L._SL1200_.jpg","Seeds",60.00,"40 seeds in a pack"));
			medicineService.SaveMedicine(new Medicine(null,"Beans","https://5.imimg.com/data5/SELLER/Default/2020/8/FH/YD/XJ/6399641/serengati-bean-seeds-500x500.jpg","Seeds",40.00,"20 seeds in a pack"));

		};
	}
}
