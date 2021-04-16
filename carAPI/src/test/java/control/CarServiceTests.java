//package control;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.doReturn;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import com.everis.control.CarService;
//import com.everis.control.PersistenceService;
//import com.everis.entity.Car;
//import com.everis.entity.CarDto;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CarServiceTests {
//
//	@InjectMocks
//	private CarService carService;
//	
//	@Mock
//	private PersistenceService<Car, String> persistenceService;
//	
//	private Car car;
//	
//	@Before
//	public void setUp() throws Exception{
//		car = new Car();
//		car.setId("3");
//		car.setBrand("TestCar");
//		car.setCountry("Spain");
//		car.setRegistration(LocalDateTime.now());
//		car.setCreatedAt(LocalDateTime.now());
//		car.setLastUpdated(LocalDateTime.now());
//	}
//	
//	@Test
//	public void testGetCars() {
//		List<Car> carListExpected = new ArrayList<Car>();
//		when(persistenceService.getAll("Car.GetAllCars", Car.class)).thenReturn(carListExpected);
//		List<Car> carListResult = carService.getCars();
//		assertEquals(carListExpected, carListResult);
//	}
//	
//	@Test
//	public void testGetCar() {
//		when(persistenceService.getById(Car.class, "3")).thenReturn(car);
//		Car carResult = carService.getCar("3");
//		assertEquals("3", carResult.getId());
//	}
//	
//	@Test
//	public void testCreateCar() {
//		when(persistenceService.createOne(car)).thenReturn(car);
//		Car carResult = carService.getCar("3");
//		assertEquals("3", carResult.getId());
//	}
//	
//	@Test
//	public void testUpdateCar() {
//		doReturn(car).when(carService).getCar("3");
//		car.setBrand("TestCarUpdated");
//		CarDto carUpdate = carService.getCar("3");
//		doReturn(carUpdate).when(carService).updateCar(car);
//		CarDto carExpected = carUpdate;
//		CarDto carToCompare = carService.updateCar(car);
//		assertEquals(carToCompare, carExpected);
//	}
//	
//	@Test
//	public void testDeleteCar() {
//		doReturn(car).when(carService).deleteCar("3");
//		CarDto carExpected = car;
//		CarDto carToCompare = carService.deleteCar("3");
//		assertEquals(carToCompare, carExpected);
//	}
//}
