import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("uk", "UA"));
        Scanner scan = new Scanner(System.in);
        String regexForDate = "^((0|1|2|3)\\d{1})-((0|1)\\d{1})-((19|20)\\d{2})";
        Pattern pattern = Pattern.compile(regexForDate);
        String regexForDuration = "[0-9]*$";
        Pattern pattern1 = Pattern.compile(regexForDuration);
        String regexForDataFormat = "mp[3-4]";
        Pattern pattern2 = Pattern.compile(regexForDataFormat);
        String regexForRating = "[0-5]";
        Pattern pattern3 = Pattern.compile(regexForRating);
        boolean auto = false;
        for(String i: args){
            if(i.equals("-auto")){
                auto = true;
                System.out.println("Авторежим запущено");
                break;
            }
        }
        try {
            if(auto) {
                scan = new Scanner(new BufferedInputStream(
                        new FileInputStream("C:\\Users\\Sofiia\\IdeaProjects\\chaban-sofiia-lab05\\src\\automode.txt")));
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
            System.out.println("Aвтoрежим було зупинено");
            scan = new Scanner(System.in);
        }
        ArrayList<Composition> compositions = new ArrayList<>();
        System.out.println("----Доброго дня!----");
        byte choice;
        while (true) {
            System.out.println("=-=-=-=Меню=-=-=-=-=");
            System.out.println("1 - Додати нову композицію в аудіотеку");
            System.out.println("2 - Показати створені композиції");
            System.out.println("3 - Видалити існуючу компзицію");
            System.out.println("4 - Перейти до меню композиції");
            System.out.println("5 - Записати коспозиції до XML файлу");
            System.out.println("6 - Зчитати композиції з XML");
            System.out.println("7 - Вийти");
            System.out.println("=-=-=-=-=-==-=-=-=-=-=");
            System.out.println("Введіть пункт меню:");
            choice = scan.nextByte();
            switch (choice) {
                case 1:
                    System.out.println("Щоб створити композицію введіть її назву,виконавця,жанр,дату створення,тривалість,формат даних,рейтинг:");
                    System.out.println("Введіть назву:");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Введіть виконавця:");
                    String author = scan.nextLine();
                    System.out.println("Введіть жанр:");
                    String genre = scan.nextLine();
                    System.out.println("Введіть дату створення в форматі 'дд-мм-рррр':");
                    String date = scan.nextLine();
                    Matcher m = pattern.matcher(date);
                    if(m.matches()){
                        System.out.println("Введена дата відповідає регулярному виразу");
                    }
                    else
                    {
                        System.out.println("Неправильно введена дата. Не відповідає регулярному виразу (формат: дд-мм-рррр). Спробуйте ще раз.");
                        break;
                    }
                    System.out.println("Введіть тривалість в секундах:");
                    String duration = scan.nextLine();
                    Matcher m1 = pattern1.matcher(duration);
                    if(m1.matches()){
                        System.out.println("Введена тривалість відповідає регулярному виразу");
                    }
                    else {
                        System.out.println("Неправильно введена тривалість. Не відповідає регулярному виразу (лише цифри). Спробуйте ще раз");
                        break;
                    }
                    System.out.println("Введіть формат даних (mp3/mp4):");
                    String dataFormat = scan.nextLine();
                    Matcher m2 = pattern2.matcher(dataFormat);
                    if(m2.matches()){
                        System.out.println("Введений формат даних відповідає регулярному виразу.");
                    }
                    else{
                        System.out.println("Неправильно введений формат даних. Не відповідає регулярному виразу (mp3/mp4). пробуйте ще раз.");
                        break;
                    }
                    System.out.println("Введіть рейтинг");
                    //scan.nextByte();
                    String rating = scan.nextLine();
                    Matcher m3 = pattern3.matcher(rating);
                    if(m3.matches()){
                        System.out.println("Введений рейтинг відповідає регулярному виразу.");
                    }
                    else {
                        System.out.println("Введений рейтинг не відповідає даному регулярному виразу (0-5).Спробуйте ще раз.");
                        break;
                    }
                    compositions.add(new Composition(name, author, genre, date, duration, dataFormat, rating));
                    System.out.println("Готово!");
                    break;
                case 2:
                    System.out.println("Ось ваші композиції:");
                    if (compositions == null) {
                        System.out.println("Ви не створили жодної композиції!");
                    }
                    for (int i = 0; i < compositions.size(); i++) {
                        System.out.println(i + ".");
                        System.out.println(compositions.get(i).getName());
                        System.out.println(compositions.get(i).getAuthor());
                        System.out.println(compositions.get(i).getGenre());
                        System.out.println(compositions.get(i).getDate());
                        System.out.println(compositions.get(i).getDataFormat());
                        System.out.println(compositions.get(i).getRating());
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    }
                    break;
                case 3:
                    System.out.println("Введіть індекс елемента,який ви хочете видалити");
                    scan.nextInt();
                    int delIndex = scan.nextInt();
                    compositions.remove(delIndex);
                    System.out.println("Готово! Композиція була видалена.");
                    break;
                case 4:
                    System.out.println("Введіть індекс композиції,щоб працювати з меню");
                    scan.nextInt();
                    int index = scan.nextInt();
                    System.out.println("=-=-=Меню композиції=-=-=");
                    System.out.println("1 - назва композиції");
                    System.out.println("2 - назва виконавця");
                    System.out.println("3 - жанр");
                    System.out.println("4 - дата створення");
                    System.out.println("5 - формат даних");
                    System.out.println("6 - рейтинг");
                    System.out.println("7 - показати текст");
                    System.out.println("8 - додати текст");
                    System.out.println("9 - змінити назву композиції");
                    System.out.println("10 - змінити дату створення");
                    System.out.println("11 - змінити формат даних");
                    System.out.println("12 - вийти");
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Введіть пункт меню:");
                    // scan.nextByte();
                    byte command = scan.nextByte();
                    switch (command) {
                        case 1:
                            System.out.println("Назва композиції №" + index + " :");
                            System.out.println(compositions.get(index).getName());
                            break;
                        case 2:
                            System.out.println("Назва виконавця композиції №" + index + ":");
                            System.out.println(compositions.get(index).getAuthor());
                            break;
                        case 3:
                            System.out.println("Жанр композиції №" + index + ":");
                            System.out.println(compositions.get(index).getGenre());
                            break;
                        case 4:
                            System.out.println("Дата створення композиції №" + index + ":");
                            System.out.println(compositions.get(index).getDate());
                            break;
                        case 5:
                            System.out.println("Формат даних композиції №" + index + ":");
                            System.out.println(compositions.get(index).getDataFormat());
                            break;
                        case 6:
                            System.out.println("Рейтинг композиції №" + index + ":");
                            System.out.println(compositions.get(index).getRating());
                            break;
                        case 7:
                            System.out.println("Текст композиції №" + index + ":");
                            System.out.println(compositions.get(index).getText());
                        case 8:
                            System.out.println("Введіть текст пісні");
                            scan.nextLine();
                            compositions.get(index).setText(scan.nextLine());
                            System.out.println("Готово!");
                            break;
                        case 9:
                            System.out.println("Щоб змінити назву комнозиції, введіть нову:");
                            scan.nextLine();
                            compositions.get(index).setName(scan.nextLine());
                            System.out.println("Готово!");
                            break;
                        case 10:
                            System.out.println("Щоб змінити дату створення, введіть нову:");
                            scan.nextLine();
                            compositions.get(index).setDate(scan.nextLine());
                            System.out.println("Готово!");
                            break;
                        case 11:
                            System.out.println("Щоб змінити формат даних, введіть новий:");
                            scan.nextLine();
                            compositions.get(index).setDataFormat(scan.nextLine());
                            System.out.println("Готово!");
                        case 12:
                            break;
                        default:
                            System.err.println("Помилкове введення!");
                    }
                    break;
                case  5:
                    String str = FileManager.getPath(scan).toString();
                    System.out.println("Серіалізація в XML...");
                    System.out.println(str);
                    try (
                            XMLEncoder encoder = new XMLEncoder(
                                    new BufferedOutputStream(
                                            new FileOutputStream(str)))
                    )
                    {
                        Integer size = compositions.size();
                        encoder.writeObject(size);
                        for (Composition i: compositions) {
                            encoder.writeObject(i);
                        }
                    }
                    catch (Exception exc){
                        break;
                    }
                    System.out.print("Зроблено!\n");
                    break;
                case 6:
                    System.out.println("Десеріалізація в об`єкт(и)...");
                    try (XMLDecoder decoder = new XMLDecoder(
                            new BufferedInputStream(
                                    new FileInputStream(FileManager.getPath(scan).toString())))
                    )
                    {
                        Integer size = (Integer) decoder.readObject();
                        compositions = new ArrayList<>();
                        for( int i = 0; i < size; i++){

                            compositions.add((Composition) decoder.readObject());
                        }

                    }
                    catch (FileNotFoundException exception){
                        System.err.println(exception.getMessage());
                        break;
                    }
                    catch (NullPointerException e){
                        System.err.println(e.getMessage());
                        break;
                    }
                    break;
                case 7:
                    System.out.println("Папа");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Неправилне введення команди");
            }

        }
    }
}
