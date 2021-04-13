package boundary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.everis.boundary.CarResource;
import com.everis.control.CarService;
import com.everis.entity.Car;

@RunWith(MockitoJUnitRunner.class)
public class CarResourceTests {

	@InjectMocks
	private CarResource carResource;
	
	@Mock
	private CarService carService;
	
	@Mock
	private UriInfo uriInfo;
	
	private Car car;
	
	@Before
	public void setUp() throws Exception{
		car = new Car();
		car.setId(3);
		car.setBrand("TestCar");
		car.setCountry("Spain");
		car.setRegistration(LocalDateTime.now());
		car.setCreatedAt(LocalDateTime.now());
		car.setLastUpdated(LocalDateTime.now());
	}
	
	@Test
	public void testGetCars() {
		List<Car> carList = new ArrayList<Car>();
		when(this.carService.getCars()).thenReturn(carList);
		Response response = this.carResource.getCars();
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
	
	/*@Test
	public void testGetCar() {
		when(carService.getCar(Mockito.eq(3))).thenReturn(car);
		Response response = carResource.getCar(car.getId());
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}*/
	
	/*@Test
	public void testCreateCar() {
		doNothing().when(carService).createCar(car);
		Response response = carResource.createCar(car, uriInfo);
		assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testUpdateCar() {
		when(carService.getCar(Mockito.eq(3))).thenReturn(car);
		car.setBrand("TestCarUpdated");
		doNothing().when(carService).updateCar(car);
		Response response = carResource.updateCar(car.getId(), car);
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testDeleteCar() {
		doNothing().when(carService).deleteCar(Mockito.eq(3));
		Response response = carResource.deleteCar(car.getId());
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}*/
}
