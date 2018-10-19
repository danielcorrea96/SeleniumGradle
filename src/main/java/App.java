import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
	public static WebDriver driver; // Declara la variable "driver" como elemento WebDriver y static.
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver","chromedriver.exe"); // Define el driver correspondiente al navegador y su ruta.
    	System.out.println("WebDriver inicializado"); // Imprime en pantalla.
    	driver = new ChromeDriver(); // Define la variable "driver" como un driver especifico del navegador.
    	
    	driver.manage().window().maximize(); // Maximixa la pantalla del navegador.
    	driver.get("https://www.google.com.co"); // Estable la página en la que inicia el navegador.
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); // Tiempo de espera implicito.
    	  	
    	
    	WebElement search;
    	search = driver.findElement(By.xpath("//input[@id='lst-ib']"));
    	search.sendKeys("Medellín\n");   
    	
    	WebElement Wiki;
    	Wiki = driver.findElement(By.xpath("//a[@href=\"https://es.wikipedia.org/wiki/Medell%C3%ADn\"]"));
    	Wiki.click();
    	
    	WebElement getTe;
    	getTe = driver.findElement(By.xpath("//h1[@class=\"firstHeading\"]"));
    	System.out.println(getTe.getText());    	
    	if (getTe.getText().equalsIgnoreCase("Medellín")) {
    		System.out.println("Es igual a Medellín");
    	} else {
    		System.out.println("No es igual a Medellín.");
    	}
    	
    	WebDriverWait wait = new WebDriverWait(driver, 20); // Instancia de driver con tiempo de espera definido. 
    	WebElement sendInfo;
    	sendInfo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"search\"]"))); // Tiempo de espera explicito.   	
    	sendInfo.sendKeys("Esto es una prueba");
    	// Suspende el hilo actual por la cantidad de tiempo que se especifique. 
    	// Esto es una mala práctica, pero para este caso funciona.
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	sendInfo.clear();    	
    }
}
