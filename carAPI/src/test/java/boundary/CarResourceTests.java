package boundary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;

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
import com.everis.entity.CarDto;

@RunWith(MockitoJUnitRunner.class)
public class CarResourceTests {

	@InjectMocks
	private CarResource carResource;
	
	@Mock
	private CarService carService;
	
	@Mock
	private UriInfo uriInfo;
	
	@Mock
	private UriBuilder uriBuilder;
	
	private CarDto car;
	
	@Before
	public void setUp() throws Exception{
		car = new CarDto();
		car.setId("3");
		car.setBrand("TestCar");
		car.setCountry("Spain");
		car.setRegistration(LocalDateTime.now());
		car.setCreatedAt(LocalDateTime.now());
		car.setLastUpdated(LocalDateTime.now());
	}
	
	@Test
	public void testGetCars() {
		List<CarDto> carList = new ArrayList<CarDto>();
		when(this.carService.getCars()).thenReturn(carList);
		Response response = this.carResource.getCars();
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testGetCar() {
		when(carService.getCar("3")).thenReturn(car);
		Response response = carResource.getCar(car.getId());
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testGetCarFail() {
		when(carService.getCar("3")).thenReturn(null);
		Response response = carResource.getCar(car.getId());
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testCreateCar() throws IllegalArgumentException, UriBuilderException, URISyntaxException {
		when(carService.createCar(car)).thenReturn(car);
		when(uriInfo.getAbsolutePathBuilder()).thenReturn(uriBuilder);
		when(uriBuilder.path("3")).thenReturn(uriBuilder);
		when(uriBuilder.build()).thenReturn(new URI("testUri"));
		Response response = carResource.createCar(car, uriInfo);
		assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testUpdateCar() {
		car.setBrand("TestCarUpdated");
		when(carService.updateCar(car)).thenReturn(car);
		Response response = carResource.updateCar(car.getId(), car);
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testUpdateCarFail() {
		car.setBrand("TestCarUpdated");
		when(carService.updateCar(car)).thenReturn(null);
		Response response = carResource.updateCar(car.getId(), car);
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testDeleteCar() {
		when(carService.deleteCar("3")).thenReturn(car);
		Response response = carResource.deleteCar(car.getId());
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testDeleteCarFail() {
		when(carService.deleteCar("3")).thenReturn(null);
		Response response = carResource.deleteCar(car.getId());
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
}
