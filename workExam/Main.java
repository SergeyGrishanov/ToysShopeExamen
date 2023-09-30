package workExam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Raffle raf = new Raffle();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Выберете необходимое действие:
                    1 - Добавитьновую игрушку в призовой фонд
                    2 - Провести розыгрыш игрушек!
                    3 - Изменить частоту выпаения игрушки
                    0 - Выход
                    >\s""");

                    
            var manu = sc.next();
            switch (manu) {
                case "1" -> raf.addToys();
                case "2" -> raf.raffle();
                case "3" -> raf.setFrequency();
                case "0" -> {
                    System.out.println("Пока-пока");
                    System.exit(0);
                }
                default -> System.out.println("Некорректный ввод! Попробуйте еще раз, пожалуйста.");
            }
        }
    }
}