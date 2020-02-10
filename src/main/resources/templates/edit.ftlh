<#import "parts/page.ftlh" as c>
<@c.page>

<#list viewP! as viewPeople>
    <div>
        <form method="post" action="added">
            <input type="hidden" name="id" value="${viewPeople.id}">
            <input type="text" name="lastName" pattern="[A-Za-zА-Яа-яЁё]+$"
                   title="Только русские или латинские буквы"  value="${viewPeople.lastName!}">
            <input type="text" name="firstName" pattern="[A-Za-zА-Яа-яЁё]+$"
                   title="Только русские или латинские буквы"  value="${viewPeople.firstName!}">
            <input type="text" name="midName" pattern="[A-Za-zА-Яа-яЁё]+$"
                   title="Только русские или латинские буквы"  value="${viewPeople.midName!}">
            <input type="text" name="year" pattern="[0-9]{4,4}"
                   title="Год - четыре цифры" value="${viewPeople.year!}">
            <br>
            <input type="text" name="phone0" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone0!}">
            <input type="text" name="phone1" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone1!}">
            <input type="text" name="phone2" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone2!}">
            <input type="text" name="phone3" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone3!}">
            <input type="text" name="phone4" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone4!}">
            <button type="submit">Сохранить</button>
        </form>
        <br>
        <form method="post" action="del">
            <input type="hidden" name="id" value="${viewPeople.id}">
            <button type="submit">Удалить</button>
        </form>
        <br>
    </div>
<#else>
No edit data
</#list>
${Ok!}
<br>
<a href="/">Назад</a>
</@c.page>