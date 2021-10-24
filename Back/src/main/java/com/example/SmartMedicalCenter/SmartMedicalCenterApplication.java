package com.example.SmartMedicalCenter;

import com.example.SmartMedicalCenter.model.Doctor;
import com.example.SmartMedicalCenter.model.Medicine;
import com.example.SmartMedicalCenter.model.User;
import com.example.SmartMedicalCenter.service.DoctorService;
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
	CommandLineRunner run(UserService userService, MedicineService medicineService, DoctorService doctorService){
		return args->{

			userService.saveUser(new User(null,"Janaka","janaka124@gmail.com","1234"));
			userService.saveUser(new User(null,"Sampath","sampathz@gmail.com","1234"));

			medicineService.SaveMedicine(new Medicine(null,"Aspirin 500mg","https://apozona.com/wp-content/uploads/2020/10/aspirin-500mg-80.jpg","Caps",20.00,"12 caps in a card"));
			medicineService.SaveMedicine(new Medicine(null,"Penicillin","https://d2jx2rerrg6sh3.cloudfront.net/image-handler/ts/20210225083410/ri/673/picture/2021/2/shutterstock_1082421920.jpg","Caps",6.00,"16 caps in a card"));
			medicineService.SaveMedicine(new Medicine(null,"Insulin","https://media.nature.com/lw800/magazine-assets/d41586-020-01891-8/d41586-020-01891-8_18111016.jpg","Liquid",400.00,"20 ml in a bottle"));
			medicineService.SaveMedicine(new Medicine(null,"Centrum","https://www.scotsman.com/images-e.jpimedia.uk/imagefetch/http://www.scotsman.com/webimage/Prestige.Item.1.41300424!image/1827829050.jpg?crop=982:524,smart&width=640","Tabs",316.00,"20 tabs in a pack"));

			doctorService.SaveDoctor(new Doctor(null,"Janaka","https://st.depositphotos.com/1771835/1477/i/950/depositphotos_14779771-stock-photo-portrait-of-confident-young-doctor.jpg","Hart","Colombo","Male"));
			doctorService.SaveDoctor(new Doctor(null,"Chris","https://thumbs.dreamstime.com/b/young-male-doctor-close-up-happy-looking-camera-56751540.jpg","Mental","Kandy","Male"));
			doctorService.SaveDoctor(new Doctor(null,"Danny","https://thumbs.dreamstime.com/b/young-doctor-book-2954226.jpg","Mental","Kurunegala","Female"));
			doctorService.SaveDoctor(new Doctor(null,"Alex","https://thumbs.dreamstime.com/b/young-beautiful-successful-female-doctor-stethoscope-portrait-copy-space-82387502.jpg","Dental","Colombo","Female"));
		};
	}
}
