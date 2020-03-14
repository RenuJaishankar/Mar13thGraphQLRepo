package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class ArcadeGame {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    //I need to use type of Long (wrapper class) for my ID
    private String name;
    private int amountOfPlayers;

    public ArcadeGame(String name, int amountOfPlayers) {
        this.name = name;
        this.amountOfPlayers = amountOfPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArcadeGame that = (ArcadeGame) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(amountOfPlayers, that.amountOfPlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amountOfPlayers);
    }

    @Override
    public String toString() {
        return "ArcadeGame{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amountOfPlayers='" + amountOfPlayers + '\'' +
                '}';
    }

    public ArcadeGame() {
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }
}
