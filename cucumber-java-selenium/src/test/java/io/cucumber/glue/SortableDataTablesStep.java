package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.SortableDataTablesPage;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class SortableDataTablesStep extends Context {
    public SortableDataTablesStep(Manager manager) {
        super(manager);
    }
    SortableDataTablesPage sortableDataTablesPage = new SortableDataTablesPage(getDriver());

    @When("I view Example 1 table")
    public void i_view_example_1_table(){
        System.out.println("Print table 1 >>> "+sortableDataTablesPage.getExample1Table());
    }

    @Then("the table in Example 1 is displayed as expected")
    public void theTableInExampleIsDisplayedAsExpected() {
        List<List<String>> getTable1 = sortableDataTablesPage.getExample1Table();

        List<List<String>> expectedTable1 = Arrays.asList(
                Arrays.asList("Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com"),
                Arrays.asList("Bach", "Frank", "fbach@yahoo.com", "$51.00", "http://www.frank.com"),
                Arrays.asList("Doe", "Jason", "jdoe@hotmail.com", "$100.00", "http://www.jdoe.com"),
                Arrays.asList("Conway", "Tim", "tconway@earthlink.net", "$50.00", "http://www.timconway.com")
        );

        Assertions.assertEquals(getTable1, expectedTable1);

    }
}
