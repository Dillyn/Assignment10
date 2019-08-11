package ac.za.cput.utils;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Race {
    private String raceNumber;
    private String description;


    private Race() {
    }

    private Race(Race.Builder builder) {
        this.raceNumber = builder.raceNumber;
        this.description = builder.description;
    }

    public String getRaceNumber() { return raceNumber; }

    public String getDescription() {
        return description;
    }



    public static class Builder {

        private String raceNumber, description;

        public Race.Builder raceNumber(String raceNumber) {
            this.raceNumber = raceNumber;
            return this;
        }

        public Race.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Race race){
            this.raceNumber = race.raceNumber;
            this.description = race.description;
            return this;
        }

        public Race build() {
            return new Race(this);
        }

    }

    @Override
    public String toString() {
        return "Race{" +
                "raceNumber=" + raceNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return race.equals(race.raceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceNumber);
    }

}
