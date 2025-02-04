package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    public Collection<CreditCard> getOwnedCards() {
        return new HashSet<>(creditCards);
    }

    @OneToMany(mappedBy = "bank")
    @Getter
    private Collection<CreditCard> creditCards = new ArrayList<>();
}
