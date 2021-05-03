package com.movierental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;
    @Before
    public void verifyThatGeneratedStatementIsCorrect() {
        customer = new Customer("Dhrupad");
        customer.addRental(new Rental(new Movie("Godfather", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Justice League", Movie.NEW_RELEASE), 4));
    }
    @Test
    public void shouldGenerateTextStatement(){
        assertEquals("Rental Record for Dhrupad\n" +
                "\tGodfather\t3.5\n" +
                "\tToy Story\t2.0\n" +
                "\tJustice League\t12.0\n" +
                "Amount owed is 17.5\n" +
                "You earned 4 frequent renter points",customer.statement());
    }

    @Test
    public void shouldGenerateHTMLStatement(){
        assertEquals("<h1>Rental Statement for <b>Dhrupad</b></h1><br/>" +
                "Godfather 3.5<br/>" +
                "Toy Story 2.0<br/>" +
                "Justice League 12.0<br/>" +
                "Amount owed is <b>17.5</b><br/>" +
                "You earned <b>4</b> frequent renter points",customer.htmlStatement());
    }
}