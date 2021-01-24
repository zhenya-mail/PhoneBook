<#import "parts/page.ftlh" as c>
<@c.page>



    <div>PhoneBook</div>
    <br>

    <div>Поиск по ФИО или телефону</div>
    <div>Фамилия Имя Отчество - любые, даже частично известные данные через пробел, от одного до 3-х слов</div>
    <div>Телефон - любые, известные цифры</div>
    <br>
    <form method="get" action="/">
        <input type="text" name="search" value="${search!}">
        <button type="submit">Поиск</button>
    </form>
    <form method="get" action="/">
        <input type="hidden" name="search" value="">
        <button type="submit">Сбросить поиск</button>
    </form>
    <br>
    <div><strong><a href="/add">Добавить новый контакт</a></strong></div>
    <br>
    <div>Список контактов</div>
    <#list viewP! as viewPeople>
        <div>
            <br>

            <b>${viewPeople.lastName}</b>
            <b>${viewPeople.firstName}</b>
            <b>${viewPeople.midName}</b>
            <b>${viewPeople.year}</b>
            <b>Телефоны :  </b>
            <#list viewPeople.phoneList as Ph>
            <i>${Ph.phone!}<#sep>, </#sep></i>
                </#list>
                <#--            <#list viewPeople.phoneList as Ph>-->
                <#--                    Мобильный <i>${Ph!}</i>-->
                <#--&lt;#&ndash;                    Рабочий <i>${Ph.phone01!}</i>&ndash;&gt;-->
                <#--&lt;#&ndash;                    Домашний <i>${Ph.phone02!}</i>&ndash;&gt;-->
                <#--&lt;#&ndash;                    Другой <i>${Ph.phone03!}</i>&ndash;&gt;-->
                <#--&lt;#&ndash;                    Другой <i>${Ph.phone04!}</i>&ndash;&gt;-->
                <#--            </#list>-->

                <! --
                <#--            <#list viewPh! as viewPhone>-->
                <#--            Из другой таблицы <i>${viewPhone.phone00!}</i>-->
                <#--            </#list>&ndash;&gt;-->
                <form method="post" action="/edit">
                    <input type="hidden" name="id" value="${viewPeople.id}">
                    <button type="submit">Редактировать</button>
                </form>


        </div>
    <#else>
        No people
    </#list>


</@c.page>