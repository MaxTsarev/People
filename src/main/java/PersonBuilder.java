public class PersonBuilder {

    String name;
    String surname;
    int age;
    String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        try {
            if (age <= 0 || age > 100) {
                throw new IllegalArgumentException("Вы ввели некорректный возраст!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public Person build() throws IllegalStateException {
        try {
            if (name == null || surname == null) {
                throw new IllegalStateException("Вы не указали имя или фамилию!");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return new Person(name, surname, age, address);
    }
}
