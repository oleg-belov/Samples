"use strict";
var Car = (function () {
    // Проблема данного класса в том, что он хрупкий, не гибкий, тяжело расширяется и не поддается тестированию.
    // Если измениться конструктор класса Engine или Tires (например, нужно будет указать дополнительные параметры)
    // то нарушиться работа класса Car. Это делает класс хрупким.
    // Если мы захотим поместить другой тип резины в свойство tires, то столкнемся с проблемой, связанной с тем,
    // что тип шин заранее определен конструктором и поменять его тяжело. Это делает класс негибким.
    // Если мы захотим использовать один и тот же экземпляр зависимостей, для разных экземпляров автомобилей
    // в текущей версии конструктора — это невозможно будет сделать. Данному классу не хватает гибкости.
    // Для данного класса тяжело написать Unit тест, так как нет контроля над зависимостями. Нет возможности
    // контролировать какие значения будут возвращаться экземплярами классов Engine и Tires. 
    function Car() {
        this.engine = new Engine();
        this.tires = new Tires();
    }
    Car.prototype.drive = function () {
        return "\u0410\u0432\u0442\u043E\u043C\u043E\u0431\u0438\u043B\u044C \u0441 \u0434\u0432\u0438\u0433\u0430\u0442\u0435\u043B\u0435\u043C " + this.engine.cylinders + " \u0446\u0438\u043B\u0438\u043D\u0434\u0440\u043E\u0432 \u0438 \u0440\u0435\u0437\u0438\u043D\u043E\u0439 " + this.tires.name;
    };
    return Car;
}());
exports.Car = Car;
var Engine = (function () {
    function Engine() {
    }
    return Engine;
}());
var Tires = (function () {
    function Tires() {
    }
    return Tires;
}());
// создание экземпляра
var c = new Car();
//# sourceMappingURL=01_sample_no_di.js.map