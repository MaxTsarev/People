public class Main {

    public static void main(String[] args) {

        Person dad = new PersonBuilder()
                .setName("Иван")
                .setSurname("Пушкин")
                .setAddress("Воркута")
                .setAge(40)
                .build();

        dad.happyBirthday();
        System.out.println(dad.hasAge());
        System.out.println(dad);

        Person son = dad.newChildBuilder()
                .setName("Дмитрий")
                .build();

        System.out.println(son);

        Person person = new PersonBuilder()
                .setName("Сергей")
                .setSurname("Иванов")
                .build();

        System.out.println(person.hasAddress());

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Сергей").setSurname("Новиков").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
