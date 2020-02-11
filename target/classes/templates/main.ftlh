<#import "parts/page.ftlh" as c>
<@c.page>



<div>PhoneBook</div>
<br>

<div>Поиск по ФИО или телефону</div>
<div>Фамилия Имя Отчество - любые, даже частично известные данные через пробел, от одного до 3-х слов</div>
<div>Телефон - любые известные цифры</div>
<br>
<form method="get" action="/">
    <input type="text" name="search" value="${search!}" >
    <button type="submit">Поиск</button>
</form>
<form method="get" action="/">
    <input type="hidden" name="search" value="" >
    <button type="submit">Сбросить поиск</button>
</form>
<br>
<div><strong><a href="/add">Добавить новый контакт</a></strong></div>
<br>
<div>Список контактов</div>
<#list viewP! as viewPeople>
<div>
    <br>

    <b>${viewPeople.id}</b>
    <b>${viewPeople.lastName}</b>
    <b>${viewPeople.firstName}</b>
    <b>${viewPeople.midName}</b>
    <b>${viewPeople.year}</b>
            Мобильный <i>${viewPeople.phone0}</i>
            Рабочий <i>${viewPeople.phone1}</i>
            Домашний <i>${viewPeople.phone2}</i>
            Другой <i>${viewPeople.phone3}</i>
            Другой <i>${viewPeople.phone4}</i>
    <form method="post" action="/edit">
        <input type="hidden" name="id" value="${viewPeople.id}">
        <button type="submit">Редактировать</button>
    </form>


</div>
<#else>
No people
</#list>

</@c.page>