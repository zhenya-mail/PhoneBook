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
        <div> Мобильный
        <input type="tel" name="phone0" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Мобильный"></div>
        <div> Домашний
        <input type="tel" name="phone1" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Домашний">
        </div>
        <div> Рабочий
        <input type="tel" name="phone2" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Рабочий">
        </div>
        <div> Другой
        <input type="tel" name="phone3" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Другой">
        </div>
        <div> Другой
        <input type="tel" name="phone4" pattern="[0-9]{0,12}"
               title="Только цифры, максимум 12 цифр" placeholder="Другой">
        </div>
        <br>
        <div>
        <button type="submit">Добавить</button></div>
    </form>

    <br>
    <form method="get" action="/">
        <button type="submit">Назад</button>
    </form>
</div>















</@c.page>