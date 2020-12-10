package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilesTest {

    @Test
    public void whenCollectReturnAddresses() {
        List<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile(new Address("Orsk","Lenin",5,23)));
        profiles.add(new Profile(new Address("Penza","Mira",41,23)));
        List<Address> expected = Arrays.asList(new Address("Orsk", "Lenin", 5, 23)
                , new Address("Penza","Mira",41,23));
        assertThat(new Profiles().collect(profiles), is(expected));
    }

    @Test
    public void whenCollectDuplicatesReturnAddressesWithoutDuplicatesAndSorted() {
        List<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile(new Address("Orsk","Lenin",5,23)));
        profiles.add(new Profile(new Address("Penza","Mira",41,23)));
        profiles.add(new Profile(new Address("Penza","Mira",41,23)));
        profiles.add(new Profile(new Address("Moskva","Lermontova",25,1)));
        List<Address> expected = Arrays.asList(new Address("Moskva","Lermontova",25,1)
                , new Address("Orsk", "Lenin", 5, 23)
                , new Address("Penza","Mira",41,23));
        assertThat(new Profiles().collect(profiles), is(expected));
    }
}
