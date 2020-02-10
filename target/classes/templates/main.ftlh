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
    <form method="post" action="/edit">
    <b>${viewPeople.id}</b>
    <b>${viewPeople.lastName}</b>
    <b>${viewPeople.firstName}</b>
    <b>${viewPeople.midName}</b>
    <b>${viewPeople.year}</b>
        <input type="hidden" name="id" value="${viewPeople.id}">
        <button type="submit">Редактировать</button>
    </form>
        <b>Мобильный ${viewPeople.phone0!}</b>
            <b>Рабочий ${viewPeople.phone1!}</b>
            <b>Домашний ${viewPeople.phone2!}</b>
            <b>Другой ${viewPeople.phone3!}</b>
            <b>Другой ${viewPeople.phone4!}</b>



</div>
<#else>
No people
</#list>

</@c.page>