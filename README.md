### Описание 
Форма заказа карты с возможностью перепланирования встречи.

![img.png](src/test/resources/img.png)

### Задача
Автоматизированное тестирование функции перепланирования встречи с использованием фреймфворка Allure.

### Используемые методики и инструменты
Page Object  
AppVeyor, Gradle, Sellenide, Lombok, Allure

**CI**  
[![Build status](https://ci.appveyor.com/api/projects/status/y5cp6ib55c3bdftd?svg=true)](https://ci.appveyor.com/project/Kasparidi/carddelivery2)

### Команды запуска
1. Запускаем приложение ``java -jar ./artifacts/app-card-delivery.jar``
1. Открываем в браузере http://localhost:9999/
1. Запускаем тесты в IDEA ``gradlew clean test allureReport``, ``gradlew allureServe``

### Итог
Уведомление "перепланирования даты встречи" в приложении заказа карты возникает даже если не изменять дату. [Issue](https://github.com/Kasparidi/CardOrderReschedule/issues)
