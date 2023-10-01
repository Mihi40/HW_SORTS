package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void testSortTicketWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KRD", "КZN", 200, 2, 9);
        Ticket ticket2 = new Ticket("KRD", "КZN", 800, 10, 16);
        Ticket ticket3 = new Ticket("КRD", "MSK", 600, 15, 18);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "OMS", 400, 16, 20);
        Ticket ticket6 = new Ticket("KRD", "КZN", 300, 12, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("KRD", "КZN", comparator);
        Ticket[] expected = {ticket6, ticket2, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KRD", "КZN", 200, 2, 9);//7
        Ticket ticket2 = new Ticket("KRD", "КZN", 800, 10, 16);//6
        Ticket ticket3 = new Ticket("КRD", "MSK", 600, 15, 18);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "OMS", 400, 16, 20);
        Ticket ticket6 = new Ticket("KRD", "КZN", 300, 12, 17);//5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("SPB", "OMS", comparator);
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortNoTicketWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KRD", "КZN", 200, 2, 9);
        Ticket ticket2 = new Ticket("KRD", "КZN", 800, 10, 16);
        Ticket ticket3 = new Ticket("КRD", "MSK", 600, 15, 18);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "OMS", 400, 16, 20);
        Ticket ticket6 = new Ticket("KRD", "КZN", 300, 12, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("MSK", "OMS", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketByPrice() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "КZN", 500, 12, 19);
        Ticket ticket2 = new Ticket("SPB", "OMS", 300, 10, 16);//1
        Ticket ticket3 = new Ticket("КRD", "MSK", 600, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "KZN", 700, 13, 15);
        Ticket ticket5 = new Ticket("SPB", "OMS", 400, 16, 20);//2
        Ticket ticket6 = new Ticket("SPB", "OMS", 800, 11, 16);//3

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("SPB", "OMS");
        Ticket[] expected = {ticket2, ticket5, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketByPriceOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "КZN", 500, 12, 19);
        Ticket ticket2 = new Ticket("MSK", "KZN", 300, 10, 16);
        Ticket ticket3 = new Ticket("КRD", "MSK", 600, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "KZN", 700, 13, 15);
        Ticket ticket5 = new Ticket("MSK", "OMS", 400, 16, 20);
        Ticket ticket6 = new Ticket("MSK", "КZN", 800, 11, 16);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("MSK", "OMS");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketByPriceNoTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "КZN", 500, 12, 19);
        Ticket ticket2 = new Ticket("MSK", "KZN", 300, 10, 16);
        Ticket ticket3 = new Ticket("КRD", "MSK", 600, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "KZN", 700, 13, 15);
        Ticket ticket5 = new Ticket("MSK", "OMS", 400, 16, 20);
        Ticket ticket6 = new Ticket("MSK", "КZN", 800, 11, 16);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("MSK", "LA");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
