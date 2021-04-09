# Java-learning
Пишу на джаве под Eclipse

Проекты:
 
 1) Fake - пример заглушки для нагрузочного тестирования, которая слушает заданный порт и генерирует ответы в соответствии со специфакацией заданного вымышленного провайдера "Мед и Гигабайты". Запуск под Windows: /export/run.bat  ; убедиться, что в консоли слушается порт; перейти в браузер и набрать строку вида http://localhost:8080/pricePlan?method=get&ctn=9083161123 . Основные задачи реализиции: с точки зрения ООП разделить реализацию ввода-вывода, представление данных и имплементацию бизнес-логики; свести трудоемкость разработки каждого последующего метода до реализации спецификации - написания кодов и локализации ошибок, валидации пользовательского ввода и выборки из бд.
Завтра сделать представление данных фабричным.
2) Ora - коннектор к Oracle как обертка над jdbc8. Кеширует экземпляр соединения, выводит содержимое тестовой таблицы.
DeadlockSandbox - иллюстрация простого дедлока. Две вложенные транзакции, которые апдейтят одну и ту же строку. Второй апдейт никогда не будет выполнен. Из jdbc можно вызвать приватный метод, выдающий идентификатор сессий - 7и 114, а по нему сделать выборку из представления локов.
<img src="https://github.com/francehunter/Fiddler-learning/blob/main/perfwats.png" width="200" height="100">
3) FizzBuzz - решение популярной детской задачи на обучение целочисленному делению. Задан интервал целых чисел. Надо вывести каждое; если число делится на 3, то вместо значения вывести Fizz; если число делится на 5, то вместо значения вывести Buzz; если число делится на 3 и 5, то вместо значения вывести FizzBuzz. Решение относительно простое как "лапша" из условных операторов, упакованная внутрь цикла (класс SimplePerft). Однако для интервала от 1 до 10000000 для центрального процессора i7 она занимает 17.24 сек, что намекает на неоптимальность алгоритма.
Попробуем оптимизировать. Стандартная формулировка на собеседованиях не уточняет, куда именно выводить результаты. Формально, /dev/null с точки зрения Java - это тоже поток. В классе DevNullOutputPerft подменяем поток out на время выполнения и получаем десятикратный рот производительности до 1.84 секунд.
Пробуем сделать еще лучше. Стандартный метод потока println содежит оверхед в виде синхронизации, двойной кол-стек на вывод строки и перевода каретки, а так же опережающую запись в буффер. В классе FinalPerft перегружаем WriteLine: теперь мы пишем буфер, уже содержащий перевод каретки, а флэшим только после окончания работы алгоритма. Выделение памяти под буфер для целочисленных значений кешируем. Условие на вхождение в интервал можно поменять на строгое, инкрементировав верхнюю границу. Время выполнения составило 0,32 секунды.
5) 

