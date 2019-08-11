package ac.za.cput.utils;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Gender {
    private String genderNumber;
    private String description;


    private Gender() {
    }

    private Gender(Gender.Builder builder) {
        this.genderNumber = builder.genderNumber;
        this.description = builder.description;
    }

    public String getGenderNumber() { return genderNumber; }

    public String getDescription() {
        return description;
    }



    public static class Builder {

        private String genderNumber, description;

        public Gender.Builder genderNumber(String genderNumber) {
            this.genderNumber = genderNumber;
            return this;
        }

        public Gender.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Gender gender){
            this.genderNumber = gender.genderNumber;
            this.description = gender.description;
            return this;
        }

        public Gender build() {
            return new Gender(this);
        }

    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderNumber=" + genderNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return gender.equals(gender.genderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderNumber);
    }

}

