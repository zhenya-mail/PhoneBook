<#import "parts/page.ftlh" as c>
<@c.page>

<#list viewP! as viewPeople>
    <div>
        <form method="post" action="/edited">
            <input type="hidden" name="id" value="${viewPeople.id}">
            <input type="text" name="lastName" pattern="[A-Za-zА-Яа-яЁё]+$"
                   title="Только русские или латинские буквы"  value="${viewPeople.lastName!}">
            <input type="text" name="firstName" pattern="[A-Za-zА-Яа-яЁё]+$"
                   title="Только русские или латинские буквы"  value="${viewPeople.firstName!}">
            <input type="text" name="midName" pattern="[A-Za-zА-Яа-яЁё]+$"
                   title="Только русские или латинские буквы"  value="${viewPeople.midName!}">
            <input type="text" name="year" pattern="[0-9]{4,4}"
                   title="Год - четыре цифры" value="${viewPeople.year!}">
            <div> Мобильный
            <input type="text" name="phone0" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone0!}">
             </div>
            <div> Домашний
            <input type="text" name="phone1" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone1!}">
            </div>
                <div> Рабочий
                <input type="text" name="phone2" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone2!}">
                </div>
             <div> Другой
                 <input type="text" name="phone3" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone3!}">
             </div>
             <div> Другой
                 <input type="text" name="phone4" pattern="[0-9]{0,12}"
                   title="Только цифры, максимум 12 цифр" value="${viewPeople.phone4!}">
             </div>
            <div>
            <button type="submit">Сохранить</button> ${Ok!}
            </div>
        </form>
        <br>
        <div><form method="post" action="del" onclick="return confirm('Точно удалить?')">
            <input type="hidden" name="id" value="${viewPeople.id}">
            <button type="submit">Удалить</button>
        </form>
        </div>
        <br>
        <div><form method="get" action="/">
                   <button type="submit">Назад</button>
        </form>
        </div>
    </div>
<#else>
No edit data
</#list>


</@c.page>