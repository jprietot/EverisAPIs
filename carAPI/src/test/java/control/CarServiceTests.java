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
import org.mockito.Mock;
import org.mockito.Mockito;

import com.everis.control.CarService;
import com.everis.entity.Car;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTests {

	@Mock
	private CarService carService;
	
	private Car car;
	
	@Before
	public void setUp() throws Exception{
		car = new Car();
		car.setId("3");
		car.setBrand("TestCar");
		car.setCountry("Spain");
		car.setRegistration(LocalDateTime.now());
		car.setCreatedAt(LocalDateTime.now());
		car.setLastUpdated(LocalDateTime.now());
	}
	
	@Test
	public void testGetCars() {
		List<Car> carListExpected = new ArrayList<Car>();
		doReturn(carListExpected).when(carService).getCars();
		List<Car> carListToCompare = carService.getCars();
		assertEquals(carListToCompare, carListExpected);
	}
	
	@Test
	public void testGetCar() {
		doReturn(car).when(carService).getCar("3");
		Car carExpected = car;
		Car carToCompare = carService.getCar("3");
		assertEquals(carToCompare, carExpected);
	}
	
	@Test
	public void testCreateCar() {
		doReturn(car).when(carService).createCar(car);
		Car carExpected = car;
		Car carToCompare = carService.createCar(car);
		assertEquals(carToCompare, carExpected);
	}
	
	@Test
	public void testUpdateCar() {
		doReturn(car).when(carService).getCar("3");
		car.setBrand("TestCarUpdated");
		Car carUpdate = carService.getCar("3");
		doReturn(carUpdate).when(carService).updateCar(car);
		Car carExpected = carUpdate;
		Car carToCompare = carService.updateCar(car);
		assertEquals(carToCompare, carExpected);
	}
	
	@Test
	public void testDeleteCar() {
		doReturn(car).when(carService).deleteCar("3");
		Car carExpected = car;
		Car carToCompare = carService.deleteCar("3");
		assertEquals(carToCompare, carExpected);
	}
}
