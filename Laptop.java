package org.example.Laptop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Laptop {
    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> laptops = new ArrayList<>();

        // Создание нескольких ноутбуков
        HashMap<String, Object> laptop1 = new HashMap<>();
        laptop1.put("brand", "Lenovo");
        laptop1.put("RAM", 8);
        laptop1.put("hardDiskSize", 256);
        laptop1.put("OS", "Windows 10");
        laptop1.put("color", "Black");
        laptops.add(laptop1);

        HashMap<String, Object> laptop2 = new HashMap<>();
        laptop2.put("brand", "Apple");
        laptop2.put("RAM", 16);
        laptop2.put("hardDiskSize", 512);
        laptop2.put("OS", "MacOS");
        laptop2.put("color", "Silver");
        laptops.add(laptop2);

        HashMap<String, Object> laptop3 = new HashMap<>();
        laptop3.put("brand", "Dell");
        laptop3.put("RAM", 4);
        laptop3.put("hardDiskSize", 128);
        laptop3.put("OS", "Windows 10");
        laptop3.put("color", "Red");
        laptops.add(laptop3);

        HashMap<String, Object> laptop4 = new HashMap<>();
        laptop4.put("brand", "HP");
        laptop4.put("RAM", 8);
        laptop4.put("hardDiskSize", 512);
        laptop4.put("OS", "Windows 11");
        laptop4.put("color", "Blue");
        laptops.add(laptop4);

        HashMap<String, Object> laptop5 = new HashMap<>();
        laptop5.put("brand", "Acer");
        laptop5.put("RAM", 16);
        laptop5.put("hardDiskSize", 256);
        laptop5.put("OS", "Windows 11");
        laptop5.put("color", "Black");
        laptops.add(laptop5);

        // Запрос критериев фильтрации
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ: ");
                int minRAM = scanner.nextInt();
                filters.put("RAM", minRAM);
                break;
            case 2:
                System.out.println("Введите минимальный объем жесткого диска: ");
                int minHDD = scanner.nextInt();
                filters.put("hardDiskSize", minHDD);
                break;
            case 3:
                System.out.println("Введите название операционной системы: ");
                String os = scanner.next();
                filters.put("OS", os);
                break;
            case 4:
                System.out.println("Введите цвет: ");
                String color = scanner.next();
                filters.put("color", color);
                break;
            default:
                System.out.println("Некорректный выбор");
        }

        // Фильтрация списка ноутбуков по критериям
        ArrayList<HashMap<String, Object>> filteredLaptops = new ArrayList<>();
        for (HashMap<String, Object> laptop : laptops) {
            boolean satisfiesCriteria = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (!laptop.containsKey(key) || !laptop.get(key).equals(value)) {
                    satisfiesCriteria = false;
                    break;
                }
            }

            if (satisfiesCriteria) {
                filteredLaptops.add(laptop);
            }
        }

        // Вывод отфильтрованных ноутбуков
        System.out.println("Найденные ноутбуки:");
        for (HashMap<String, Object> laptop : filteredLaptops) {
            System.out.println("Бренд: " + laptop.get("brand") +
                    ", ОЗУ: " + laptop.get("RAM") +
                    ", ЖД: " + laptop.get("hardDiskSize") +
                    ", ОС: " + laptop.get("OS") +
                    ", Цвет: " + laptop.get("color"));
        }
    }
}

