package control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.everis.control.CarService;
import com.everis.control.PersistenceService;
import com.everis.entity.Brand;
import com.everis.entity.Car;
import com.everis.entity.CarDto;
import com.everis.entity.Country;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTests {

	@InjectMocks
	private CarService carService;
	
	@Mock
	private PersistenceService<Car, String> persistenceService;
	
	private Car car;
	
	@Before
	public void setUp() throws Exception{
		car = new Car();
		car.setId("3");
		car.setBrand(new Brand("1", "BMW"));
		car.setCountry(new Country("1", "Spain"));
		car.setRegistration(LocalDateTime.now());
		car.setCreatedAt(LocalDateTime.now());
		car.setLastUpdated(LocalDateTime.now());
	}
	
	@Test
	public void testGetCars() {
		List<Car> carListExpected = new ArrayList<Car>();
		when(persistenceService.getAll(Car.class, null, 0, null, 0, null)).thenReturn(carListExpected);
		List<Car> carListResult = carService.getCars(null, 0, null, 0, null);
		assertEquals(carListExpected, carListResult);
	}
	
	@Test
	public void testGetCar() {
		when(persistenceService.getById(Car.class, "3")).thenReturn(car);
		Car carResult = carService.getCar("3");
		assertEquals("3", carResult.getId());
	}
	
	@Test
	public void testCreateCar() {
		CarDto carDto = createDto();
		when(persistenceService.createOne(Mockito.any())).thenReturn(car);
		Car carResult = carService.createCar(carDto);
		assertEquals("3", carResult.getId());
	}
	
	@Test
	public void testUpdateCar() {
		CarDto carDto = createDto();
		when(persistenceService.getById(Car.class, "3")).thenReturn(car);
		when(persistenceService.updateOne(Mockito.any())).thenReturn(car);
		Car carResult = carService.updateCar(carDto);
		assertEquals("3", carResult.getId());
	}
	
	@Test
	public void testDeleteCar() {
		CarDto carDto = createDto();
		when(persistenceService.getById(Car.class, "3")).thenReturn(car);
		when(persistenceService.deleteOne(Mockito.any())).thenReturn(car);
		Car carResult = carService.deleteCar(carDto.getId());
		assertEquals("3", carResult.getId());
	}
	
	private CarDto createDto() {
		CarDto carDto = new CarDto();
		carDto.setId("3");
		return carDto;
	}
}
