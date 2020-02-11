<#import "parts/page.ftlh" as c>
<@c.page>




<form method="get" action="/search">
    <input type="text" name="search" value="${search!}" >
    <button type="submit">Найти</button>

</form>
<div>Список контактов</div>
<#list viewP! as viewPeople>
<div>
    <br>
    <form method="post" action="/edit">
        <b>${viewPeople.id}</b>
        <b>${viewPeople.lastName}</b>
        <b>${viewPeople.firstName}</b>
        <b>${viewPeople.midName}</b>
        <b>${viewPeople.year}</b></div>
        <input type="hidden" name="id" value="${viewPeople.id}">
        <button type="submit">Редактировать</button>
    </form>
<div>
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