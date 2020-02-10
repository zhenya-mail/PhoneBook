<#import "parts/page.ftlh" as c>
<@c.page>

<div>Добавление нового контакта</div>
<br>
<div>
    <form method="post" action="/add">
        <input type="text" name="lastName" pattern="[A-Za-zА-Яа-яЁё]+$"
               title="Только русские или латинские буквы" placeholder="Фамилия">
        <input type="text" name="firstName" pattern="[A-Za-zА-Яа-яЁё]+$"
               title="Только русские или латинские буквы"  placeholder="Имя">
        <input type="text" name="midName" pattern="[A-Za-zА-Яа-яЁё]+$"
               title="Только русские или латинские буквы"  placeholder="Отчество">
        <input type="text" name="year" pattern="[0-9]{4,4}"
               title="Год - четыре цифры" placeholder="Год рождения">
        <br>
        <input type="tel" name="phone0" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Мобильный">
        <input type="tel" name="phone1" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Домашний">
        <input type="tel" name="phone2" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Рабочий">
        <input type="tel" name="phone3" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Другой">
        <input type="tel" name="phone4" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Другой">
        <button type="submit">Добавить</button>
    </form>
    <br>
    ${Ok!}
</div>
<br>
<a href="/">Назад</a>













</@c.page>