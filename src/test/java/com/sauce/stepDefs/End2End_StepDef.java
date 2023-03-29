package com.sauce.stepDefs;

import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class End2End_StepDef {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    @When("The user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("The user should be able to login and see {string} header")
    public void theUserShouldBeAbleToLoginAndSeeHeader(String expectedText) {
        productsPage.isDisplayedMethod();
    }

    @And("The user should be able to sort products {string}")
    public void theUserShouldBeAbleToSortProducts(String sortType) {
        productsPage.sortProduct(sortType);
    }

    @When("The user clicks the cheapest as {string} and the second costliest as {string} products")
    public void theUserClicksTheCheapestAsAndTheSecondCostliestAsProducts(String cheapest, String secondCost) {
        productsPage.addProducts(cheapest);
        productsPage.addProducts(secondCost);
    }

    @And("The user opens basket")
    public void theUserOpensBasket() {
        productsPage.cartBtn.click();
    }

    @And("The user clicks on checkout button")
    public void theUserClicksOnCheckoutButton() {
        checkoutPage.checkoutBtn.click();
    }

    @And("The user enters details as {string} {string} {string} and finish purchase")
    public void theUserEntersDetailsAsAndFinishPurchase(String firstName, String lastName, String postalCode) {
        checkoutPage.enterDetails(firstName,lastName,postalCode);
    }

    @Then("The user verifies that the items are {string} and total is {string}")
    public void theUserVerifiesThatTheItemsAreAndTotalIs(String totalPrice, String expectedTotal) {
        Assert.assertEquals(expectedTotal,checkoutPage.getTotalPrice(totalPrice));
        System.out.println("expectedTotal = " + expectedTotal);
        System.out.println("totalPrice = " + totalPrice);
    }
}
