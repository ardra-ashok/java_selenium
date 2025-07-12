package Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class Download_Upload {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @Test
    public void download_Upload() throws IOException {

        String fruitName = "Apple";
        String downloadFilepath = "/Users/aashok/IdeaProjects/java_selenium/supportData/dataFiles";
        String uploadFilepath = "/Users/aashok/IdeaProjects/java_selenium/supportData/dataFiles/download.xlsx";
        String downloadFile = downloadFilepath + "/download.xlsx";

        File existingFile = new File(downloadFile);
        if (existingFile.exists()) {
            existingFile.delete();
            System.out.println("Old file deleted.");
        }
        webDriver = setupChrome(downloadFilepath);
        webDriver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        webDriver.findElement(By.cssSelector("[id='downloadButton']")).click();

        File downloadedFile = new File(uploadFilepath);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(driver -> downloadedFile.exists());

        int columnNum = getColorRowNumber(uploadFilepath,"price","column");
        int rowNum = getColorRowNumber(uploadFilepath,"apple", "row");
        updateCell(uploadFilepath,rowNum,columnNum,"200");

        WebElement upload = webDriver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys(uploadFilepath);

        By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
        webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        assertEquals("Updated Excel Data Successfully.",webDriver.findElement(toastLocator).getText());

        String priceColumn = webDriver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-Id");
        String actualPrice = webDriver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
        assertEquals("200",actualPrice);
        webDriver.quit();

    }

    private boolean updateCell(String fileName, int rowNum, int columnNum, String updatedValue) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        fis.close();
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(columnNum);
        if (cell == null) {
            cell = row.createCell(columnNum);
        }
        cell.setCellValue(updatedValue);
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.flush();
        fos.close();
        workbook.close();

        return true;
    }


    private WebDriver setupChrome(String downloadFilepath) {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("safebrowsing.enabled", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(5));

        return webDriver;
    }

    public int getColorRowNumber(String fileName, String attribute, String rowOrCol) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Iterator<Row> rows = sheet.iterator();
        int column = 0;
        int rowIndex = -1;
        boolean flag = false;
            while (rows.hasNext()) {
                    Row row = rows.next();
                    rowIndex = row.getRowNum();
                    Iterator<Cell> ce = row.cellIterator();
                    int k = 0;
                    while (ce.hasNext()) {
                        Cell value = ce.next();
                        String cellContent = formatter.formatCellValue(value);
                        if (cellContent.equalsIgnoreCase(attribute)) {
                            column = k;
                            flag = true;
                            break;
                        }
                        k++;
                    }
                    if(flag)
                        break;

            }
        if(rowOrCol.equalsIgnoreCase("column"))
            return column;
        else
            return rowIndex;
    }
}
