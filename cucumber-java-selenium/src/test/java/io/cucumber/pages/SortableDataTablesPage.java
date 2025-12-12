package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortableDataTablesPage extends GenericPage{

    public SortableDataTablesPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(css = "#table1 tbody tr")
    private List<WebElement> rows;

    public List<List<String>> getExample1Table() {
        List<List<String>> table = new ArrayList<>();

        for (WebElement row : rows) {
            List<String> cells = row.findElements(By.tagName("td")).
                    stream().limit(5).
                    map(WebElement::getText).
                    collect(Collectors.toList());
            table.add(cells);
        }

        return table;
    }

}
